package com.zenon.bowlingapp.scoring;

import com.zenon.bowlingapp.*;

import java.util.ArrayList;

public class FrameScoreParser {

    private static final int TEN_POINTS = 10;

    //TODO split this into one function for frames and another for game
    public static Game parseFramesFromRolls(String player, final ArrayList<Roll> rolls) {
        ArrayList<Frame> frames = new ArrayList<>();
        int rollCounter = 0;

        while (rollCounter < rolls.size()) {
            Frame frame = parseFrameFromRoll(rollCounter, rolls);

            System.out.println("A FRAME " + frame.getTotalScore());
            System.out.println("A FRAME " + frame.getFirstRoll().getRollPoints());

            frames.add(frame);

            if(frame.isStrike()){
                rollCounter += 1;
            } else {
                rollCounter += 2;
            }
        }


        for (Frame frame: frames) {
            System.out.println("SCORE PER FRAME " + Integer.toString(frame.getTotalScore()));
        }

        return new Game(player, frames);
    }

    private static Frame parseFrameFromRoll(int aRoll, ArrayList<Roll> rolls) {
        Roll firstOne = parseRoll(aRoll, rolls);

        if (firstOne.getRollPoints() == TEN_POINTS) {
            return new Strike(firstOne);
        }

        Roll secondOne = parseRoll(aRoll + 1, rolls);

        if (firstOne.getRollPoints() + secondOne.getRollPoints() == TEN_POINTS) {
            return new Spare(firstOne, secondOne);
        }

        return new Frame(firstOne, secondOne);
    }

    private static Roll parseRoll(int rollIndex, ArrayList<Roll> rolls) {

        if (rollIndex < rolls.size()) {
            System.out.println("CURRENT ROLL " + Integer.toString(rolls.get(rollIndex).getRollPoints()));
            return rolls.get(rollIndex);
        } else return new Roll(0);
    }
}
