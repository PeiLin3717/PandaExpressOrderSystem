package com.PandaExpressOrderSystem;

public class Entre {

    int id; //entre number
    String entreName;
    double price;

    public Entre() {
    }

    public Entre(int id, String entreName, double price) {
        this.id = id;
        this.entreName = entreName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntreName() {
        return entreName;
    }

    public void setEntreName(String entreName) {
        this.entreName = entreName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Entre{" +
                "id=" + id +
                ", entreName='" + entreName + '\'' +
                ", price=" + price +
                '}';
    }
}
