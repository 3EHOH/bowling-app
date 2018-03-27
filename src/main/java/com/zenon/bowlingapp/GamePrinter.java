package com.zenon.bowlingapp;

import java.util.ArrayList;

public class GamePrinter {

    private static final char STRIKE_CHAR = 'X';
    private static final char SPARE_CHAR = '/';
    private static final char FAULT_CHAR = 'F';
    private static final int ALL_REGULATION_FRAMES = 10;

    private static void printFrameNumbers() {
        System.out.print("Frame\t\t");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "\t\t");
        }
        System.out.print("\n");
    }

    public static void printAllGames(ArrayList<Game> allGames) {

        printFrameNumbers();

//        for (Game aGame : allGames) {
//            printGame(aGame);
//            System.out.print("\n");
//        }
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
        int counter = 0;
        for (Frame frame : frames) {
            printPinfall(frame, counter);
            counter++;
        }
    }

    private static void printPinfall(Frame frame, int counter) {
        if (frame.isStrike() && counter > (ALL_REGULATION_FRAMES - 1)){ //edge case to print to bonus strikes
            System.out.print(STRIKE_CHAR);
        } else if (frame.isStrike()) {
            System.out.print("\t");
            System.out.print(STRIKE_CHAR);
        } else if (frame.isSpare()) {
            System.out.print(frame.getFirstRoll().getRollPoints());
            System.out.print("\t");
            System.out.print(SPARE_CHAR);
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

        if (frame.getSecondRoll() != null && frame.getSecondRoll().isFault()) {
            System.out.print(FAULT_CHAR);
        } else if (frame.getSecondRoll() != null) {
            System.out.print(frame.getSecondRoll().getRollPoints());
        }
    }


    private static void printScore(ArrayList<Frame> frames) {
        System.out.print("\nScore\t\t");
        for (int i = 0; i < ALL_REGULATION_FRAMES; i++) {
            System.out.print(Integer.toString(frames.get(i).getTotalScore()));
            System.out.print("\t\t");
        }
    }

}
