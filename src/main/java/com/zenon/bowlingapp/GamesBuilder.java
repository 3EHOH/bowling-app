package com.zenon.bowlingapp;

import com.zenon.bowlingapp.scoring.FrameBuilder;
import com.zenon.bowlingapp.scoring.GameCalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamesBuilder {

    public static ArrayList<Game> buildGame(HashMap<String, ArrayList<Roll>> allPlayersAndRolls){
        ArrayList<Game> allGames = new ArrayList<>();

        for (Object o : allPlayersAndRolls.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            String bowlerName = pair.getKey().toString();
            ArrayList<Roll> bowlerRolls = (ArrayList<Roll>) pair.getValue();
            Game aGame = FrameBuilder.parseFramesFromRolls(bowlerName, bowlerRolls);
            Game calculatedGame = GameCalculator.calculateGame(aGame);

            allGames.add(calculatedGame);
        }

        return allGames;
    }
}
