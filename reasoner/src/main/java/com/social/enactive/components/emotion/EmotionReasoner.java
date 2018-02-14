package com.social.enactive.components.emotion;

import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;

import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import com.social.enactive.bot.components.user.Emotion;

public class EmotionReasoner {

	private static final String DEFAULT_IRI_BASE = "http://purl.obolibrary.org/obo/";

	private String iriBase = DEFAULT_IRI_BASE;
	private IRI iri;
	private EmotionOntology ontology;

	public EmotionReasoner(URI ontologyUri, String iriBase) throws OWLOntologyCreationException, FileNotFoundException {
		if (StringUtils.isBlank(iriBase)) {
			throw new IllegalArgumentException(iriBase);
		}

		this.iri = IRI.create("file:///" + ontologyUri);
		this.iriBase = iriBase;
		loadOntology();
	}

	public EmotionReasoner(URI ontologyUri) throws OWLOntologyCreationException {
		this.iri = IRI.create(ontologyUri);
		loadOntology();
	}

	private String InferEmotions(OWLIndividual user) {
		PelletReasonerFactory reasonerFactory = PelletReasonerFactory.getInstance();
		PelletReasoner reasoner = reasonerFactory.createReasoner(ontology.getOwlOntology(), new SimpleConfiguration());
		OWLDataProperty actionEmotions = ontology.getEmotionHandler().getActionEmotions();
		OWLNamedIndividual namedUser = ontology.getUserHandler().asNamedIndividual(user);
		Set<OWLLiteral> values = reasoner.getDataPropertyValues(namedUser, actionEmotions);
		OWLLiteral value = (OWLLiteral) values.toArray()[0];

		return value.getLiteral();
	}

	private void loadOntology() throws OWLOntologyCreationException {
		if (iri == null) {
			iri = IRI.create(iriBase);
		}
		
		ontology = new EmotionOntology(iri, iriBase);
	}

	public String inferEmotionalResponse(String observedUserName, Emotion emotion) throws OWLOntologyStorageException {
		OWLIndividual user = ontology.getUserHandler().findUser(observedUserName);

		if (user == null) {
			throw new IllegalStateException("User not found");

		}

		OWLClassAssertionAxiom individualAxiom = ontology.getEmotionHandler().CreateEmotion(emotion, observedUserName);
		ontology.add(individualAxiom);
		OWLObjectPropertyAssertionAxiom objectPropertyAxiom = ontology.getUserHandler().createUserEmotionalState(user,
				individualAxiom.getIndividual());
		ontology.add(objectPropertyAxiom);

		String inferedEmotions = InferEmotions(user);
		ontology.RemoveCreatedAxioms();

		return inferedEmotions;
	}

	public EmotionOntology getOntology() {
		return ontology;
	}
}
