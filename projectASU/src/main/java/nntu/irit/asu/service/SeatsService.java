package nntu.irit.asu.service;

import nntu.irit.asu.model.Seats;

import java.util.List;

public interface SeatsService {
    public void addSeats(Seats seats);

    public void updateSeats(Seats seats);

    public void removeSeats(int idSeats);

    public Seats getSeatsById(int idSeats);

    public List<Seats> listSeats();
}
