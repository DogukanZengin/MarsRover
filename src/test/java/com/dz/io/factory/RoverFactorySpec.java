package com.dz.io.factory;

import com.dz.io.entity.Coordinate;
import com.dz.io.entity.Direction;
import com.dz.io.entity.Rover;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RoverFactorySpec {

    @Test
    public void whenRoverIsCreatedThenDirectionIsSet(){
        Rover rover = RoverFactory.createInstance('N');
        assertThat(rover.getLocation().getDirection(),is(Direction.NORTH));
    }

    @Test
    public void whenRoverIsCreatedThenCoordinateIsSet(){
        Coordinate coordinate = new Coordinate(5,5);
        Rover rover = RoverFactory.createInstance('N', 5, 5);
        assertThat(rover.getLocation().getCoordinate(),equalTo(coordinate));
    }

}
