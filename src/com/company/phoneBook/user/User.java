package com.company.phoneBook.user;

import com.company.phoneBook.enums.ContactDataTypes;

import java.util.Map;

public class User {

    private final Map<ContactDataTypes,String> phoneNumber;
    private String company;
    private final Map<ContactDataTypes,String> email;

    public User(Map<ContactDataTypes, String> phoneNumber, String company, Map<ContactDataTypes, String> email) {
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.email = email;
    }

    public Map<ContactDataTypes, String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setCompany(String company){
        this.company=company;
    }

    public Map<ContactDataTypes, String> getEmail() {
        return email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder cb = new StringBuilder();
        for (Map.Entry<ContactDataTypes,String> x:phoneNumber.entrySet()) {
            sb.append(x.getKey()).append(" ").append(x.getValue()).append('\n');
        }
        for (Map.Entry<ContactDataTypes,String> x:email.entrySet()) {
            cb.append(x.getKey()).append(" ").append(x.getValue()).append('\n');
        }
        return  sb+ "COMPANY " + company + '\n' + cb;
    }

}
