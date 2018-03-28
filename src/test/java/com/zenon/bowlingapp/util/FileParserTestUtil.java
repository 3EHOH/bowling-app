package com.zenon.bowlingapp.util;

import com.zenon.bowlingapp.builder.GamesBuilder;
import com.zenon.bowlingapp.domain.game.Game;
import com.zenon.bowlingapp.domain.roll.Roll;
import com.zenon.bowlingapp.io.FileParser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class FileParserTestUtil {

    public ArrayList<Game> parseFileIntoGames(String fileName) {

        File file = loadFile(fileName);
        FileParser fp = new FileParser();

        HashMap<String, ArrayList<Roll>> allPlayersAndRolls = new HashMap<>();

        try {
            allPlayersAndRolls = fp.parseGameFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return GamesBuilder.buildGame(allPlayersAndRolls);
    }

    public File loadFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());

    }



}
