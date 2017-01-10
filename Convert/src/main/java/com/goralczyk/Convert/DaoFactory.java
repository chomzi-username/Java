package com.goralczyk.Convert;

public class DaoFactory implements IDaoFactory{
	
	private EDaoFactory eDaoFactory;

    private DB db = DB.getInstance();
    private WS ws = WS.getInstance();
    private XML xml = XML.getInstance();

    private static DaoFactory daoFactory = null;

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    private DaoFactory() {
        eDaoFactory = EDaoFactory.XML;
    }

    
    public void setSource(EDaoFactory source) {
        eDaoFactory = source;
        switch (eDaoFactory) {
            case DB:
                db.setSource(eDaoFactory);
            case WS:
                ws.setSource(eDaoFactory);
            case XML:
                xml.setSource(eDaoFactory);
        }
    }

    
    public Person getPersonByID(int id) {
        switch (eDaoFactory) {
            case DB:
                return db.getPersonByID(id);
            case WS:
                return ws.getPersonByID(id);
            case XML:
                return xml.getPersonByID(id);
            default:
                return null;
        }
    }
}
