//package edu.mum.cs.cs401.examples.java8.utils;
//
//import edu.mum.cs.cs401.examples.java8.pojos.City;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Stream;
//
//public class MyTopCities {
//
//    public static List<City> getTopCities(){
//        List<City> topCities = null;
//        try{
//            topCities = loadTopCities();
//            Collections.shuffle(topCities);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return topCities;
//    }
//
//    private static List<City> loadTopCities() throws Exception{
//        System.out.println("Loading the list of top 50 US cities ....");
//        FileReader reader = new FileReader("./src/main/resources/Cities.csv");
//        BufferedReader br = new BufferedReader(reader);
//
//        List<City> topCities = new ArrayList<>(50);
//
//        String line = null;
//        while ((line = br.readLine())!= null){
//            City city = convertCSV2City(line);
//            topCities.add(city);
//            System.out.println(".");
//            Thread.sleep(100);
//        }
//        br.close();
//        System.out.println("\nFinished loading the list of 50 US cities");
//        Thread.sleep(1000);
//        return topCities;
//
//    }
//
//    private static City convertCSV2City(String line) {
//        String[] tokens = line.split(",");
//
//        edu.mum.cs.cs401.examples.java8.pojos.City city = new edu.mum.cs.cs401.examples.java8.pojos.City();
//
//        city.setName(tokens[0].trim());
//        city.setState(tokens[1].trim());
//
//        city.setPopulation2012(convertToInteger(tokens[2]));
//        city.setPopulation2010(convertToInteger(tokens[3]));
//        city.setPopulation2005(convertToInteger(tokens[4]));
//        city.setPopulation2000(convertToInteger(tokens[5]));
//        city.setPopulation1990(convertToInteger(tokens[6]));
//
//        city.setPopulationChange(convertToDouble(tokens[7]));
//
//        city.setRank1990(convertToInteger(tokens[8]));
//        city.setRank2000(convertToInteger(tokens[9]));
//        city.setRank2010(convertToInteger(tokens[10]));
//        city.setRank2012(convertToInteger(tokens[11]));
//
//        city.adjust();
//
//        return city;
//    }
//
//    private static Double convertToDouble(String token) {
//    }
//
//    private static Integer convertToInteger(String value) {
//        if(null == value) {
//            return null;
//        }
//
//        value = value.trim();
//        if(value.equals("")) {
//            return null;
//        }
//
//        return Integer.valueOf(value);
//    }
//
//    public static class City{
//
//    }
//}
