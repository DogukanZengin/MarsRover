package com.dz.io.controller;

import com.dz.io.entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RemoteRoverControllerSpec {

    private RemoteRoverController roverController;

    @Before
    public void setUp(){
        roverController = new RemoteRoverController(20,20);
    }

    @Test
    public void whenInstantiatedThenEmptyRoverListCreated(){
        assertThat(roverController.getRovers(),hasSize(0));
    }

    @Test
    public void whenInstantiatedSurfaceIsSet(){
        Coordinate expected = new Coordinate(20,20);
        assertThat(roverController.getSurface().getMax(),is(expected));
    }

    @Test
    public void whenRoverCreatedThenAddedToRoverList(){
        Rover rover = roverController.landRover('N', 5, 5);
        assertThat(roverController.getRovers(),hasSize(1));
        assertThat(roverController.getRovers(),hasItem(rover));
    }

}
