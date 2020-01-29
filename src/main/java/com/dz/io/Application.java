package com.dz.io;

import com.dz.io.entity.Surface;

import java.util.Scanner;

public class Application {

    private static Scanner scanner;


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Surface surface = new Surface(scanner.nextInt(),scanner.nextInt());

        while(scanner.hasNextLine()){

        }
    }
}
