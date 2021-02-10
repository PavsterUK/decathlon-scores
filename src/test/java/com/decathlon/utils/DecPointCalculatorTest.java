package com.decathlon.utils;

import com.decathlon.domain.Athlete;
import com.decathlon.domain.Decathlon;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DecPointCalculatorTest {

    File csv = new File("src/test/resources/CSVParserTest/CSV.txt");
    List<List<String>> athDataList = CSVParser.parseCSV(csv);
    List<Athlete> athleteList = CSVParser.getAthleteList(athDataList);

    @Test
    void countPoints(){
        Decathlon decathlon = new Decathlon(athleteList);
    }



}