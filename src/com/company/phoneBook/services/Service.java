package com.company.phoneBook.services;

import com.company.phoneBook.contact.Contact;

import java.util.List;

public interface Service {

    void addContact(Contact contact);

    List<Contact> search(String userName);

    Contact update(Contact contact);

    void delete(Contact contact);

}
