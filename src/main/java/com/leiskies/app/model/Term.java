package com.leiskies.app.model;

public class Term {
	private Integer id;
	private String name;
	public Term(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Term(String name) {
		this.name = name;
	}
	public Term() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Term [id=" + id + ", name=" + name + "]";
	}
}
