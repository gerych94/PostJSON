package service;

import dao.ResponseDaoInterface;
import model.ResponseFromServer;

/**
 * Created by vitaliy on 27.10.15.
 */
public class ResponseService implements IResponseService {
    private ResponseDaoInterface daoInterface;


    public ResponseService(ResponseDaoInterface daoInterface){
        this.daoInterface=daoInterface;
    }


    @Override
    public void addData(ResponseFromServer responseFromServer) {
        daoInterface.add(responseFromServer);
    }

    @Override
    public ResponseFromServer getLastResponse() {
        return daoInterface.getLastResponse();
    }
}
