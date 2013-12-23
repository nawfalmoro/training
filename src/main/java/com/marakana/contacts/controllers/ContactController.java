package com.marakana.contacts.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.ContactRepository;

@Controller
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public void getContactList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contacts", contactRepository.findAll());
		RequestDispatcher view = request
				.getRequestDispatcher("view/contact/list.jsp");
		view.forward(request, response);
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public void getContact(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("add") != null) {
			request.getRequestDispatcher("view/contact/add.jsp").forward(
					request, response);
		} else {
			// getting an id from request parameter and populating the model
			// withe the contact
			long id = Long.parseLong(request.getParameter("id"));
			Contact contact = contactRepository.findOne(id);
			request.setAttribute("contact", contact);
			// select edit or view forward
			if (request.getParameter("edit") != null) {
				request.getRequestDispatcher("/view/contact/edit.jsp").forward(
						request, response);

			} else
				request.getRequestDispatcher("/view/contact/view.jsp").forward(
						request, response);
		}
	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public void postContact(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("add") != null) {
			Address address = new Address(request.getParameter("city"),
					request.getParameter("state"),
					request.getParameter("street"), Integer.parseInt(request
							.getParameter("zip")));
			Contact contact = new Contact(request.getParameter("name"), address);
			contact = contactRepository.save(contact);
			response.sendRedirect("/contacts");
		} else if (request.getParameter("delete") != null) {
			Contact contact = contactRepository.findOne(Long.parseLong(request
					.getParameter("id")));
			contactRepository.delete(contact);
			response.sendRedirect("/contacts");
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
