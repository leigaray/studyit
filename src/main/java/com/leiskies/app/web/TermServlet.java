package com.leiskies.app.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leiskies.app.bo.BO;
import com.leiskies.app.dao.ModelDAO;
import com.leiskies.app.model.Attribute;
import com.leiskies.app.model.Tag;
import com.leiskies.app.model.Term;

/**
 * Servlet implementation class TermServlet
 */
@WebServlet("/")
public class TermServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TermServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();
		System.out.println(action);
		switch(action) {
		case "/ViewAllTerms":
			listAllTerms(request, response);
			break;
		case "/AddANewTerm":
			addNewTerm(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		switch(action) {
		
		case "/AddANewTerm":
			registerNewTerm(request, response);
			break;
		}
	}
	
	private void listAllTerms(HttpServletRequest request, final HttpServletResponse response) 
			throws ServletException, IOException {
		ModelDAO<Term,Integer> termDao = new ModelDAO<Term,Integer>(Term.class);
		List<Term> allTermList = termDao.readAll();
		ModelDAO<Tag,Integer> tagDao = new ModelDAO<Tag,Integer>(Tag.class);
		List<Tag> allTagList = tagDao.readAll();
		ModelDAO<Attribute,Integer> attributeDao = new ModelDAO<Attribute,Integer>(Attribute.class);
		List<Attribute> allAttributeList = attributeDao.readAll();
		
		
		System.out.println("inside listAllTerms");
		System.out.println("size of listAllTerms:"+allTermList.size());
		request.setAttribute("allTermList", allTermList);
		//request.setAttribute("allTagList", allTagList);
		//request.setAttribute("allAttributeList", allAttributeList);
		request.getRequestDispatcher("termView.jsp").forward(request, response);
		

	}
	
	private void addNewTerm(HttpServletRequest request, final HttpServletResponse response) 
			throws ServletException, IOException {
		ModelDAO<Term,Integer> termDao = new ModelDAO<Term,Integer>(Term.class);
		List<Term> allTermList = termDao.readAll();
		ModelDAO<Tag,Integer> tagDao = new ModelDAO<Tag,Integer>(Tag.class);
		List<Tag> allTagList = tagDao.readAll();
		ModelDAO<Attribute,Integer> attributeDao = new ModelDAO<Attribute,Integer>(Attribute.class);
		List<Attribute> allAttributeList = attributeDao.readAll();
		
		
		System.out.println("inside addNewTerm");
		request.setAttribute("allTermList", allTermList);
		request.setAttribute("allTagList", allTagList);
		request.setAttribute("allAttributeList", allAttributeList);
		request.getRequestDispatcher("addNewTermForm.jsp").forward(request, response);
	}
	
	private void registerNewTerm(HttpServletRequest request, final HttpServletResponse response) 
			throws ServletException, IOException {
		
		String term = request.getParameter("term");
		String attribute = request.getParameter("attribute");
		String answer = request.getParameter("answer");
		String termTags = request.getParameter("term_tags");
		String answerTags = request.getParameter("answer_tags");
		BO bo = new BO();
		bo.processTerm(term, termTags, attribute, answer, answerTags);
		request.getRequestDispatcher("addNewTermForm.jsp").forward(request, response);
	}

}
