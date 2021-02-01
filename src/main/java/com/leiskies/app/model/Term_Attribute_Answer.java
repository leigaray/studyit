package com.leiskies.app.model;

public class Term_Attribute_Answer {
	private Integer termId;
	private Integer attributeId;
	private Integer answerId;
	public Term_Attribute_Answer(Integer termId, Integer attributeId, Integer answerId) {
		this.termId = termId;
		this.attributeId = attributeId;
		this.answerId = answerId;
	}
	public Term_Attribute_Answer() {
	}
	public Integer getTermId() {
		return termId;
	}
	public void setTermId(Integer termId) {
		this.termId = termId;
	}
	public Integer getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}
	public Integer getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
	
}
