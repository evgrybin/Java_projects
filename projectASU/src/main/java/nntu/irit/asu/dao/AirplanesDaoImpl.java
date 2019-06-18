package nntu.irit.asu.dao;

import nntu.irit.asu.model.Airplanes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirplanesDaoImpl implements AirplanesDao {
    private static final Logger logger = LoggerFactory.getLogger(AirplanesDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAirplanes(Airplanes airplanes) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(airplanes);
        logger.info("Tickets successfully saved. Tickets details: " + airplanes);
    }

    @Override
    public void updateAirplanes(Airplanes airplanes) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(airplanes);
        logger.info("Tickets successfully update. Tickets details: " + airplanes);

    }

    @Override
    public void removeAirplanes(int idAirplanes) {
        Session session = this.sessionFactory.getCurrentSession();
        Airplanes airplanes = (Airplanes) session.load(Airplanes.class, new Integer(idAirplanes));
        if(airplanes!=null){
            session.delete(airplanes);
        }
        logger.info("Tickets successfully removed. Tickets details: " + airplanes);
    }

    @Override
    public Airplanes getAirplanesById(int idAirplanes) {
        Session session = this.sessionFactory.getCurrentSession();
        Airplanes airplanes = (Airplanes) session.load(Airplanes.class, new Integer(idAirplanes));
        logger.info("Tickets successfully loaded. Tickets details: " + airplanes);
        return airplanes;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Airplanes> listAirplanes() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Airplanes> airplanesList = session.createQuery("from Airplanes").list();

        for(Airplanes airplanes: airplanesList){
            logger.info("Tickets list :" + airplanes);
        }

        return airplanesList;
    }
}