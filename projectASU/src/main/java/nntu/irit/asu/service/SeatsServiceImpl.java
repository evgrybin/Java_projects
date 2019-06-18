package nntu.irit.asu.service;

import nntu.irit.asu.dao.SeatsDao;
import nntu.irit.asu.model.Seats;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class SeatsServiceImpl implements SeatsService {
    private SeatsDao seatsDao;

    public void setSeatsDao(SeatsDao seatsDao) {
        this.seatsDao = seatsDao;
    }

    @Override
    @Transactional
    public void addSeats(Seats seats) {
        this.seatsDao.addSeats(seats);
    }

    @Override
    @Transactional
    public void updateSeats(Seats seats) {
        this.seatsDao.updateSeats(seats);
    }

    @Override
    @Transactional
    public void removeSeats(int idSeats) {
        this.seatsDao.removeSeats(idSeats);
    }

    @Override
    @Transactional
    public Seats getSeatsById(int idSeats) {
        return this.seatsDao.getSeatsById(idSeats);
    }

    @Override
    @Transactional
    public List<Seats> listSeats() {
        return this.seatsDao.listSeats();
    }
}

