package com.marakana.contacts.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Company extends Contact{
	
	public Company(){
		
	}
	
	public Company(String name,Set<Office> offices){
		super(name);
		this.offices=offices;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	Set<Office> offices;

	public Set<Office> getOffices() {
		return offices;
	}

	public void setOffices(Set<Office> offices) {
		this.offices = offices;
	}
	
	
}
