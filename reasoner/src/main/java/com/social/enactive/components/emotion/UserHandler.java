package com.social.enactive.components.emotion;

import java.util.Collection;
import java.util.Iterator;

import org.semanticweb.owlapi.dlsyntax.renderer.DLSyntaxObjectRenderer;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.search.EntitySearcher;



public class UserHandler {
	private OWLOntology owlOntology;
	private OWLDataFactory factory;
	private PrefixManager prefixManager;
	private DLSyntaxObjectRenderer renderer = new DLSyntaxObjectRenderer();

	private OWLClass userClass;

	public UserHandler(OWLOntology ontology, OWLDataFactory factory, PrefixManager prefixManager) {
		this.owlOntology = ontology;
		this.factory = factory;
		this.prefixManager = prefixManager;
		this.userClass = factory.getOWLClass(":User", this.prefixManager);
	}

	public boolean existsUser(String userName) {
		return findUser(userName) != null;
	}

	public OWLIndividual findUser(String userName) {
		userClass = factory.getOWLClass(":User", prefixManager);
		Collection<OWLIndividual> userInstances = EntitySearcher.getIndividuals(userClass, owlOntology);
		Iterator<OWLIndividual> iterator = userInstances.iterator();

		OWLIndividual user = null;
		// TODO: improve this code. Here we can have a infinite loop
		while (iterator.hasNext()) {
			OWLIndividual individual = iterator.next();

			if (renderer.render(individual).equals(userName)) {
				user = individual;
			}
		}

		return user;
	}

	public OWLNamedIndividual asNamedIndividual(OWLIndividual user) {
		return factory.getOWLNamedIndividual(renderer.render(user), prefixManager);
	}

	public OWLObjectPropertyAssertionAxiom createUserEmotionalState(OWLIndividual user, OWLIndividual emotion) {
		OWLObjectProperty userEmotionalState = factory.getOWLObjectProperty("userEmotionalState", prefixManager);
		OWLObjectPropertyAssertionAxiom axiom = factory.getOWLObjectPropertyAssertionAxiom(userEmotionalState, user,
				emotion);

		return axiom;
	}

	public OWLClassAssertionAxiom createUser(String userName) {
		OWLNamedIndividual newUser = factory.getOWLNamedIndividual(":" + userName, prefixManager);
		return factory.getOWLClassAssertionAxiom(userClass, newUser);
	}
}
