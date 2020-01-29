package com.dz.io.entity;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RoverSpec {

    private Rover rover;

    @Before
    public void setUp(){
        Coordinate coordinate = new Coordinate(15,20);
        rover = new Rover(Direction.NORTH, coordinate);
    }

    @Test
    public void whenInstantiatedThenXIsSet(){
        assertThat(rover.getLocation().getCoordinate().getX(),is(15));
    }

    @Test
    public void whenInstantiatedThenYIsSet(){
        assertThat(rover.getLocation().getCoordinate().getY(),is(20));
    }

    @Test
    public void whenInstantiatedThenDirectionIsSet(){
        assertThat(rover.getLocation().getDirection(),is(Direction.NORTH));
    }

    @Test
    public void whenMoveForwardThenCoordinatesChange(){
        Coordinate max = new Coordinate(25,25);
        rover.moveForward(max);
        assertThat(rover.getLocation().getCoordinate().getY(),is(21));
    }

    @Test
    public void whenTurnLeftThenDirectionChange(){
        rover.turnLeft();
        assertThat(rover.getLocation().getDirection(),is(Direction.WEST));
    }

    @Test
    public void whenTurnRightThenDirectionChange(){
        rover.turnRight();
        assertThat(rover.getLocation().getDirection(),is(Direction.EAST));
    }

    @Test
    public void whenDisplayLocationThenPropsAreCorrect(){
        assertThat(rover.displayLocation(),is("15 20 N"));
    }
}
