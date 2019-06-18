package nntu.irit.asu.service;

import nntu.irit.asu.dao.AirportsDao;
import nntu.irit.asu.model.Airports;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AirportsServiceImpl implements AirportsService {
    private AirportsDao airportsDao;

    public void setAirportsDao(AirportsDao airportsDao) {
        this.airportsDao = airportsDao;
    }

    @Override
    @Transactional
    public void addAirports(Airports airports) {
        this.airportsDao.addAirports(airports);
    }

    @Override
    @Transactional
    public void updateAirports(Airports airports) {
        this.airportsDao.updateAirports(airports);
    }

    @Override
    @Transactional
    public void removeAirports(int idAirports) {
        this.airportsDao.removeAirports(idAirports);
    }

    @Override
    @Transactional
    public Airports getAirportsById(int idAirports) {
        return this.airportsDao.getAirportsById(idAirports);
    }

    @Override
    @Transactional
    public List<Airports> listAirports() {
        return this.airportsDao.listAirports();
    }
}
