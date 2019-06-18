package nntu.irit.asu.service;

import nntu.irit.asu.dao.CrewsDao;
import nntu.irit.asu.model.Crews;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CrewsServiceImpl implements CrewsService {
    private CrewsDao crewsDao;

    public void setCrewsDao(CrewsDao crewsDao) {
        this.crewsDao = crewsDao;
    }

    @Override
    @Transactional
    public void addCrews(Crews crews) {
        this.crewsDao.addCrews(crews);
    }

    @Override
    @Transactional
    public void updateCrews(Crews crews) {
        this.crewsDao.updateCrews(crews);
    }

    @Override
    @Transactional
    public void removeCrews(int idCrews) {
        this.crewsDao.removeCrews(idCrews);
    }

    @Override
    @Transactional
    public Crews getCrewsById(int idCrews) {
        return this.crewsDao.getCrewsById(idCrews);
    }

    @Override
    @Transactional
    public List<Crews> listCrews() {
        return this.crewsDao.listCrews();
    }
}
