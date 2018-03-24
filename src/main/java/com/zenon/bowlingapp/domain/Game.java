package com.zenon.bowlingapp.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {

    String bowler;
    ArrayList<Integer> allRolls;

    public Game(String playerName, ArrayList<Integer> playerRolls) {

        this.bowler  = playerName;
        this.allRolls = playerRolls;
    }
}
