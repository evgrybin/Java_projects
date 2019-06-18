package nntu.irit.asu.service;

import nntu.irit.asu.dao.TimetablesDao;
import nntu.irit.asu.model.Timetables;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TimetablesServiceImpl implements TimetablesService {
    private TimetablesDao timetablesDao;

    public void setTimetablesDao(TimetablesDao timetablesDao) {
        this.timetablesDao = timetablesDao;
    }

    @Override
    @Transactional
    public void addTimetables(Timetables timetables) {
        this.timetablesDao.addTimetables(timetables);
    }

    @Override
    @Transactional
    public void updateTimetables(Timetables timetables) {
        this.timetablesDao.updateTimetables(timetables);
    }

    @Override
    @Transactional
    public void removeTimetables(int idTimetables) {
        this.timetablesDao.removeTimetables(idTimetables);
    }

    @Override
    @Transactional
    public Timetables getTimetablesById(int idTimetables) {
        return this.timetablesDao.getTimetablesById(idTimetables);
    }

    @Override
    @Transactional
    public List<Timetables> listTimetables() {
        return this.timetablesDao.listTimetables();
    }
}
