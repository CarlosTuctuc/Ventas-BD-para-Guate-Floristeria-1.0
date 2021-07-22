/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

/**
 *
 * @author Carlos Tuctuc
 * numero: colajcarloswt@gmail.com
 */

import Conexiones.Conexiones;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import javax.swing.Timer;

public class Interfaz extends javax.swing.JFrame {
  
//    public static Conexiones conect;
    
    private Timer timer;
 Connection con = null;
Conexiones conect = new Conexiones();
//conect = new Conexiones();

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/icono.png")).getImage());
       
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        
        setTitle("SISTEMA DE VENTAS");
        this.setExtendedState(MAXIMIZED_BOTH);
        
        
        //poniendo fecha
        Calendar cal = Calendar.getInstance();
        String fecha = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MARCH) + 1) + "/" + cal.get(Calendar.YEAR);
        this.Fecha.setText(fecha);
        
            //cuando abra crea la conexión
         con=conect.getConnection();
         
         
    }

    private Object setIconImage(ImageIcon imageIcon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    @Override
//    public Image getIconImage(){
//    
//        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("src/icono.png"));
//        return retValue;
//    }
    
// poniendo reloj
   
    public class cronometro implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            GregorianCalendar tiempo = new GregorianCalendar();
            int hora,minutos,segundos;
            hora=tiempo.get(Calendar.HOUR);
            minutos=tiempo.get(Calendar.MINUTE);
            segundos=tiempo.get(Calendar.SECOND);
            LabelHora.setText(String.valueOf(hora));
            LabelMinuto.setText(String.valueOf(minutos));
            LabelSegundo.setText(String.valueOf(segundos));
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JDesktopPane();
        logo = new javax.swing.JLabel();
        FechaTitulo = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        HoraTitulo = new javax.swing.JLabel();
        LabelHora = new javax.swing.JLabel();
        LabelMinuto = new javax.swing.JLabel();
        Puntitos = new javax.swing.JLabel();
        LabelSegundo = new javax.swing.JLabel();
        pedidos = new javax.swing.JButton();
        pedidos1 = new javax.swing.JButton();
        pedidos2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setMaximumSize(getMaximumSize());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo2.gif"))); // NOI18N
        logo.setText("jLabel1");
        Fondo.add(logo);
        logo.setBounds(1170, 570, 140, 70);

        FechaTitulo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        FechaTitulo.setForeground(new java.awt.Color(153, 255, 204));
        FechaTitulo.setText("Fecha:");
        Fondo.add(FechaTitulo);
        FechaTitulo.setBounds(20, 610, 50, 40);

        Fecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Fecha.setForeground(new java.awt.Color(153, 255, 204));
        Fecha.setText("00/00/00");
        Fondo.add(Fecha);
        Fecha.setBounds(70, 610, 120, 40);

        HoraTitulo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        HoraTitulo.setForeground(new java.awt.Color(153, 255, 204));
        HoraTitulo.setText("Hora:");
        Fondo.add(HoraTitulo);
        HoraTitulo.setBounds(150, 620, 34, 19);

        LabelHora.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        LabelHora.setForeground(new java.awt.Color(153, 255, 204));
        LabelHora.setText("00");
        Fondo.add(LabelHora);
        LabelHora.setBounds(192, 610, 30, 40);

        LabelMinuto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        LabelMinuto.setForeground(new java.awt.Color(153, 255, 204));
        LabelMinuto.setText("00");
        Fondo.add(LabelMinuto);
        LabelMinuto.setBounds(216, 610, 30, 40);

        Puntitos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Puntitos.setForeground(new java.awt.Color(153, 255, 204));
        Puntitos.setText(":     :");
        Puntitos.setAlignmentY(0.6F);
        Fondo.add(Puntitos);
        Puntitos.setBounds(210, 620, 30, 20);

        LabelSegundo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        LabelSegundo.setForeground(new java.awt.Color(153, 255, 204));
        LabelSegundo.setText("00");
        Fondo.add(LabelSegundo);
        LabelSegundo.setBounds(240, 610, 50, 40);

        pedidos.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        pedidos.setForeground(new java.awt.Color(153, 255, 204));
        pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/A2.png"))); // NOI18N
        pedidos.setText("Pedidos");
        pedidos.setBorder(null);
        pedidos.setBorderPainted(false);
        pedidos.setContentAreaFilled(false);
        pedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedidos.setIconTextGap(-3);
        pedidos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/A3.png"))); // NOI18N
        pedidos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/A.png"))); // NOI18N
        pedidos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosActionPerformed(evt);
            }
        });
        Fondo.add(pedidos);
        pedidos.setBounds(40, 40, 100, 100);

        pedidos1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        pedidos1.setForeground(new java.awt.Color(153, 255, 204));
        pedidos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/B2.png"))); // NOI18N
        pedidos1.setText("Buscar");
        pedidos1.setBorder(null);
        pedidos1.setBorderPainted(false);
        pedidos1.setContentAreaFilled(false);
        pedidos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedidos1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedidos1.setIconTextGap(-3);
        pedidos1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/B3.png"))); // NOI18N
        pedidos1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/B.png"))); // NOI18N
        pedidos1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pedidos1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedidos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidos1ActionPerformed(evt);
            }
        });
        Fondo.add(pedidos1);
        pedidos1.setBounds(180, 40, 100, 100);

        pedidos2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        pedidos2.setForeground(new java.awt.Color(153, 255, 204));
        pedidos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/C2.png"))); // NOI18N
        pedidos2.setText("Reportes");
        pedidos2.setBorder(null);
        pedidos2.setBorderPainted(false);
        pedidos2.setContentAreaFilled(false);
        pedidos2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedidos2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedidos2.setIconTextGap(-3);
        pedidos2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/C3.png"))); // NOI18N
        pedidos2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/C.png"))); // NOI18N
        pedidos2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pedidos2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedidos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidos2ActionPerformed(evt);
            }
        });
        Fondo.add(pedidos2);
        pedidos2.setBounds(320, 40, 100, 100);

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 690));

        jMenu3.setText("Opciones");

        jMenuItem5.setText("Nuevo pedido");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Buscar pedido");
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Reportes");
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Ver");

        jMenuItem1.setText("Arreglos y zonas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Control de clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       ControlRegistros registros= new ControlRegistros();
       
       Fondo.add(registros);
       registros.toFront();
       registros.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // icono de pedido
         FormularioPedido formulario= new FormularioPedido();
       
       Fondo.add(formulario);
       formulario.toFront();
       formulario.setVisible(true);
       
       
       
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       //cuando se abra la ventana, corre el reloj
       timer=new Timer(1000, new cronometro());
       timer.start();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Cuando se cierre de desconecta
        Conexiones obj = new Conexiones();
        obj.Desconexion();
    }//GEN-LAST:event_formWindowClosing

    private void pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosActionPerformed
        // TODO add your handling code here:
         FormularioPedido buscar=new FormularioPedido();
         buscar.setVisible(true);
            Fondo.add(buscar);
       buscar.toFront();
       buscar.setVisible(true);
       buscar.setLocation(Fondo.getWidth() / 2 - buscar.getWidth() / 2, Fondo.getHeight() / 2 - buscar.getHeight() / 2);
       try {
        buscar.setMaximum(false); //OPCIONAL
        } catch (PropertyVetoException ex) {
        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
       
        }
       
    }//GEN-LAST:event_pedidosActionPerformed

    private void pedidos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidos1ActionPerformed
        
         
         Buscar buscar=new Buscar();
         buscar.setVisible(true);
            Fondo.add(buscar);
       buscar.toFront();
       buscar.setVisible(true);
       buscar.setLocation(Fondo.getWidth() / 2 - buscar.getWidth() / 2, Fondo.getHeight() / 2 - buscar.getHeight() / 2);
       try {
        buscar.setMaximum(true); //OPCIONAL
        } catch (PropertyVetoException ex) {
        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        
    }//GEN-LAST:event_pedidos1ActionPerformed

    private void pedidos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidos2ActionPerformed
        Reportes reportes=new Reportes();
         reportes.setVisible(true);
            Fondo.add(reportes);
       reportes.toFront();
       reportes.setVisible(true);
       reportes.setLocation(Fondo.getWidth() / 2 - reportes.getWidth() / 2, Fondo.getHeight() / 2 - reportes.getHeight() / 2);
       try {
        reportes.setMaximum(false); //OPCIONAL
        } catch (PropertyVetoException ex) {
        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
       
        }
    }//GEN-LAST:event_pedidos2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ControlClientes registros= new ControlClientes();
       
       Fondo.add(registros);
       registros.toFront();
       registros.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //creando conexion
        
//        conect = new Conexiones();
        
        
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
       
        
        /* CREANDO LA FORMA */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel FechaTitulo;
    public static javax.swing.JDesktopPane Fondo;
    private javax.swing.JLabel HoraTitulo;
    private javax.swing.JLabel LabelHora;
    private javax.swing.JLabel LabelMinuto;
    private javax.swing.JLabel LabelSegundo;
    private javax.swing.JLabel Puntitos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JLabel logo;
    private javax.swing.JButton pedidos;
    private javax.swing.JButton pedidos1;
    private javax.swing.JButton pedidos2;
    // End of variables declaration//GEN-END:variables
}
