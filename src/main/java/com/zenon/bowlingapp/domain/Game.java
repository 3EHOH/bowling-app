package com.zenon.bowlingapp.domain;

import java.util.ArrayList;


public class Game {

    private String bowler;
    private ArrayList<Integer> allRolls;

    public Game(String playerName, ArrayList<Integer> playerRolls) {

        this.bowler  = playerName;
        this.allRolls = playerRolls;
    }

    public String getBowler() {
        return bowler;
    }

    public ArrayList<Integer> getBowlerRolls() {
        return allRolls;
    }
}
