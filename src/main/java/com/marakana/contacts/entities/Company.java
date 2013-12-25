package com.marakana.contacts.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Company extends Contact {

	public Company() {

	}

	public Company(String name) {
		super(name);
	}

	public Company(String name, Set<Office> offices) {
		super(name);
		this.offices = offices;
	}

	@OneToMany
	@JoinTable(joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "office_id"))
	Set<Office> offices;

	public Set<Office> getOffices() {
		return offices;
	}

	public void setOffices(Set<Office> offices) {
		this.offices = offices;
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return "/company?id=";
	}

}
