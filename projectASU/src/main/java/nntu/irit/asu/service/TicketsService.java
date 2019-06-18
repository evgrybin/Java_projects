package nntu.irit.asu.service;

import nntu.irit.asu.model.Tickets;

import java.util.List;

public interface TicketsService {
    public void addTickets(Tickets tickets);

    public void updateTickets(Tickets tickets);

    public void removeTickets(int idTickets);

    public Tickets getTicketsById(int idTickets);

    public List<Tickets> listTickets();
}
