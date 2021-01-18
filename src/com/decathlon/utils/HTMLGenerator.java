package com.decathlon.utils;

import com.decathlon.domain.Athlete;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HTMLGenerator {

    public static String makeHTMLString(List<Athlete> athleteList){
        String htmlString = null;
        try {
            htmlString = Files.readString(Path.of("src/com/decathlon/utils/template.html"), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String athleteData = null;
        for (Athlete athlete : athleteList){
                athleteData += appendData(athlete);
        }
        return htmlString.replace("$addData", athleteData);
    }

    private static String appendData(Athlete athlete){
        return "<tr>" + '\n' +
                        "<td>" + athlete.getName() + "</td>" + '\n' +
                        "<td>" + athlete.getPlace() + "</td>" + '\n' +
                        "<td>" + athlete.getTotalScore() + "</td>" + '\n' +
                "</tr>" + '\n' + '\n';
    }
}





