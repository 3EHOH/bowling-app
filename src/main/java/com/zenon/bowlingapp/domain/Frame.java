package com.zenon.bowlingapp.domain;

public class Frame {

    private Roll firstRoll;
    private Roll secondRoll;
    private int totalScore;

    public Frame(Roll roll0, Roll roll1, int score) {
        this.firstRoll = roll0;
        this.secondRoll = roll1;
        this.totalScore = score;
    }

}
