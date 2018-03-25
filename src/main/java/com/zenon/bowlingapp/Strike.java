package com.zenon.bowlingapp;

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
