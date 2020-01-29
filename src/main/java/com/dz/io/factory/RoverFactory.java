package com.dz.io.factory;

import com.dz.io.entity.Coordinate;
import com.dz.io.entity.Direction;
import com.dz.io.entity.Rover;

public class RoverFactory {

    public static Rover createInstance(Character shortDesc){
        return createInstance(shortDesc, 0, 0);
    }

    public static Rover createInstance(Character shortDesc, int x, int y){
        return new Rover(Direction.getDirection(shortDesc),new Coordinate(x,y));
    }
}
