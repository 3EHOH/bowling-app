package com.zenon.bowlingapp.domain.roll;

public class Roll {

    private int rollPoints;
    private boolean isFault;

    public Roll(int rollPoints) {
        if (rollPoints == -1) {
            this.rollPoints = 0;
            this.isFault = true;
        } else {
            this.rollPoints = rollPoints;
            this.isFault = false;
        }
    }

    public int getRollPoints() {
        return rollPoints;
    }

    public boolean isFault() {
        return isFault;
    }

}
