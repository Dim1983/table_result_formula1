package com.loctionov.racer.saver;

import java.time.LocalTime;
import java.util.Objects;

public class Racer {
    private final String commandAbbreviation;
    private final LocalTime startTimeOfCircle;
    private final LocalTime endTimeOfCircle;
    private final String racerNamesAndCommandNames;

    private Racer(RacerBuilder builder) {
        this.commandAbbreviation = builder.commandAbbreviation;
        this.startTimeOfCircle = builder.startTimeOfCircle;
        this.endTimeOfCircle = builder.endTimeOfCircle;
        this.racerNamesAndCommandNames = builder.racerNamesAndCommandNames;
    }

    public static RacerBuilder builder() {
        return new RacerBuilder();
    }

    public String getCommandAbbreviation() {
        return commandAbbreviation;
    }

    public LocalTime getStartTimeOfCircle() {
        return startTimeOfCircle;
    }

    public LocalTime getEndTimeOfCircle() {
        return endTimeOfCircle;
    }

    public String getRacerNamesAndCommandNames() {
        return racerNamesAndCommandNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Racer racer = (Racer) o;
        return Objects.equals(commandAbbreviation, racer.commandAbbreviation) &&
                Objects.equals(startTimeOfCircle, racer.startTimeOfCircle) &&
                Objects.equals(endTimeOfCircle, racer.endTimeOfCircle) &&
                Objects.equals(racerNamesAndCommandNames, racer.racerNamesAndCommandNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandAbbreviation, startTimeOfCircle, endTimeOfCircle, racerNamesAndCommandNames);
    }

    @Override
    public String toString() {
        return "Racer{" +
                "commandAbbreviation='" + commandAbbreviation + '\'' +
                ", startTimeOfCircle='" + startTimeOfCircle + '\'' +
                ", endTimeOfCircle='" + endTimeOfCircle + '\'' +
                ", racerNamesAndCommandNames='" + racerNamesAndCommandNames + '\'' +
                '}';
    }

    public static class RacerBuilder {
        private String commandAbbreviation;
        private LocalTime startTimeOfCircle;
        private LocalTime endTimeOfCircle;
        private String racerNamesAndCommandNames;

        private RacerBuilder() {
        }

        public RacerBuilder withCommandAbbreviation(String commandAbbreviation) {
            this.commandAbbreviation = commandAbbreviation;
            return this;
        }

        public RacerBuilder withStartTimeOfCircle(LocalTime startTimeOfCircle) {
            this.startTimeOfCircle = startTimeOfCircle;
            return this;
        }

        public RacerBuilder withEndTimeOfCircle(LocalTime endTimeOfCircle) {
            this.endTimeOfCircle = endTimeOfCircle;
            return this;
        }

        public RacerBuilder withRacerNamesAndCommandNames(String racerNamesAndCommandNames) {
            this.racerNamesAndCommandNames = racerNamesAndCommandNames;
            return this;
        }

        public Racer build() {
            return new Racer(this);
        }
    }
}
