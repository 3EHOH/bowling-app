package com.zenon.bowlingapp.domain;

import com.zenon.bowlingapp.domain.Frame.Frame;

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

    public ArrayList<Frame> getBowlerRolls() {
        return allFrames;
    }
}
