package com.company.phoneBook.controller;

import com.company.phoneBook.contact.Contact;
import com.company.phoneBook.enums.ContactDataTypes;
import com.company.phoneBook.services.Service;
import com.company.phoneBook.services.impl.ContactServiceImpl;
import com.company.phoneBook.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.company.phoneBook.enums.ContactDataTypes.findByType;
import static com.company.phoneBook.validator.Validator.*;

public class Controller {

    Scanner sc = new Scanner(System.in);
    Service service = new ContactServiceImpl();
    private Contact member;

    public void contUpdate(){
        int i=0;
        String userName1;
        while (true){
            System.out.print("Enter userName ");
            userName1= sc.nextLine();
            if (isValidUserName(userName1)) {
                break;
            }
            else {
                System.out.println("Invalid insert ");
            }
        }
        List<Contact> contacts = service.listOfTheSameNameContacts(userName1);
        if (contacts.size()>1) {
            service.printWithPosition(userName1);
            while (true){
                System.out.print("Choose contact by its position ");
                i = sc.nextInt();
                if (isValidPosition(i) && i<=contacts.size()-1) {
                    break;
                }
                else {
                    System.out.println("Invalid input ");
                }
            }
        }
        else {
            service.search(userName1);
        }
        member=service.update(contacts.get(i));
        System.out.println("""
                            Choose by number what do you want to update
                            1-UserName
                            2-PhoneNumber
                            3-Company
                            4-Email
                            """);
        int var= sc.nextInt();
        sc.nextLine();
        switch (var) {
            case 1 -> updateName();
            case 2 -> updatePhoneNumber();
            case 3 -> updateCompanyName();
            case 4 -> updateEmail();
        }
    }

    public void contDelete(){
        int position=0;
        String userName2;
        while (true){
            System.out.println("Enter userName ");
            userName2= sc.nextLine();
            if (isValidUserName(userName2)) {
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }
        List<Contact> contacts1 = service.listOfTheSameNameContacts(userName2);
        if (contacts1.size()>1) {
            service.printWithPosition(userName2);
            while (true){
                System.out.print("Choose contact by its position ");
                position = sc.nextInt();
                if (isValidPosition(position) && position<=contacts1.size()-1) {
                    break;
                }
                else {
                    System.out.println("Invalid input ");
                }
            }
            sc.nextLine();
        }
        else {
            service.search(userName2);
        }
        service.delete(contacts1.get(position));
        System.out.println();
    }

    public void contAdd(){
        String phoneNumberType;
        String phoneNumber;
        String company;
        String emailType;
        String email;
        String userName;

        Map<ContactDataTypes,String> phone = new HashMap<>();
        Map<ContactDataTypes,String> mail = new HashMap<>();

        while (true){
            System.out.print("Enter phoneNumberType ");
            phoneNumberType= sc.nextLine();
            if (isValidPhoneNUmberType(phoneNumberType)){
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }
        while (true){
            System.out.print("Enter phoneNumber ");
            phoneNumber= sc.nextLine();
            if (isValidPhoneNumber(phoneNumber)) {
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }
        while (true){
            System.out.print("Enter company ");
            company= sc.nextLine();
            if (isValidCompanyName(company)) {
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }
        while (true){
            System.out.print("Enter emailType ");
            emailType= sc.nextLine();
            if (isValidEmailType(emailType)) {
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }
        while (true){
            System.out.print("Enter email ");
            email= sc.nextLine();
            if (isValidEmail(email)) {
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }
        while (true){
            System.out.print("Enter userName ");
            userName= sc.nextLine();
            if (isValidUserName(userName)) {
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }

        phone.put(findByType(phoneNumberType),phoneNumber);
        mail.put(findByType(emailType),email);

        User user = new User(phone,company,mail);
        Contact contact = new Contact(userName,user);
        service.addContact(contact);
        System.out.println();
    }

    public void contSearch(){
        String userNameForSearch;
        while (true){
            System.out.println("Enter name for search");
            userNameForSearch=sc.nextLine();
            if (isValidUserName(userNameForSearch)) {
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }
        service.search(userNameForSearch);
    }

    private void updateName(){
        String userName;
        while (true) {
            System.out.println("Enter new userName");
            userName=sc.nextLine();
            if (isValidUserName(userName)) {
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }
        member.setUserName(userName);
    }

    private void updatePhoneNumber(){
        String phoneType;
        String phoneNumber;
        while (true) {
            System.out.println("Enter phone type which you want to update/add ");
            phoneType=sc.nextLine();
            if (isValidPhoneNUmberType(phoneType)) {
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }
        while (true) {
            System.out.println("Enter new phone number ");
            phoneNumber=sc.nextLine();
            if (isValidPhoneNumber(phoneNumber)) {
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }
        member.getUser().getPhoneNumber().put(findByType(phoneType),phoneNumber);
    }

    private void updateEmail(){
        String emailType;
        String email;
        while (true) {
            System.out.println("Enter email type which you want to update/add ");
            emailType=sc.nextLine();
            if (isValidEmailType(emailType)) {
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }
        while (true) {
            System.out.println("Enter new email ");
            email=sc.nextLine();
            if (isValidEmail(email)) {
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }
        member.getUser().getEmail().put(findByType(emailType),email);
    }

    private void updateCompanyName(){
        String companyName;
        while (true) {
            System.out.println("Enter new company name");
            companyName=sc.nextLine();
            if (isValidCompanyName(companyName)) {
                break;
            }
            else {
                System.out.println("Invalid input ");
            }
        }
        member.getUser().setCompany(companyName);
    }

}
