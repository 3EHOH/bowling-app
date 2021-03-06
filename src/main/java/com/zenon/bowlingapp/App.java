package com.zenon.bowlingapp;

import com.zenon.bowlingapp.domain.game.Game;
import com.zenon.bowlingapp.domain.roll.Roll;
import com.zenon.bowlingapp.builder.GamesBuilder;
import com.zenon.bowlingapp.io.FileParser;
import com.zenon.bowlingapp.printer.GamePrinter;

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
