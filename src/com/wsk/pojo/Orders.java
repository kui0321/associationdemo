package com.wsk.pojo;

import java.util.List;

public class Orders {
    private int orderid;
    private double orderprice;
    List<Items> items;

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(double orderprice) {
        this.orderprice = orderprice;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderid=" + orderid +
                ", orderprice=" + orderprice +
                '}';
    }
}
