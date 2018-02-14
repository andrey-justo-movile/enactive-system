package com.social.enactive.components.emotion;

import java.util.ArrayList;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.PrefixManager;

public class EmotionOntology {
	private OWLOntologyManager manager;
	private OWLOntology owlOntology;
	private OWLDataFactory factory;
	private PrefixManager prefixManager;

	private ArrayList<OWLClassAssertionAxiom> classAxioms = new ArrayList<OWLClassAssertionAxiom>();
	private ArrayList<OWLObjectPropertyAssertionAxiom> propertyAxioms = new ArrayList<OWLObjectPropertyAssertionAxiom>();

	private UserHandler userHandler;
	private EmotionHandler emotionHandler;

	public EmotionOntology(IRI iri, String iriBase) throws OWLOntologyCreationException {
		manager = OWLManager.createOWLOntologyManager();
		owlOntology = manager.loadOntologyFromOntologyDocument(iri);
		factory = manager.getOWLDataFactory();
		prefixManager = (PrefixManager) manager.getOntologyFormat(owlOntology);
		userHandler = new UserHandler(owlOntology, factory, prefixManager);
		emotionHandler = new EmotionHandler(factory, prefixManager);
	}

	public void add(OWLClassAssertionAxiom individualAxiom) throws OWLOntologyStorageException {
		manager.addAxiom(owlOntology, individualAxiom);
		classAxioms.add(individualAxiom);
		manager.saveOntology(owlOntology);
	}

	public void add(OWLObjectPropertyAssertionAxiom objectPropertyAxiom) throws OWLOntologyStorageException {
		manager.addAxiom(owlOntology, objectPropertyAxiom);
		propertyAxioms.add(objectPropertyAxiom);
		manager.saveOntology(owlOntology);
	}

	public void RemoveCreatedAxioms() throws OWLOntologyStorageException {
		for (OWLClassAssertionAxiom axiom : classAxioms) {
			manager.removeAxiom(owlOntology, axiom);
		}

		for (OWLObjectPropertyAssertionAxiom axiom : propertyAxioms) {
			manager.removeAxiom(owlOntology, axiom);
		}

		manager.saveOntology(owlOntology);
	}
	
	public OWLOntologyManager getManager() {
		return manager;
	}

	public OWLOntology getOwlOntology() {
		return owlOntology;
	}

	public UserHandler getUserHandler() {
		return userHandler;
	}

	public EmotionHandler getEmotionHandler() {
		return emotionHandler;
	}

}