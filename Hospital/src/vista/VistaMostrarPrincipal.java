/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorMostrar;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author artur
 */
public class VistaMostrarPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaMostrarPrincipal
     */
    public VistaMostrarPrincipal() {
        initComponents();
    }
    VistaMostrar window = new VistaMostrar();
    ControladorMostrar c = new ControladorMostrar();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msgMostrar = new javax.swing.JLabel();
        gravedad = new javax.swing.JTextField();
        mostrarGravedad = new javax.swing.JButton();
        patologia = new javax.swing.JTextField();
        mostrarPatologia = new javax.swing.JButton();
        mostrarTodo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        msgPatologia = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msgMostrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        msgMostrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msgMostrar.setText("Mostrar");

        gravedad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gravedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gravedadActionPerformed(evt);
            }
        });

        mostrarGravedad.setText("Mostrar");
        mostrarGravedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarGravedadActionPerformed(evt);
            }
        });

        patologia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        patologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patologiaActionPerformed(evt);
            }
        });

        mostrarPatologia.setText("Mostrar");
        mostrarPatologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPatologiaActionPerformed(evt);
            }
        });

        mostrarTodo.setText("Mostrar");
        mostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTodoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Todo");

        msgPatologia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        msgPatologia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msgPatologia.setText("Por patologia");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Por Gravedad");

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(msgMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mostrarGravedad, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(msgPatologia, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addComponent(gravedad)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addComponent(patologia)
                                .addComponent(mostrarTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mostrarPatologia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(msgMostrar)
                .addGap(37, 37, 37)
                .addComponent(msgPatologia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(patologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(mostrarPatologia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(13, 13, 13)
                .addComponent(gravedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(mostrarGravedad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mostrarTodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(volver))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gravedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gravedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gravedadActionPerformed

    private void patologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patologiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patologiaActionPerformed

    private void mostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTodoActionPerformed
        try {
            window.setVisible(true);
            c.mostrar(window);
        } catch (IOException ex) {
            Logger.getLogger(VistaMostrarPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mostrarTodoActionPerformed

    private void mostrarPatologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarPatologiaActionPerformed
       window.setVisible(true);
        try {
            c.mostrar(window, patologia.getText());
        } catch (IOException ex) {
            Logger.getLogger(VistaMostrarPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mostrarPatologiaActionPerformed

    private void mostrarGravedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarGravedadActionPerformed
        window.setVisible(true);
        try {
            c.mostrar(window, Integer.parseInt(gravedad.getText()));
        } catch (IOException ex) {
            Logger.getLogger(VistaMostrarPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mostrarGravedadActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed


    public JTextField getGravedad() {
        return gravedad;
    }

    public JTextField getPatologia() {
        return patologia;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField gravedad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton mostrarGravedad;
    private javax.swing.JButton mostrarPatologia;
    private javax.swing.JButton mostrarTodo;
    private javax.swing.JLabel msgMostrar;
    private javax.swing.JLabel msgPatologia;
    private javax.swing.JTextField patologia;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
