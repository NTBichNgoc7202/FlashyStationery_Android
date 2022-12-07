package com.race.models;

public class OrderDetailStatus {
    int orderStatusIcon;
    String orderStatus;

    public OrderDetailStatus(int orderStatusIcon, String orderStatus) {
        this.orderStatusIcon = orderStatusIcon;
        this.orderStatus = orderStatus;
    }

    public int getOrderStatusIcon() {
        return orderStatusIcon;
    }

    public void setOrderStatusIcon(int orderStatusIcon) {
        this.orderStatusIcon = orderStatusIcon;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
