package com.goralczyk.Convert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class App 
{
	private static Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
    	BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
        DaoFactory df = DaoFactory.getInstance();
        df.setSource(EDaoFactory.DB);
        logger.trace(df.getPersonByID(10).toString());
        df.setSource(EDaoFactory.WS);
        logger.trace(df.getPersonByID(10).toString());
        df.setSource(EDaoFactory.XML);
        logger.trace(df.getPersonByID(10).toString());
        logger.info("Number of persons : " + Person.getCount());
    }
}
