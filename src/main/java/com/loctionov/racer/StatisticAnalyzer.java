package com.loctionov.racer;

import com.loctionov.racer.datareader.ReaderDateFiles;
import com.loctionov.racer.parser.RaceDateParser;
import com.loctionov.racer.saver.Racer;
import com.loctionov.racer.validation.Validator;
import com.loctionov.racer.viewer.RacerViewProvider;

import java.util.List;

public class StatisticAnalyzer {
    private final Validator<String> validator;
    private final ReaderDateFiles readerDataFiles;
    private final RaceDateParser raceDataParser;
    private final RacerViewProvider racerViewProvider;

    public StatisticAnalyzer(Validator<String> validator, ReaderDateFiles readerDataFiles,
                             RaceDateParser raceDataParser, RacerViewProvider racerViewProvider) {
        this.validator = validator;
        this.readerDataFiles = readerDataFiles;
        this.raceDataParser = raceDataParser;
        this.racerViewProvider = racerViewProvider;
    }

    public String provideAnalysis(String pathOfStartDateFile, String pathOfEndFile, String pathOfAbbreviationFile) {
        validator.validationFilePath(pathOfStartDateFile, "Path of start.log is not corrected!");
        validator.validationFilePath(pathOfEndFile, "Path of end.log is not corrected!");
        validator.validationFilePath(pathOfAbbreviationFile, "Path of abbreviations.log is not corrected!");

        List<String> abbreviationDate = readerDataFiles.getReadDateOfFiles(pathOfAbbreviationFile);
        List<String> startDateCircles = readerDataFiles.getReadDateOfFiles(pathOfStartDateFile);
        List<String> endDateCircles = readerDataFiles.getReadDateOfFiles(pathOfEndFile);
        List<Racer> resultDateCommandsOfCircles = raceDataParser.parseRaceData(abbreviationDate,
                startDateCircles, endDateCircles);

        return racerViewProvider.provideRacerView(resultDateCommandsOfCircles);
    }
}
