package com.loctionov.racer;

import com.loctionov.racer.datareader.ReaderDataFilesImpl;
import com.loctionov.racer.datareader.ReaderDateFiles;
import com.loctionov.racer.parser.RaceDataParserImpl;
import com.loctionov.racer.parser.RaceDateParser;
import com.loctionov.racer.validation.Validator;
import com.loctionov.racer.validation.ValidatorImpl;
import com.loctionov.racer.viewer.RacerViewProviderImpl;
import com.loctionov.racer.viewer.RacerViewProvider;

public class FormulaApp {
    public static void main(String[] args) {
        Validator<String> validator = new ValidatorImpl();
        ReaderDateFiles readerDataFiles = new ReaderDataFilesImpl();
        RaceDateParser raceDateParser = new RaceDataParserImpl();
        RacerViewProvider racerViewProvider = new RacerViewProviderImpl();

        StatisticAnalyzer statisticAnalyzer = new StatisticAnalyzer(validator, readerDataFiles, raceDateParser,
                racerViewProvider);
        System.out.println(statisticAnalyzer.provideAnalysis("files/start.log",
                "files/end.log", "files/abbreviations.txt"));
    }
}
