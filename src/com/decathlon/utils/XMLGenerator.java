package com.decathlon.utils;

import com.decathlon.Athlete;
import java.util.List;

public class XMLGenerator {

    public static String generate(List<Athlete> athleteList){
        StringBuilder finalXML = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + '\n');
        finalXML.append("<decathlon>" + '\n');
        for (Athlete athlete : athleteList){
                finalXML.append(appendXML(athlete));
        }
        finalXML.append("</decathlon>" + '\n');
        return finalXML.toString();
    }

    private static String appendXML(Athlete athlete){
        String athleteXML =
                "<athlete>" + '\n' +
                        "<place>" + athlete.getPlace() + "</place>" + '\n' +
                        "<name>" + athlete.getName() + "</name>" + '\n' +
                        "<totalScore>" + athlete.getTotalScore() + "</totalScore>" + '\n' +
                "</athlete>" + '\n';
        return athleteXML;
    }
}





