package com.zenon.bowlingapp.scoring;

import com.zenon.bowlingapp.Frame;
import com.zenon.bowlingapp.Game;

import java.util.ArrayList;

public class GameCalculator {

    private static final int ALL_FRAMES = 10;

    public static Game calculateGame(Game aGame) {

        ArrayList<Frame> totalFrames = new ArrayList<>();
        int points = 0;
//        for (Frame frame : aGame.getAllFrames()) {
//            points += PointsCalculator.frameTotalScore(frame, aGame.getAllFrames());
//            Frame calculatedFrame = FramePointsCalculator.calculateTotalPoints(frame, points);
//
//            totalFrames.add(calculatedFrame);
//        }

        ArrayList<Frame> allFrames = aGame.getAllFrames();

        for (int i = 0; i < ALL_FRAMES; i++) {
            Frame currentFrame = allFrames.get(i);

            points += PointsCalculator.frameTotalScore(currentFrame, aGame.getAllFrames());

            Frame calculatedFrame = FramePointsCalculator.calculateTotalPoints(currentFrame, points);

            totalFrames.add(calculatedFrame);
        }

        if (allFrames.size() > 10) {
            Frame bonusFrame = allFrames.get((allFrames.size() - 1));

            totalFrames.add(bonusFrame);
        }

        return new Game(aGame.getBowler(), totalFrames);
    }

}
