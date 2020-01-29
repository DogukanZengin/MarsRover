package com.dz.io;

import com.dz.io.controller.RemoteRoverController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        List<RemoteRoverController> controllers = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){

            int maxX = bufferedReader.read();
            int maxY = bufferedReader.read();
            bufferedReader.readLine();
            String lineInput;
            while(!(lineInput = bufferedReader.readLine()).equals("")){
                String[] line = lineInput.split(" ");
                RemoteRoverController controller = new RemoteRoverController();
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                char direction = line[2].charAt(0);
                String orderLiteral = line[3];
                controller.buildRover(direction,x,y).buildSurface(maxX,maxY).buildOrders(orderLiteral);
                controllers.add(controller);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (RemoteRoverController controller: controllers) {
            controller.processOrders();
            System.out.println(controller.getRover().displayLocation());
        }

    }
}
