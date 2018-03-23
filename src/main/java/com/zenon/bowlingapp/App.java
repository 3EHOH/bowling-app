package com.zenon.bowlingapp;

import java.io.File;


public class App {
    public static void main( String[] args ) {

        if(args.length > 0) {
            File file = new File(args[0]);

            System.out.println(file.getName());

            // Work with your 'file' object here
        }

        System.out.println( "Hello World!" );
    }
}
