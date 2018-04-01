package com.social.enactive.bot.components.knowledge;

public class KnowledgeCsvItem {

	private String questionId;
	private String question;
	private String answerId;
	private String answer;

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "KnowledgeCsvItem {questionId=" + questionId + ", question=" + question + ", answerId=" + answerId
				+ ", answer=" + answer + "}";
	}

}
