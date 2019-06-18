package nntu.irit.asu.dao;

import nntu.irit.asu.model.Tickets;

import java.util.List;

public interface TicketsDao {

    public void addTickets(Tickets tickets);

    public void updateTickets(Tickets tickets);

    public void removeTickets(int idTickets);

    public Tickets getTicketsById(int idTickets);

    public List<Tickets> listTickets();
}
