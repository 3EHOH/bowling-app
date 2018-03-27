package com.zenon.bowlingapp.scoring;

import com.zenon.bowlingapp.domain.*;

import java.util.ArrayList;

public class GameBuilder {

    private static final int TEN_POINTS = 10;

    public static Game parseGameFromRolls(String player, ArrayList<Roll> rolls) {
        ArrayList<Frame> frames = new ArrayList<>();
        int rollCounter = 0;

        while (rollCounter < rolls.size()) {
            Frame frame = parseFrameFromRoll(rollCounter, rolls);

            frames.add(frame);

            if(frame.isStrike()){
                rollCounter += 1;
            } else {
                rollCounter += 2;
            }
        }

        return new Game(player, frames);
    }

    private static Frame parseFrameFromRoll(int aRoll, ArrayList<Roll> rolls) {
        Roll firstRoll = parseRoll(aRoll, rolls);

        if (firstRoll.getRollPoints() == TEN_POINTS) {
            return new Strike(firstRoll);
        }

        Roll secondRoll = parseRoll(aRoll + 1, rolls);

        if (firstRoll.getRollPoints() + secondRoll.getRollPoints() == TEN_POINTS) {
            return new Spare(firstRoll, secondRoll);
        }

        return new Frame(firstRoll, secondRoll);
    }

    private static Roll parseRoll(int rollIndex, ArrayList<Roll> rolls) {

        if (rollIndex < rolls.size()) {
            return rolls.get(rollIndex);
        } else return new Roll(0);
    }
}
