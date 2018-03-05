package com.social.enactive.components.emotion;

import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import com.social.enactive.bot.components.user.Emotion;

public class EmotionService {

	private final EmotionReasoner emotionReasoner;

	public EmotionService(EmotionReasoner emotionReasoner) {
		this.emotionReasoner = emotionReasoner;
	}
	
	public String[] interact(String username, String emotion) throws OWLOntologyStorageException {
		return interact(new EmotionRecognitionParams(username, emotion));
	}

	public String[] interact(EmotionRecognitionParams params) throws OWLOntologyStorageException {
		Emotion emotion = Emotion.valueOf(params.getUserEmotion());
		if (!emotionReasoner.getOntology().getUserHandler().existsUser(params.getUserName())) {
			OWLClassAssertionAxiom newUser = emotionReasoner.getOntology().getUserHandler()
					.createUser(params.getUserName());
			emotionReasoner.getOntology().add(newUser);
		}

		String emotionalResponse = emotionReasoner.inferEmotionalResponse(params.getUserName(), emotion);
		return emotionalResponse.split(",");
	}

}
