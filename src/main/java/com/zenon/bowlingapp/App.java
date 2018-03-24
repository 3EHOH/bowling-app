package com.zenon.bowlingapp;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.zenon.bowlingapp.util.io.FileParser;
import org.apache.commons.io.FileUtils;
import java.io.BufferedReader;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class App {

    public static void main( String[] args ) {

        FileParser fp = new FileParser();
        try {
            fp.readScore();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class PlayerProfile {

        public String playerName;
        public List<Integer> playerScores;

        public PlayerProfile(String name) {
            this.playerName = name;
            this.playerScores = Collections.emptyList();
        }


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
