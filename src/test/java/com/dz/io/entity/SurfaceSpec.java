package com.dz.io.entity;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SurfaceSpec {

    private Surface surface;

    @Before
    public void setUp(){
        surface = new Surface(5,10);
    }

    @Test
    public void whenInstantiatedThenMaxXIsSet(){
        assertThat(surface.getMax().getX(),is(5));
    }

    @Test
    public void whenInstantiatedMaxYIsSet(){
        assertThat(surface.getMax().getY(),is(10));
    }
}
