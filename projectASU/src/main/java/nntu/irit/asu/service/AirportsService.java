package nntu.irit.asu.service;

import nntu.irit.asu.model.Airports;

import java.util.List;

public interface AirportsService {
    public void addAirports(Airports airports);

    public void updateAirports(Airports airports);

    public void removeAirports(int idAirports);

    public Airports getAirportsById(int idAirports);

    public List<Airports> listAirports();
}
