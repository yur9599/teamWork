package com.company.phoneBook;

import com.company.phoneBook.contact.Contact;
import com.company.phoneBook.controller.Controller;

import java.io.*;
import java.util.*;

import static com.company.phoneBook.dB.DB.*;

public class PhoneBookApp {

    private PhoneBookApp(){}

    public final static List<Contact> CONTACTS =new ArrayList<>();

    public static void start(){
        int count=0;
        String command;
        Scanner sc = new Scanner(System.in);
        Controller cnt = new Controller();
        File file = new File("contactsData.txt");
        if (file.length() != 0) {
            uploadData(file);
        }
        while (true) {
            System.out.println("Enter command");
            if ((count++)==0) {
                System.out.println("If you don`t know what to write enter (help)");
            }
            command=sc.nextLine();
            if (command.equals("exit")){
                updateData(file);
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
