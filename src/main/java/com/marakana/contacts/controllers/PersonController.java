package com.marakana.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Person;
import com.marakana.contacts.repositories.PersonRepository;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(value = "/person", params = "add", method = RequestMethod.GET)
	public String getAddPerson() {
		return "person/add";
	}

	@RequestMapping(value = "/person", params = "edit", method = RequestMethod.GET)
	public String getEditPerson(@RequestParam long id, Model model) {
		model.addAttribute("person", personRepository.findOne(id));
		return "person/edit";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String getViewPerson(@RequestParam Long id, Model model) {
		model.addAttribute("person", personRepository.findOne(id));
		return "person/view";
	}

	@RequestMapping(value = "/person", params = "add", method = RequestMethod.POST)
	public String postAddPerson(@RequestParam String name,
			@RequestParam String city, @RequestParam String state,
			@RequestParam String street, @RequestParam int zip) {
		Address address = new Address(city, state, street, zip);
		Person person = new Person(name, address);
		person = (Person) personRepository.save(person);
		return "redirect:person?id=" + person.getId();
	}

	@RequestMapping(value = "/person", params = "delete", method = RequestMethod.POST)
	public String postDeletePerson(@RequestParam Long id) {
		personRepository.delete(id);
		return "redirect:contacts";
	}

	@RequestMapping(value = "/person", params = "edit", method = RequestMethod.POST)
	public String postEditPerson(@RequestParam Long id,
			@RequestParam String name, @RequestParam String city,
			@RequestParam String state, @RequestParam String street,
			@RequestParam int zip) {
		Person person = (Person) personRepository.findOne(id);
		person.setName(name);
		person.getAddress().setCity(city);
		person.getAddress().setState(state);
		person.getAddress().setStreet(street);
		person.getAddress().setZip(zip);
		personRepository.save(person);
		return "redirect:person?id=" + person.getId();

	}
}
