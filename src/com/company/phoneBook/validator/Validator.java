package com.company.phoneBook.validator;


public class Validator {

    private Validator(){}

    public static boolean isValidPhoneNumber(String number){
        if (number==null || number.length()==0){
            return false;
        }
        if (number.charAt(0)=='+'){
            number=number.substring(1);
        }
        char[] arr=number.toCharArray();
        for (char x: arr) {
            if (x==' '){
                continue;
            }
            if (x<'0' || x>'9'){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidPhoneNUmberType(String type){
        if (type==null || type.length()==0){
            return false;
        }
        switch (type){
            case("home"):
            case("mobile"):
            case("work"):
            case("school"):
                return true;
        }
        return false;
    }

    public static boolean isValidEmailType(String type){
        if (type==null || type.length()==0){
            return false;
        }
        switch (type){
            case("home"):
            case("work"):
            case("school"):
                return true;
        }
        return false;
    }

    public static boolean isValidUserName(String userName){
        return userName == null || userName.length() != 0;
    }

    public static boolean isValidCompanyName(String companyName){
        return companyName == null || companyName.length() != 0;
    }

    public static boolean isValidEmail(String email){
        if (email==null || email.length()==0){
            return false;
        }
        if (email.contains("@")){
            String subEmail=email.substring(email.indexOf('@')+1);
            if (dotsCount(subEmail)>1){
                return false;
            }
            for (int i = 0; i < subEmail.length(); i++) {
                if (subEmail.charAt(i)=='.'){
                    continue;
                }
                if (subEmail.charAt(i)<'a' || subEmail.charAt(i)>'z'){
                    return false;
                }
            }
        }
        return true;
    }

    private static int dotsCount(String word){
        int count=0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i)=='.'){
                count++;
            }
        }
        return count;
    }

    public static boolean isValidPosition(int position){
        return position >= 0;
    }

}
