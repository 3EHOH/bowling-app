package com.zenon.bowlingapp.scoring;

import com.zenon.bowlingapp.*;

import java.util.ArrayList;

public class FrameBuilder {

    private static final int TEN_POINTS = 10;

    //TODO split this into one function for frames and another for game
    public static Game parseFramesFromRolls(String player, ArrayList<Roll> rolls) {
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

//        for(Frame f: frames){
//            System.out.println("first roll " + f.getFirstRoll().getRollPoints());
//            if(f.getSecondRoll())
//            System.out.println("first roll " + f.getFirstRoll().getRollPoints())
//        }

        return new Game(player, frames);
    }

    private static Frame parseFrameFromRoll(int aRoll, ArrayList<Roll> rolls) {
        Roll firstRoll = parseRoll(aRoll, rolls);

//        System.out.println("FRAME first roll: " + firstRoll.getRollPoints());

        if (firstRoll.getRollPoints() == TEN_POINTS) {
            return new Strike(firstRoll);
        }

        Roll secondRoll = parseRoll(aRoll + 1, rolls);

        if (firstRoll.getRollPoints() + secondRoll.getRollPoints() == TEN_POINTS) {
            return new Spare(firstRoll, secondRoll);
        }

//        System.out.println("FRAME second roll: " + secondRoll.getRollPoints());

        return new Frame(firstRoll, secondRoll);
    }

    private static Roll parseRoll(int rollIndex, ArrayList<Roll> rolls) {

        if (rollIndex < rolls.size()) {
            return rolls.get(rollIndex);
        } else return new Roll(0);
    }
}
