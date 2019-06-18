package nntu.irit.asu.dao;

import nntu.irit.asu.model.Airports;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirportsDaoImpl implements AirportsDao{
    private static final Logger logger = LoggerFactory.getLogger(AirportsDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAirports(Airports airports) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(airports);
        logger.info("Tickets successfully saved. Tickets details: " + airports);
    }

    @Override
    public void updateAirports(Airports airports) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(airports);
        logger.info("Tickets successfully update. Tickets details: " + airports);

    }

    @Override
    public void removeAirports(int idAirports) {
        Session session = this.sessionFactory.getCurrentSession();
        Airports airports = (Airports) session.load(Airports.class, new Integer(idAirports));
        if(airports!=null){
            session.delete(airports);
        }
        logger.info("Tickets successfully removed. Tickets details: " + airports);
    }

    @Override
    public Airports getAirportsById(int idAirports) {
        Session session = this.sessionFactory.getCurrentSession();
        Airports airports = (Airports) session.load(Airports.class, new Integer(idAirports));
        logger.info("Tickets successfully loaded. Tickets details: " + airports);
        return airports;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Airports> listAirports() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Airports> airportsList = session.createQuery("from Airports").list();

        for(Airports airports: airportsList){
            logger.info("Tickets list :" + airports);
        }

        return airportsList;
    }
}
