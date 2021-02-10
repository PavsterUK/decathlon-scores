package com.decathlon.utils;

import com.decathlon.domain.Athlete;

import java.io.*;
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
     * athlete place, score, name.
     * @param athleteList [List<Athlete>] List of Athlete objects
     *
     * Throws IOException if template.html not found.
     *
     * @return [String] HTML table, containing athlete results.
     */
    public static String makeHTMLString(List<Athlete> athleteList){
        String htmlTempl = "";
        try {
            htmlTempl = new String(Files.readAllBytes(
                    Paths.get("src/main/java/com/decathlon/utils/template.html").toAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder athleteData = new StringBuilder("");
        for (Athlete athlete : athleteList){
                athleteData.append(getTableRow(athlete));
        }
        return htmlTempl.replace("$addData", athleteData.toString());
    }

    /**
     * Helper method to get information from passed
     * argument and generate HTML column using that
     * information.
     *
     * @param athlete [Athlete] Athlete
     * @return [String] HTML column containing
     * Athletes Name, Place, TotalScore
     */
    private static String getTableRow(Athlete athlete){
        return "<tr>" + '\n' +
                        "<td>" + athlete.getName() + "</td>" + '\n' +
                        "<td>" + athlete.getPlace() + "</td>" + '\n' +
                        "<td>" + athlete.getTotalScore() + "</td>" + '\n' +
                "</tr>" + '\n' + '\n';
    }

    /**
     * Creates .html extension file.
     *
     * @param htmlString [String] Contents to go inside .html file.
     * @param outputFile [String] Absolute path of file to be created.
     *
     */
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





