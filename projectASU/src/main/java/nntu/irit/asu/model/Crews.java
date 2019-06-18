package nntu.irit.asu.model;

import javax.persistence.*;

@Entity
@Table(name = "crews")
public class Crews {
    @Id
    @Column(name = "idCrews")
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int idCrews;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Age")
    private int age;

    @Column(name = "Country")
    private String country;

    @Column(name = "Sity")
    private String sity;

    @Column(name = "Position")
    private String position;

    public int getIdCrews() {
        return idCrews;
    }

    public void setIdCrews(int idCrews) {
        this.idCrews = idCrews;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Crews{" +
                "idCrews=" + idCrews +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", sity='" + sity + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
