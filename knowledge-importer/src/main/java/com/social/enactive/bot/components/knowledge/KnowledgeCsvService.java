package com.social.enactive.bot.components.knowledge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import com.social.enactive.bot.integration.wit.WitClient;

public class KnowledgeCsvService {

	private final KnowledgeQuestionRepository questionRepository;
	private final KnowledgeAnswerRepository answerRepository;
	private final WitClient witClient;

	public KnowledgeCsvService(KnowledgeQuestionRepository questionRepository,
			KnowledgeAnswerRepository answerRepository, WitClient witClient) {
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
		this.witClient = witClient;
	}

	public void extract(String botId, String csvPath) throws FileNotFoundException, IOException {
		try (CSVParser parser = new CSVParser(new FileReader(csvPath), CSVFormat.DEFAULT)) {
			parser.forEach(record -> {
				
			});
		}
	}

}
