package com.social.enactive.bot.components.decision;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.RandomUtils;

import com.social.enactive.bot.components.knowledge.Knowledge;
import com.social.enactive.bot.components.message.ResponseBuilder;

public class ResultDecisionService {

	private final DecisionRepository repository;
	private final DecisionHandling defaultHandling = new DecisionHandling(UUID.randomUUID().toString(),
			DecisionType.DEFAULT, new HashMap<>());

	public ResultDecisionService(DecisionRepository repository) {
		this.repository = repository;
	}

	public void generate(Knowledge knowledge, ResponseBuilder builder) {
		DecisionHandling handling = Optional.ofNullable(repository.find(knowledge.getQuestion().getCustomDecision()))
				.orElse(defaultHandling);

		switch (handling.getType()) {
		case SINGLE:
			singleResult(handling, knowledge, builder);
			break;
		case RANDOM:
			randomResult(handling, knowledge, builder);
			break;
		default:
			results(handling, knowledge, builder);
			break;
		}
	}

	private void singleResult(DecisionHandling handling, Knowledge knowledge, ResponseBuilder builder) {
		int selected = Optional.ofNullable(Integer.parseInt(handling.getArguments().get("selected"))).orElse(0);
		int index = Math.min(selected, knowledge.getAnswers().size() - 1);

		builder.add(knowledge.getAnswers().get(index).getAnswerContent());
	}

	private void randomResult(DecisionHandling handling, Knowledge knowledge, ResponseBuilder builder) {
		int selected = RandomUtils.nextInt(0, knowledge.getAnswers().size());

		builder.add(knowledge.getAnswers().get(selected).getAnswerContent());
	}
	
	private void results(DecisionHandling handling, Knowledge knowledge, ResponseBuilder builder) {
		int selected = Optional.ofNullable(Integer.parseInt(handling.getArguments().get("max"))).orElse(knowledge.getAnswers().size());
		knowledge.getAnswers().subList(0, selected).forEach(answer -> builder.add(answer.getAnswerContent()));
	}

}
