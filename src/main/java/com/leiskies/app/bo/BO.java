package com.leiskies.app.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.leiskies.app.dao.ModelDAO;
import com.leiskies.app.model.Answer;
import com.leiskies.app.model.Answer_Tag;
import com.leiskies.app.model.Attribute;
import com.leiskies.app.model.Tag;
import com.leiskies.app.model.Term;
import com.leiskies.app.model.Term_Attribute_Answer;
import com.leiskies.app.model.Term_Tag;

public class BO {
	private static ModelDAO dao;
	
	private boolean add(Term term) {
		boolean added = false;
		Term dbTerm = null;
		dao = new ModelDAO<Term,Integer>(Term.class);
		if((dbTerm = (Term) dao.readByAttribute("name", term.getName()))==null) {
			added = dao.create(term);
		}	return added;
	}
	private boolean add(Tag tag) {
		boolean added = false;
		Tag dbTag = null;
		dao = new ModelDAO<Tag,Integer>(Tag.class);
		if((dbTag = (Tag) dao.readByAttribute("name", tag.getName()))==null) {
			added = dao.create(tag);
		}	return added;
	}
	private boolean add(Answer answer) {
		boolean added = false;
		Answer dbAnswer = null;
		dao = new ModelDAO<Answer,Integer>(Answer.class);
		if((dbAnswer = (Answer) dao.readByAttribute("content", answer.getContent()))==null) {
			added = dao.create(answer);
		}	return added;
	}
	
	private Integer update(Term term) {
		int updated = 0;
		Term dbTerm = null;
		dao = new ModelDAO<Term,Integer>(Term.class);
		if((dbTerm = (Term) dao.readByAttribute("name", term.getName()))!=null) {
			updated = dao.update(term);
		}	return updated;
	}
	private Integer update(Tag tag) {
		int updated = 0;
		Tag dbTag = null;
		dao = new ModelDAO<Tag,Integer>(Tag.class);
		if((dbTag = (Tag) dao.readByAttribute("name", tag.getName()))!=null) {
			updated = dao.update(tag);
		}	return updated;
	}
	private Integer update(Answer answer) {
		int updated = 0;
		Answer dbAnswer = null;
		dao = new ModelDAO<Answer,Integer>(Answer.class);
		if((dbAnswer = (Answer) dao.readByAttribute("content", answer.getContent()))!=null) {
			updated = dao.update(answer);
		}	return updated;
	}
	
	private boolean delete(Term term) {
		boolean deleted = false;;
		Term dbTerm = null;
		dao = new ModelDAO<Term,Integer>(Term.class);
		if((dbTerm = (Term) dao.readByAttribute("name", term.getName()))!=null) {
			deleted = dao.delete(term);
		}	return deleted;
	}
	
	private boolean delete(Tag tag) {
		boolean deleted = false;;
		Tag dbTag = null;
		dao = new ModelDAO<Tag,Integer>(Tag.class);
		if((dbTag = (Tag) dao.readByAttribute("name", tag.getName()))!=null) {
			deleted = dao.delete(tag);
		}	return deleted;
	}
	
	private boolean delete(Answer answer) {
		boolean deleted = false;;
		Answer dbAnswer = null;
		dao = new ModelDAO<Answer,Integer>(Answer.class);
		if((dbAnswer = (Answer) dao.readByAttribute("content", answer.getContent()))!=null) {
			deleted = dao.delete(answer);
		}	return deleted;
	}
	
	private static Integer getTermId(String name) {
		Integer id = null;
		Term dbTerm = null;
		dao = new ModelDAO<Term,Integer>(Term.class);
		if((dbTerm = (Term) dao.readByAttribute("name", name))!=null) {
			id = dbTerm.getId();
		}	return id;
	}
	
	private Integer getTagId(String name) {
		Integer id = null;
		Tag dbTag = null;
		dao = new ModelDAO<Tag,Integer>(Tag.class);
		if((dbTag = (Tag) dao.readByAttribute("name", name))!=null) {
			id = dbTag.getId();
		}	return id;
	}
	
	private static Integer getAttributeId(String name) {
		Integer id = null;
		Attribute dbAttribute = null;
		dao = new ModelDAO<Attribute,Integer>(Attribute.class);
		if((dbAttribute = (Attribute) dao.readByAttribute("name", name))!=null) {
			id = dbAttribute.getId();
		}	return id;
	}
	
	private Integer getAnswerId(String content) {
		Integer id = null;
		Answer dbAnswer = null;
		dao = new ModelDAO<Answer,Integer>(Answer.class);
		if((dbAnswer = (Answer) dao.readByAttribute("content", content))!=null) {
			id = dbAnswer.getId();
		}	return id;
	}
	
	private String[] strings(String rawWithDelimiter) {
		return rawWithDelimiter.split(",");
	}
	
