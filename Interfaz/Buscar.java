/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Conexiones.Conexiones;
import Reportes.GenerarReportes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charlie
 */
public class Buscar extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();  
    Statement st = null;
    ResultSet rs = null;
    Connection con2 = null;
    String Pago;
    
    public Buscar() {
        initComponents();
        
        this.setTitle("Buscar");
        vaciarTabla();
        verDatos();
        jButton1.setEnabled(false);
       
    }

       public void vaciarTabla(){
        String titulos[] = {"No.", "Cliente", "Tel Cliente", "Nombre Factura", "Fecha de pedido", "Fecha de Entrega", "Arreglo", "Total","Receptor","Dir Receptor","Tel Receptor","No de envío","Tipo de pago"};
        model = new DefaultTableModel(null,titulos);
        JT_TablaHistorial.setModel(model);
    }
       public void verDatos(){
        try {
            Connection con1 = null;
            DefaultTableModel miModelo = (DefaultTableModel) JT_TablaHistorial.getModel();
            Conexiones conect1 = new Conexiones();
            con1 = conect1.getConnection();
            String dts[] = new String[23];
            String sql = "select * from Comprador";
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                dts[0] = rs.getString("NumeroPedido");
                dts[1] = rs.getString("NombreComprador");
                dts[2] = rs.getString("TelefonoComprador");
//                dts[3] = rs.getString("NitComprador");
//                dts[4] = rs.getString("DireccionFiscal");
                dts[3] = rs.getString("NombreFactura");               
//                dts[6] = rs.getString("CorreoComprador");
                dts[4] = rs.getString("FechaPedido");
                dts[5] = rs.getString("FechaEntrega");
                dts[6] = rs.getString("NombreArreglo");
//                dts[10] = rs.getString("PrecioArreglo");
//                dts[11] = rs.getString("PrecioEnvio");
//                dts[12] = rs.getString("Adicional");
                dts[7] = rs.getString("PrecioTotal");
//                dts[14] = rs.getString("NoTargeta");
//                dts[15] = rs.getString("VencimientoTargeta");
//                dts[16] = rs.getString("CodigoSeguro");
//                dts[17] = rs.getString("NoDeposito");
                dts[8] = rs.getString("NombreReceptor");
                dts[9] = rs.getString("DireccionReceptor");
                dts[10] = rs.getString("TelefonoReceptor");
//                dts[21] = rs.getString("Observaciones");
                dts[11] = rs.getString("NoEnvio");
                dts[12] = rs.getString("TipoDePago");
       
                miModelo.addRow(dts);
            }
            JT_TablaHistorial.setModel(miModelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

       
       public void cargar (String sql){
       
           String titulos[] = {"No.", "Cliente", "Tel Cliente", "Nombre Factura",  "Fecha de pedido", "Fecha de Entrega", "Arreglo","Total","Receptor","Dir Receptor","Tel Receptor","Tipo de pago","NoEnvio"};
        String[] registros = new String[100];
        
        
        
        model = new DefaultTableModel(null, titulos);
        Conexiones conect1 = new Conexiones();
        con2 = conect1.getConnection();
        try
        {
            st = (Statement) con2.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                registros[0] = rs.getString("NumeroPedido");
                registros[1] = rs.getString("NombreComprador");
                registros[2] = rs.getString("TelefonoComprador");
//                registros[3] = rs.getString("NitComprador");
//                registros[4] = rs.getString("DireccionFiscal");
                registros[3] = rs.getString("NombreFactura");               
//                registros[6] = rs.getString("CorreoComprador");
                registros[4] = rs.getString("FechaPedido");
                registros[5] = rs.getString("FechaEntrega");
                registros[6] = rs.getString("NombreArreglo");
//                registros[10] = rs.getString("PrecioArreglo");
////                registros[11] = rs.getString("PrecioEnvio");
//                registros[12] = rs.getString("Adicional");
                registros[7] = rs.getString("PrecioTotal");
//                registros[14] = rs.getString("NoTargeta");
//                registros[15] = rs.getString("VencimientoTargeta");
//                registros[16] = rs.getString("CodigoSeguro");
//                registros[17] = rs.getString("NoDeposito");
                registros[8] = rs.getString("NombreReceptor");
                registros[9] = rs.getString("DireccionReceptor");
                registros[10] = rs.getString("TelefonoReceptor");
                registros[12] = rs.getString("TipoDePago");
                registros[11] = rs.getString("NoEnvio");
             
                model.addRow(registros);
            }
            JT_TablaHistorial.setModel(model);
        } catch (SQLException ex)
        {
            System.out.println("ERROR AL BUSCAR LOS DATOS : " + ex.getMessage());
        }
       
       
       }
//     
       
       
       
       
       
       
       
//       public void Reporte() {
//        List Lista = new ArrayList();
//        for (int i = 0; i < JT_TablaHistorial.getRowCount(); i++) {
//            AsistenteDatos t = new AsistenteDatos(JT_TablaHistorial.getValueAt(i, 0).toString(),JT_TablaHistorial.getValueAt(i, 1).toString(),JT_TablaHistorial.getValueAt(i, 2).toString(),JT_TablaHistorial.getValueAt(i, 6).toString());
//            Lista.add(t);
//            System.out.println(""+JT_TablaHistorial.getValueAt(i, 0).toString());
//        }
//       
////     
//        try {
//            JasperReport reporte;
//        String master = System.getProperty("user.dir")+"\\src\\Reportes\\ReporteBusqueda.jasper";
//             reporte = (JasperReport)JRLoader.loadObjectFromFile(master);
//             JasperPrint j = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(Lista) );
//            JasperViewer jv = new JasperViewer(j,false);
//
//            jv.setTitle("Reporte de Busqueda");
//            jv.setVisible(true);
//        } catch (Exception e) {
//        }
//        
//    }
       
       
       
       
       
       
       
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        buscartodo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JT_TablaHistorial = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        TipoBusqueda = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        NPedido = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buscartodo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buscartodo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscartodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscartodoActionPerformed(evt);
            }
        });
        buscartodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscartodoKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel1.setText("Buscar:");

        JT_TablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NO_CATALOGO", "MARCA", "MODELO", "NOMBRE", "DESCRIPCION", "CANTIDAD", "UBICACION", "ID_PROVEEDOR", "NOMBRE_PROVEEDOR", "CODIGO", "URL", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19", "Title 20", "Title 21", "Title 22", "Title 23"
            }
        ));
        JT_TablaHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_TablaHistorialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JT_TablaHistorial);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 2924, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel3);

        jLabel2.setText("Buscar por:");

        TipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre de cliente", "No de pedido", "Telefono de cliente", "Nit de cliente", "Nombre factura", "Correo comprador", "Fecha pedido dd/mm/aaaa", "Fecha entrega dd/mm/aaaa", "Receptor/Destinatario", "Telefono de receptor", "No de depósito", "No de Targeta", "No de envío", "Tipo de pago" }));
        TipoBusqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TipoBusquedaItemStateChanged(evt);
            }
        });
        TipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoBusquedaActionPerformed(evt);
            }
        });

        jLabel3.setText("Presiona Enter para concluir la busqueda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("ver pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("pedido:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(NPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(NPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscartodoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartodoKeyPressed
        
        int opcion = TipoBusqueda.getSelectedIndex();
        
        //
        //para buscar con opcion 1 NOMBRE DE COMPRADOR
        if(opcion==0){
            String sql = "SELECT * FROM Comprador WHERE NombreComprador LIKE '%" + buscartodo.getText() + "%'";
            cargar(sql);
//     
        }
        
        if(opcion==1){
            String sql = "SELECT * FROM Comprador WHERE NumeroPedido LIKE '%" + buscartodo.getText() + "%'";
            cargar(sql);
//     
        }
        
        //para buscar con opcion 3
        //Buscar con Telefono de comprador
        else if(opcion==2){
      
        String sql = "SELECT * FROM Comprador WHERE TelefonoComprador LIKE '%" + buscartodo.getText() + "%'";
        cargar(sql);
       
        }
        //Buscar por opcion 4
        //busqueda por Nit del cliente
        if(opcion==3){
      
        String sql = "SELECT * FROM Comprador WHERE NitComprador LIKE '%" + buscartodo.getText() + "%'";
        cargar(sql);
       
        }
        
        
        //buscar con opcion 5
        //buscar por nombre factura
        if(opcion==4){
      
        String sql = "SELECT * FROM Comprador WHERE NombreFactura LIKE '%" + buscartodo.getText() + "%'";
        cargar(sql);
        
        }
        
        //opcion 6
        //Busqueda por correo comprador
        if(opcion==5){
      
        String sql = "SELECT * FROM Comprador WHERE CorreoComprador LIKE '%" + buscartodo.getText() + "%'";
        cargar(sql);
        
        }
        
        
        //busqueda con opcion 7
        //busqueda por fecha del pedido
        if(opcion==6){
        
        String sql = "SELECT * FROM Comprador WHERE FechaPedido LIKE '%" + buscartodo.getText() + "%'";
        
        cargar(sql);
        }
        
        
        //buscando con opcion 8
        //buscar por fecha de entrega
        if(opcion==7){
      
        String sql = "SELECT * FROM Comprador WHERE FechaEntrega LIKE '%" + buscartodo.getText() + "%'";
        
       cargar(sql);
        }
        
        
        //buscando con opcion 9
        //buscar por nombre de receptor
        if(opcion==8){
        
        String sql = "SELECT * FROM Comprador WHERE NombreReceptor LIKE '%" + buscartodo.getText() + "%'";
        
        cargar(sql);
        }
        
        //buscar con opcion 10
        //buscar por telefono de receptor
        if(opcion==9){
        
        
        String sql = "SELECT * FROM Comprador WHERE TelefonoReceptor LIKE '%" + buscartodo.getText() + "%'";
        
       cargar(sql);
        }
        
        //buscar por numero de deposito , op 11
        
        if(opcion==10){
        
        String sql = "SELECT * FROM Comprador WHERE NoDeposito LIKE '%" + buscartodo.getText() + "%'";
        
        cargar(sql);
        }
        //buscar por numero de targeta , op 12
        if(opcion==11){
        
        String sql = "SELECT * FROM Comprador WHERE NoTargeta LIKE '%" + buscartodo.getText() + "%'";
        
        
        }
        //buscar por numero de deposito , op 13
        
        if(opcion==12){
        
        
        String sql = "SELECT * FROM Comprador WHERE NoEnvio LIKE '%" + buscartodo.getText() + "%'";
        
      cargar(sql);
        }
    }//GEN-LAST:event_buscartodoKeyPressed

    private void TipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoBusquedaActionPerformed

    private void TipoBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TipoBusquedaItemStateChanged
        //para el combo     
    }//GEN-LAST:event_TipoBusquedaItemStateChanged

    private void buscartodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscartodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscartodoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        String pago1= new String("Tarjeta");
        String pago2= new String("Deposito");
        String pago3 =new String("Ninguno");
        GenerarReportes porpedido = new GenerarReportes();
        
        if(Pago.equals(pago3)){
        
            porpedido.ReporteVerPedido(NPedido.getText());
            
        }
        else if(Pago.equals(pago2)){
            porpedido.ReporteVerPedidoDeposito(NPedido.getText());
        }
        else if(Pago.equals(pago1)){
            porpedido.ReporteVerPedidoTarjeta(NPedido.getText());
        }
