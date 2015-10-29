package service;

import dao.CityDaoInterface;
import model.City;

/**
 * Created by vitaliy on 29.10.15.
 */
public class CityService implements ICityService {

    private CityDaoInterface cityDaoInterface;

    public CityService(CityDaoInterface cityDaoInterface){
        this.cityDaoInterface=cityDaoInterface;
    }



    @Override
    public void addCity(City city) {
        cityDaoInterface.add(city);
    }
}
