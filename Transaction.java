package edu.psu.ist;

import java.util.ArrayList;
import java.util.Scanner;

enum PaymentType {cash, credit}

public class Transaction {

    //Class Level Variables - Protect the data
    private int transactionId;
    private Order order;
    private PaymentType pType;

    //Constructor Method
    public Transaction(int _transactionId) {
        this.transactionId = _transactionId;
    }

    //Setters and Getters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int _transactionId) {
        this.transactionId = _transactionId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order _order) {
        this.order = _order;
    }

    public PaymentType getPaymentType() {
        return pType;
    }

    public void setPaymentType(PaymentType _pType) {
        this.pType = _pType;
    }

    public static void listTransactions(ArrayList<Transaction> tList) {
        int tTrans = 1;
        Transaction tran = new Transaction(tTrans);
        Scanner scnr = new Scanner(System.in);
        System.out.println("Transaction ID:");
        tran.setTransactionId(scnr.nextInt());
        System.out.println("How would you like to pay? cash or card");
        System.out.print("please select" + " transaction type\n1. Cash\n2. Credit\nSelect an option");
        int transType = scnr.nextInt();
        PaymentType type = PaymentType.credit;
        if (transType == 1) {
            type = PaymentType.cash;
            System.out.println("you have selected:" + transType);
        }else{
          System.out.println  ("You have selected credit");
        }

            for (Transaction trans : tList) {
                System.out.println("Transaction ID: " + trans.getTransactionId());
                Order order = trans.getOrder();
                for (Menu menu : order.getItems()) {
                    System.out.println(menu.getmenuId() + ":" + menu.getmenuItem() + menu.getmenuPrice());
                }
                //System.out.println("Order:" + trans.getOrder());  //TODO: Print order
                System.out.println("Payment Type: " + trans.getPaymentType());
            }
        }

    }


