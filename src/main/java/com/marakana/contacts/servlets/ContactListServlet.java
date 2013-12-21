package com.marakana.contacts.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.ContactRepository;
@WebServlet("/contactList")
public class ContactListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// instantiate an address repository
		ContactRepository contactRepository = new ContactRepository();
		List<Contact> contacts=null;
			contacts=contactRepository.findAll();
		request.setAttribute("contacts", contacts);
		RequestDispatcher view = request.getRequestDispatcher("jsp/contactList.jsp");
		view.forward(request, response);
	}

}
