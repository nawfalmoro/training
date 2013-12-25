package com.marakana.contacts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Person extends Contact{
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

	public Person(){

	}
	
	public Person (String name,Address address){
		super(name);
		this.address=address;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return "/person?id=";
	}
	
	

}
