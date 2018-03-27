package com.zenon.bowlingapp.scoring;

import com.zenon.bowlingapp.Frame;
import com.zenon.bowlingapp.Game;

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

        int bonusFrameCounter = 0;

        //handle the bonus - could fold this into if check in previous loop
        if (allFrames.size() > ALL_REGULATION_FRAMES) {
            while(totalFrames.size() < allFrames.size()){
                Frame bonusFrame = allFrames.get((ALL_REGULATION_FRAMES - 1) + bonusFrameCounter);

                totalFrames.add(bonusFrame);
                bonusFrameCounter++;
            }
        }



        return new Game(aGame.getBowler(), totalFrames);
    }

}
