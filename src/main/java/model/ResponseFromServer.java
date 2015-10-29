package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaliy on 24.10.15.
 */
@Entity
@Table(name = "response")
public class ResponseFromServer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_response;
    @Column
    private String type;
    @Column
    private long time;
    @Column
    private String echo;
    //  @ElementCollection
    @OneToMany(mappedBy = "responseFromServer")
    private List<Country> countries=new ArrayList<>();

    public ResponseFromServer(){
    }

    public ResponseFromServer(String type, long time, String echo) {
        this.type = type;
        this.time = time;
        this.echo = echo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }

    public int getId_response() {
        return id_response;
    }

    public void setId_response(int id_response) {
        this.id_response = id_response;
    }

    @Override
    public String toString() {
        return "ResponseFromServer{" +
                "type='" + type + '\'' +
                ", time=" + time +
                ", countries=" + countries +
                ", echo='" + echo + '\'' +
                '}';
    }

}
