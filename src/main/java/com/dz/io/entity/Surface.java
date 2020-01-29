package com.dz.io.entity;

public class Surface {

    private Coordinate max;

    public Surface(int x, int y) {
        max = new Coordinate(x,y);
    }

    public Coordinate getMax() {
        return max;
    }
}
