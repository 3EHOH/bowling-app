package com.zenon.bowlingapp.scoring;

import com.zenon.bowlingapp.domain.Frame;
import com.zenon.bowlingapp.domain.Game;

import java.util.ArrayList;

public class GameCalculator {

    private static final int ALL_REGULATION_FRAMES = 10;

    public static Game calculateGame(Game aGame) {

        ArrayList<Frame> totalFrames = new ArrayList<>();
        int points = 0;

        ArrayList<Frame> allFrames = aGame.getAllFrames();

        for (int i = 0; i < ALL_REGULATION_FRAMES; i++) {
            Frame currentFrame = allFrames.get(i);
            points += PointsCalculator.frameTotalScore(currentFrame, aGame.getAllFrames());
            Frame calculatedFrame = FramePointsCalculator.calculateTotalPoints(currentFrame, points);

            totalFrames.add(calculatedFrame);
        }


        //handle the bonus - todo fold this into if check in previous loop?

        if (allFrames.size() > totalFrames.size()){
            while(totalFrames.size() < allFrames.size()){
                Frame bonusFrame = allFrames.get(totalFrames.size());
                totalFrames.add(bonusFrame);
            }
        }

        return new Game(aGame.getBowler(), totalFrames);
    }

}
