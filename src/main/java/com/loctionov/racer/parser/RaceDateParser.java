package com.loctionov.racer.parser;

import com.loctionov.racer.saver.Racer;

import java.util.List;

public interface RaceDateParser {
    List<Racer> parseRaceData(List<String> abbreviationDate, List<String> startDateCircles,
                              List<String> endDateCircles);
}
