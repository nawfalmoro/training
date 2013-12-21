package com.marakana.contacts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private Long adresseId;

	public Contact(){};
	public Contact(String name, Long adresseId) {
		super();
		this.name = name;
		this.adresseId = adresseId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAdresseId() {
		return adresseId;
	}

	public void setAdresseId(long adresseId) {
		this.adresseId = adresseId;
	}

}
