package com.race.models;

public class Address {
    String userName, userPhoneNumber, addressDetail, address, addressType;
    int defaultAddress;

    public Address(String userName, String userPhoneNumber, String addressDetail, String address,
                   String addressType, int defaultAddress) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.addressDetail = addressDetail;
        this.address = address;
        this.addressType = addressType;
        this.defaultAddress = defaultAddress;
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
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public int getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(int defaultAddress) {
        this.defaultAddress = defaultAddress;
    }
}
