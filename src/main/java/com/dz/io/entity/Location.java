package com.dz.io.entity;

import java.util.Objects;

public class Location {

    private Direction direction;
    private Coordinate coordinate;

    public Location(Direction direction) {
        this.direction = direction;
        this.coordinate = new Coordinate(0,0);
    }

    public Location(Direction direction, Coordinate coordinate) {
        this.direction = direction;
        this.coordinate = coordinate;
    }

    public void moveForward(Coordinate max){
        move(max);
    }

    private void move(Coordinate max){
        switch (direction){
            case NORTH:
                getCoordinate().setY(Math.min(getCoordinate().getY()+1,max.getY()));
                break;
            case SOUTH:
                getCoordinate().setY(Math.min(getCoordinate().getY()-1,max.getY()));
                break;
            case EAST:
                getCoordinate().setX(Math.min(getCoordinate().getX()+1,max.getX()));
                break;
            case WEST:
                getCoordinate().setX(Math.min(getCoordinate().getX()-1,max.getX()));
                break;
            default:
                break;
        }
    }


    public void turnLeft(){
        direction = Direction.getDirection((direction.getValue() +3) % 4);
    }

    public void turnRight(){
        direction = Direction.getDirection((direction.getValue()  +1) % 4);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return coordinate.toString() + " " + direction.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getDirection() == location.getDirection() &&
                Objects.equals(getCoordinate(), location.getCoordinate());
    }

}
