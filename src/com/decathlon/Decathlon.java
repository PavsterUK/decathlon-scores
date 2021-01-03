package com.decathlon;

import com.decathlon.disciplines.*;

import java.util.ArrayList;
import java.util.List;

public class Decathlon {

    private final boolean isWomenTournament;
    private List<Discipline> decathlon = new ArrayList<>();

    public Decathlon(boolean womenTournament){
        this.isWomenTournament = womenTournament;
        makeDecathlon();
    }

    public void makeDecathlon(){
        decathlon.add(0, new HundredMeters(isWomenTournament));
        decathlon.add(1, new LongJump(isWomenTournament));
        decathlon.add(2, new ShotPut(isWomenTournament));
        decathlon.add(3, new HighJump(isWomenTournament));
        decathlon.add(4, new FourHundredMeters(isWomenTournament));
        decathlon.add(5, new OutdoorHurdles(isWomenTournament));
        decathlon.add(6, new DiscusThrow(isWomenTournament));
        decathlon.add(7, new PoleVault(isWomenTournament));
        decathlon.add(8, new JavelinThrow(isWomenTournament));
        decathlon.add(9, new FifteenHundredMeters(isWomenTournament));
    }

    public List<Discipline> getDecathlon() {
        return decathlon;
    }
}
