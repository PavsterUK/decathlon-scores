package com.decathlon.utils;

import com.decathlon.domain.Athlete;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Utility class to generate HTML format table with
 * three columns: ATHLETE NAME, PLACE, TOTAL SCORE.
 * Uses template.html as a skeleton html table,
 * uses List of Athlete objects to populate a table
 * with relevant information.
 * Result saved as an HTML format file.
 */

public class HTMLGenerator {

    /**
     * Generates html format table populated with
     * data from List<Athlete>.
     * @param athleteList List of Athlete objects must have
     *                    set fields
     *
     *
     *
     * @return populated HTML table with athletes results as String
     */
    public static String makeHTMLString(List<Athlete> athleteList){
        String htmlTempl = null;
        Charset charset = StandardCharsets.ISO_8859_1;
        try {
            htmlTempl = new String(Files.readAllBytes( Paths.get("src/main/com/decathlon/utils/template.html")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder athleteData = new StringBuilder("");
        for (Athlete athlete : athleteList){
                athleteData.append(getData(athlete));
        }
        return htmlTempl.replace("$addData", athleteData.toString());
    }

    private static String getData(Athlete athlete){
        return "<tr>" + '\n' +
                        "<td>" + athlete.getName() + "</td>" + '\n' +
                        "<td>" + athlete.getPlace() + "</td>" + '\n' +
                        "<td>" + athlete.getTotalScore() + "</td>" + '\n' +
                "</tr>" + '\n' + '\n';
    }

    public static void createHTMLFile(String htmlString, String outputFile){
        File outputHTML = new File(outputFile);
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(outputHTML));
            bufferedWriter.write(htmlString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





