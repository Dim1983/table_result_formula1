package com.loctionov.racer.viewer;

import com.loctionov.racer.saver.Racer;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RacerViewProviderImpl implements RacerViewProvider {
    private static final int COUNT_FIRST_FIFTEEN_RACERS = 16;
    private static final String TABLE_RACERS_VIEW_SETTER = "%d %s | %s%s";
    private static final String TABLE_RACERS_VIEW_SETTER_WITH_DELIMITER = "%s%d %s | %s%s";
    private static final String DELIMITER_FIRST_FIFTEEN_RACERS = "-----------------------------------------------------------\n";
    private static final String TRANSFER_OF_LINE = "\n";
    private static final String TIME_FORMAT_SETTER = "mm:ss.SSS";

    @Override
    public String provideRacerView(List<Racer> resultDateCommandsOfCircles) {
        AtomicInteger countNumberOfLine = new AtomicInteger(1);

        return resultDateCommandsOfCircles.stream()
                .collect(Collectors.toMap(s -> countDifferentTimeOfCircles(s.getStartTimeOfCircle(), s.getEndTimeOfCircle()),
                        Racer::getRacerNamesAndCommandNames, (s1, s2) -> s1, TreeMap::new))
                .entrySet().stream()
                .map(s -> countNumberOfLine.get() != COUNT_FIRST_FIFTEEN_RACERS ?
                        String.format(TABLE_RACERS_VIEW_SETTER, countNumberOfLine.getAndIncrement(),
                                s.getValue(), s.getKey(), TRANSFER_OF_LINE) :
                        String.format(TABLE_RACERS_VIEW_SETTER_WITH_DELIMITER, DELIMITER_FIRST_FIFTEEN_RACERS,
                                countNumberOfLine.getAndIncrement(), s.getValue(), s.getKey(), TRANSFER_OF_LINE))
                .collect(Collectors.joining());
    }

    private String countDifferentTimeOfCircles(LocalTime startTimeOfCircle, LocalTime endTimeOfCircle) {
        long millis = ChronoUnit.MILLIS.between(startTimeOfCircle, endTimeOfCircle);

        Instant instant = Instant.ofEpochMilli(millis);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMAT_SETTER);

        return formatter.format(zonedDateTime);
    }
}
