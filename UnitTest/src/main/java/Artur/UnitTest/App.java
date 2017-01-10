package Artur.UnitTest;

import org.apache.log4j.*;
import org.apache.log4j.chainsaw.Main;
import org.apache.log4j.jmx.LoggerDynamicMBean;

import Artur.UnitTest.Kalkulator;

public class App 
{
	private final static Logger log = LogManager.getLogger(Main.class);
	
    public static void main( String[] args )
    {
    	BasicConfigurator.configure();
    	log.setLevel(Level.INFO);
    	Kalkulator kal = new Kalkulator();
    	int zmienna = kal.dodawanie(5, 5);
    	log.info(zmienna);
        
    }
}
