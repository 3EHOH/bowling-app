package com.zenon.bowlingapp.domain.frame;

import com.zenon.bowlingapp.domain.roll.Roll;

public class Frame {

    private Roll firstRoll;
    private Roll secondRoll;
    private int totalScore;

    public Frame(Roll roll0, Roll roll1, int score) {
        this.firstRoll = roll0;
        this.secondRoll = roll1;
        this.totalScore = score;
    }

    //Constructor for Spare superclass
    public Frame(Roll roll0, Roll roll1) {
        this.firstRoll = roll0;
        this.secondRoll = roll1;
    }

    //Constructor for Strike superclass
    Frame(Roll roll0, int score) {
        this.firstRoll = roll0;
        this.totalScore = score;
    }

    //Constructor for Strike superclass
    public Frame(Roll roll0) {
        this.firstRoll = roll0;
    }

    public Roll getFirstRoll(){
        return firstRoll;
    }

    public Roll getSecondRoll() {
        return secondRoll;
    }

    public int getTotalScore() {
        return totalScore;
    }

    //default response, toggled in superclasses
    public boolean isSpare() {
        return false;
    }

    public boolean isStrike() {
        return false;
    }


}
