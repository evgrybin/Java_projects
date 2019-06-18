package nntu.irit.asu.dao;

import nntu.irit.asu.model.Airports;

import java.util.List;

public interface AirportsDao {
    public void addAirports(Airports airports);

    public void updateAirports(Airports airports);

    public void removeAirports(int idAirports);

    public Airports getAirportsById(int idAirports);

    public List<Airports> listAirports();
}
