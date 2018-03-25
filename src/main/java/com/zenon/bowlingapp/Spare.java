package com.zenon.bowlingapp;

public class Spare extends Frame {

    public Spare(Roll roll0, Roll roll1) {
        super(roll0, roll1);
    }

    public Spare(Roll roll0, Roll roll1, int totalScore) {
        super(roll0, roll1, totalScore);
    }

    public boolean isSpare() {
        return true;
    }
}