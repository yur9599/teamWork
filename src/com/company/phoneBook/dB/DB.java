package com.company.phoneBook.dB;

import com.company.phoneBook.contact.Contact;

import java.io.*;

import static com.company.phoneBook.PhoneBookApp.CONTACTS;

public class DB {

    private DB(){}

    public static void uploadData(File file){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            while (true){
                try {
                    CONTACTS.add((Contact) ois.readObject());
                }
                catch (EOFException e){
                    break;
                }
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void updateData(File file){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            for (Contact x:CONTACTS){
                oos.writeObject(x);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
