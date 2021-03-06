package com.zenon.bowlingapp.builder;

import com.zenon.bowlingapp.domain.frame.Frame;
import com.zenon.bowlingapp.domain.frame.Spare;
import com.zenon.bowlingapp.domain.frame.Strike;

public class FrameBuilder {

    static public Frame buildFrameTypeAndPoints(Frame frame, int points) {

        if (frame.isStrike()) {
            return new Strike(frame.getFirstRoll(), points);
        }

        if (frame.isSpare()) {
            return new Spare(frame.getFirstRoll(), frame.getSecondRoll(), points);
        }

        return new Frame(frame.getFirstRoll(), frame.getSecondRoll(), points);
    }

}
