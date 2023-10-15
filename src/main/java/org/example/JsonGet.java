package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonGet {
    private static final String filePath = "C:\\Users\\X\\IdeaProjects\\Weather\\test.json";
    public  String jsonReturn(double tem, double max, double min){
        return "temp: "+tem+"\n"+"temp_max: "+max+"\n"+"temp_min: "+min;
    }
    public static void main(String[] args) {
        try {
                // считывание файла JSON
                FileReader reader = new FileReader(filePath);

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

                // получение строки из объекта
                JSONObject main = (JSONObject) jsonObject.get("main");
                double temp = (double) main.get("temp");
                double min_temp = (double) main.get("temp_min");
                double max_temp = (double) main.get("temp_max");
                System.out.println("temp: "+temp+"\n"+"temp_max: "+max_temp+"\n"+"temp_min: "+min_temp);

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ParseException ex) {
                ex.printStackTrace();
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }

        }
}
