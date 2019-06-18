package nntu.irit.asu.dao;

import nntu.irit.asu.model.Tickets;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketsDaoImpl implements TicketsDao {
    private static final Logger logger = LoggerFactory.getLogger(TicketsDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTickets(Tickets tickets) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(tickets);
        logger.info("Tickets successfully saved. Tickets details: " + tickets);
    }

    @Override
    public void updateTickets(Tickets tickets) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(tickets);
        logger.info("Tickets successfully update. Tickets details: " + tickets);

    }

    @Override
    public void removeTickets(int idTickets) {
        Session session = this.sessionFactory.getCurrentSession();
        Tickets tickets = (Tickets) session.load(Tickets.class, new Integer(idTickets));
        if(tickets!=null){
            session.delete(tickets);
        }
        logger.info("Tickets successfully removed. Tickets details: " + tickets);
    }

    @Override
    public Tickets getTicketsById(int idTickets) {
        Session session = this.sessionFactory.getCurrentSession();
        Tickets tickets = (Tickets) session.load(Tickets.class, new Integer(idTickets));
        logger.info("Tickets successfully loaded. Tickets details: " + tickets);
        return tickets;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Tickets> listTickets() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Tickets> ticketsList = session.createQuery("from Tickets").list();

        for(Tickets tickets: ticketsList){
            logger.info("Tickets list :" + tickets);
        }

        return ticketsList;
    }
}
