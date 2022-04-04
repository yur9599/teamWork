package com.company.phoneBook.enums;


public enum ContactDataTypes {

    MOBILE("mobile"),
    HOME("home"),
    WORK("work"),
    SCHOOL("school");

    ContactDataTypes(String type){
        this.type=type;
    }

    private final String type;

    public static ContactDataTypes findByType(String type){
        for (ContactDataTypes x:values()){
            if (type.equals(x.getType())){
                return x;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

}
