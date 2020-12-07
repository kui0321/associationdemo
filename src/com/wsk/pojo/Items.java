package com.wsk.pojo;

public class Items {
    private int itemid;
    private String itemname;
    private double itemprice;

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public double getItemprice() {
        return itemprice;
    }

    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemid=" + itemid +
                ", itemname='" + itemname + '\'' +
                ", itemprice=" + itemprice +
                '}';
    }
}
