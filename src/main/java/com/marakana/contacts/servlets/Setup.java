package com.marakana.contacts.servlets;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.AddressRepository;
import com.marakana.contacts.repositories.ContactRepository;

//class to test our repositories classes
@WebListener
public class Setup implements ServletContextListener {
 
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// instantiate an address repository
		AddressRepository addressRepository=new AddressRepository();
		ContactRepository contactRepository=new ContactRepository();
		try {
			Address address=new Address("San Jose", "CA", "150 West Tasman Dr", 95134);
			addressRepository.init();
			contactRepository.init();
			addressRepository.create(address);
			contactRepository.create(new Contact("nawfal", address.getId()));
			contactRepository.create(new Contact("joe",  address.getId()));
			contactRepository.create(new Contact("jason",  address.getId()));
			contactRepository.create(new Contact("steve",  address.getId()));
			
			contactRepository.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
