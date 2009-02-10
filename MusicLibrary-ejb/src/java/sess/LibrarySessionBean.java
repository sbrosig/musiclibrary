/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sess;

import entity.Instrument;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author sbrosig
 */
@Stateless
public class LibrarySessionBean implements LibrarySessionRemote, LibrarySessionLocal {
    @PersistenceContext
    private EntityManager em;

    public String testMethod(String parameter) {
        System.out.println("beany boy "+parameter);
        return parameter;
    }

    public List<Instrument> loadInstruments() {        
        return (List<Instrument>) em.createQuery("select i from Instrument i").getResultList();

     
    }




    public void persist(Object object) {
        em.persist(object);
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
}
