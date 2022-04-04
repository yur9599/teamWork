package com.company.phoneBook.services.impl;

import static com.company.phoneBook.PhoneBookApp.CONTACTS;
import com.company.phoneBook.contact.Contact;
import com.company.phoneBook.services.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactServiceImpl implements Service {

    @Override
    public void addContact(Contact member) {
        Collections.sort(CONTACTS);
        CONTACTS.add(member);
    }

    public List<Contact> searchWithPosition(String userName) {
        int index=0;
        List<Contact> contacts = new ArrayList<>();
        for (Contact x: CONTACTS){
            if (x.getUserName().equals(userName)) {
                System.out.println(x.getUserName() + '\n' + "POSITION "+(index++)+ '\n' + x.getUser());
                contacts.add(x);
            }
        }
        return contacts;
    }

    @Override
    public List<Contact> search(String userName) {
        List<Contact> contacts = new ArrayList<>();
        for (Contact x: CONTACTS){
            if (x.getUserName().equals(userName)) {
                System.out.println(x.getUserName() + " " + '\n' + x.getUser());
                contacts.add(x);
            }
        }
        return contacts;
    }

    @Override
    public Contact update(Contact contact) {
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        CONTACTS.remove(contact);
    }

}
