package nntu.irit.asu.service;

import nntu.irit.asu.model.Crews;

import java.util.List;

public interface CrewsService {

    public void addCrews(Crews crews);

    public void updateCrews(Crews crews);

    public void removeCrews(int idCrews);

    public Crews getCrewsById(int idCrews);

    public List<Crews> listCrews();
}
