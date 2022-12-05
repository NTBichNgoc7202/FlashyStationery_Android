package com.race.models;

public class Address {
    int addressId;
    String userName, userPhoneNumber, address, addressDetail, addressType, defaultAddress;

    public Address(int addressId, String userName, String userPhoneNumber, String address,
                   String addressDetail, String addressType, String defaultAddress) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.address = address;
        this.addressDetail = addressDetail;
        this.addressType = addressType;
        this.defaultAddress = defaultAddress;
        this.addressId = addressId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

}
