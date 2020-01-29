package com.dz.io.entity;

public class Rover {

    private Location location;

    public Rover(Direction direction,Coordinate coordinate) {
        this.location = new Location(direction,coordinate);
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
}
