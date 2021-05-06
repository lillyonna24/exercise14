package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("JSON with gson example");
        //serializeSimple();
        deserializeSimple();
    }

    static void serializeSimple(){
        Simple person = new Simple ("walk the dog", false, 0, 3, "dog");

        Gson gson = new Gson();

        String json = gson.toJson(person);

        try {
            FileWriter writer = new FileWriter("data.json");
            gson.toJson(person, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void deserializeSimple(){
        String person2Json = "{\"body\":\"walk the dog\",\"done\":\"false\",\"id\":0,\"priority\":3,\"title\":\"dog\"}";
        JsonParser parser = new JsonParser();

        JsonElement test = parser.parse(person2Json);
        System.out.println(test.isJsonObject());
        Gson gson = new Gson();
        Simple person2 = gson.fromJson(person2Json, Simple.class);
        System.out.println(person2.toString());
        System.out.println(person2.getClass());
    }
}

class Simple{
    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public Simple(String body, boolean done, int id, int priority, String title) {
        this.body = body;
        this.done = false;
        this.id = id;
        this.priority = priority;
        this. title = title;
    }


}
