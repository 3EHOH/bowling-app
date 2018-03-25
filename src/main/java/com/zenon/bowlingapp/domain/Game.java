package com.zenon.bowlingapp.domain;

import java.util.ArrayList;


public class Game {

    private String bowler;
    private ArrayList<Roll> allRolls;

    public Game(String playerName, ArrayList<Roll> playerRolls) {

        this.bowler  = playerName;
        this.allRolls = playerRolls;
    }

    public String getBowler() {
        return bowler;
    }

    public ArrayList<Roll> getBowlerRolls() {
        return allRolls;
    }
}
