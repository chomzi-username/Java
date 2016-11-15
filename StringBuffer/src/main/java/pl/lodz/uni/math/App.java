package pl.lodz.uni.math;


public class App 
{
    public static void main( String[] args )
    {
        StringBuffer stringBuffer = new StringBuffer("Hello");
        
        System.out.println("");
        stringBuffer.append(" world");
        System.out.println(stringBuffer);
        
        System.out.println("");
        stringBuffer.reverse();
        System.out.println(stringBuffer);
        
        
        stringBuffer = new StringBuffer("Some text");
        
        System.out.println("");
        stringBuffer.insert(4, " 12345");
        System.out.println(stringBuffer);
        
        System.out.println("");
        stringBuffer.delete(1, 5);
        System.out.println(stringBuffer);
        
        System.out.println("");
        stringBuffer.replace(1, 7,"HELLO");
        System.out.println(stringBuffer);
        
    }
}
