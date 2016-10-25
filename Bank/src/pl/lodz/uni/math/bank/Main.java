
package pl.lodz.uni.math.bank;

 
import org.apache.log4j.*;
import pl.lodz.uni.math.Class.Check;
import pl.lodz.uni.math.Class.Deposite;
import pl.lodz.uni.math.Class.WireOut;

public class Main {
    
     private static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Check check = Check.getInstance();
        Deposite deposite = Deposite.getInstance();
        WireOut wire = WireOut.getInstance();
        
        //logger.trace(check.);
        
        
    }
    
}
