package com.leiskies.app.model;

public class Answer {
	private Integer id;
	private String content;
	public Answer(Integer id, String content) {
		this.id = id;
		this.content = content;
	}
	public Answer(String content) {
		this.content = content;
	}
	public Answer() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", content=" + content + "]";
	}
}
