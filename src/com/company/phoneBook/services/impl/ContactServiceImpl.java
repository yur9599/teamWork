package com.company.phoneBook.services.impl;

import static com.company.phoneBook.PhoneBookApp.CONTACTS;
import static com.company.phoneBook.validator.Validator.isValidPhoneNumber;

import com.company.phoneBook.contact.Contact;
import com.company.phoneBook.services.Service;
import java.util.Collections;

public class ContactServiceImpl implements Service {

    @Override
    public void addContact(Contact member) {
        Collections.sort(CONTACTS);
        CONTACTS.add(member);
    }

    @Override
    public void search(String userNameOrPhoneNumber) {
        if (isValidPhoneNumber(userNameOrPhoneNumber)){
            for (Contact x: CONTACTS){
                if (x.getUser().getPhoneNumber().containsValue(userNameOrPhoneNumber)) {
                    System.out.println(x.getUserName() + " " + '\n' + x.getUser());
                }
            }
        }
        else {
            for (Contact x : CONTACTS) {
                if (x.getUserName().equals(userNameOrPhoneNumber)) {
                    System.out.println(x.getUserName() + " " + '\n' + x.getUser());
                }
            }
        }
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
