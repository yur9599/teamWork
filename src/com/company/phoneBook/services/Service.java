package com.company.phoneBook.services;

import com.company.phoneBook.contact.Contact;
import java.util.ArrayList;
import java.util.List;

import static com.company.phoneBook.PhoneBookApp.CONTACTS;

public interface Service {

    void addContact(Contact contact);

    void search(String userName);

    Contact update(Contact contact);

    void delete(Contact contact);

    default List<Contact> listOfTheSameNameContacts(String userName) {
        List<Contact> contacts = new ArrayList<>();
        for (Contact x: CONTACTS){
            if (x.getUserName().equals(userName)) {
                contacts.add(x);
            }
        }
        return contacts;
    }

    default void printWithPosition(String userName){
        int index=0;
        for (Contact x: CONTACTS){
            if (x.getUserName().equals(userName)) {
                System.out.println(x.getUserName() + '\n' + "POSITION "+(index++)+ '\n' + x.getUser());
            }
        }
    }

}
