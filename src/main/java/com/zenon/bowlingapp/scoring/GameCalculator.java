package com.zenon.bowlingapp.scoring;

import com.zenon.bowlingapp.Frame;
import com.zenon.bowlingapp.Game;

import java.util.ArrayList;

public class GameCalculator {

    public static Game calculateGame(Game aGame) {

        ArrayList<Frame> totalFrames = new ArrayList<>();
        int points = 0;
        for (Frame frame : aGame.getAllFrames()) {
            points += PointsCalculator.frameTotalScore(frame, aGame.getAllFrames());
            Frame calculatedFrame = FramePointsCalculator.calculateTotalPoints(frame, points);

            totalFrames.add(calculatedFrame);
        }
        return new Game(aGame.getBowler(), totalFrames);
    }



}
