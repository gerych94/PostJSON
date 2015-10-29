package dao;

import model.Country;
import org.hibernate.Session;
import utils.ConnectionHibernate;

import java.util.List;

/**
 * Created by vitaliy on 28.10.15.
 */
public class CountryDaoHibernate implements CountryDaoInterface {


    private Session session;

    public CountryDaoHibernate(){
        session= ConnectionHibernate.getSessionFactory().openSession();
    }

    @Override
    public void addCountry(Country country) {
        session.beginTransaction();
        session.save(country);
        session.getTransaction().commit();
    }

    @Override
    public Country getLastCountry() {
        session.beginTransaction();
        List<Country> countryList=session.createCriteria(Country.class).list();
        session.getTransaction().commit();
        return countryList.get(countryList.size()-1);
    }
}
