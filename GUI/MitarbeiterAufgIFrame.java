/*
 * MitarbeiterAufgIFrame.java
 *
 * Created on 2. Juni 2005, 09:30
 */

package GUI;
import FK.*;
import java.util.*;

public class MitarbeiterAufgIFrame extends javax.swing.JInternalFrame {
     private LinkedList aenderungen = new LinkedList();
     
    /** Creates new form MitarbeiterAufgIFrame */
    public MitarbeiterAufgIFrame() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mitarbeiterAufgTBL = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        ausblendenBTN = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Aufgaben Mitarbeiter");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        mitarbeiterAufgTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aufabe", "Immobilie", "Erledigt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(mitarbeiterAufgTBL);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        ausblendenBTN.setFont(new java.awt.Font("Tahoma", 0, 12));
        ausblendenBTN.setIcon(new javax.swing.ImageIcon("Ausblenden"));
        ausblendenBTN.setText("Ausblenden");
        ausblendenBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ausblendenBTNActionPerformed(evt);
            }
        });

        jPanel2.add(ausblendenBTN);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Reservierungsverwaltung eineVerwaltung = new Reservierungsverwaltung();
        LinkedList eineListe = null;

        
        eineListe = eineVerwaltung.sucheEndDatumAktuell();
        
        ListIterator einIterator = eineListe.listIterator();
        int i=0;
        
       // <editor-fold defaultstate="collapsed" desc=" Tabellen Modell ">
        String[] titel = {"Aufabe", "Immobilie", "Erledigt"};
        boolean[] canEdit = {false, false, true};
        Class[] types = {String.class, Integer.class, Boolean.class};
        
        TabellenModell einModell = new TabellenModell(eineListe.size(), titel, canEdit, types);
        mitarbeiterAufgTBL.setModel(einModell);
        // </editor-fold>    
        
        while(einIterator.hasNext())
        {
            Reservierung eineReservierung = (Reservierung)einIterator.next();
            mitarbeiterAufgTBL.setValueAt("Putzen & Abnahme",i,0);
            mitarbeiterAufgTBL.setValueAt(eineReservierung.getMietobjektNr(),i,1);
 
            i++;
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void ausblendenBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ausblendenBTNActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_ausblendenBTNActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ausblendenBTN;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mitarbeiterAufgTBL;
    // End of variables declaration//GEN-END:variables
    
}
