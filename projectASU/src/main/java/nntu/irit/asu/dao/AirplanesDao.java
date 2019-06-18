package nntu.irit.asu.dao;

import nntu.irit.asu.model.Airplanes;

import java.util.List;


public interface AirplanesDao {
    public void addAirplanes(Airplanes airplanes);

    public void updateAirplanes(Airplanes airplanes);

    public void removeAirplanes(int idAirplanes);

    public Airplanes getAirplanesById(int idAirplanes);

    public List<Airplanes> listAirplanes();
}
