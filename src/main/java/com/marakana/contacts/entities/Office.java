package com.marakana.contacts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Office extends UrlEntity {

	@Column(nullable=false,length=64)
	private String name;

	@OneToOne(optional=false,cascade = CascadeType.ALL)
	private Address address;

	@ManyToOne(optional=false)
	private Company company;

	public Office() {

	}

	public Office(String name, Address address, Company company) {
		this.name = name;
		this.address = address;
		this.company=company;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
