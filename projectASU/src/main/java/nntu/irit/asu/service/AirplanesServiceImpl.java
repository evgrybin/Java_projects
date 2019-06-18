package nntu.irit.asu.service;

import nntu.irit.asu.dao.AirplanesDao;
import nntu.irit.asu.model.Airplanes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AirplanesServiceImpl implements AirplanesService {
    private AirplanesDao airplanesDao;

    public void setAirplanesDao(AirplanesDao airplanesDao) {
        this.airplanesDao = airplanesDao;
    }

    @Override
    @Transactional
    public void addAirplanes(Airplanes airplanes) {
        this.airplanesDao.addAirplanes(airplanes);
    }

    @Override
    @Transactional
    public void updateAirplanes(Airplanes airplanes) {
        this.airplanesDao.updateAirplanes(airplanes);
    }

    @Override
    @Transactional
    public void removeAirplanes(int idAirplanes) {
        this.airplanesDao.removeAirplanes(idAirplanes);
    }

    @Override
    @Transactional
    public Airplanes getAirplanesById(int idAirplanes) {
        return this.airplanesDao.getAirplanesById(idAirplanes);
    }

    @Override
    @Transactional
    public List<Airplanes> listAirplanes() {
        return this.airplanesDao.listAirplanes();
    }
}
