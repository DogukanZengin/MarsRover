package com.dz.io.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class DirectionSpec {

    private Direction direction;

    @Before
    public void setUp(){
        direction = Direction.NORTH;
    }

    @Test
    public void whenPassedValueThenGetDirection(){
        assertThat(Direction.getDirection(0),is(Direction.NORTH));
        assertThat(Direction.getDirection(3),is(Direction.WEST));
    }

    @Test
    public void whenPassedShortDescThenGetDirection(){
        assertThat(Direction.getDirection('N'),is(Direction.NORTH));
        assertThat(Direction.getDirection('W'),is(Direction.WEST));
        assertThat(Direction.getDirection('E'),is(Direction.EAST));
        assertThat(Direction.getDirection('S'),is(Direction.SOUTH));
        assertThat(Direction.getDirection('A'),is(Direction.NONE));
    }

    @Test
    public void whenInvalidDirectionValueThenNone(){
        direction = Direction.getDirection(5);
        assertThat(direction,is(Direction.NONE));
    }

    @Test
    public void testToString(){
        assertThat(direction.toString(),is("N"));
    }
}
