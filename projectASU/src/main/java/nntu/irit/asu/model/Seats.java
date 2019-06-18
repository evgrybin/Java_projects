package nntu.irit.asu.model;
import javax.persistence.*;

@Entity
@Table(name = "seats")
public class Seats {
    @Id
    @Column(name = "idSeats")
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int idSeats;

    @Column(name = "Row")
    private int row;

    @Column(name = "Number")
    private int number;

    @Column(name = "Type")
    private String type;

    @Column(name = "Airplaneid")
    private int airplane_id;


    public int getIdSeats() {
        return idSeats;
    }

    public void setIdSeats(int idSeats) {
        this.idSeats = idSeats;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(int airplane_id) {
        this.airplane_id = airplane_id;
    }

    @Override
    public String toString() {
        return "Seats{" +
                "idSeats=" + idSeats +
                ", row=" + row +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", airplane_id=" + airplane_id +
                '}';
    }
}
