package com.zenon.bowlingapp.scoring;

import com.zenon.bowlingapp.Frame;
import java.util.ArrayList;

public class PointsCalculator {


    public static int frameTotalScore(Frame frame, ArrayList<Frame> frames) {
        return frameScore(frame) + isStrikeOrSpareBonus(frame, frames);
    }

    private static int frameScore(Frame frame) {

        if( frame.getSecondRoll() != null ) {
            return frame.getSecondRoll().getRollPoints() + frame.getFirstRoll().getRollPoints();
        } else {
            return frame.getFirstRoll().getRollPoints();
        }
    }

    private static int isStrikeOrSpareBonus(Frame frame, ArrayList<Frame> frames) {
        if (frame.isStrike()) {
            return calculateStrikeTotalPoints(frame, frames);
        }
        if (frame.isSpare()) {
            return calculateSpareTotalPoints(frame, frames);
        }
        return 0;
    }

    private static Frame getNextFrame(ArrayList<Frame> frames, Frame frame) {
        Frame nextFrame = frame;
        int currentFrameIndex = frames.indexOf(frame);

        if (currentFrameIndex < frames.size() - 1) {
            nextFrame = frames.get(currentFrameIndex + 1);
        }
        return nextFrame;
    }

    private static int calculateStrikeTotalPoints(Frame frame, ArrayList<Frame> frames) {
        Frame next = getNextFrame(frames, frame);
        if (next.isStrike()) {
            return next.getFirstRoll().getRollPoints() + getNextFrame(frames, next).getFirstRoll().getRollPoints();
        }
        return frameScore(next);
    }

    private static int calculateSpareTotalPoints(Frame frame, ArrayList<Frame> frames) {
        Frame next = getNextFrame(frames, frame);
        return next.getFirstRoll().getRollPoints();
    }

}
