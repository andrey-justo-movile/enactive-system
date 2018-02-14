package com.social.enactive.bot.components.knowledge;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.social.enactive.bot.components.scenario.BehaviorScenario;

public class KnowledgeQuestion {

	@Id
	private String id;
	private BehaviorScenario knowledgeDatabase;
	private String originQuestion;
	private List<String> answerIds;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BehaviorScenario getKnowledgeDatabase() {
		return knowledgeDatabase;
	}

	public void setKnowledgeDatabase(BehaviorScenario knowledgeDatabase) {
		this.knowledgeDatabase = knowledgeDatabase;
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

	@Override
	public String toString() {
		return "KnowledgeQuestion {id=" + id + ", knowledgeDatabase=" + knowledgeDatabase + ", originQuestion="
				+ originQuestion + ", answerIds=" + answerIds + "}";
	}

}
