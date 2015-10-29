package dao;

import model.ResponseFromServer;

/**
 * Created by vitaliy on 27.10.15.
 */
public interface ResponseDaoInterface {

    void add(ResponseFromServer responseFromServer);

    ResponseFromServer getLastResponse();

}
