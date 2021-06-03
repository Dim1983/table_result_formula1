package com.loctionov.racer.parser;

import com.loctionov.racer.saver.Racer;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RaceDataParserImpl implements RaceDateParser {
    private static final String UNDERSCORES_DELIMITER = "_";
    private static final String FORMAT_SETTER = "%s | %s ";
    private static final int POSITION_OF_COMMAND_ABBREVIATIONS = 0;
    private static final int POSITION_OF_RACERS_NAME = 1;
    private static final int POSITION_OF_COMMAND_NAME = 2;
    private static final String FOUND_ABBREVIATIONS_OF_WORD = "\\w{3}";
    private static final int TIME_OF_CIRCLE = 1;
    private static final Pattern PATTERN = Pattern.compile(FOUND_ABBREVIATIONS_OF_WORD);

    @Override
    public List<Racer> parseRaceData(List<String> abbreviationDate, List<String> startDateCircles,
                                     List<String> endDateCircles) {

        Map<String, String> abbreviationsToCommand = abbreviationDate.stream()
                .map(abbreviationsAndCommandName -> abbreviationsAndCommandName.split(UNDERSCORES_DELIMITER))
                .collect(Collectors.toMap(abbreviationsOfCommand -> abbreviationsOfCommand[POSITION_OF_COMMAND_ABBREVIATIONS],
                        racerNameAndCommandName -> String.format(FORMAT_SETTER,
                                racerNameAndCommandName[POSITION_OF_RACERS_NAME],
                                racerNameAndCommandName[POSITION_OF_COMMAND_NAME])));

        Map<String, String> startDateCircle = getDateOfCircle(startDateCircles);

        Map<String, String> endDateCircle = getDateOfCircle(endDateCircles);

        return getDateOfObject(abbreviationsToCommand, startDateCircle, endDateCircle);
    }

    private Map<String, String> getDateOfCircle(List<String> dateCircles) {
        return dateCircles.stream()
                .map(dateOfTimeCircle -> dateOfTimeCircle.split(UNDERSCORES_DELIMITER))
                .collect(Collectors.toMap(dateOfTimeCircle -> {
                    Matcher matcher = PATTERN.matcher(dateOfTimeCircle[POSITION_OF_COMMAND_ABBREVIATIONS]);
                    matcher.find();

                    return matcher.group();
                }, dateOfTimeCircle -> dateOfTimeCircle[TIME_OF_CIRCLE]));
    }

    private List<Racer> getDateOfObject(Map<String, String> abbreviationsCommand, Map<String, String> startDateCircle,
                                        Map<String, String> endDateCircle) {

        return abbreviationsCommand.keySet().stream()
                .map((keyHasCommandAbbreviations) -> Racer.builder()
                        .withCommandAbbreviation(keyHasCommandAbbreviations)
                        .withStartTimeOfCircle(LocalTime.parse(startDateCircle.get(keyHasCommandAbbreviations)))
                        .withEndTimeOfCircle(LocalTime.parse(endDateCircle.get(keyHasCommandAbbreviations)))
                        .withRacerNamesAndCommandNames(abbreviationsCommand.get(keyHasCommandAbbreviations))
                        .build())
                .collect(Collectors.toList());
    }
}
