package racer;

import com.loctionov.racer.StatisticAnalyzer;
import com.loctionov.racer.datareader.ReaderDateFiles;
import com.loctionov.racer.parser.RaceDateParser;
import com.loctionov.racer.saver.Racer;
import com.loctionov.racer.validation.Validator;
import com.loctionov.racer.viewer.RacerViewProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatisticAnalyzerTest {
    @Mock
    private Validator<String> validatorMock;

    @Mock
    private ReaderDateFiles readerDataFilesMock;

    @Mock
    private RaceDateParser raceDataParserMock;

    @Mock
    private RacerViewProvider racerViewProviderMock;

    @InjectMocks
    private StatisticAnalyzer statisticAnalyzer;

    @Test
    void provideAnalysisShouldBeReturnTableOfResultRaceUsString() {
        String pathStartFile = "target/start.log";
        String pathEndFile = "target/end.log";
        String pathAbbreviations = "target/abbreviations.txt";

        String tableOfResultCircle = "1 Sebastian Vettel | FERRARI | 01:04.415\n" +
                "2 Daniel Ricciardo | RED BULL RACING TAG HEUER | 01:12.013\n" +
                "3 Valtteri Bottas | MERCEDES | 01:12.434\n" +
                "4 Lewis Hamilton | MERCEDES | 01:12.460\n" +
                "5 Stoffel Vandoorne | MCLAREN RENAULT | 01:12.463\n" +
                "6 Kimi Raikkonen | FERRARI | 01:12.639\n" +
                "7 Fernando Alonso | MCLAREN RENAULT | 01:12.657\n" +
                "8 Sergey Sirotkin | WILLIAMS MERCEDES | 01:12.706\n" +
                "9 Charles Leclerc | SAUBER FERRARI | 01:12.829\n" +
                "10 Sergio Perez | FORCE INDIA MERCEDES | 01:12.848\n" +
                "11 Romain Grosjean | HAAS FERRARI | 01:12.930\n" +
                "12 Pierre Gasly | SCUDERIA TORO ROSSO HONDA | 01:12.941\n" +
                "13 Carlos Sainz | RENAULT | 01:12.950\n" +
                "14 Esteban Ocon | FORCE INDIA MERCEDES | 01:13.028\n" +
                "15 Nico Hulkenberg | RENAULT | 01:13.065\n" +
                "-----------------------------------------------------------\n" +
                "16 Brendon Hartley | SCUDERIA TORO ROSSO HONDA | 01:13.179\n" +
                "17 Marcus Ericsson | SAUBER FERRARI | 01:13.265\n" +
                "18 Lance Stroll | WILLIAMS MERCEDES | 01:13.323\n" +
                "19 Kevin Magnussen | HAAS FERRARI | 01:13.393\n";

        List<String> startCirclesDate = Arrays.asList(
                "SVF2018-05-24_12:02:58.917",
                "NHR2018-05-24_12:02:49.914",
                "FAM2018-05-24_12:13:04.512",
                "KRF2018-05-24_12:03:01.250",
                "SVM2018-05-24_12:18:37.735",
                "MES2018-05-24_12:04:45.513",
                "LSW2018-05-24_12:06:13.511",
                "BHS2018-05-24_12:14:51.985",
                "EOF2018-05-24_12:17:58.810",
                "RGH2018-05-24_12:05:14.511",
                "SSW2018-05-24_12:16:11.648",
                "KMH2018-05-24_12:02:51.003",
                "PGS2018-05-24_12:07:23.645",
                "CSR2018-05-24_12:03:15.145",
                "SPF2018-05-24_12:12:01.035",
                "DRR2018-05-24_12:14:12.054",
                "LHM2018-05-24_12:18:20.125",
                "CLS2018-05-24_12:09:41.921",
                "VBM2018-05-24_12:00:00.000"
        );

        List<String> endCirclesDate = Arrays.asList(
                "MES2018-05-24_12:05:58.778",
                "RGH2018-05-24_12:06:27.441",
                "SPF2018-05-24_12:13:13.883",
                "LSW2018-05-24_12:07:26.834",
                "DRR2018-05-24_12:15:24.067",
                "NHR2018-05-24_12:04:02.979",
                "CSR2018-05-24_12:04:28.095",
                "KMH2018-05-24_12:04:04.396",
                "BHS2018-05-24_12:16:05.164",
                "SVM2018-05-24_12:19:50.198",
                "KRF2018-05-24_12:04:13.889",
                "VBM2018-05-24_12:01:12.434",
                "SVF2018-05-24_12:04:03.332",
                "EOF2018-05-24_12:19:11.838",
                "PGS2018-05-24_12:08:36.586",
                "SSW2018-05-24_12:17:24.354",
                "FAM2018-05-24_12:14:17.169",
                "CLS2018-05-24_12:10:54.750",
                "LHM2018-05-24_12:19:32.585)"
        );

        List<String> abbreviationDate = Arrays.asList(
                "DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER",
                "SVF_Sebastian Vettel_FERRARI",
                "LHM_Lewis Hamilton_MERCEDES",
                "KRF_Kimi Raikkonen_FERRARI",
                "VBM_Valtteri Bottas_MERCEDES",
                "EOF_Esteban Ocon_FORCE INDIA MERCEDES",
                "FAM_Fernando Alonso_MCLAREN RENAULT",
                "CSR_Carlos Sainz_RENAULT",
                "SPF_Sergio Perez_FORCE INDIA MERCEDES",
                "PGS_Pierre Gasly_SCUDERIA TORO ROSSO HONDA",
                "NHR_Nico Hulkenberg_RENAULT",
                "SVM_Stoffel Vandoorne_MCLAREN RENAULT",
                "SSW_Sergey Sirotkin_WILLIAMS MERCEDES",
                "CLS_Charles Leclerc_SAUBER FERRARI",
                "RGH_Romain Grosjean_HAAS FERRARI",
                "BHS_Brendon Hartley_SCUDERIA TORO ROSSO HONDA",
                "MES_Marcus Ericsson_SAUBER FERRARI",
                "LSW_Lance Stroll_WILLIAMS MERCEDES",
                "KMH_Kevin Magnussen_HAAS FERRARI"
        );

        List<Racer> finalDateOfRacersCircles = new ArrayList<Racer>() {{
            add(Racer.builder()
                    .withCommandAbbreviation("VBM")
                    .withStartTimeOfCircle(LocalTime.parse("12:00:00.000"))
                    .withEndTimeOfCircle(LocalTime.parse("12:01:12.434"))
                    .withRacerNamesAndCommandNames("Valtteri Bottas | MERCEDES ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("SVF")
                    .withStartTimeOfCircle(LocalTime.parse("12:02:58.917"))
                    .withEndTimeOfCircle(LocalTime.parse("12:04:03.332"))
                    .withRacerNamesAndCommandNames("Sebastian Vettel | FERRARI ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("CSR")
                    .withStartTimeOfCircle(LocalTime.parse("12:03:15.145"))
                    .withEndTimeOfCircle(LocalTime.parse("12:04:28.095"))
                    .withRacerNamesAndCommandNames("Carlos Sainz | RENAULT ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("DRR")
                    .withStartTimeOfCircle(LocalTime.parse("12:14:12.054"))
                    .withEndTimeOfCircle(LocalTime.parse("12:15:24.067"))
                    .withRacerNamesAndCommandNames("Daniel Ricciardo | RED BULL RACING TAG HEUER ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("KMH")
                    .withStartTimeOfCircle(LocalTime.parse("12:02:51.003"))
                    .withEndTimeOfCircle(LocalTime.parse("12:04:04.396"))
                    .withRacerNamesAndCommandNames("Kevin Magnussen | HAAS FERRARI ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("SPF")
                    .withStartTimeOfCircle(LocalTime.parse("12:12:01.035"))
                    .withEndTimeOfCircle(LocalTime.parse("12:13:13.883"))
                    .withRacerNamesAndCommandNames("Sergio Perez | FORCE INDIA MERCEDES ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("SVM")
                    .withStartTimeOfCircle(LocalTime.parse("12:18:37.735"))
                    .withEndTimeOfCircle(LocalTime.parse("12:19:50.198"))
                    .withRacerNamesAndCommandNames("Stoffel Vandoorne | MCLAREN RENAULT ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("CLS")
                    .withStartTimeOfCircle(LocalTime.parse("12:09:41.921"))
                    .withEndTimeOfCircle(LocalTime.parse("12:10:54.750"))
                    .withRacerNamesAndCommandNames("Charles Leclerc | SAUBER FERRARI ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("BHS")
                    .withStartTimeOfCircle(LocalTime.parse("12:14:51.985"))
                    .withEndTimeOfCircle(LocalTime.parse("12:16:05.164"))
                    .withRacerNamesAndCommandNames("Brendon Hartley | SCUDERIA TORO ROSSO HONDA ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("LHM")
                    .withStartTimeOfCircle(LocalTime.parse("12:18:20.125"))
                    .withEndTimeOfCircle(LocalTime.parse("12:19:32.585"))
                    .withRacerNamesAndCommandNames("Lewis Hamilton | MERCEDES ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("LSW")
                    .withStartTimeOfCircle(LocalTime.parse("12:06:13.511"))
                    .withEndTimeOfCircle(LocalTime.parse("12:07:26.834"))
                    .withRacerNamesAndCommandNames("Lance Stroll | WILLIAMS MERCEDES ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("RGH")
                    .withStartTimeOfCircle(LocalTime.parse("12:05:14.511"))
                    .withEndTimeOfCircle(LocalTime.parse("12:06:27.441"))
                    .withRacerNamesAndCommandNames("Romain Grosjean | HAAS FERRARI ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("FAM")
                    .withStartTimeOfCircle(LocalTime.parse("12:13:04.512"))
                    .withEndTimeOfCircle(LocalTime.parse("12:14:17.169"))
                    .withRacerNamesAndCommandNames("Fernando Alonso | MCLAREN RENAULT ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("SSW")
                    .withStartTimeOfCircle(LocalTime.parse("12:16:11.648"))
                    .withEndTimeOfCircle(LocalTime.parse("12:17:24.354"))
                    .withRacerNamesAndCommandNames("Sergey Sirotkin | WILLIAMS MERCEDES ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("NHR")
                    .withStartTimeOfCircle(LocalTime.parse("12:02:49.914"))
                    .withEndTimeOfCircle(LocalTime.parse("12:04:02.979"))
                    .withRacerNamesAndCommandNames("Nico Hulkenberg | RENAULT ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("MES")
                    .withStartTimeOfCircle(LocalTime.parse("12:04:45.513"))
                    .withEndTimeOfCircle(LocalTime.parse("12:05:58.778"))
                    .withRacerNamesAndCommandNames("Marcus Ericsson | SAUBER FERRARI ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("EOF")
                    .withStartTimeOfCircle(LocalTime.parse("12:17:58.810"))
                    .withEndTimeOfCircle(LocalTime.parse("12:19:11.838"))
                    .withRacerNamesAndCommandNames("Esteban Ocon | FORCE INDIA MERCEDES ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("PGS")
                    .withStartTimeOfCircle(LocalTime.parse("12:07:23.645"))
                    .withEndTimeOfCircle(LocalTime.parse("12:08:36.586"))
                    .withRacerNamesAndCommandNames("Pierre Gasly | SCUDERIA TORO ROSSO HONDA ")
                    .build());
            add(Racer.builder()
                    .withCommandAbbreviation("KRF")
                    .withStartTimeOfCircle(LocalTime.parse("12:03:01.250"))
                    .withEndTimeOfCircle(LocalTime.parse("12:04:13.889"))
                    .withRacerNamesAndCommandNames("Kimi Raikkonen | FERRARI ")
                    .build());

        }};

        when(readerDataFilesMock.getReadDateOfFiles(pathStartFile)).thenReturn(startCirclesDate);
        when(readerDataFilesMock.getReadDateOfFiles(pathEndFile)).thenReturn(endCirclesDate);
        when(readerDataFilesMock.getReadDateOfFiles(pathAbbreviations)).thenReturn(abbreviationDate);
        when(raceDataParserMock.parseRaceData(abbreviationDate, startCirclesDate, endCirclesDate)).thenReturn(finalDateOfRacersCircles);
        when(racerViewProviderMock.provideRacerView(finalDateOfRacersCircles)).thenReturn(tableOfResultCircle);

        assertThat(statisticAnalyzer.provideAnalysis(pathStartFile, pathEndFile, pathAbbreviations), is(tableOfResultCircle));

        verify(validatorMock, times(3)).validationFilePath(any(),any());
        verify(readerDataFilesMock, times(3)).getReadDateOfFiles(any());
        verify(raceDataParserMock).parseRaceData(any(), any(), any());
        verify(racerViewProviderMock).provideRacerView(any());
    }

    @Test
    void provideAnalysisShouldBeThrowExceptionWhenPathIsNotExist() {
        String pathStartFileNotExist = "files/notexistfile.log";
        String pathEndFile = "files/end.log";
        String pathAbbreviations = "files/abbreviations.txt";

        doThrow(new IllegalArgumentException("Path of start.log is not corrected!")).when(validatorMock).validationFilePath(pathStartFileNotExist, "Path of start.log is not corrected!");

        assertThrows(IllegalArgumentException.class, () -> statisticAnalyzer.provideAnalysis(pathStartFileNotExist, pathEndFile, pathAbbreviations));

        verifyNoMoreInteractions(readerDataFilesMock, raceDataParserMock, racerViewProviderMock);
    }
}
