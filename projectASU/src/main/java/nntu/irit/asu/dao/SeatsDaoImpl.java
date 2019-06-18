package nntu.irit.asu.dao;

import nntu.irit.asu.model.Seats;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatsDaoImpl implements SeatsDao {
    private static final Logger logger = LoggerFactory.getLogger(SeatsDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSeats(Seats seats) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(seats);
        logger.info("Tickets successfully saved. Tickets details: " + seats);
    }

    @Override
    public void updateSeats(Seats seats) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(seats);
        logger.info("Tickets successfully update. Tickets details: " + seats);

    }

    @Override
    public void removeSeats(int idSeats) {
        Session session = this.sessionFactory.getCurrentSession();
        Seats seats = (Seats) session.load(Seats.class, new Integer(idSeats));
        if(seats!=null){
            session.delete(seats);
        }
        logger.info("Tickets successfully removed. Tickets details: " + seats);
    }

    @Override
    public Seats getSeatsById(int idSeats) {
        Session session = this.sessionFactory.getCurrentSession();
        Seats seats = (Seats) session.load(Seats.class, new Integer(idSeats));
        logger.info("Tickets successfully loaded. Tickets details: " + seats);
        return seats;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Seats> listSeats() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Seats> seatsList = session.createQuery("from Seats").list();

        for(Seats seats: seatsList){
            logger.info("Tickets list :" + seats);
        }

        return seatsList;
    }

}
