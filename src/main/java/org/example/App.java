package org.example;
import org.json.JSONException;


import java.io.*;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.List;



import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App

{
    private static final String filePath = "C:\\Users\\X\\IdeaProjects\\Weather\\test.json";
    public static void main( String[] args ) throws IOException {
        System.out.println("                                                                       \n" +
                "                                                                              \n" +
                "                                        ___      ,---,                        \n" +
                "                                      ,--.'|_  ,--.' |                        \n" +
                "         .---.                        |  | :,' |  |  :                __  ,-. \n" +
                "        /. ./|                        :  : ' : :  :  :              ,' ,'/ /| \n" +
                "     .-'-. ' |   ,---.     ,--.--.  .;__,'  /  :  |  |,--.   ,---.  '  | |' | \n" +
                "    /___/ \\: |  /     \\   /       \\ |  |   |   |  :  '   |  /     \\ |  |   ,' \n" +
                " .-'.. '   ' . /    /  | .--.  .-. |:__,'| :   |  |   /' : /    /  |'  :  /   \n" +
                "/___/ \\:     '.    ' / |  \\__\\/: . .  '  : |__ '  :  | | |.    ' / ||  | '    \n" +
                ".   \\  ' .\\   '   ;   /|  ,\" .--.; |  |  | '.'||  |  ' | :'   ;   /|;  : |    \n" +
                " \\   \\   ' \\ |'   |  / | /  /  ,.  |  ;  :    ;|  :  :_:,''   |  / ||  , ;    \n" +
                "  \\   \\  |--\" |   :    |;  :   .'   \\ |  ,   / |  | ,'    |   :    | ---'     \n" +
                "   \\   \\ |     \\   \\  / |  ,     .-./  ---`-'  `--''       \\   \\  /           \n" +
                "    '---\"       `----'   `--`---'                           `----'            \n" +
                "                                                                              ");
        WeatherService service = new WeatherService();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название города на английском: ");
        String city = scanner.nextLine();
        city = city.substring(0, 1).toUpperCase() + city.substring(1);
        System.out.println(city);
        try {

            JSONObject weather = service.getWeather(city, "060187363d63fc42691e6c2d6c0cd8d6");
            try(FileWriter writer = new FileWriter("test.json", false))
            {
                // запись всей строки

                writer.write(weather.toString());
                // запись по символам


                writer.flush();

            }


            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
            try {
                // считывание файла JSON
                FileReader reader = new FileReader(filePath);

                JSONParser jsonParser = new JSONParser();
                org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) jsonParser.parse(reader);

                // получение строки из объекта
                org.json.simple.JSONObject main = (org.json.simple.JSONObject) jsonObject.get("main");
                double temp = (double) main.get("temp");
                double min_temp = (double) main.get("temp_min");
                double max_temp = (double) main.get("temp_max");
                System.out.println("temp: "+(temp-273)+"\n"+"temp_max: "+(max_temp-273)+"\n"+"temp_min: "+(min_temp-273));

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ParseException ex) {
                ex.printStackTrace();
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }
//            try {
//                // считывание файла JSON
//                FileReader reader = new FileReader(filePath);
//
//                JSONParser jsonParser = new JSONParser();
//                JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
//
//                // получение строки из объекта
//                JSONObject main = (JSONObject) jsonObject.get("main");
//                double temp = (double) main.get("temp");
//                double min_temp = (double) main.get("temp_min");
//                double max_temp = (double) main.get("temp_max");
//                System.out.println("temp: "+temp+"\n"+"temp_max: "+max_temp+"\n"+"temp_min: "+min_temp);
//
//
//            } catch (FileNotFoundException ex) {
//                ex.printStackTrace();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            } catch (ParseException ex) {
//                ex.printStackTrace();
//            } catch (NullPointerException ex) {
//                ex.printStackTrace();
//            }






        } catch (Exception exception){
            System.out.println("Вы ввели некоректно город");
        }


    }

}
