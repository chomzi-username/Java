package com.goralczyk.Convert;

public class XML implements IDaoFactory {

	private static XML xml=null;
    public static XML getInstance(){
        if(xml==null){
            xml=new XML();
        }
        return xml;
    }
    
    private XML(){
        
    }
    
    //@Override
    public void setSource(EDaoFactory source){
        //Method stub
    }
    
    //@Override
    public Person getPersonByID(int id){
        return new Person("Jarek",33);
    }

}
