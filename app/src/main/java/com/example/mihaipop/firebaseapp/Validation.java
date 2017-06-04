package com.example.mihaipop.firebaseapp;

/**
 * Created by mihaipop on 27/05/2017.
 */

public final class Validation {

    private Validation() {}

    public static boolean validString(String string){
        if(string.equals(""))
            return false;
        return true;
    }

    public static boolean validName(String name){

        boolean ok=true;
        name=name.toLowerCase();

        for(int i=0; i<name.length() ; i++){
            if((name.charAt(i)<='a')&&(name.charAt(i)>='z')){
                ok=false;
            }
        }

        return ok;
    }

    public static boolean validUser(String user){

        boolean ok=false;

        for(int i=0 ; i<user.length();i++){
            if(user.charAt(i)=='@'){
                ok=true;
            }
        }

        return ok;
    }

    public static boolean validPhone(String phone){

        boolean ok=true;

        for(int i=0;i<phone.length();i++){
            if((phone.charAt(i)<='0')&&(phone.charAt(i)>='9')){
                ok=false;
            }
        }

        return ok;
    }

    public static boolean validPassword(String password) {

        if (password.length() < 6)
            return false;

        boolean validLitera = false;
        for (int i = 0; i < password.length(); i++)
            if ((password.charAt(i) >= 'A') && (password.charAt(i) <= 'Z'))
                validLitera = true;

        boolean validCifra = false;
        for (int i = 0; i < password.length(); i++)
            if ((password.charAt(i) >= '0') && (password.charAt(i) <= '9'))
                validCifra = true;

        if ((validLitera == false) || (validCifra == false))
            return false;

        return true;
    }


    public static boolean validData(String firstName, String lastName, String phone, String country){

        boolean ok=true;

        if((!validString(firstName)) ||(!validString(lastName)) || (!validString(phone)) ||(!validString(country))) {
            ok = false;
        }

        if((!validName(firstName)) ||(!validName(lastName))  ||(!validName(country))) {
            ok = false;
        }
        if(!validPhone(phone)){
            ok=false;
        }

        return ok;

    }

}
