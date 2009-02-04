/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sess;

import javax.ejb.Remote;

/**
 *
 * @author sbrosig
 */
@Remote
public interface LibrarySessionRemote {

    String testMethod(String parameter);
    
}
