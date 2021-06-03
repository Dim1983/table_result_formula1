package racer.viewer;

import com.loctionov.racer.saver.Racer;
import com.loctionov.racer.viewer.RacerViewProviderImpl;
import com.loctionov.racer.viewer.RacerViewProvider;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacerViewProviderImplTest {
    private final RacerViewProvider racerViewProvider = new RacerViewProviderImpl();

    @Test
    void provideRacerViewShouldBeReturnString() {
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

        String expected = "1 Sebastian Vettel | FERRARI  | 01:04.415\n" +
                "2 Daniel Ricciardo | RED BULL RACING TAG HEUER  | 01:12.013\n" +
                "3 Valtteri Bottas | MERCEDES  | 01:12.434\n" +
                "4 Lewis Hamilton | MERCEDES  | 01:12.460\n" +
                "5 Stoffel Vandoorne | MCLAREN RENAULT  | 01:12.463\n" +
                "6 Kimi Raikkonen | FERRARI  | 01:12.639\n" +
                "7 Fernando Alonso | MCLAREN RENAULT  | 01:12.657\n" +
                "8 Sergey Sirotkin | WILLIAMS MERCEDES  | 01:12.706\n" +
                "9 Charles Leclerc | SAUBER FERRARI  | 01:12.829\n" +
                "10 Sergio Perez | FORCE INDIA MERCEDES  | 01:12.848\n" +
                "11 Romain Grosjean | HAAS FERRARI  | 01:12.930\n" +
                "12 Pierre Gasly | SCUDERIA TORO ROSSO HONDA  | 01:12.941\n" +
                "13 Carlos Sainz | RENAULT  | 01:12.950\n" +
                "14 Esteban Ocon | FORCE INDIA MERCEDES  | 01:13.028\n" +
                "15 Nico Hulkenberg | RENAULT  | 01:13.065\n" +
                "-----------------------------------------------------------\n" +
                "16 Brendon Hartley | SCUDERIA TORO ROSSO HONDA  | 01:13.179\n" +
                "17 Marcus Ericsson | SAUBER FERRARI  | 01:13.265\n" +
                "18 Lance Stroll | WILLIAMS MERCEDES  | 01:13.323\n" +
                "19 Kevin Magnussen | HAAS FERRARI  | 01:13.393\n";

        assertEquals(expected, racerViewProvider.provideRacerView(finalDateOfRacersCircles));
    }

    @Test
    void provideRacerViewShouldBeReturnStringWhenWeHaveTwoSameObjects() {
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

            add(Racer.builder()
                    .withCommandAbbreviation("KRF")
                    .withStartTimeOfCircle(LocalTime.parse("12:03:01.250"))
                    .withEndTimeOfCircle(LocalTime.parse("12:04:13.889"))
                    .withRacerNamesAndCommandNames("Kimi Raikkonen | FERRARI ")
                    .build());

        }};

        String expected = "1 Sebastian Vettel | FERRARI  | 01:04.415\n" +
                "2 Daniel Ricciardo | RED BULL RACING TAG HEUER  | 01:12.013\n" +
                "3 Valtteri Bottas | MERCEDES  | 01:12.434\n" +
                "4 Lewis Hamilton | MERCEDES  | 01:12.460\n" +
                "5 Stoffel Vandoorne | MCLAREN RENAULT  | 01:12.463\n" +
                "6 Kimi Raikkonen | FERRARI  | 01:12.639\n" +
                "7 Fernando Alonso | MCLAREN RENAULT  | 01:12.657\n" +
                "8 Sergey Sirotkin | WILLIAMS MERCEDES  | 01:12.706\n" +
                "9 Charles Leclerc | SAUBER FERRARI  | 01:12.829\n" +
                "10 Sergio Perez | FORCE INDIA MERCEDES  | 01:12.848\n" +
                "11 Romain Grosjean | HAAS FERRARI  | 01:12.930\n" +
                "12 Pierre Gasly | SCUDERIA TORO ROSSO HONDA  | 01:12.941\n" +
                "13 Carlos Sainz | RENAULT  | 01:12.950\n" +
                "14 Esteban Ocon | FORCE INDIA MERCEDES  | 01:13.028\n" +
                "15 Nico Hulkenberg | RENAULT  | 01:13.065\n" +
                "-----------------------------------------------------------\n" +
                "16 Brendon Hartley | SCUDERIA TORO ROSSO HONDA  | 01:13.179\n" +
                "17 Marcus Ericsson | SAUBER FERRARI  | 01:13.265\n" +
                "18 Lance Stroll | WILLIAMS MERCEDES  | 01:13.323\n" +
                "19 Kevin Magnussen | HAAS FERRARI  | 01:13.393\n";

        assertEquals(expected, racerViewProvider.provideRacerView(finalDateOfRacersCircles));
    }
}
