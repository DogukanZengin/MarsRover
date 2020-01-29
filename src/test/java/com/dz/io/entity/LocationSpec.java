package com.dz.io.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LocationSpec {

    private Location location;

    @Before
    public void setUp(){
        Coordinate coordinate =  new Coordinate(5,5);
        location = new Location(Direction.NORTH,coordinate);
    }

    @Test
    public void whenInstantiatedWithNorthThenDirectionIsNorth(){
        assertThat(location.getDirection(),is(Direction.NORTH));
    }

    @Test
    public void whenInstantiatedWithoutCoordinatesThenCoordinatesAreZero(){
        location = new Location(Direction.NORTH);
        assertThat(location.getCoordinate(),is(new Coordinate(0,0)));
    }

    @Test
    public void whenInstantiatedWithCoordinatesThenCoordinatesAreEqual(){
        assertThat(location.getCoordinate(),is(new Coordinate(5,5)));
    }

    @Test
    public void whenMoveForwardNorthThenYIncreases(){
        location.moveForward(new Coordinate(10,10));
        assertThat(location.getCoordinate().getY(),is(6));
    }

    @Test
    public void whenMoveForwardSouthThenYDecreases(){
        location.setDirection(Direction.SOUTH);
        location.moveForward(new Coordinate(10,10));
        assertThat(location.getCoordinate().getY(),is(4));
    }

    @Test
    public void whenMoveForwardEastThenXIncreases(){
        location.setDirection(Direction.EAST);
        location.moveForward(new Coordinate(10,10));
        assertThat(location.getCoordinate().getX(),is(6));
    }

    @Test
    public void whenMoveForwardWestThenXDecreases(){
        location.setDirection(Direction.WEST);
        location.moveForward(new Coordinate(10,10));
        assertThat(location.getCoordinate().getX(),is(4));
    }

    @Test
    public void givenDirectionWhenTurnLeftThenDirectionIsSet(){
        location.turnRight();
        assertThat(location.getDirection(),is(Direction.EAST));
        location.turnRight();
        assertThat(location.getDirection(),is(Direction.SOUTH));
        location.turnRight();
        assertThat(location.getDirection(),is(Direction.WEST));
        location.turnRight();
        assertThat(location.getDirection(),is(Direction.NORTH));
    }

    @Test
    public void givenDirectionWhenTurnRightThenDirectionIsSet(){
        location.turnLeft();
        assertThat(location.getDirection(),is(Direction.WEST));
        location.turnLeft();
        assertThat(location.getDirection(),is(Direction.SOUTH));
        location.turnLeft();
        assertThat(location.getDirection(),is(Direction.EAST));
        location.turnLeft();
        assertThat(location.getDirection(),is(Direction.NORTH));
    }

    @Test
    public void whenMaxCoordinateReachedThenDoNothing(){
        location.getCoordinate().setY(5);
        Coordinate max = new Coordinate(5,5);
        location.moveForward(max);
        assertThat(location.getCoordinate().getY(),is(5));
    }

    @Test
    public void testToString(){
        assertThat(location.toString(),is("5 5 N"));
    }

    @Test
    public void testEquals(){
        Location copy = new Location(Direction.NORTH,new Coordinate(5,5));
        assertThat(location,is(copy));
    }
}