	public void processTerm(String term, String termTagsRaw, String attribute, String answer, String answerTagsRaw) {
		int termId = 0;
		int attributeId = 0;
		int answerId = 0;
		List<Integer> tagIds = new ArrayList<Integer>();
		
		//insert new term into term table and get term id
		if(term!=null && !term.isBlank()) {
			dao = new ModelDAO<Term,Integer>(Term.class);
			if(dao.readByAttribute("name", term)==null) {
				if(dao.create(new Term(term))) {
					if(getTermId(term)!=null) {
						termId = getTermId(term);
					}
				}
			}	else {
				if(getTermId(term)!=null) {
					termId = getTermId(term);
				}
			}
		}
		
		//insert new attribute into attribute table and get attribute id
		if(attribute!=null && !attribute.isBlank()) {
			dao = new ModelDAO<Attribute,Integer>(Attribute.class);
			if(dao.readByAttribute("name", attribute)==null) {
				if(dao.create(new Attribute(attribute))) {
					if(getAttributeId(attribute)!=null) {
						attributeId = getAttributeId(attribute);
					}
				}
			}	else {
				if(getAttributeId(attribute)!=null) {
					attributeId = getAttributeId(attribute);
				}
			}
		}
		
		//insert new answer into answer table and get answer id
		if(answer!=null && !answer.isBlank()) {
			dao = new ModelDAO<Answer,Integer>(Answer.class);
			if(dao.readByAttribute("content", answer)==null) {
				if(dao.create(new Answer(answer))) {
					if(getAnswerId(answer)!=null) {
						answerId = getAnswerId(answer);
					}
				}
			}	else {
				if(getAnswerId(answer)!=null) {
					answerId = getAnswerId(answer);
				}
			}
		}
		
		//insert new tags into tag table using term_tags
		if(termTagsRaw!=null && !termTagsRaw.isBlank()) {
			dao = new ModelDAO<Tag,Integer>(Tag.class);
			for(String tagString:termTagsRaw.split(",")) {
				if(dao.readByAttribute("name", tagString.trim())==null) {
					if(dao.create(new Tag(tagString.trim()))) {
						if(getTagId(tagString.trim())!=null) {
							tagIds.add(getTagId(tagString.trim()));
						}
					}
				}	else {
					if(getTagId(tagString.trim())!=null) {
						tagIds.add(getTagId(tagString.trim()));
					}
				}
			}
		}
		
		//insert new tags into tag table using answer_tags
		if(answerTagsRaw!=null && !answerTagsRaw.isBlank()) {
			for(String tagString:termTagsRaw.split(",")) {
				if(dao.readByAttribute("name", tagString.trim())==null) {
					if(dao.create(new Tag(tagString.trim()))) {
						if(getTagId(tagString.trim())!=null) {
							tagIds.add(getTagId(tagString.trim()));
						}
					}
				}	else {
					if(getTagId(tagString.trim())!=null) {
						tagIds.add(getTagId(tagString.trim()));
					}
				}
			}
		}
		
		
		if(tagIds.size()>0 && !tagIds.isEmpty()) {
			dao = new ModelDAO<Term_Tag,Integer>(Term_Tag.class);
			if(termId!=0) {
				List<Term_Tag> allDbTermTags = new ArrayList<Term_Tag>();
				for(Term_Tag termTag : (ArrayList<Term_Tag>)dao.readAll()) {
					if(termTag.getTermId() == termId) {
						allDbTermTags.add(termTag);
					}
				}
				
				if(allDbTermTags!=null && !allDbTermTags.isEmpty()) {
			
					for(int tagId : tagIds) {
						Term_Tag termTag = (Term_Tag) dao.readByAttribute("tag_id", tagId);
						if(termTag==null) {
							dao.create(new Term_Tag(termId,tagId));
						}
					}
				}
			}
			dao = new ModelDAO<Answer_Tag,Integer>(Answer_Tag.class);
			if(answerId!=0) {
				List<Answer_Tag> allDbAnswerTags = new ArrayList<Answer_Tag>();
				for(Answer_Tag answerTag : (ArrayList<Answer_Tag>)dao.readAll()) {
					if(answerTag.getAnswerId() == answerId) {
						allDbAnswerTags.add(answerTag);
					}
				}
				
				if(allDbAnswerTags!=null && !allDbAnswerTags.isEmpty()) {
					
					for(int tagId : tagIds) {
						Answer_Tag answerTag = (Answer_Tag) dao.readByAttribute("tag_id", tagId);
						if(answerTag==null) {
							dao.create(new Answer_Tag(termId,tagId));
						}
					}
				}
			}
		}
		
		if(!(term==null && attribute==null && answer==null) &&
				!(term.isBlank() && attribute.isBlank() && answer.isBlank()) &&
					!(termId==0 && attributeId==0 && answerId==0)) {
			dao = new ModelDAO<Term_Attribute_Answer, Integer>(Term_Attribute_Answer.class);
			List<Term_Attribute_Answer> termAttributeAnswerList = new ArrayList<Term_Attribute_Answer>();
			List<Term_Attribute_Answer> dbList = null;
			dbList = dao.readAll();
			
			for (int i = 0; i < dbList.size(); i++) {
				if(dbList.get(i).getAnswerId() == answerId &&
						dbList.get(i).getAttributeId() == attributeId &&
							dbList.get(i).getAnswerId() == answerId) {
					termAttributeAnswerList.add(dbList.get(i));
				}
			}
		}
	}
}