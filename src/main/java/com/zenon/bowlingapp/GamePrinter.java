package com.zenon.bowlingapp;

import java.util.ArrayList;

public class GamePrinter {

    private static final char STRIKE_CHAR = 'X';
    private static final char SPARE_CHAR = '/';
    private static final char FAULT_CHAR = 'F';
    private static final int ALL_REGULATION_FRAMES = 10;

//    private static void printFrameNumbers() {
//        System.out.print("Frame\t\t");
//        for (int i = 1; i <= ALL_REGULATION_FRAMES; i++) {
//            System.out.print(i + "\t\t");
//        }
//        System.out.print("\n");
//    }
//
//    public static void printAllGames(ArrayList<Game> allGames) {
//
//        printFrameNumbers();
//
//        for (Game aGame : allGames) {
//            printGame(aGame);
//            System.out.print("\n");
//        }
//    }
//
//    private static void printGame(Game game) {
//        Game currentGame = game;
//
//        printBowlerName(currentGame.getBowler());
//        printPinfalls(currentGame.getAllFrames());
//        printScore(currentGame.getAllFrames());
//    }
//
//    private static void printBowlerName(String name) {
//        System.out.println(name);
//    }
//
//    private static void printPinfalls(ArrayList<Frame> frames) {
//        int counter = 0;
//
//        System.out.print("Pinfalls\t");
//
//        for (Frame frame : frames) {
//            printPinfall(frame, counter);
//            counter++;
//        }
//    }
//
//    private static void printPinfall(Frame frame, int counter) {
//        if (frame.isStrike() && counter >= ALL_REGULATION_FRAMES){ //edge case to properly print 2 bonus strikes
//            System.out.print(STRIKE_CHAR);
//        } else if (frame.isStrike()) {
//            System.out.print("\t");
//            System.out.print(STRIKE_CHAR);
//        } else if (frame.isSpare()) {
//            System.out.print(frame.getFirstRoll().getRollPoints());
//            System.out.print("\t");
//            System.out.print(SPARE_CHAR);
//        } else {
//            printPinfallOrFault(frame);
//        }
//        System.out.print("\t");
//    }
//
//    private static void printPinfallOrFault(Frame frame) {
//        if (frame.getFirstRoll().isFault()) {
//            System.out.print(FAULT_CHAR);
//        } else {
//            System.out.print(frame.getFirstRoll().getRollPoints());
//        }
//        System.out.print("\t");
//
//        if (frame.getSecondRoll() != null && frame.getSecondRoll().isFault()) {
//            System.out.print(FAULT_CHAR);
//        } else if (frame.getSecondRoll() != null) {
//            System.out.print(frame.getSecondRoll().getRollPoints());
//        }
//    }
//
//
//    private static void printScore(ArrayList<Frame> frames) {
//
//        System.out.print("\nScore\t\t");
//
//        for (int i = 0; i < ALL_REGULATION_FRAMES; i++) {
//            System.out.print(Integer.toString(frames.get(i).getTotalScore()));
//            System.out.print("\t\t");
//        }
//    }

    public static StringBuilder printAllGames(ArrayList<Game> allGames) {

        StringBuilder printedAllGames = new StringBuilder();

        printedAllGames.append(printFrameNumbers());

        for (Game aGame : allGames) {
//            printGame(aGame);
            printedAllGames.append(printGame(aGame));
            printedAllGames.append("\n");
//            System.out.print("\n");
        }

        return printedAllGames;
    }

    private static StringBuilder printGame(Game game) {
        StringBuilder printedGame = new StringBuilder();
        Game currentGame = game;

        printedGame.append(printBowlerName(currentGame.getBowler()));
        printedGame.append(printPinfalls(currentGame.getAllFrames()));
        printedGame.append(printScore(currentGame.getAllFrames()));
//        printScore(currentGame.getAllFrames());

        return printedGame;
    }

    private static StringBuilder printBowlerName(String name) {
        StringBuilder printedName = new StringBuilder();
//        System.out.println(name);
        printedName.append(name);
        printedName.append("\n");
        return printedName;
    }

    private static StringBuilder printPinfalls(ArrayList<Frame> frames) {
        int counter = 0;

        StringBuilder printedPinfalls = new StringBuilder();

        printedPinfalls.append("Pinfalls\t");

//        System.out.print("Pinfalls\t");

        for (Frame frame : frames) {
//            printPinfall(frame, counter);
            printedPinfalls.append(printPinfall(frame, counter));
            counter++;
        }

        return printedPinfalls;
    }

    private static StringBuilder printPinfall(Frame frame, int counter) {
        StringBuilder printedPinfall = new StringBuilder();

        if (frame.isStrike() && counter >= ALL_REGULATION_FRAMES){ //edge case to properly print 2 bonus strikes
//            System.out.print(STRIKE_CHAR);
            printedPinfall.append(STRIKE_CHAR);
        } else if (frame.isStrike()) {
            printedPinfall.append("\t");
            printedPinfall.append(STRIKE_CHAR);
//            System.out.print("\t");
//            System.out.print(STRIKE_CHAR);
        } else if (frame.isSpare()) {
//            System.out.print(frame.getFirstRoll().getRollPoints());
//            System.out.print("\t");
//            System.out.print(SPARE_CHAR);


            printedPinfall.append(frame.getFirstRoll().getRollPoints());
            printedPinfall.append("\t");
            printedPinfall.append(SPARE_CHAR);
        } else {
            printedPinfall.append(printPinfallOrFault(frame));
//            printPinfallOrFault(frame);
        }
        printedPinfall.append("\t");

        return printedPinfall;
//        System.out.print("\t");
    }

    private static StringBuilder printPinfallOrFault(Frame frame) {
        StringBuilder printedPinfallOrFault = new StringBuilder();

        if (frame.getFirstRoll().isFault()) {
//            System.out.print(FAULT_CHAR);
            printedPinfallOrFault.append(FAULT_CHAR);
        } else {
//            System.out.print(frame.getFirstRoll().getRollPoints());
            printedPinfallOrFault.append(frame.getFirstRoll().getRollPoints());
        }
        printedPinfallOrFault.append("\t");
//        System.out.print("\t");

        if (frame.getSecondRoll() != null && frame.getSecondRoll().isFault()) {
//            System.out.print(FAULT_CHAR);
            printedPinfallOrFault.append(FAULT_CHAR);
        } else if (frame.getSecondRoll() != null) {
            printedPinfallOrFault.append(frame.getSecondRoll().getRollPoints());
//            System.out.print(frame.getSecondRoll().getRollPoints());
        }

        return printedPinfallOrFault;
    }


    private static StringBuilder printScore(ArrayList<Frame> frames) {

        StringBuilder printedScore = new StringBuilder();
//        System.out.print("\nScore\t\t");
        printedScore.append("\nScore\t\t");

        for (int i = 0; i < ALL_REGULATION_FRAMES; i++) {
            printedScore.append(Integer.toString(frames.get(i).getTotalScore()));
            printedScore.append("\t\t");
//            System.out.print(Integer.toString(frames.get(i).getTotalScore()));
//            System.out.print("\t\t");
        }
        return printedScore;
    }

    private static StringBuilder printFrameNumbers() {

        StringBuilder printedFrameNumbers = new StringBuilder();

//        System.out.print("Frame\t\t");
        printedFrameNumbers.append("Frame\t\t");
        for (int i = 1; i <= ALL_REGULATION_FRAMES; i++) {
//            System.out.print(i + "\t\t");
            printedFrameNumbers.append(Integer.toString(i)).append("\t\t");
        }
//        System.out.print("\n");
        return printedFrameNumbers.append("\n");
    }


}
