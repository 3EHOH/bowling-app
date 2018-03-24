package com.zenon.bowlingapp.util.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.zenon.bowlingapp.util.Constants.FOUL_CHAR;
import static com.zenon.bowlingapp.util.Constants.FOUL_INT;

public class FileParser {


    public  HashMap<String,ArrayList<Integer>> readScore() throws IOException {

//        if(args.length > 0) {
//            File file = new File(args[0]);
//
//
//
//            String str;
//            str = FileUtils.readFileToString(file,  "UTF-8");
//
//            System.out.println(str);
//
//            // Work with your 'file' object here
//        }


        BufferedReader buf = null;

        try {
            buf = new BufferedReader(new FileReader("src/main/java/com/zenon/bowlingapp/game.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    //            ArrayList<String> words = new ArrayList<>();
            Set<String> uniquePlayers = new HashSet<>();
            String lineJustFetched;
            String[] playerAndScoreArray;

//            List<PlayerProfile> playerProfiles = Collections.emptyList();

            HashMap<String,ArrayList<Integer>> playerProfs = new HashMap<>();

            while(true){
                lineJustFetched = buf.readLine();

                if (lineJustFetched == null) {

                    break;

                } else {
                    playerAndScoreArray = lineJustFetched.split(" ");
                    String playerName = playerAndScoreArray[0];
                    int playerScore = ConvertIntoNumeric(playerAndScoreArray[1]);

                    if (playerProfs.containsKey(playerName) ) {
                        ArrayList<Integer> playerScores = playerProfs.get(playerName);

                        playerScores.add(playerScore);
                        playerProfs.put(playerName, playerScores);
                    } else {
                        ArrayList<Integer> scores = new ArrayList<>();

                        scores.add(playerScore);
                        playerProfs.put(playerName, scores);
                    }

                }
            }


            buf.close();


            return playerProfs;

    }


    private static int ConvertIntoNumeric(String xVal)
    {

        if (xVal.charAt(0) == FOUL_CHAR) {
            return FOUL_INT;
        } else {
            return Integer.parseInt(xVal);
        }
    }

}

