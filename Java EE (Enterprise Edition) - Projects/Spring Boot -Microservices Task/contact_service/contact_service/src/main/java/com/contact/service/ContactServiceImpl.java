package com.contact.service;

import com.contact.entity.Contact;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;


@Service
public class ContactServiceImpl implements ContactService {

    //fake list of contacts

    List<Contact> list = List.of(
            new Contact(1L, "ahmad@gmail.com", "Ahmad", 1311L),
            new Contact(2L, "luqman@gmail.com", "Luqman", 1311L),
            new Contact(3L, "ibrahim@gmail.com", "Ibrahim", 1312L),
            new Contact(4L, "hashaam@gmail.com", "Hashaam", 1314L)
    );


    @Override
    public List<Contact> getContactsOfUser(Long userId) {
        
    	List<Contact> filteredContacts = new ArrayList<>();
    	for (Contact contact : list) {
    	    if (contact.getUserId().equals(userId)) {
    	        filteredContacts.add(contact);
    	    }
    	}
    	return filteredContacts;

    }
}
