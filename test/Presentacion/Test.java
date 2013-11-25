/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Persistencia.FachadaPersistencia;
import dominio.Animal;
import dominio.CategoriaAnimal;
import dominio.Productor;
import javax.swing.JFrame;

/**
 *
 * @author diego
 */
public class Test {

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and dis
         JFrame frm = new Inicio();
         frm.setExtendedState(Inicio.Mplay the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarProductor();
            }

            private void AgregarAnimales() {
                CategoriaAnimal cat = new CategoriaAnimal();
                cat.setNombre("novillo no cuota");
                Productor p = new Productor();
                p.setNombre("diego");
                for (int i = 0; i < 10000000; i++) {
                    Animal a = new Animal();
                    a.setNroCaravana(i);
                    a.setCategoria((CategoriaAnimal) FachadaPersistencia.getInstancia().buscar(CategoriaAnimal.class, cat.getNombre()));
                    a.setEstado("ACTIVO");
                    a.setPesoActual(500 + i);
                    a.setPesoIngreso(500 + i);
                    a.setProductor((Productor) FachadaPersistencia.getInstancia().buscar(Productor.class, p.getNombre()));
                    FachadaPersistencia.getInstancia().Guardar(a);
                    System.err.println(i);
                }
                System.err.println("Termino el guardado");
            }

            private void AgregarProductor() {
               for (int i = 0; i < 5000; i++) {
                    Productor p = new Productor();
                   p.setNombre("Productor"+i);
                   p.setDireccion("Direccion"+i);
                   p.setEmail("mail"+i);
                   p.setEstado("ACTIVO");
                   p.setDicose("d"+i);
                   p.setProduce(true);
                   p.setTelefono(i);
                   p.setObservacion("Observacion"+i);
                    FachadaPersistencia.getInstancia().Guardar(p);
                    System.err.println(i);
                }
                System.err.println("Termino el guardado");
            }
        });
    }
}
