package com.race.flashystationery;

public class ReadWriteUserDetails {

    public String dOB, gender, phoneNumber;

    //Contruct
    public  ReadWriteUserDetails(){

    }

    public ReadWriteUserDetails( String textDOB, String textGender, String textPhoneNumber){

        this.phoneNumber = textPhoneNumber;
        this.gender = textGender;
        this.dOB = textDOB;
    }
}
