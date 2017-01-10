package com.goralczyk.Convert;

public class DB implements IDaoFactory {

	private static DB db=null;
    public static DB getInstance(){
        if(db==null){
            db=new DB();
        }
        return db;
    }
    
    private DB(){
        
    }
    
    public void setSource(EDaoFactory source){
        //Method stub
    }
    
    
    public Person getPersonByID(int id){
        return new Person("Ola",20);
    }

}
