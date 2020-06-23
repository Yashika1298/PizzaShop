package edu.psu.ist;

import java.util.ArrayList;

public class Order {
    //Class Level Variables - Protect the data
    private int orderId;
    private Customer cust;
    private ArrayList<Menu> menuItem;

    //Constructor Method
    public Order(int _orderId, Customer c){

        this.orderId = _orderId;
        this.cust = c;
        menuItem = new ArrayList<>();
    }

    //Setters and Getters
    public int getorderId() { return orderId; }
    public void setorderId(int _orderId) {this.orderId = _orderId;}
    public Customer getCustomer(){ return this.cust;}
    public  ArrayList<Menu> getItems(){ return menuItem;}
    public void addItem(Menu menu){
        menuItem.add(menu);
    }
    
}
