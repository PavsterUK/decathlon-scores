package com.decathlon.utils;

import com.decathlon.domain.Athlete;
import java.util.List;

public class XMLGenerator {

    public static String makeXMLString(List<Athlete> athleteList){
        StringBuilder finalXML = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + '\n');
        finalXML.append("<decathlon>" + '\n');
        for (Athlete athlete : athleteList){
                finalXML.append(injectAthleteData(athlete));
        }
        finalXML.append("</decathlon>" + '\n');
        return finalXML.toString();
    }

    private static String injectAthleteData(Athlete athlete){
        String athleteXML = '\n' +
                "<athlete>" + '\n' +
                        "<place>" + athlete.getPlace() + "</place>" + '\n' +
                        "<name>" + athlete.getName() + "</name>" + '\n' +
                        "<totalScore>" + athlete.getTotalScore() + "</totalScore>" + '\n' +
                "</athlete>" + '\n' + '\n';
        return athleteXML;
    }
}





