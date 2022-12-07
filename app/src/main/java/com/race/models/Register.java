package com.race.models;

public class Register {
    int userId;
    String userName, userPhoneNumber, userEmail, userGender, userDOB, userPassword;

    public Register(int userId, String userName, String userPhoneNumber, String userEmail,
                   String userGender, String userDOB, String userPassword) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userDOB = userDOB;
        this.userPassword = userPassword;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;}

    public String getUserEmail() {return userEmail;}

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;}

    public String getUserGender() {return userGender;}

    public void setUserGender(String userGender) {
        this.userGender = userGender;}

    public String getUserDOB() {return userDOB;}

    public void setUserDOB(String userDOB) {
        this.userDOB = userDOB;}


    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
