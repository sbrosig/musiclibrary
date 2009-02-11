/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import javax.swing.JPanel;


/**
 *
 * @author sbrosig
 */
public abstract class CRUDPanel extends JPanel implements CRUD {

    abstract public void create();
    abstract public void update();
    abstract public void delete();

}
