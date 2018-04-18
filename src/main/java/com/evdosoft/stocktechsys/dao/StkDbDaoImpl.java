/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evdosoft.stocktechsys.dao;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.evdosoft.stocktechsys.Parameters;

/**
 *
 * @author atlantis
 */
@Repository
public class StkDbDaoImpl implements StkDbDao {

    @Autowired
    private Parameters parameters;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(StkDbDaoImpl.class);

    /**
     * execStatement Execute an Sql Statement.
     * 
     * @version 1.0
     * @author : dj
     * @param strsql
     * @return true if successful.
     * @throws java.sql.SQLException
     */

    @Override
    public Boolean execStatement(String strsql) throws SQLException {
	try {
	    jdbcTemplate.execute(strsql);
	    return true;
	} catch (DataAccessException e) {
	    logger.error("execStatement: returned an error on {}", strsql);
	    logger.error("{} : {}", e.getClass().getName(), e.getMessage());
	    return false;
	}
    }

    /**
     *
     * Create CompanyList Table to contain company info.
     * 
     * @version 1.0
     * @author : dj
     * @return true if successful.
     * @throws java.sql.SQLException
     */
    @Override
    public boolean createCompanyTables() throws SQLException {
	logger.info("createCompanyTable Company starting");
	String query = "CREATE TABLE COMPANY   (companyid INTEGER PRIMARY KEY," + 
		"  symbol             VARCHAR(10) NOT NULL, " + 
		"  companyname        VARCHAR(255) NOT NULL, " + 
		"  companyexchange    VARCHAR(80),  " + 
		"  industry           VARCHAR(255), " + 
		"  website            VARCHAR(255),  " + 
		"  description        VARCHAR(500), " + 
		"  ceo                VARCHAR(255),  " + 
		"  issuetype          VARCHAR(80), " + 
		"  sector             VARCHAR(80),  " + 		
		"  UNIQUE KEY (symbol, companyexchange )," + 
		"  FOREIGN KEY(symbol) REFERENCES symbol(symbol));              ";
		
	
	try {

	    if (execStatement(query) == true) {
		// logger.info("createCompanyTables created successfully");
	    } else {
		logger.error("createCompanyTable Company did not complete.");
	    }
	} catch (Exception e) {
	    logger.error("createCompanyTable Company did not complete.");
	    logger.error("{} : {}", e.getClass().getName(), e.getMessage());
	    return false;

	}
	return true;
    }

    /**
     *
     * Create SymbolList Table to contain Symbol info.
     * 
     * @version 1.0
     * @author : dj
     * @return true if successful.
     * @throws java.sql.SQLException
     */
    @Override
    public boolean createSymbolTable() throws SQLException {
	logger.info("createSymbolTable Symbol starting");
	jdbcTemplate.execute("DROP TABLE SYMBOL IF EXISTS");
	String query = "CREATE TABLE SYMBOL   (symbolID INTEGER PRIMARY KEY,   " + 
		"  SYMBOL             VARCHAR(10) NOT NULL, " + 
		"  NAME               VARCHAR(255) NOT NULL, " + 
		"  DATE               DATE, "    + 
		"  ISENABLED          BIT, "  + 
		"  TYPE               VARCHAR(4), " + 
		"  IEXID              INTEGER, " + 
		"  UNIQUE KEY (SYMBOL) );";
	try {

	    if (execStatement(query) == true) {
		logger.info("createCompanyTables created successfully");
	    } else {
		logger.error("createSymbolTable Symbol did not complete.");
	    }
	    return true;
	} catch (Exception e) {
	    logger.error("createSymbolTable Symbol did not complete.");
	    logger.error("{} : {}", e.getClass().getName(), e.getMessage());
	    return false;
	}

    }
   
