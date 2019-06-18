package nntu.irit.asu.model;

import javax.persistence.*;

@Entity
@Table(name = "Airplanes")
public class Airplanes {
    @Id
    @Column(name = "idAirplanes")
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int idAirplanes;

    @Column(name = "Departureairport")
    private int departureairport;

    @Column(name = "Arrivalairport")
    private int arrivalairport;

    @Column(name = "Airplanename")
    private String airplanename;

    public int getIdAirplanes() {
        return idAirplanes;
    }

    public void setIdAirplanes(int idAirplanes) {
        this.idAirplanes = idAirplanes;
    }

    public int getDepartureairport() {
        return departureairport;
    }

    public void setDepartureairport(int departureairport) {
        this.departureairport = departureairport;
    }

    public int getArrivalairport() {
        return arrivalairport;
    }

    public void setArrivalairport(int arrivalairport) {
        this.arrivalairport = arrivalairport;
    }

    public String getAirplanename() {
        return airplanename;
    }

    public void setAirplanename(String airplanename) {
        this.airplanename = airplanename;
    }

    @Override
    public String toString() {
        return "Airplanes{" +
                "idAirplanes=" + idAirplanes +
                ", departureairport=" + departureairport +
                ", arrivalairport=" + arrivalairport +
                ", airplanename='" + airplanename + '\'' +
                '}';
    }
}
