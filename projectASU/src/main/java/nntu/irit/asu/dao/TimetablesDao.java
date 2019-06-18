package nntu.irit.asu.dao;

import nntu.irit.asu.model.Timetables;

import java.util.List;

public interface TimetablesDao {
    public void addTimetables(Timetables timetables);

    public void updateTimetables(Timetables timetables);

    public void removeTimetables(int idTimetables);

    public Timetables getTimetablesById(int idTimetables);

    public List<Timetables> listTimetables();
}
