package dao;

import model.City;
import org.hibernate.Session;
import utils.ConnectionHibernate;

/**
 * Created by vitaliy on 28.10.15.
 */
public class CityDaoHibernate implements CityDaoInterface{


    private Session session;

    public CityDaoHibernate(){
        session= ConnectionHibernate.getSessionFactory().openSession();
    }


    @Override
    public void add(City city) {
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
    }
}
