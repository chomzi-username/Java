package com.goralczyk.Convert;

public class WS implements IDaoFactory {

	private static WS ws=null;
    public static WS getInstance(){
        if(ws==null){
            ws=new WS();
        }
        return ws;
    }
    
    private WS(){
        
    }
    
    
    public void setSource(EDaoFactory source){
        //Method stub
    }
    
    
    public Person getPersonByID(int id){
        return new Person("Artur",22);
    }

}
