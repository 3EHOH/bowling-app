package com.zenon.bowlingapp;

import com.zenon.bowlingapp.domain.frame.Frame;
import com.zenon.bowlingapp.domain.game.Game;

import java.util.ArrayList;

public class GamePrinter {

    private static final char STRIKE_CHAR = 'X';
    private static final char SPARE_CHAR = '/';
    private static final char FAULT_CHAR = 'F';
    private static final int ALL_REGULATION_FRAMES = 10;


    public static StringBuilder printAllGames(ArrayList<Game> allGames) {

        StringBuilder printedAllGames = new StringBuilder();

        printedAllGames.append(printFrameNumbers());

        for (Game aGame : allGames) {
            printedAllGames.append(printGame(aGame));
            printedAllGames.append("\n");
        }

        return printedAllGames;
    }

    private static StringBuilder printGame(Game game) {
        StringBuilder printedGame = new StringBuilder();
        Game currentGame = game;

        printedGame.append(printBowlerName(currentGame.getBowler()));
        printedGame.append(printPinfalls(currentGame.getAllFrames()));
        printedGame.append(printScore(currentGame.getAllFrames()));

        return printedGame;
    }

    private static StringBuilder printBowlerName(String name) {
        StringBuilder printedName = new StringBuilder();

        printedName.append(name);
        printedName.append("\n");

        return printedName;
    }

    private static StringBuilder printPinfalls(ArrayList<Frame> frames) {
        int counter = 0;

        StringBuilder printedPinfalls = new StringBuilder();

        printedPinfalls.append("Pinfalls\t");

        for (Frame frame : frames) {
            printedPinfalls.append(printPinfall(frame, counter));
            counter++;
        }

        return printedPinfalls;
    }

    private static StringBuilder printPinfall(Frame frame, int counter) {
        StringBuilder printedPinfall = new StringBuilder();

        if (frame.isStrike() && counter >= ALL_REGULATION_FRAMES){ //edge case to properly print 2 bonus strikes
            printedPinfall.append(STRIKE_CHAR);
        } else if (frame.isStrike()) {
            printedPinfall.append("\t");
            printedPinfall.append(STRIKE_CHAR);
        } else if (frame.isSpare()) {
            printedPinfall.append(frame.getFirstRoll().getRollPoints());
            printedPinfall.append("\t");
            printedPinfall.append(SPARE_CHAR);
        } else {
            printedPinfall.append(printPinfallOrFault(frame));
        }
        printedPinfall.append("\t");

        return printedPinfall;
    }

    private static StringBuilder printPinfallOrFault(Frame frame) {
        StringBuilder printedPinfallOrFault = new StringBuilder();

        if (frame.getFirstRoll().isFault()) {
            printedPinfallOrFault.append(FAULT_CHAR);
        } else {
            printedPinfallOrFault.append(frame.getFirstRoll().getRollPoints());
        }
        printedPinfallOrFault.append("\t");

        if (frame.getSecondRoll() != null && frame.getSecondRoll().isFault()) {
            printedPinfallOrFault.append(FAULT_CHAR);
        } else if (frame.getSecondRoll() != null) {
            printedPinfallOrFault.append(frame.getSecondRoll().getRollPoints());
        }

        return printedPinfallOrFault;
    }


    private static StringBuilder printScore(ArrayList<Frame> frames) {
        StringBuilder printedScore = new StringBuilder();

        printedScore.append("\nScore\t\t");

        for (int i = 0; i < ALL_REGULATION_FRAMES; i++) {
            printedScore.append(Integer.toString(frames.get(i).getTotalScore()));
            printedScore.append("\t\t");
        }
        return printedScore;
    }

    private static StringBuilder printFrameNumbers() {
        StringBuilder printedFrameNumbers = new StringBuilder();

        printedFrameNumbers.append("Frame\t\t");

        for (int i = 1; i <= ALL_REGULATION_FRAMES; i++) {
            printedFrameNumbers.append(Integer.toString(i)).append("\t\t");
        }

        return printedFrameNumbers.append("\n");
    }
}
