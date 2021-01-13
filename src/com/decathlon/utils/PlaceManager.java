package com.decathlon.utils;

import com.decathlon.domain.Athlete;

import java.util.Comparator;
import java.util.List;

public class PlaceManager {

    public static void arrangePlaces(List<Athlete> athleteList){
        int totalPlaces = athleteList.size();
        athleteList.sort(Comparator.comparingInt(Athlete::getTotalScore)
                .reversed());

        for (int i = 0; i < totalPlaces; i++) {
            
        }
    }
}
