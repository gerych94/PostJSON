package service;

import model.Country;

/**
 * Created by vitaliy on 29.10.15.
 */
public interface ICountryService {


    void addCountry(Country country);

    Country getLastCountry();

}
