package com.jac.in_class_coding.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    int age;
    String address;

    @OneToMany
    List<Purchase> purchases;

    public Customer() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    /** Adds an item to the list of purchases we have */
    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }


}
