package com.dz.io.controller;

import com.dz.io.entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RemoteRoverControllerSpec {

    private RemoteRoverController roverController;
    private Location location;

    @Before
    public void setUp(){
        location = new Location(Direction.NORTH, new Coordinate(5,5));
        roverController = new RemoteRoverController();
        roverController.buildSurface(10,10).buildRover('N',5,5).buildOrders("LMR");
    }

    @Test
    public void whenLocationBuiltThenRoverLocationIsSet(){
        roverController.buildRover('N', 5, 5);
        assertThat(roverController.getRover().getLocation(), equalTo(location));
    }

    @Test
    public void whenOrdersAreBuiltThenOrdersAreSet(){
        roverController.buildOrders("L");
        assertThat(roverController.getOrders(),hasItem(Order.LEFT));
        assertThat(roverController.getOrders(),hasSize(1));
    }

    @Test
    public void whenSurfaceSetThenMaxCoordinateIsSet(){
        roverController.buildSurface(20,20);
        Coordinate expected = new Coordinate(20,20);
        assertThat(roverController.getSurface().getMax(),is(expected));
    }

    @Test
    public void whenProcessOrderThenLocationIsSet(){
        roverController.buildSurface(20,20);
        roverController.processOrder(Order.LEFT,roverController.getSurface().getMax());
        assertThat(roverController.getRover().getLocation().getDirection(),is(Direction.WEST));
        roverController.processOrder(Order.MOVE_FORWARD,roverController.getSurface().getMax());
        assertThat(roverController.getRover().getLocation().getCoordinate().getX(),is(4));
        roverController.processOrder(Order.RIGHT,roverController.getSurface().getMax());
        assertThat(roverController.getRover().getLocation().getDirection(),is(Direction.NORTH));
        roverController.processOrder(Order.MOVE_FORWARD,roverController.getSurface().getMax());
        assertThat(roverController.getRover().getLocation().getCoordinate().getY(),is(6));
    }

    @Test
    public void whenOrdersProcessedThenRoverLocationIsSet(){
        roverController.processOrders();
        Coordinate expected = new Coordinate(4,5);
        assertThat(roverController.getRover().getLocation().getDirection(),is(Direction.NORTH));
        assertThat(roverController.getRover().getLocation().getCoordinate(),is(expected));
    }

}
