package com.example.saku1.benseronemv.Controller;

import com.example.saku1.benseronemv.Model.MenuItemModel;

import java.util.List;

/**
 * Created by saku1 on 4/3/2017.
 */

public class OrderController {

    private OrderController(){

    }

    private static OrderController instance = null;

    public static OrderController getInstance(){
        if (instance==null) instance=new OrderController();
        return instance;
    }

    private static List<MenuItemModel> orderList;

    public static void setOrderList(List<MenuItemModel> menuItemModels){
        orderList=menuItemModels;
    }

    public static List<MenuItemModel> getOrderList(){
        return orderList;
    }
}
