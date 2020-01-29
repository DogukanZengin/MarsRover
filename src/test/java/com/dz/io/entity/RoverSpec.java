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
    public void whenOrdersAreSetThenOrderListPopulated(){
        rover.setOrders("LRF");
        assertThat(rover.getOrders(),hasSize(3));
        assertThat(rover.getOrders(),contains(Order.LEFT,Order.RIGHT,Order.INVALID));
    }

    @Test
    public void whenProcessOrderThenLocationIsSet(){
        Surface surface = new Surface(20,20);
        rover.processOrder(Order.LEFT,surface.getMax());
        assertThat(rover.getLocation().getDirection(),is(Direction.WEST));
        rover.processOrder(Order.MOVE_FORWARD,surface.getMax());
        assertThat(rover.getLocation().getCoordinate().getX(),is(14));
        rover.processOrder(Order.RIGHT,surface.getMax());
        assertThat(rover.getLocation().getDirection(),is(Direction.NORTH));
        rover.processOrder(Order.MOVE_FORWARD,surface.getMax());
        assertThat(rover.getLocation().getCoordinate().getY(),is(20));
    }

    @Test
    public void whenOrdersProcessedThenRoverLocationIsSet(){
        Surface surface = new Surface(20,20);
        rover.setOrders("LMLMRRM");
        rover.processOrders(surface.getMax());
        Coordinate expected = new Coordinate(14,20);
        assertThat(rover.getLocation().getDirection(),is(Direction.NORTH));
        assertThat(rover.getLocation().getCoordinate(),is(expected));
    }

    @Test
    public void whenDisplayLocationThenPropsAreCorrect(){
        assertThat(rover.displayLocation(),is("15 20 N"));
    }
}
