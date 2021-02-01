package com.leiskies.app.model;

public class Answer_Tag {
	private Integer answerId;
	private Integer tagId;
	public Answer_Tag(Integer answerId, Integer tagId) {
		this.answerId = answerId;
		this.tagId = tagId;
	}
	public Answer_Tag() {
	}
	public Integer getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
}