    /**
     *
     * Create Quote Table to contain stock prices.
     * 
     * @version 1.0
     * @author : dj
     * @return true if successful.
     * @throws java.sql.SQLException
     */
    @Override
    public boolean createQuoteTable() throws SQLException {
	// stmt = null;
	// stmt = c.createStatement();

	logger.info("createQuoteTable starting");
	String query = // FOR NOW delete table if already exists
		"CREATE TABLE QUOTE " + "(quoteID INTEGER PRIMARY KEY," + " SYMBOL       VARCHAR(10) NOT NULL,"
			+ " COMPANYNAME            TEXT, " + " PRIMARYEXCHANGE         TEXT, "
			+ " SECTOR                 TEXT, " + " CALCULATIONPRICE       TEXT, "
			+ " OPEN                   TEXT, " + " OPENTIME               TEXT, "
			+ " CLOSE                  TEXT, " + " CLOSETIME              TEXT, "
			+ " LATESTPRICE            TEXT, " + " LATESTSOURCE           TEXT, "
			+ " LATESTTIME             TEXT, " + " LATESTUPDATE           TEXT, "
			+ " LATESTVOLUME           TEXT, " + " IEXREALTIMEPRICE       TEXT, "
			+ " IEXREALTIMESIZE        TEXT, " + " IEXLASTUPDATED         TEXT, "
			+ " DELAYEDPRICE           TEXT, " + " DELAYEDPRICETIME       TEXT, "
			+ " PREVIOUSCLOSE          TEXT, " + " CHANGE                 TEXT, "
			+ " CHANGEPERCENT          TEXT, " + " IEXMARKETPERCENT       TEXT, "
			+ " IEXVOLUME              TEXT, " + " AVGTOTALVOLUME         TEXT, "
			+ " IEXBIDPRICE            TEXT, " + " IEXBIDSIZE             TEXT, "
			+ " IEXASKPRICE            TEXT, " + " IEXASKSIZE             TEXT, "
			+ " MARKETCAP              TEXT, " + " PERATIO                TEXT, "
			+ " WEEK52HIGH             TEXT, " + " WEEK52LOW              TEXT, "
			+ " YTDCHANGE              TEXT, "
			+ "UNIQUE (SYMBOL, PRIMARYEXCHANGE, CLOSETIME) ON CONFLICT REPLACE, "
			+ "FOREIGN KEY(SYMBOL,PRIMARYEXCHANGE) REFERENCES COMPANY(SYMBOL,EXCHANGE)" + ");"
			+ "CREATE INDEX DATE_IDX ON QUOTE (SYMBOL, PRIMARYEXCHANGE, CLOSETIME);";

	try {
	    if (execStatement(query) == true) {
		// logger.info("createCompanyTables created successfully");
		return true;
	    } else {
		logger.error("createQuoteTable did not complete.");
		return false;
	    }
	} catch (Exception e) {
	    logger.error("createQuoteTable did not complete.");
	    logger.error("{} : {}", e.getClass().getName(), e.getMessage());
	    return false;
	}
    }

    /**
     *
     * Create Quote Table to contain stock prices.
     * 
     * @version 1.0
     * @author : dj
     * @return true if successful.
     * @throws java.sql.SQLException
     */
    @Override
    public boolean createChartTable() throws SQLException {
	// stmt = null;
	// stmt = c.createStatement();

	// logger.info("createChartTable starting");
	String query = // FOR NOW delete table if already exists
		"CREATE TABLE CHART " + "(chartID INTEGER PRIMARY KEY," + " SYMBOL       VARCHAR(10) NOT NULL,"
			+ " DATE                   TEXT, " + " OPEN                   TEXT, "
			+ " HIGH                   TEXT, " + " LOW                    TEXT, "
			+ " CLOSE                  TEXT, " + " VOLUME                 TEXT, "
			+ " UNADJUSTEDVOLUME       TEXT, " + " CHANGE                 TEXT, "
			+ " CHANGEPERCENT          TEXT, " + " VWAP                   TEXT, "
			+ " LABEL                  TEXT, " + " CHANGEOVERTIME         TEXT, "
			+ "UNIQUE (SYMBOL, DATE) ON CONFLICT REPLACE, "
			+ "FOREIGN KEY(SYMBOL) REFERENCES COMPANY(SYMBOL)" + ");"
			+ "CREATE INDEX SYMBOL_CHART ON CHART (SYMBOL, DATE);";

	try {
	    if (execStatement(query) == true) {
		// logger.info("createCompanyTables created successfully");
		return true;
	    } else {
		logger.error("createChartTable did not complete.");
		return false;
	    }
	} catch (Exception e) {
	    logger.error("createChartTable did not complete.");
	    logger.error("{} : {}", e.getClass().getName(), e.getMessage());
	    return false;
	}
    }

    @Override
    public boolean deleteDuplicateFromStockListTrimDb() throws SQLException {

	String query = "DELETE FROM STOCKLISTTRIM " + "WHERE ROWID NOT IN " + "(" + "SELECT MIN (ROWID) "
		+ "FROM STOCKLISTTRIM " + "GROUP BY SYMBOL, EXCHANGE);";

	try {
	    if (execStatement(query) == true) {
		// logger.info("createCompanyTables created successfully");
		return true;
	    } else {
		logger.error("deleteDuplicateFromStockListTrimDb did not complete.");
		return false;
	    }
	} catch (Exception e) {
	    logger.error("deleteDuplicateFromStockListTrimDb did not complete.");
	    logger.error("{} : {}", e.getClass().getName(), e.getMessage());
	    return false;
	}
    }

}

/*
 * Find duplicate rows with data from 2 columns
 * 
 * SELECT symbol, name, COUNT(*) FROM stocklist GROUP BY symbol, name HAVING
 * COUNT(*) > 1
 * 
 * 
 * delete duplicate rows keeping only one
 * 
 * delete from stocklist where rowid not in ( select min(rowid) from stocklist
 * group by symbol , exchange )
 */

/*
 * Search values =10 select * from stockpricedaily where ( ( (CAST(close as
 * double)) = 10.0) and date = "2016-03-11")
 * 
 */

/*
 * find last date update SELECT date, COUNT(*) FROM stockpricedaily GROUP BY
 * date order by date
 * 
 */