package com.marakana.contacts.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.ContactRepository;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static ContactRepository contactRepository = new ContactRepository();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("add") != null) {
			request.getRequestDispatcher("jsp/addContact.jsp").forward(request,
					response);
		} else {
			Long id = Long.parseLong(request.getParameter("id"));
			Contact contact = contactRepository.find(id);
			request.setAttribute("contact", contact);
			if (request.getParameter("edit") != null) {
				request.getRequestDispatcher("/jsp/editContact.jsp").forward(
						request, response);
			} else
				request.getRequestDispatcher("/jsp/viewContact.jsp").forward(
						request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("add") != null) {
			Address address = new Address(request.getParameter("city"),
					request.getParameter("state"),
					request.getParameter("street"), Integer.parseInt(request
							.getParameter("zip")));
			Contact contact = new Contact(request.getParameter("name"), address);
			contact = contactRepository.save(contact);
			response.sendRedirect("/contactList");
		} else if (request.getParameter("delete") != null) {
			Contact contact = contactRepository.find(Long.parseLong(request
					.getParameter("id")));
			contactRepository.delete(contact);
			response.sendRedirect("/contactList");
		} else if (request.getParameter("save") != null) {
			Address address = new Address(request.getParameter("city"),
					request.getParameter("state"),
					request.getParameter("street"), Integer.parseInt(request
							.getParameter("zip")));
			address.setId(Long.parseLong(request.getParameter("adresseId")));
			Contact contact = new Contact(request.getParameter("name"), address);
			contact.setId(Long.parseLong(request.getParameter("id")));
			contactRepository.save(contact);
			response.sendRedirect("/contact?id=" + contact.getId());
		}
	}
}
