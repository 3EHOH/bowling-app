package com.zenon.bowlingapp;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.apache.commons.io.FileUtils;
import java.io.BufferedReader;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class App {

    public static final int FOUL_INT = -1;
    public static final char FOUL_CHAR = 'F';
    public static final int FOUL_CHAR_ENCODING = 70;

    public static void main( String[] args ) throws IOException {

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



        try {
            BufferedReader buf = new BufferedReader(new FileReader("src/main/java/com/zenon/bowlingapp/game.txt"));
            ArrayList<String> words = new ArrayList<>();
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
//                    playersArray = lineJustFetched.split("\t");

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

            for (Object name: playerProfs.keySet()){

                String key = name.toString();
                String value = playerProfs.get(name).toString();
                System.out.println(key + " " + value);

            }

            for(String each : uniquePlayers){
                System.out.println(each);
            }

            buf.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        System.out.println( "Hello World!" );
    }

    static class PlayerProfile {

        public String playerName;
        public List<Integer> playerScores;

        public PlayerProfile(String name) {
            this.playerName = name;
            this.playerScores = Collections.emptyList();
        }


    }

    public static int ConvertIntoNumeric(String xVal)
    {
//        try
//        {
//            return Integer.parseInt(xVal);
//        }
//        catch(Exception ex)
//
//        {
            if (xVal.charAt(0) == FOUL_CHAR) {
                return FOUL_INT;
            } else {
                return Integer.parseInt(xVal);
            }
//        }
    }


//    HashMap<String, ArrayList<Integer>> playerProf = new HashMap<String, ArrayList<Integer>>();
//
//    public synchronized void addToList(String mapKey, Integer myItem) {
//        ArrayList<Integer> itemsList = playerProf.get(mapKey);
//
//        // if list does not exist create it
//        if(itemsList == null) {
//            itemsList = new ArrayList<Integer>();
//            itemsList.add(myItem);
//            playerProf.put(mapKey, itemsList);
//        } else {
//            // add if item is not already in list
//            if(!itemsList.contains(myItem)) itemsList.add(myItem);
//        }
//    }
}
