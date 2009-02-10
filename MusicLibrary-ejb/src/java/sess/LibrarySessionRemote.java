/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sess;

import entity.Instrument;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sbrosig
 */
@Remote
public interface LibrarySessionRemote {

    String testMethod(String parameter);

    public List<Instrument> loadInstruments();

    public void persist(java.lang.Object object);
    
}
