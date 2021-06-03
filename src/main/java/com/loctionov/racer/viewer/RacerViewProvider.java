package com.loctionov.racer.viewer;

import com.loctionov.racer.saver.Racer;

import java.util.List;

public interface RacerViewProvider {
    String provideRacerView(List<Racer> resultDateCommandsOfCircles);
}
