package com.social.enactive.bot.components.knowledge;

import java.util.Optional;

public class KnowledgeService {

	private final KnowledgeAnswerRepository answerRepository;
	private final KnowledgeQuestionRepository questionRepository;

	public KnowledgeService(KnowledgeAnswerRepository answerRepository,
			KnowledgeQuestionRepository questionRepository) {
		this.answerRepository = answerRepository;
		this.questionRepository = questionRepository;
	}

	public Knowledge knowlegde(String questionId) {
		// TODO: create an unknown answer and not return null
		return Optional.ofNullable(questionRepository.find(questionId))
				.map(q -> new Knowledge(q, answerRepository.list(q.getAnswerIds()))).orElse(null);
	}

}
