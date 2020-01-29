package com.dz.io.entity;

import java.util.List;
import java.util.stream.Collectors;

public enum Order {
    LEFT('L'),
    RIGHT('R'),
    MOVE_FORWARD('M'),
    INVALID(' ');

    public final Character shortDesc;

    Order(Character shortDesc) {
        this.shortDesc = shortDesc;
    }

    public static Order getOrder(char shortDesc){
        for(Order order : Order.values()){
            if(order.getShortDesc() == shortDesc){
                return order;
            }
        }
        return Order.INVALID;
    }

    public static List<Order> extractOrders(String orderLiteral){
        return orderLiteral.chars().mapToObj(v -> getOrder((char)v)).collect(Collectors.toList());
    }

    public Character getShortDesc() {
        return shortDesc;
    }
}
