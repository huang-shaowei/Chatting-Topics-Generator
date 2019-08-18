package com.oath;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;


/**
 * Hello world!
 */
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private static final String filePath = "/topic-generator/src/resources/topics-1.json";

    public static void main(String[] args) {
        String result = getTopic();
        System.out.println(result);
    }

    private static String getTopic() {
        Gson gson = new Gson();
        File jsonFile = Paths.get(System.getProperty("user.dir") + filePath).toFile();
        String result = "";
        try {
            JsonObject jsonObject = gson.fromJson(new FileReader(jsonFile), JsonObject.class);
            result = jsonObject.get("topic").getAsString();
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        return result;
    }
}
