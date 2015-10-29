package dao;

import model.Country;

/**
 * Created by vitaliy on 28.10.15.
 */
public interface CountryDaoInterface {

    void addCountry(Country country);

    Country getLastCountry();

}
