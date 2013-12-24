package com.marakana.contacts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Office {
	@Id
	@GeneratedValue
	Long id;
	
	@Column
	String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address address;

	public Office() {

	}

	public Office(String name,Address address) {
		this.name=name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
}
