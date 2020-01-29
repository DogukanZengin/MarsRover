package com.dz.io.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CoordinateSpec {

    private Coordinate coordinate;

    @Before
    public void setUp(){
        coordinate = new Coordinate(1,1);
    }

    @Test
    public void whenInstantiatedThenXIsCorrect(){
        coordinate = new Coordinate(5,5);
        assertThat(coordinate.getX(),is(5));
    }

    @Test
    public void whenInstantiatedThenYIsCorrect(){
        coordinate = new Coordinate(10,10);
        assertThat(coordinate.getY(),is(10));
    }

    @Test
    public void testEquals(){
        Coordinate copy =  new Coordinate(1,1);
        assertThat(coordinate,is(copy));
        assertThat(coordinate,is(coordinate));
    }

    @Test
    public void testToString(){
        assertThat(coordinate.toString(),is("1 1"));
    }
}
