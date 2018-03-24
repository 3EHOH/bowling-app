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


    public void readScore() throws IOException {

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

//                    if ( Integer.valueOf(playerAndScoreArray[1]) == FOUL_CHAR_ENCODING ) {
//                        playerScore = FOUL_INT;
//                    } else {
//                        playerScore = Integer.valueOf(playerAndScoreArray[1]);
//                    }

//                    playerProf.add
//                    for(String each : playersArray){
//                        if(!"".equals(playerAndScoreArray[0])){
//                            uniquePlayers.add(playerAndScoreArray[0]);
//                        }



//                    PlayerProfile aPlayer = new PlayerProfile(playerAndScoreArray[0]);

//                    if (playerProfs.containsKey(aPlayer) ) {
//                        ArrayList<Integer> playerScores = playerProfs.get(aPlayer);
//                        playerScores.add(playerScore);
//                        playerProfs.put()
//                    } else {

                    if (playerProfs.containsKey(playerName) ) {
                        ArrayList<Integer> playerScores = playerProfs.get(playerName);

                        playerScores.add(playerScore);
                        playerProfs.put(playerName, playerScores);
                    } else {
                        ArrayList<Integer> scores = new ArrayList<>();

                        scores.add(playerScore);
                        playerProfs.put(playerName, scores);
                    }



//                    if (playerProfiles.contains(aPlayer.playerName))
//                    addToList(playerAndScoreArray[0], playerAndScoreArray[1]);

//                    playerProfiles.add(aPlayer);


//                        JSONObject obj = new JSONObject();
//
//
//                        obj.put("playerName", uniquePlayers);
////                        obj.put("playerScore", new ArrayList<Integer>);
//                        JSONArray playerScore = new JSONArray();
//
//                        Gson gson = new GsonBuilder().create();
//                        List<Integer> myList = new ArrayList<>();





//                        JsonArray myCustomArray = gson.toJsonTree(myCustomList).getAsJsonArray();

//                    }
                }
            }


//            for(String each : uniquePlayers){
//                System.out.println(each);
//            }

            buf.close();

            for (Object name: playerProfs.keySet()){

                String key = name.toString();
                String value = playerProfs.get(name).toString();
                System.out.println(key + " " + value);

            }



        System.out.println( "Hello World!" );
    }


    public static int ConvertIntoNumeric(String xVal)
    {

        if (xVal.charAt(0) == FOUL_CHAR) {
            return FOUL_INT;
        } else {
            return Integer.parseInt(xVal);
        }
//        }
    }

}

