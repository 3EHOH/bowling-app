package com.zenon.bowlingapp;


import com.zenon.bowlingapp.scoring.FileParser;
import com.zenon.bowlingapp.scoring.FrameBuilder;
import com.zenon.bowlingapp.scoring.GameCalculator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;


public class App {

    public static void main( String[] args ) {
        File bowlingGameFile = new File(args[0]);
        FileParser fp = new FileParser();

        HashMap<String, ArrayList<Roll>> allPlayersAndRolls = new HashMap<>();

        try {
            allPlayersAndRolls = fp.parseGameFile(bowlingGameFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Game> allGames = new ArrayList<>();

        for (Object o : allPlayersAndRolls.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            String bowlerName = pair.getKey().toString();
            ArrayList<Roll> bowlerRolls = (ArrayList<Roll>) pair.getValue();
            Game aGame = FrameBuilder.parseFramesFromRolls(bowlerName, bowlerRolls);
            Game calculatedGame = GameCalculator.calculateGame(aGame);

            allGames.add(calculatedGame);
        }

        GamePrinter.printAllGames(allGames);

    }

}
