package io.github.sb.util;

import io.github.sb.error.JsonFileNotFound;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileToString {

    public static String CONTENT(String jsonName){
        File file = new File("./src/test/resources/" + jsonName + ".json");
        try {
            return new String(Files.readAllBytes(Paths.get(file.toURI())));
        } catch (IOException e) {
            throw new JsonFileNotFound("Json file "+ jsonName+" not found :"+ e.getMessage());
        }
    }
}
