package service;

import model.ResponseFromServer;

/**
 * Created by vitaliy on 27.10.15.
 */
public interface IResponseService {

    void addData(ResponseFromServer responseFromServer);

    ResponseFromServer getLastResponse();

}
