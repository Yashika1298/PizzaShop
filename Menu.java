package edu.psu.ist;

import java.util.ArrayList;

public class Menu {

    //Class Level Variables - Protect the data
    private int menuId;
    private String menuItem;
    private double _Price;

    //Constructor Method
    public Menu(int _menuId, String _menuItem, double _Price){
        this.menuId = _menuId;
        this.menuItem = _menuItem;
        this._Price = _Price;
    }

    //Setters and Getters
    public int getmenuId() { return menuId; }
    public void setmenuId(int _menuId) {this.menuId = _menuId;}

    public String getmenuItem() { return menuItem; }
    public void setmenuItem(String _menuItem) {this.menuItem = _menuItem;}

    public double getmenuPrice() { return _Price; }
    public void setMenuPrice(int _menuPrice) {this._Price = _menuPrice;}

    public static void listMenu(ArrayList<Menu> mList){
        for (Menu menu: mList){
            System.out.println("\n" + menu.getmenuId() + " "
            + menu.getmenuItem() + " $-" + menu.getmenuPrice());
        }
    }
}
