package nntu.irit.asu.model;

import javax.persistence.*;

@Entity
@Table(name = "airports")
public class Airports {
    @Id
    @Column(name = "idAirports")
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int idAirports;

    @Column(name = "Airportname")
    private String airportname;

    @Column(name = "Country")
    private String country;

    @Column(name = "Sity")
    private String sity;

    public int getIdAirports() {
        return idAirports;
    }

    public void setIdAirports(int idAirports) {
        this.idAirports = idAirports;
    }

    public String getAirportname() {
        return airportname;
    }

    public void setAirportname(String airportname) {
        this.airportname = airportname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }

    @Override
    public String toString() {
        return "Airports{" +
                "idAirports=" + idAirports +
                ", airportname='" + airportname + '\'' +
                ", country='" + country + '\'' +
                ", sity='" + sity + '\'' +
                '}';
    }
}
