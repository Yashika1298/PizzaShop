package edu.psu.ist;
/*
Project: Lab 9
Purpose Details: Pizza ordering application
Course: IST 242
Author: Yashika Patel
Date Developed: 6/11/19
Last Date Changed: 6/20/1
Rev: 1
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    int cCount = 1;
    int oCount = 1;

    private static ArrayList<Customer> cList = null;

    public static void main(String[] args) {

        Main main = new Main();

        final char EXIT_CODE = 'E';
        final char CUST_CODE = 'C';
        final char MENU_CODE = 'M';
        final char ORDE_CODE = 'O';
        final char TRAN_CODE = 'T';
        final char CUST_PRNT = 'P';
        final char HELP_CODE = '?';
        char userAction;
        final String PROMPT_ACTION = "Add 'C'ustomer, 'P'rint Customer, List 'M'enu, Add 'O'rder, List 'T'ransaction or 'E'xit: ";
        cList = new ArrayList<>();
        ArrayList<Menu> mList = new ArrayList<>();
        ArrayList<Order> oList = new ArrayList<>();
        ArrayList<Transaction> tList = new ArrayList<>();


        Menu menu1 = new Menu(1, "Plain", 5.0);
        Menu menu2 = new Menu(2, "Meat", 10.0);
        Menu menu3 = new Menu(3, "Extra", 7.0);
        Menu menu4 = new Menu(4, "Veg", 13.0);

        mList.add(menu1);
        mList.add(menu2);
        mList.add(menu3);
        mList.add(menu4);


        userAction = getAction(PROMPT_ACTION);

        while (userAction != EXIT_CODE) {
            switch (userAction) {
                case CUST_CODE:
                    cList.add(main.addCustomer());
                    break;
                case CUST_PRNT:
                    Customer.printCustomer(cList);
                    break;
                case MENU_CODE:
                    Menu.listMenu(mList);
                    break;
                case ORDE_CODE:
                    main.addOrders(mList);
                    break;
                case TRAN_CODE:
                    Transaction.listTransactions(tList);
                    break;
            }

            userAction = getAction(PROMPT_ACTION);
        }
    }

    public static char getAction(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String answer = "";
        System.out.println(prompt);
        answer = scnr.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);
        return firstChar;
    }

    public Customer addCustomer() {
        Customer cust = new Customer(cCount++);
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please Enter your Name: ");
        cust.setCustomerName(scnr.nextLine());
        System.out.println("Please Enter your Phone: ");
        cust.setCustomerPhoneNumber(scnr.nextLine());
        //System.out.println("New customer");
        return cust;
    }

    public void addOrders(ArrayList<Menu> mList) {
        Scanner scnr = new Scanner(System.in);
        Customer customerOrder = null;
        if (cList.isEmpty()) {
            System.out.println("Please add customer first");
        } else {
            int counter = 1;
            System.out.println("Customer List:");
            for (Customer cust : cList) {
                System.out.println(counter++ + ")" + cust.getCustomerName());
            }
            System.out.print("Select a customer");
            int selectCust = scnr.nextInt();

            customerOrder = cList.get(selectCust - 1);
            Order order = new Order(++oCount, customerOrder);

            System.out.println("Select menu by Id: (press 0 to finalize)");
            for (Menu menu : mList)
                System.out.println(menu.getmenuId() + "-" + menu.getmenuItem()
                        + "$" + menu.getmenuPrice());
            int flag;
            while (true) {
                flag = scnr.nextInt();
                if (flag == 0)
                    break;
                mList.add(mList.get(flag - 1));
            }
        }
    }
}

