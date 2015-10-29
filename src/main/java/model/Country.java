package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaliy on 26.10.15.
 */
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_country;
    @Column
    private String countryName;
    @Column
    private String countryISOCode;
    @ManyToOne
    @JoinColumn(name="id_response",referencedColumnName = "id_response")
    private ResponseFromServer responseFromServer;
   //  @ElementCollection
    @OneToMany(mappedBy = "country",targetEntity = City.class)
    private List<City> cities=new ArrayList<>();



    public Country(){
    }

    public Country(String countryName, String countryISOCode,ResponseFromServer responseFromServer) {
        this.countryName = countryName;
        this.countryISOCode = countryISOCode;
        this.responseFromServer=responseFromServer;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryISOCode() {
        return countryISOCode;
    }

    public void setCountryISOCode(String countryISOCode) {
        this.countryISOCode = countryISOCode;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public int getId_country() {
        return id_country;
    }

    public void setId_country(int id_country) {
        this.id_country = id_country;
    }

    public ResponseFromServer getResponse() {
        return responseFromServer;
    }

    public void setResponse(ResponseFromServer response) {
        this.responseFromServer = response;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cities=" + cities +
                '}';
    }
}
