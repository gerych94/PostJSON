package model;


import javax.persistence.*;


/**
 * Created by vitaliy on 26.10.15.
 */
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_city;
    @Column
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "id_country",referencedColumnName = "id_country")
    private Country country;

    public City(){
    }

    public City(String cityName,Country country) {
        this.cityName = cityName;
        this.country=country;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                '}';
    }


}
