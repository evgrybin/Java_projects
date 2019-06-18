package nntu.irit.asu.service;

import nntu.irit.asu.model.Airplanes;

import java.util.List;

public interface AirplanesService {
    public void addAirplanes(Airplanes airplanes);

    public void updateAirplanes(Airplanes airplanes);

    public void removeAirplanes(int idAirplanes);

    public Airplanes getAirplanesById(int idAirplanes);

    public List<Airplanes> listAirplanes();
}
