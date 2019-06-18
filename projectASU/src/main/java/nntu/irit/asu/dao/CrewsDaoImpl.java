package nntu.irit.asu.dao;

import nntu.irit.asu.model.Crews;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrewsDaoImpl implements CrewsDao {
    private static final Logger logger = LoggerFactory.getLogger(TicketsDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCrews(Crews crews) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(crews);
        logger.info("Tickets successfully saved. Tickets details: " + crews);
    }

    @Override
    public void updateCrews(Crews crews) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(crews);
        logger.info("Tickets successfully update. Tickets details: " + crews);

    }

    @Override
    public void removeCrews(int idCrews) {
        Session session = this.sessionFactory.getCurrentSession();
        Crews crews = (Crews) session.load(Crews.class, new Integer(idCrews));
        if(crews!=null){
            session.delete(crews);
        }
        logger.info("Tickets successfully removed. Tickets details: " + crews);
    }

    @Override
    public Crews getCrewsById(int idCrews) {
        Session session = this.sessionFactory.getCurrentSession();
        Crews crews = (Crews) session.load(Crews.class, new Integer(idCrews));
        logger.info("Tickets successfully loaded. Tickets details: " + crews);
        return crews;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Crews> listCrews() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Crews> crewsList = session.createQuery("from Crews").list();

        for(Crews crews: crewsList){
            logger.info("Tickets list :" + crews);
        }

        return crewsList;
    }
}
