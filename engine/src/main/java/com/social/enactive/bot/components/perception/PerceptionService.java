package com.social.enactive.bot.components.perception;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import com.social.enactive.bot.components.user.UserInteraction;
import com.social.enactive.bot.configuration.log.Log;
import com.social.enactive.bot.integration.microsoft.face.FaceClient;
import com.social.enactive.bot.integration.microsoft.face.response.FaceDetectionResponse;
import com.social.enactive.components.emotion.EmotionService;

public class PerceptionService {

	private final List<String> attributes = Arrays.asList("smile", "emotion");
	private final FaceClient faceClient;
	private final EmotionService emotionService;

	public PerceptionService(FaceClient faceClient, EmotionService emotionService) {
		super();
		this.faceClient = faceClient;
		this.emotionService = emotionService;
	}

	public void perception(UserInteraction userInteraction) {
		FaceDetectionResponse detectionResponse = faceClient.detect(userInteraction.getMessage().getContent().getImageUrl(), attributes, true, false);
		
		String currentEmotion = detectionResponse.getFaceAttributes().getEmotion().entrySet().stream().max(Comparator.comparing(Entry::getValue)).map(Entry::getKey).orElse(null);
		try {
			// TODO: return emotion
			emotionService.interact(userInteraction.getUser().getId(), currentEmotion);
		} catch (OWLOntologyStorageException e) {
			Log.EXCEPTION.error("Couldn't interact with emotion service for {}", userInteraction, e);
		}
	}
	
}
