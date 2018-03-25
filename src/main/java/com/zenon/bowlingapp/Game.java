package com.zenon.bowlingapp;

import java.util.ArrayList;


public class Game {

    private String bowler;
    private ArrayList<Frame> allFrames;

    public Game(String playerName, ArrayList<Frame> frames) {

        this.bowler  = playerName;
        this.allFrames = frames;
    }

    public String getBowler() {
        return bowler;
    }

    public ArrayList<Frame> getAllFrames() {
        return allFrames;
    }
}
