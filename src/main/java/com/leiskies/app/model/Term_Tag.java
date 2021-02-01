package com.leiskies.app.model;

public class Term_Tag {
	private Integer termId;
	private Integer tagId;
	public Term_Tag(Integer termId, Integer tagId) {
		this.termId = termId;
		this.tagId = tagId;
	}
	public Term_Tag() {
	}
	public Integer getTermId() {
		return termId;
	}
	public void setTermId(Integer termId) {
		this.termId = termId;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
}
