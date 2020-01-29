package com.dz.io;

import com.dz.io.controller.RemoteRoverController;
import com.dz.io.entity.Rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        RemoteRoverController controller;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){

            int maxX = bufferedReader.read();
            int maxY = bufferedReader.read();
            controller = new RemoteRoverController(maxX, maxY);

            bufferedReader.readLine();
            String lineInput;
            while(!(lineInput = bufferedReader.readLine()).equals("")){
                String[] line = lineInput.split(" ");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                char direction = line[2].charAt(0);
                String orderLiteral = line[3];
                controller.landRover(direction, x, y).setOrders(orderLiteral);
            }

            for (Rover rover: controller.getRovers()) {
                rover.processOrders(controller.getSurface().getMax());
                System.out.println(rover.displayLocation());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
