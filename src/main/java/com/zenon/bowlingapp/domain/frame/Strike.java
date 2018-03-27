package com.zenon.bowlingapp.domain.frame;

import com.zenon.bowlingapp.domain.Roll;

public class Strike extends Frame {

    public Strike(Roll roll0) {
        super(roll0);
    }

    public Strike(Roll roll0, int score) {
        super(roll0, score);
    }

    public boolean isStrike() {
        return true;
    }

}
