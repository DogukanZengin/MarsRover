package com.dz.io.entity;

import java.util.ArrayList;
import java.util.List;

public class Rover {

    private Location location;
    private List<Order> orders;

    public Rover(Direction direction,Coordinate coordinate) {
        this.location = new Location(direction,coordinate);
        orders = new ArrayList<>();
    }

    public Location getLocation() {
        return location;
    }

    public void moveForward(Coordinate max){
        location.moveForward(max);
    }

    public void turnLeft(){
        location.turnLeft();
    }

    public void turnRight(){
        location.turnRight();
    }

    public String displayLocation(){
        return location.toString();
    }

    public void processOrders(Coordinate max){
        for (Order order: orders) {
            processOrder(order, max);
        }
    }

    public void processOrder(Order order, Coordinate max){
        switch (order){
            case LEFT:
                turnLeft();
                break;
            case RIGHT:
                turnRight();
                break;
            case MOVE_FORWARD:
                moveForward(max);
                break;
            default:
                break;
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(String orderLiteral) {
        this.orders = Order.extractOrders(orderLiteral);
    }
}
