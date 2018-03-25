package com.zenon.bowlingapp.scoring;

import com.zenon.bowlingapp.Frame;
import com.zenon.bowlingapp.Game;

import java.util.ArrayList;

public class PointsCalculator {

    public void calculateTotalScore(Game aGame) {
        int rollCount = 0;

        for (Frame frame : aGame.getAllFrames()) {

            rollCount++;

        }



    }

    private static int frameTotalScore(Frame frame) {

        if( frame.getSecondRoll() != null ) {

            return frame.getSecondRoll().getRollPoints() + frame.getFirstRoll().getRollPoints();

        } else {

            return frame.getFirstRoll().getRollPoints();

        }
    }

    private static Frame getNextFrame(ArrayList<Frame> frames, final Frame frame) {
        Frame nextFrame = frame;
        int currentTried = frames.indexOf(frame);
        if (currentTried < frames.size() - 1) {
            nextFrame = frames.get(currentTried + 1);
        }
        return nextFrame;
    }

}
