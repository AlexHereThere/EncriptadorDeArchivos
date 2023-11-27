/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Todo;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author nunez
 */
public class Desencriptar extends javax.swing.JFrame {
 Encriptador paraDesencriptar = new Encriptador();
    /**
     * Creates new form Desencriptar
     */
    public Desencriptar() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        desencriptar = new javax.swing.JButton();
        casa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        areaDeTextoDeDireccion = new javax.swing.JScrollPane();
        textoDeArchivo = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        textoPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Desencriptar archivo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 10, 360, -1));

        desencriptar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        desencriptar.setText("Desencriptar");
        desencriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desencriptarActionPerformed(evt);
            }
        });
        jPanel1.add(desencriptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        casa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Imagenes/Casa.png"))); // NOI18N
        casa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casaActionPerformed(evt);
            }
        });
        jPanel1.add(casa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 30, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña para desencriptar el archivo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setText("Direccion del archivo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        textoDeArchivo.setEditable(false);
        textoDeArchivo.setColumns(20);
        textoDeArchivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoDeArchivo.setRows(5);
        areaDeTextoDeDireccion.setViewportView(textoDeArchivo);

        jPanel1.add(areaDeTextoDeDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, 60));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Imagenes/imagenArchivo.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 45, 45));

        textoPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(textoPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void desencriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desencriptarActionPerformed
     try {
         String mensajeError="ERROR ESPECIAL";
         //El System.getProperty("user.dir") regresa en que carpeta se encuentra el projecto, pero dentro del projecto hay mas subcarpetas, donde se debe especificar en donde se encuentra
         Icon icono =  new ImageIcon("src\\resources\\Imagenes\\confirmacion.png"); //Recuerda poner tu direccion del archivo
         char[] cadea = textoPassword.getPassword(); //regresa una cadena de char que
         StringBuilder cadenaDeVerdad =  new StringBuilder();
         cadenaDeVerdad.append(cadea);
         UIManager.put("OptionPane.messageFont", new Font("Segoe UI Semibold", Font.PLAIN, 18)); //Es para darle formato
         
         int caso = paraDesencriptar.desencriptarArchivo(textoDeArchivo.getText(),cadenaDeVerdad.toString());
        
         if(caso==0)mensajeError = "Error, archivo no esta encriptado";
         if(caso==1)mensajeError = "Contraseña incorrecta"; //o tambien puede ser String mensajeError = "Error, archivo no esta encriptado";
         if(caso!=3)JOptionPane.showConfirmDialog(null, mensajeError, "Estado de archivo encriptado", JOptionPane.CLOSED_OPTION,JOptionPane.ERROR_MESSAGE);
         else  JOptionPane.showConfirmDialog(null,"Se Desencripto" , "Estado de archivo encriptado", JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE,icono);
//Aqui deberia haber un if para ver si el archivo se puede desencriptar, en caso que no se pueda se usara la linea de codigo que esta arriba
         //Ahora ya se puede usar como to.string
          
     } catch (IOException ex) {
         Logger.getLogger(Desencriptar.class.getName()).log(Level.SEVERE, null, ex);
     }

    }//GEN-LAST:event_desencriptarActionPerformed

    private void casaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casaActionPerformed
        Menu menu =  new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_casaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser escogerArchivo =  new JFileChooser();
        int seleccion = escogerArchivo.showOpenDialog(null);
        if(seleccion == JFileChooser.APPROVE_OPTION) //Significa  que el usuario selecciono acceptar
        {
            File archivo = escogerArchivo.getSelectedFile(); //Con este archivo se puede usar un .toString para obtener la cadena de la direccion del archivo

            textoDeArchivo.setText(archivo.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Desencriptar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Desencriptar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Desencriptar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Desencriptar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Desencriptar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane areaDeTextoDeDireccion;
    private javax.swing.JButton casa;
    private javax.swing.JButton desencriptar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextArea textoDeArchivo;
    private javax.swing.JPasswordField textoPassword;
    // End of variables declaration//GEN-END:variables
}