package com.decathlon.utils;

import com.decathlon.domain.Athlete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CSVParserTest {

    File csv = new File("src/test/resources/CSVParserTest/CSV.txt");
    List<List<String>> athDataList = CSVParser.parseCSV(csv);

    @Test
    void parseCSV() {

        List<String> one = Arrays.asList("ATHLETE_ONE", "12.61", "5.00", "9.22", "1.50", "60.39", "16.43", "21.60", "2.60", "35.81", "5.25.72");
        List<String> two = Arrays.asList("ATHLETE_TWO", "13.04", "4.53", "7.79", "1.55", "64.72", "18.74", "24.20", "2.40", "28.20", "6.50.76");
        List<String> three = Arrays.asList("ATHLETE_THREE", "13.75", "4.84", "10.12", "1.50", "68.44", "19.18", "30.85", "2.80", "33.88", "6.22.75");
        List<String> four = Arrays.asList("ATHLETE_FOUR", "13.43", "4.35", "8.64", "1.50", "66.06", "19.05", "24.89", "2.20", "33.48", "6.51.01");

        //Compare single Arraylists
        Assertions.assertArrayEquals(one.toArray(), athDataList.get(0).toArray());
        Assertions.assertArrayEquals(two.toArray(), athDataList.get(1).toArray());
        Assertions.assertArrayEquals(three.toArray(), athDataList.get(2).toArray());
        Assertions.assertArrayEquals(four.toArray(), athDataList.get(3).toArray());

        List<List<String>> testList = new ArrayList<>();
        testList.add(one);
        testList.add(two);
        testList.add(three);
        testList.add(four);

        //Compare Entire Lists
        Assertions.assertEquals(testList, athDataList);
    }


    @Test
    void createAthleteList() {

        List<Athlete> athleteList = CSVParser.getAthleteList(athDataList);

        Athlete one = new Athlete(
                "ATHLETE_ONE",
                new String[]{"12.61", "5.00", "9.22", "1.50", "60.39", "16.43", "21.60", "2.60", "35.81", "5.25.72"});

        Athlete two = new Athlete(
                "ATHLETE_TWO",
                new String[]{"13.04", "4.53", "7.79", "1.55", "64.72", "18.74", "24.20", "2.40", "28.20", "6.50.76"});

        Athlete three = new Athlete(
                "ATHLETE_THREE",
                new String[]{"13.75", "4.84", "10.12", "1.50", "68.44", "19.18", "30.85", "2.80", "33.88", "6.22.75"});

        Athlete four = new Athlete(
                "ATHLETE_FOUR",
                new String[]{"13.43", "4.35", "8.64", "1.50", "66.06", "19.05", "24.89", "2.20", "33.48", "6.51.01"});

        //AthleteList must be size 4
        Assertions.assertEquals(4, athleteList.size());

        //Athlete 1
        Assertions.assertEquals(one.getName(), athleteList.get(0).getName());
        Assertions.assertArrayEquals(one.getResults(), athleteList.get(0).getResults());

        //Athlete 2
        Assertions.assertEquals(two.getName(), athleteList.get(1).getName());
        Assertions.assertArrayEquals(two.getResults(), athleteList.get(1).getResults());

        //Athlete 3
        Assertions.assertEquals(three.getName(), athleteList.get(2).getName());
        Assertions.assertArrayEquals(three.getResults(), athleteList.get(2).getResults());

        //Athlete 4
        Assertions.assertEquals(four.getName(), athleteList.get(3).getName());
        Assertions.assertArrayEquals(four.getResults(), athleteList.get(3).getResults());

    }
}