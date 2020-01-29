package com.dz.io.controller;

import com.dz.io.entity.*;
import com.dz.io.factory.RoverFactory;

import java.util.List;

public class RemoteRoverController {

    private Rover rover;
    private List<Order> orders;
    private Surface surface;

    public RemoteRoverController buildRover(Character shortDesc, int x, int y){
        rover = RoverFactory.createInstance(shortDesc,x,y);
        return this;
    }

    public RemoteRoverController buildOrders(String orderLiteral){
        orders = Order.extractOrders(orderLiteral);
        return this;
    }

    public RemoteRoverController buildSurface(int maxX, int maxY){
        surface =  new Surface(maxX,maxY);
        return this;
    }

    public void processOrders(){
        for (Order order: orders) {
            processOrder(order, surface.getMax());
        }
    }

    public void processOrder(Order order, Coordinate max){
        switch (order){
            case LEFT:
                rover.turnLeft();
                break;
            case RIGHT:
                rover.turnRight();
                break;
            case MOVE_FORWARD:
                rover.moveForward(max);
                break;
            default:
                break;
        }
    }

    public Rover getRover() {
        return rover;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Surface getSurface() {
        return surface;
    }
}
