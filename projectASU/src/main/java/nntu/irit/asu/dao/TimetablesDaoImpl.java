package nntu.irit.asu.dao;

import nntu.irit.asu.model.Timetables;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TimetablesDaoImpl implements TimetablesDao {
    private static final Logger logger = LoggerFactory.getLogger(TicketsDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTimetables(Timetables timetables) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(timetables);
        logger.info("Tickets successfully saved. Tickets details: " + timetables);
    }

    @Override
    public void updateTimetables(Timetables timetables) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(timetables);
        logger.info("Tickets successfully update. Tickets details: " + timetables);

    }

    @Override
    public void removeTimetables(int idTimetables) {
        Session session = this.sessionFactory.getCurrentSession();
        Timetables timetables = (Timetables) session.load(Timetables.class, new Integer(idTimetables));
        if(timetables!=null){
            session.delete(timetables);
        }
        logger.info("Tickets successfully removed. Tickets details: " + timetables);
    }

    @Override
    public Timetables getTimetablesById(int idTimetables) {
        Session session = this.sessionFactory.getCurrentSession();
        Timetables timetables = (Timetables) session.load(Timetables.class, new Integer(idTimetables));
        logger.info("Tickets successfully loaded. Tickets details: " + timetables);
        return timetables;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Timetables> listTimetables() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Timetables> timetablesList = session.createQuery("from Timetables").list();

        for(Timetables timetables: timetablesList){
            logger.info("Tickets list :" + timetables);
        }

        return timetablesList;
    }
}
