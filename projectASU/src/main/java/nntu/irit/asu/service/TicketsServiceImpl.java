package nntu.irit.asu.service;

import nntu.irit.asu.dao.TicketsDao;
import nntu.irit.asu.model.Tickets;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketsServiceImpl implements TicketsService {
    private TicketsDao ticketsDao;

    public void setTicketsDao(TicketsDao ticketsDao) {
        this.ticketsDao = ticketsDao;
    }

    @Override
    @Transactional
    public void addTickets(Tickets tickets) {
        this.ticketsDao.addTickets(tickets);
    }

    @Override
    @Transactional
    public void updateTickets(Tickets tickets) {
        this.ticketsDao.updateTickets(tickets);
    }

    @Override
    @Transactional
    public void removeTickets(int idTickets) {
        this.ticketsDao.removeTickets(idTickets);
    }

    @Override
    @Transactional
    public Tickets getTicketsById(int idTickets) {
        return this.ticketsDao.getTicketsById(idTickets);
    }

    @Override
    @Transactional
    public List<Tickets> listTickets() {
        return this.ticketsDao.listTickets();
    }
}
