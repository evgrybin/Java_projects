package nntu.irit.asu.model;

import javax.persistence.*;

@Entity
@Table(name = "timetables")
public class Timetables {
    @Id
    @Column(name = "idTimetables")
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int idTimetables;

    @Column(name = "Dateofdeparture")
    private String dateofdeparture;

    @Column(name = "Dateofarrival")
    private String dateofarrival;

    public int getIdTimetables() {
        return idTimetables;
    }

    public void setIdTimetables(int idTimetables) {
        this.idTimetables = idTimetables;
    }

    public String getDateofdeparture() {
        return dateofdeparture;
    }

    public void setDateofdeparture(String dateofdeparture) {
        this.dateofdeparture = dateofdeparture;
    }

    public String getDateofarrival() {
        return dateofarrival;
    }

    public void setDateofarrival(String dateofarrival) {
        this.dateofarrival = dateofarrival;
    }

    @Override
    public String toString() {
        return "Timetables{" +
                "idTimetables=" + idTimetables +
                ", dateofdeparture='" + dateofdeparture + '\'' +
                ", dateofarrival='" + dateofarrival + '\'' +
                '}';
    }
}
