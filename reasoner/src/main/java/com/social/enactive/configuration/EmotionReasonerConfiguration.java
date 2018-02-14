package com.social.enactive.configuration;

import java.net.URISyntaxException;
import java.net.URL;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.social.enactive.components.emotion.EmotionReasoner;
import com.social.enactive.components.emotion.EmotionService;


@Configuration
public class EmotionReasonerConfiguration {

	@Bean
	public EmotionReasoner emotionReasoner() throws OWLOntologyCreationException, URISyntaxException {
		ClassLoader cl = this.getClass().getClassLoader();
		URL ontology = cl.getResource("ontologies/MFOEM.owl");
		return new EmotionReasoner(ontology.toURI());
	}
	
	@Bean
	@Autowired
	public EmotionService emotionService(EmotionReasoner emotionReasoner) {
		return new EmotionService(emotionReasoner);
	}
	
}
