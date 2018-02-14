package com.social.enactive.bot.components.knowledge;

import org.springframework.data.annotation.Id;

import com.social.enactive.bot.components.message.Content;

public class KnowledgeAnswer {

	@Id
	private String id;
	private Content answerContent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Content getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(Content answerContent) {
		this.answerContent = answerContent;
	}

	@Override
	public String toString() {
		return "KnowledgeAnswer {id=" + id + ", answerContent=" + answerContent + "}";
	}

}
