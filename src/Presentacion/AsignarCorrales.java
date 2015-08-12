/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Persistencia.FachadaPersistencia;
import dominio.Animal;
import dominio.Corral;
import dominio.CorralAnimal;
import dominio.Productor;
import dominio.Tropa;
import dominio.TropaAnimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class AsignarCorrales extends javax.swing.JInternalFrame {

    /**
     * Creates new form AsignarCorrales
     */
    public AsignarCorrales() {
        initComponents();
        cargarCombos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTropa = new javax.swing.JTextField();
        txtAnimal = new javax.swing.JTextField();
        btnBuscarTropa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnimales = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cboCorrales = new javax.swing.JComboBox();
        btnBuscarAnimal = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(450, 300));
        setMinimumSize(new java.awt.Dimension(450, 300));
        setPreferredSize(new java.awt.Dimension(450, 300));

        jLabel1.setText("Tropa:");

        jLabel2.setText("Animal:");

        txtTropa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTropaActionPerformed(evt);
            }
        });

        btnBuscarTropa.setText("Buscar");
        btnBuscarTropa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTropaActionPerformed(evt);
            }
        });

        jLabel3.setText("Animales");

        tblAnimales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblAnimales);

        jLabel4.setText("Corral");

        cboCorrales.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBuscarAnimal.setText("Buscar");
        btnBuscarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAnimalActionPerformed(evt);
            }
        });

        jButton4.setText("Quitar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cboCorrales, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(21, 21, 21)
                                .addComponent(txtTropa, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarTropa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addComponent(txtAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarAnimal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTropa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarTropa)
                    .addComponent(jLabel2)
                    .addComponent(txtAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAnimal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cboCorrales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        quitarAnimal();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AsignarCorral();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBuscarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAnimalActionPerformed
        buscarAnimal();
    }//GEN-LAST:event_btnBuscarAnimalActionPerformed

    private void btnBuscarTropaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTropaActionPerformed
        buscarTropa();
    }//GEN-LAST:event_btnBuscarTropaActionPerformed

    private void txtTropaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTropaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTropaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAnimal;
    private javax.swing.JButton btnBuscarTropa;
    private javax.swing.JComboBox cboCorrales;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAnimales;
    private javax.swing.JTextField txtAnimal;
    private javax.swing.JTextField txtTropa;
    // End of variables declaration//GEN-END:variables
    DefaultComboBoxModel<Object> mdcCorrales = new DefaultComboBoxModel<>();
    DefaultTableModel mdlAnimal = new DefaultTableModel(new String[]{"Nro Caravana", "Corral Actual"}, 0);

    private void cargarCombos() {
        mdcCorrales.removeAllElements();
        cboCorrales.setModel(mdcCorrales);
        cboCorrales.setSelectedItem(null);
        List<Object> corrales = FachadaPersistencia.getInstancia().listadoHabilitados(Corral.class);
        for (Object o : corrales) {
            mdcCorrales.addElement(o);
        }
    }

    public static Object guardar(Object object, Boolean msj) {
        object = Persistencia.FachadaPersistencia.getInstancia().Guardar(object, msj);
        return object;
    }

    public static Object buscar(Object o, Object obj) {
        Object c = new Object();
        c = Persistencia.FachadaPersistencia.getInstancia().buscar(o, obj);
        return c;
    }

    private void limpiarTabla(DefaultTableModel d) {
        while (d.getRowCount() > 0) {
            d.removeRow(0);
        }

    }

    private void buscarTropa() {
        tblAnimales.setModel(mdlAnimal);
        if (!txtTropa.getText().equals("")) {
            Object o = buscar(Tropa.class, txtTropa.getText());
            Tropa t = (Tropa) o;
            limpiarTabla(mdlAnimal);
            tblAnimales.setModel(mdlAnimal);
            List<TropaAnimal>lista = FachadaPersistencia.getInstancia().listarAnimales(t);
            for (Object obj : lista) {
                TropaAnimal ta = (TropaAnimal) obj;
                Corral corralActual = (Corral) FachadaPersistencia.getInstancia().buscarCorralActual(ta.getAnimal());
                mdlAnimal.addRow(new Object[]{ta.getAnimal().getNroCaravana(), corralActual.getNombre(), 0});
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nro de tropa en el campo 'Tropa'");
        }
    }

    private void buscarAnimal() {
        tblAnimales.setModel(mdlAnimal);
        if (!txtAnimal.getText().equals("")) {
            Object o = buscar(Animal.class, txtAnimal.getText());
            Animal a = (Animal) o;
            Corral corralActual = (Corral) FachadaPersistencia.getInstancia().buscarCorralActual(a);
            if (a != null) {
                mdlAnimal.addRow(new Object[]{a.getNroCaravana(), corralActual.getNombre(), 0});
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado ningun animal con el numero de caravana:" + txtAnimal.getText() + ".\nPor favor verifiquelo.");
            }
            txtAnimal.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nro de caravana en el campo 'Animal'");
        }
    }

    private void AsignarCorral() {
        try {
            if (cboCorrales.getSelectedItem() != null) {
                for (int i = 0; i < mdlAnimal.getRowCount(); i++) {
                    CorralAnimal aux = new CorralAnimal();
                    CorralAnimal ca = new CorralAnimal();
                    Corral corral = (Corral) cboCorrales.getSelectedItem();
                    String caravana = Integer.toString((Integer) mdlAnimal.getValueAt(i, 0));
                    Animal animal = (Animal) FachadaPersistencia.getInstancia().buscar(Animal.class, caravana);
                    aux = (CorralAnimal) FachadaPersistencia.getInstancia().buscarCorralAnimal(animal);
                    if (aux != null) {
                        if (!aux.getCorral().equals(corral)) {
                            aux.setFechaEgr(new Date());
                            guardar(aux, false);
                            ca.setFechaIng(new Date());
                            ca.setCorral((Corral) cboCorrales.getSelectedItem());
                            ca.setAnimal(animal);
                            guardar(ca, true);
                        }
                    } else {
                        ca.setFechaIng(new Date());
                        ca.setCorral((Corral) cboCorrales.getSelectedItem());
                        ca.setAnimal(animal);
                        guardar(ca, true);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado. Por Favor verifique los datos");
        }
    }

    private void quitarAnimal() {
        int[] selectedRows = tblAnimales.getSelectedRows();
        tblAnimales.setModel(mdlAnimal);
        if (tblAnimales.getSelectedRow() != -1) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                mdlAnimal.removeRow(selectedRows[i]);
            }
        }
    }
}