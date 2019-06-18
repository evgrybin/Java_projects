package nntu.irit.asu.model;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Tickets {
    @Id
    @Column(name = "idTickets")
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int idTickets;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "document")
    private String document;

    @Column(name = "Passportseries")
    private int passport_series;

    @Column(name = "Passportnumber")
    private int passport_number;

    @Column(name = "Flightnumber")
    private String flight_number;


    /*@Column(name = "Seatid")
    private int seat_id;*/

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn(name="idSeats")
    private Seats seat_id;



    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private String date;

    @Column(name = "Price")
    private double price;


    public int getIdTickets() {
        return idTickets;
    }

    public void setIdTickets(int idTickets) {
        this.idTickets = idTickets;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getPassport_series() {
        return passport_series;
    }

    public void setPassport_series(int passport_series) {
        this.passport_series = passport_series;
    }

    public int getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(int passport_number) {
        this.passport_number = passport_number;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }




    public Seats getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Seats seat_id) {
        this.seat_id = seat_id;
    }



    /*public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "idTickets=" + idTickets +
                ", fullName='" + fullName + '\'' +
                ", document='" + document + '\'' +
                ", passport_series=" + passport_series +
                ", passport_number=" + passport_number +
                ", flight_number='" + flight_number + '\'' +
                ", seat_id=" + seat_id +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                '}';
    }
}


