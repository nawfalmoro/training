package com.marakana.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Office;
import com.marakana.contacts.repositories.CompanyRepository;
import com.marakana.contacts.repositories.OfficeRepository;

@Controller
public class OfficeController {

	@Autowired
	private OfficeRepository officeRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@RequestMapping(value = "/office", params = "add", method = RequestMethod.GET)
	public String getAddOffice(@RequestParam Long company_id, Model model) {
		model.addAttribute("company", companyRepository.findOne(company_id));
		return "office/add";
	}

	@RequestMapping(value = "/office", params = "edit", method = RequestMethod.GET)
	public String getEditOffice(@RequestParam long id, Model model) {
		model.addAttribute("office", officeRepository.findOne(id));
		return "office/edit";
	}

	@RequestMapping(value = "/office", method = RequestMethod.GET)
	public String getViewOffice(@RequestParam Long id, Model model) {
		model.addAttribute("office", officeRepository.findOne(id));
		return "office/view";
	}

	@RequestMapping(value = "/office", params = "add", method = RequestMethod.POST)
	public String postAddOffice(@RequestParam String name,
			@RequestParam String city, @RequestParam String state,
			@RequestParam String street, @RequestParam int zip,
			@RequestParam Long company_id) {
		Address address = new Address(city, state, street, zip);
		Office office = new Office(name, address,
				companyRepository.findOne(company_id));
		office = (Office) officeRepository.save(office);
		return "redirect:" + office.getUrl();
	}

	@RequestMapping(value = "/office", params = "delete", method = RequestMethod.POST)
	@Transactional
	public String postDeleteOffice(@RequestParam Long id) {
		Office office = officeRepository.findOne(id);
		officeRepository.delete(office);
		return "redirect:" + office.getCompany().getUrl();
	}

	@RequestMapping(value = "/office", params = "edit", method = RequestMethod.POST)
	@Transactional
	public String postEditOffice(@RequestParam Long id,
			@RequestParam String name, @RequestParam String city,
			@RequestParam String state, @RequestParam String street,
			@RequestParam int zip) {
		Office office = (Office) officeRepository.findOne(id);
		office.setName(name);
		office.getAddress().setCity(city);
		office.getAddress().setState(state);
		office.getAddress().setStreet(street);
		office.getAddress().setZip(zip);
		officeRepository.save(office);
		return "redirect:" + office.getUrl();

	}
}
