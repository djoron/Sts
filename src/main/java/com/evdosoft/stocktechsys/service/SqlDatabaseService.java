package com.evdosoft.stocktechsys.service;

public interface SqlDatabaseService {

    boolean createSqlDb() throws Exception;
    boolean checkExistSqlDb() throws Exception;
    
}