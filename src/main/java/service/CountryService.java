package service;

import dao.CountryDaoInterface;
import model.Country;

/**
 * Created by vitaliy on 29.10.15.
 */
public class CountryService implements ICountryService {

    private CountryDaoInterface countryDaoInterface;

    public CountryService(CountryDaoInterface countryDaoInterface){
        this.countryDaoInterface=countryDaoInterface;
    }
    @Override
    public void addCountry(Country country) {
        countryDaoInterface.addCountry(country);
    }

    @Override
    public Country getLastCountry() {
        return countryDaoInterface.getLastCountry();
    }
}
