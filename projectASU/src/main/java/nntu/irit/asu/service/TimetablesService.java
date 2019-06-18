package nntu.irit.asu.service;

import nntu.irit.asu.model.Timetables;

import java.util.List;

public interface TimetablesService {
    public void addTimetables(Timetables timetables);

    public void updateTimetables(Timetables timetables);

    public void removeTimetables(int idTimetables);

    public Timetables getTimetablesById(int idTimetables);

    public List<Timetables> listTimetables();
}
