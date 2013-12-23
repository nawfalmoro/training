package com.marakana.contacts.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.ContactRepository;

@Controller
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String getContactList(Model model) {
		model.addAttribute("contacts", contactRepository.findAll());
		return "contact/list";
	}
	
	@RequestMapping(value = "/contact", params ="add", method= RequestMethod.GET)
	public String getAddContact(){
		return "contact/add";
	}
	
	@RequestMapping(value = "/contact", params ="edit", method= RequestMethod.GET)
	public String getEditContact(@RequestParam long id,Model model){
		model.addAttribute("contact",contactRepository.findOne(id));
		return "contact/edit";
	}
	
	@RequestMapping(value = "/contact", method= RequestMethod.GET)
	public String getViewContact(@RequestParam long id,Model model){
		model.addAttribute("contact",contactRepository.findOne(id));
		return "contact/view";
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
