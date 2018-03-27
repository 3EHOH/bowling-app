package com.zenon.bowlingapp.scoring;

import com.zenon.bowlingapp.domain.Frame;
import com.zenon.bowlingapp.domain.Spare;
import com.zenon.bowlingapp.domain.Strike;

public class FramePointsCalculator {

    static public Frame calculateTotalPoints(Frame frame, int points) {

        if (frame.isStrike()) {
            return new Strike(frame.getFirstRoll(), points);
        }

        if (frame.isSpare()) {
            return new Spare(frame.getFirstRoll(), frame.getSecondRoll(), points);
        }

        return new Frame(frame.getFirstRoll(), frame.getSecondRoll(), points);
    }

}
