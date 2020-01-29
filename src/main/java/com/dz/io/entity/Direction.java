package com.dz.io.entity;

public enum Direction {
    NORTH(0,'N'),
    EAST(1,'E'),
    SOUTH(2,'S'),
    WEST(3,'W'),
    NONE(4,' ');

    public final int value;
    public final Character shortDesc;

    Direction(int value, Character shortDesc) {
        this.value = value;
        this.shortDesc = shortDesc;
    }

    public static Direction getDirection(int value){
        for(Direction direction : Direction.values()){
            if(direction.getValue() == value){
                return direction;
            }
        }
        return Direction.NONE;
    }

    public static Direction getDirection(char shortDesc){
        for(Direction direction : Direction.values()){
            if(direction.getShortDesc() == shortDesc){
                return direction;
            }
        }
        return Direction.NONE;
    }

    public int getValue() {
        return value;
    }

    public Character getShortDesc() {
        return shortDesc;
    }

    @Override
    public String toString() {
        return shortDesc.toString();
    }
}
