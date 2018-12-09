package modules.general.model.db;


import modules.general.model.db.listener.ISqliteCallBack;

import java.util.ArrayList;


/**
 * Created by Net22 on 11/15/2017.
 */

public   abstract class SqliteCallBack implements ISqliteCallBack {


    @Override
    public void onDBDataListLoaded(ArrayList data, String localDbOperation) {

    }

    @Override
    public void onDBDataObjectLoaded(Object data, String localDbOperation) {

    }

    @Override
    public void onDBDataListLoaded(ArrayList data) {

    }

    @Override
    public void onDBDataObjectLoaded(Object data) {

    }
}
