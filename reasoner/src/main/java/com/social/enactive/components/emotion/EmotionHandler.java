package com.social.enactive.components.emotion;

import org.apache.commons.lang3.StringUtils;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.PrefixManager;

import com.social.enactive.bot.components.user.Emotion;


public class EmotionHandler {
	private OWLDataFactory factory;
	private PrefixManager prefixManager;

	public EmotionHandler(OWLDataFactory factory, PrefixManager prefixManager) {
		this.factory = factory;
		this.prefixManager = prefixManager;
	}

	public OWLClassAssertionAxiom CreateEmotion(Emotion emotion, String observedUserName) {
		if (emotion == null) {
			throw new IllegalArgumentException("emotion cannot be null");
		}

		if (StringUtils.isEmpty(observedUserName)) {
			throw new IllegalArgumentException("observedUserName cannot be null or empty");
		}

		OWLClass emotionClass = factory.getOWLClass(":" + emotion.code(), prefixManager);
		if (emotionClass == null) {
			throw new IllegalStateException("Emotion class not found, please check it and try again");
			
		}
		
		String emotionInstanceName = observedUserName + "_" + emotion;
		OWLNamedIndividual emotionIndividual = factory.getOWLNamedIndividual(emotionInstanceName, prefixManager);
		OWLClassAssertionAxiom axiom = factory.getOWLClassAssertionAxiom(emotionClass, emotionIndividual);

		return axiom;
	}

	public OWLDataProperty getActionEmotions() {
		return factory.getOWLDataProperty("actionEmotions", prefixManager);
	}
}
