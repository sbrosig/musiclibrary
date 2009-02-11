/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InstrumentPanel.java
 *
 * Created on 04-Feb-2009, 10:13:20
 */
package gui;

import entity.Instrument;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import sess.LibrarySessionRemote;

/**
 *
 * @author sbrosig
 */
public class InstrumentPanel extends CRUDPanel {

    private LibrarySessionRemote lsb;

    /** Creates new form InstrumentPanel */
    public InstrumentPanel() {
        lsb = AppMain.getBean(LibrarySessionRemote.class);
        initComponents();
        

     }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        instrumentList = java.beans.Beans.isDesignTime() ? ((List<Instrument>)null): (List<Instrument>) ObservableCollections.observableList(lsb.loadInstruments());
        scrollPane = new javax.swing.JScrollPane();
        instrTable = new javax.swing.JTable();

        setName("Form"); // NOI18N

        scrollPane.setName("scrollPane"); // NOI18N

        instrTable.setName("instrTable"); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, instrumentList, instrTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${abbr}"));
        columnBinding.setColumnName("Abbr");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${family}"));
        columnBinding.setColumnName("Family");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderIndex}"));
        columnBinding.setColumnName("Order Index");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${transpose}"));
        columnBinding.setColumnName("Transpose");
        columnBinding.setColumnClass(ancillary.Note.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollPane.setViewportView(instrTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable instrTable;
    private java.util.List<entity.Instrument> instrumentList;
    private javax.swing.JScrollPane scrollPane;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public void create() {
        Instrument newI = new Instrument();
        instrumentList.add(newI);
        int row = instrumentList.size() - 1;
        instrTable.setRowSelectionInterval(row, row);
        instrTable.scrollRectToVisible(instrTable.getCellRect(row, 0, true));
    }

    @Override
    public void update() {
        List<Instrument> il = new ArrayList<Instrument>(instrumentList.size());
        il.addAll(instrumentList);
        lsb.persist(il);
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}