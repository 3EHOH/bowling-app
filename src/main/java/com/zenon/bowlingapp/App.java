package com.zenon.bowlingapp;

import com.zenon.bowlingapp.scoring.FileParser;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

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

        ArrayList<Game> allGames = GamesBuilder.buildGame(allPlayersAndRolls);
        StringBuilder printedAllGames = GamePrinter.printAllGames(allGames);
        System.out.print(printedAllGames);
    }
}
