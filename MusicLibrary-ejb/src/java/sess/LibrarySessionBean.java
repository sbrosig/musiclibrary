/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sess;

import javax.ejb.Stateless;

/**
 *
 * @author sbrosig
 */
@Stateless
public class LibrarySessionBean implements LibrarySessionRemote, LibrarySessionLocal {

    public String testMethod(String parameter) {
        System.out.println("beany boy "+parameter);
        return parameter;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
}
