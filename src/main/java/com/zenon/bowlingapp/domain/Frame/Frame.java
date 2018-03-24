package com.zenon.bowlingapp.domain.Frame;

import com.zenon.bowlingapp.domain.Roll;

public class Frame {

    Roll firstRoll;
    Roll secondRoll;
    int totalScore;

    public Frame(Roll roll0, Roll roll1, int score) {
        this.firstRoll = roll0;
        this.secondRoll = roll1;
        this.totalScore = score;
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


}
