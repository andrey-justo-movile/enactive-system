package com.social.enactive.bot.components.knowledge;

import java.util.List;

public class Knowledge {

	private final KnowledgeQuestion question;
	private final List<KnowledgeAnswer> answers;

	public Knowledge(KnowledgeQuestion question, List<KnowledgeAnswer> answers) {
		super();
		this.question = question;
		this.answers = answers;
	}

	public KnowledgeQuestion getQuestion() {
		return question;
	}

	public List<KnowledgeAnswer> getAnswers() {
		return answers;
	}

	@Override
	public String toString() {
		return "Knowledge {question=" + question + ", answers=" + answers + "}";
	}

}
