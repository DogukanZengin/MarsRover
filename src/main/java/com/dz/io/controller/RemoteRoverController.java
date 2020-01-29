package com.dz.io.controller;

import com.dz.io.entity.Rover;
import com.dz.io.entity.Surface;
import com.dz.io.factory.RoverFactory;

import java.util.ArrayList;
import java.util.List;

public class RemoteRoverController {

    private List<Rover> rovers;
    private Surface surface;

    public RemoteRoverController(int x, int y) {
        rovers = new ArrayList<>();
        surface = new Surface(x, y);
    }

    public List<Rover> getRovers() {
        return rovers;
    }

    public Surface getSurface() {
        return surface;
    }

    public Rover landRover(Character shortDesc, int x, int y){
        Rover rover = RoverFactory.createInstance(shortDesc,x ,y);
        rovers.add(rover);
        return rover;
    }
}
