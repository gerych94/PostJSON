package dao;

import model.City;
import model.Country;
import model.ResponseFromServer;
import org.hibernate.Session;
import service.ICityService;
import service.ICountryService;
import utils.ConnectionHibernate;

import java.util.List;

/**
 * Created by vitaliy on 28.10.15.
 */
public class ResponseDaoHibernate implements ResponseDaoInterface{


    private Session session;
    private ICityService cityService;
    private ICountryService countryService;

    public ResponseDaoHibernate(ICityService cityService,ICountryService countryService){
        session= ConnectionHibernate.getSessionFactory().openSession();
        this.cityService=cityService;
        this.countryService=countryService;
    }


    @Override
    public void add(ResponseFromServer responseFromServer) {
        session.beginTransaction();
        session.save(responseFromServer);
        session.getTransaction().commit();
        ResponseFromServer lastResponse=getLastResponse();
        List<Country> countryList=lastResponse.getCountries();
        for (int i = 0; i <countryList.size() ; i++) {
            countryList.get(i).setResponse(responseFromServer);
            countryService.addCountry(countryList.get(i));
            List<City> cityList=countryService.getLastCountry().getCities();
            for (int j = 0; j <cityList.size() ; j++) {
                cityList.get(j).setCountry(countryService.getLastCountry());
                cityService.addCity(cityList.get(j));
            }
        }
    }

    @Override
    public ResponseFromServer getLastResponse() {
        session.beginTransaction();
        List<ResponseFromServer> list=session.createCriteria(ResponseFromServer.class).list();
        session.getTransaction().commit();
        return list.get(list.size()-1);
    }
}
