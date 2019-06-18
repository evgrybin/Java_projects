package nntu.irit.asu.dao;

import nntu.irit.asu.model.Seats;
import java.util.List;


public interface SeatsDao {
    public void addSeats(Seats seats);

    public void updateSeats(Seats seats);

    public void removeSeats(int idSeats);

    public Seats getSeatsById(int idSeats);

    public List<Seats> listSeats();

}
