
package pl.goralczyk.config;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.persistence.EntityManager;
import pl.goralczyk.entity.Przychodnia;


public class PrzychodniaConverter implements Converter{
    public Object getAsObject(FacesContext ctx, UIComponent c, String s) {
        Integer i = Integer.valueOf(s);
        EntityManager em = DBManager.getManager().createEntityManager();
        Przychodnia p = em.find(Przychodnia.class, i);
        em.close();
        return p;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent c, Object o) {
        if(!(o instanceof Przychodnia))
            throw new ConverterException(new FacesMessage("Nie udało się dokonać konwersji!"));
        Przychodnia p = (Przychodnia)o;
        return p.getId().toString();
    }
}