////        GenerarReportes newo = new GenerarReportes();
////        newo.ReportePedido(4);
//     AsistenteDatos em;
//     List<AsistenteDatos>lista = new ArrayList<>();
//     for (int i = 0 ; i< JT_TablaHistorial.getRowCount(); i++)
//     {
//     em = new AsistenteDatos(JT_TablaHistorial.getValueAt(i,0).toString(),JT_TablaHistorial.getValueAt(i,1).toString(),JT_TablaHistorial.getValueAt(i,0).toString(),JT_TablaHistorial.getValueAt(i,1).toString());
//     lista.add(em);
//     System.out.println(""+ JT_TablaHistorial.getValueAt(i,0).toString());
//     System.out.println(" "+ JT_TablaHistorial.getValueAt(i,1).toString());
//     }
//     JasperReport reporte;
//     String path=System.getProperty("user.dir")+"\\src\\Reportes\\ReporteBusqueda.jasper";
//        try {
//            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
//            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
//            JasperViewer viewer = new JasperViewer(jprint,false);
//            viewer.setVisible(true);
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JT_TablaHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_TablaHistorialMouseClicked
        // TODO add your handling code here:
        jButton1.setEnabled(true);
        int fila = JT_TablaHistorial.getSelectedRow();
            NPedido.setText(JT_TablaHistorial.getValueAt(fila, 0).toString());
            Pago=JT_TablaHistorial.getValueAt(fila, 12).toString();
            
    }//GEN-LAST:event_JT_TablaHistorialMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        jButton1.setEnabled(false);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable JT_TablaHistorial;
    private javax.swing.JLabel NPedido;
    private javax.swing.JComboBox<String> TipoBusqueda;
    private javax.swing.JTextField buscartodo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
