package com.company.phoneBook.contact;

import com.company.phoneBook.user.User;

public class Contact implements Comparable<Contact> {

    private String userName;
    private final User user;

    public Contact(String userName,User user){
        this.userName=userName;
        this.user=user;
    }

    public String getUserName(){
        return userName;
    }

    public User getUser(){
        return user;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }

    @Override
    public int compareTo(Contact o) {
        return this.userName.compareTo(o.userName);
    }

}
