package com.zenon.bowlingapp;

import java.util.ArrayList;

public class GamePrinter {

    private static final char STRIKE_CHAR = 'X';
    private static final char SPARE_CHAR = '/';
    private static final char FAULT_CHAR = 'F';

    private static void printFrameNumbers() {
        System.out.print("Frame\t\t");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "\t\t");
        }
        System.out.print("\n");
    }

    public static void printAllGames(ArrayList<Game> allGames) {

        printFrameNumbers();

        for (Game aGame : allGames) {
            printGame(aGame);
            System.out.print("\n");
        }

    }

    private static void printGame(Game game) {
        Game currentGame = game;

        printBowlerName(currentGame.getBowler());
        printPinfalls(currentGame.getAllFrames());
        printScore(currentGame.getAllFrames());
    }

    private static void printBowlerName(String name) {
        System.out.println(name);
    }

    private static void printPinfalls(ArrayList<Frame> frames) {
        System.out.print("Pinfalls\t");
        for (Frame frame : frames) {
            printPinfall(frame);
        }
    }

    private static void printPinfall(Frame frame) {
        if (frame.isStrike()) {
            System.out.print("\t");
            System.out.print(STRIKE_CHAR);
//            System.out.print("\t");
        } else if (frame.isSpare()) {
            System.out.print(frame.getFirstRoll().getRollPoints());
            System.out.print("\t");
            System.out.print(SPARE_CHAR);
//            System.out.print("\t");
        } else {
            printPinfallOrFault(frame);
        }
        System.out.print("\t");
    }

    private static void printPinfallOrFault(Frame frame) {
        if (frame.getFirstRoll().isFault()) {
            System.out.print(FAULT_CHAR);
        } else {
            System.out.print(frame.getFirstRoll().getRollPoints());
        }
        System.out.print("\t");

        if (frame.getSecondRoll().isFault()) {
            System.out.print(FAULT_CHAR);
        } else if (frame.getSecondRoll() != null) {
            System.out.print(frame.getSecondRoll().getRollPoints());
        }
//        System.out.print("\t");

    }


    private static void printScore(ArrayList<Frame> frames) {
        System.out.print("\nScore\t\t");
        for (int i = 0; i < 10; i++) {
            System.out.print(Integer.toString(frames.get(i).getTotalScore()));
            System.out.print("\t\t");
        }
    }

}
