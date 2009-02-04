/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import ancillary.Note;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sbrosig
 */
@Entity
public class Instrument implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String name;
    public static final String PROP_NAME = "name";

    /**
     * Get the value of the instrument name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of the instrument name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange(PROP_NAME, oldName, name);
    }
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }


    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    protected String abbr;
    public static final String PROP_ABBR = "abbr";

    /**
     * Get the value of abbr
     *
     * @return the value of abbr
     */
    public String getAbbr() {
        return abbr;
    }

    /**
     * Set the value of abbr
     *
     * @param abbr new value of abbr
     */
    public void setAbbr(String abbr) {
        String oldAbbr = this.abbr;
        this.abbr = abbr;
        propertyChangeSupport.firePropertyChange(PROP_ABBR, oldAbbr, abbr);
    }
    protected Note transpose;
    public static final String PROP_TRANSPOSE = "transpose";


    public Note getTranspose() {
        return transpose;
    }

   
    public void setTransposeNote(Note transpose) {
        Note oldTranspose = this.transpose;
        this.transpose = transpose;
        propertyChangeSupport.firePropertyChange(PROP_TRANSPOSE, oldTranspose, transpose);
    }
    protected String family;
    public static final String PROP_FAMILY = "family";

    /**
     * Get the value of family
     *
     * @return the value of family
     */
    public String getFamily() {
        return family;
    }

    /**
     * Set the value of instrument family
     *
     * @param family new value of family
     */
    public void setFamily(String family) {
        String oldFamily = this.family;
        this.family = family;
        propertyChangeSupport.firePropertyChange(PROP_FAMILY, oldFamily, family);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instrument)) {
            return false;
        }
        Instrument other = (Instrument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Instrument[id=" + id + "]";
    }

}
