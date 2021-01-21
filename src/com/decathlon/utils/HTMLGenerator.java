package com.decathlon.utils;

import com.decathlon.domain.Athlete;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Utility class used to generate HTML String.
 */

public class HTMLGenerator {

    /**
     * Used to generate HTML
     * @param athleteList is list of athletes after comp
     * @return
     */
    public static String makeHTMLString(List<Athlete> athleteList){
        String htmlString = null;
        try {
            htmlString = Files.readString(Path.of("src/com/decathlon/utils/template.html"), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder athleteData = new StringBuilder("");
        for (Athlete athlete : athleteList){
                athleteData.append(getData(athlete));
        }
        return htmlString.replace("$addData", athleteData.toString());
    }

    private static String getData(Athlete athlete){
        return "<tr>" + '\n' +
                        "<td>" + athlete.getName() + "</td>" + '\n' +
                        "<td>" + athlete.getPlace() + "</td>" + '\n' +
                        "<td>" + athlete.getTotalScore() + "</td>" + '\n' +
                "</tr>" + '\n' + '\n';
    }
}





