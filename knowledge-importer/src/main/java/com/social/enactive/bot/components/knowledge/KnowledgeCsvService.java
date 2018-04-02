package com.social.enactive.bot.components.knowledge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import com.social.enactive.bot.components.message.Content;
import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.scenario.BotBehaviorRepository;
import com.social.enactive.bot.components.scenario.intent.IntentDetection;
import com.social.enactive.bot.components.scenario.intent.IntentDetectionRepository;
import com.social.enactive.bot.configuration.log.Log;
import com.social.enactive.bot.integration.wit.WitClient;
import com.social.enactive.bot.integration.wit.request.train.Sample;
import com.social.enactive.bot.integration.wit.request.train.SampleEntity;
import com.social.enactive.bot.integration.wit.response.TrainResponse;

public class KnowledgeCsvService {

	private final KnowledgeQuestionRepository questionRepository;
	private final KnowledgeAnswerRepository answerRepository;
	private final IntentDetectionRepository intentDetectionRepository;
	private final BotBehaviorRepository botBehaviorRepository;
	private final WitClient witClient;

	public KnowledgeCsvService(KnowledgeQuestionRepository questionRepository,
			KnowledgeAnswerRepository answerRepository, IntentDetectionRepository intentDetectionRepository,
			BotBehaviorRepository botBehaviorRepository, WitClient witClient) {
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
		this.intentDetectionRepository = intentDetectionRepository;
		this.botBehaviorRepository = botBehaviorRepository;
		this.witClient = witClient;
	}

	public void extract(String botId, String csvPath) throws FileNotFoundException, IOException {
		List<KnowledgeQuestion> questions = new ArrayList<>();
		List<KnowledgeAnswer> answers = new ArrayList<>();
		try (CSVParser parser = new CSVParser(new FileReader(csvPath), CSVFormat.DEFAULT)) {
			parser.forEach(record -> {
				KnowledgeQuestion question = new KnowledgeQuestion();
				question.setId(botId + "-" + record.get(0));
				question.setOriginQuestion(record.get(1));
				KnowledgeAnswer answer = new KnowledgeAnswer();
				answer.setId(botId + "-" + record.get(2));
				question.setAnswerIds(Arrays.asList(answer.getId()));
				answer.setAnswerContent(new Content(record.get(3), null));
				questions.add(question);
				answers.add(answer);
			});

			questionRepository.removeAll(questions.stream().map(KnowledgeQuestion::getId).collect(Collectors.toList()));
			answerRepository.removeAll(answers.stream().map(KnowledgeAnswer::getId).collect(Collectors.toList()));
			questionRepository.inserAll(questions);
			answerRepository.inserAll(answers);
			updateIntentService(botId, questions);
		}
	}
	
	private void updateIntentService(String botId, List<KnowledgeQuestion> questions) {
		BotBehavior botBehavior = botBehaviorRepository.find(botId);
		IntentDetection intentDetection = intentDetectionRepository.find(botBehavior.getIntentDetectionId());
		
		switch (intentDetection.getType()) {
		case WIT:
			updateWit(intentDetection, questions);
			break;
		default:
			Log.SYSTEM.warn("Intent {} not implemented", intentDetection);
			break;
		}
	}
	
	private void updateWit(IntentDetection intentDetection, List<KnowledgeQuestion> questions) {
		List<Sample> samples = questions.stream().map(question -> {
			Sample s = new Sample();
			s.setText(question.getOriginQuestion());
			s.setEntities(question.getAnswerIds().stream().map(answerId -> new SampleEntity(answerId)).collect(Collectors.toList()));
			return s;
		}).collect(Collectors.toList());
		
		Log.SYSTEM.info("Updating WIT.ai with {}", samples);
		TrainResponse trainResponse = witClient.train(samples, intentDetection.getToken(), intentDetection.getVersion());
		Log.SYSTEM.info("Wit training response={}", trainResponse);
	}

}
