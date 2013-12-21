package com.marakana.contacts.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.AddressRepository;
import com.marakana.contacts.repositories.ContactRepository;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static AddressRepository addressRepository = new AddressRepository();
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
			Address address = addressRepository.find(contact.getAdresseId());
			request.setAttribute("contact", contact);
			request.setAttribute("address", address);
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
			address=addressRepository.save(address);
			Contact contact = new Contact(request.getParameter("name"),
					address.getId());
			contact=contactRepository.save(contact);
			response.sendRedirect("/contactList");
		} else if (request.getParameter("delete") != null) {
			Contact contact = contactRepository.find(Long.parseLong(request
					.getParameter("id")));
			Address address = addressRepository.find(contact.getAdresseId());
			contactRepository.delete(contact);
			addressRepository.delete(address);
			response.sendRedirect("/contactList");
		} else if (request.getParameter("save") != null) {
			Address address = new Address(request.getParameter("city"),
					request.getParameter("state"),
					request.getParameter("street"), Integer.parseInt(request
							.getParameter("zip")));
			address.setId(Long.parseLong(request.getParameter("adresseId")));
			Contact contact = new Contact(request.getParameter("name"),
					Long.parseLong(request.getParameter("adresseId")));
			contact.setId(Long.parseLong(request.getParameter("id")));
			addressRepository.save(address);
			contactRepository.save(contact);
			response.sendRedirect("/contact?id=" + contact.getId());
		}
	}
}
