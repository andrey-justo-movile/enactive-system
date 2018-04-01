package com.social.enactive.bot.components.knowledge;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.social.enactive.bot.components.decision.DecisionHandling;

public class KnowledgeQuestion {

	@Id
	private String id;
	private DecisionHandling customDecision;
	private String originQuestion;
	private List<String> answerIds;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOriginQuestion() {
		return originQuestion;
	}

	public void setOriginQuestion(String originQuestion) {
		this.originQuestion = originQuestion;
	}

	public List<String> getAnswerIds() {
		return answerIds;
	}

	public void setAnswerIds(List<String> answerIds) {
		this.answerIds = answerIds;
	}

	public DecisionHandling getCustomDecision() {
		return customDecision;
	}

	public void setCustomDecision(DecisionHandling customDecision) {
		this.customDecision = customDecision;
	}

	@Override
	public String toString() {
		return "KnowledgeQuestion {id=" + id + ", customDecision=" + customDecision + ", originQuestion="
				+ originQuestion + ", answerIds=" + answerIds + "}";
	}

}
