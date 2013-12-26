package com.marakana.contacts.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import javax.persistence.CascadeType;

@Entity
public class Company extends Contact {

	@OneToMany(mappedBy = "company", orphanRemoval=true,cascade = CascadeType.ALL)
	Set<Office> offices;

	public Company() {

	}

	public Company(String name) {
		super(name);
	}

	public Company(String name, Set<Office> offices) {
		super(name);
		this.offices = offices;
	}

	public Set<Office> getOffices() {
		return offices;
	}

	public void setOffices(Set<Office> offices) {
		this.offices = offices;
	}
}
