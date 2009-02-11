/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sess;

import entity.Instrument;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        
        List<Instrument> ili = (List<Instrument>)  em.createQuery("select i from Instrument i").getResultList();
        
        System.out.printf("instr list has %d elements\n", ili.size());
        return ili;

    }

    public void persist(Object object) {
        if (object instanceof List) {
            for (Object lo: (List) object) {
                em.persist(lo);
            }
        } else  {
            em.persist(object);
        }
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
}
