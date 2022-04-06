package com.company.phoneBook;

import com.company.phoneBook.contact.Contact;
import com.company.phoneBook.controller.Controller;
import java.util.*;

public class PhoneBookApp {

    private PhoneBookApp(){}

    public final static List<Contact> CONTACTS =new ArrayList<>();

    public static void start(){
        String command;
        Scanner sc = new Scanner(System.in);
        Controller cnt = new Controller();

        while (true) {
            System.out.println("Enter command");
            command=sc.nextLine();
            if (command.equals("exit")){
                break;
            }
            switch (command) {
                case ("update") -> cnt.contUpdate();
                case ("delete") -> cnt.contDelete();
                case ("contacts") -> printContacts();
                case ("search") -> cnt.contSearch();
                case ("add") -> cnt.contAdd();
                case ("help") -> System.out.println("""
                        You can choose one of these commands
                                                    
                        add
                        update
                        search
                        delete
                        contacts
                        exit
                        """);
                default -> System.out.println("Invalid command");
            }
        }
    }

    private static void printContacts(){
        for (Contact contact:CONTACTS){
            System.out.println(contact.getUserName()+'\n'+contact.getUser());
        }
    }

}
