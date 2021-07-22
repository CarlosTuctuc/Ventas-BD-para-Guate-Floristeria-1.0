
package Interfaz;

/**
 *
 * @author Carlos_Tuctuc
 */

import Conexiones.Conexiones;
import Reportes.GenerarReportes;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class FormularioPedido extends javax.swing.JInternalFrame {
      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
      SimpleDateFormat formato2= new SimpleDateFormat("yyyy-MM-dd");
    int contador = 0;
    int contador2=0;
    String Pago;
    int editar = 0;
   

    /**
     * Creates new form FormularioPedido
     */
   
    public FormularioPedido() {
        initComponents();
        
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        jTextField4.setVisible(false);
        jTextField17.setVisible(false);
        jLabel23.setVisible(false);
        jLabel30.setVisible(false);
        Zona.setVisible(false);
        IdZona.setVisible(false);
        jButton1.setEnabled(false);
      
        jButton2.setEnabled(false);
        jButton5.setEnabled(false);
        IdCliente.setVisible(false);
        
//        jLabel31.setVisible(false);
    
        desabilitar();
        vaciarTabla();
        vaciarTabla2();
        verDatos();
        verClientes();
        llenarcombobox();
//        
        
        
    }
    public void llenarcombobox(){
    
    
       this.jComboBox1.removeAllItems();
       this.jComboBox2.removeAllItems();
       
        this.jComboBox1.addItem("SELECCIONAR ARREGLO");
        this.jComboBox2.addItem("SELECCIONAR ZONA");
        //para combobox1 Arreglos
        try{
            ResultSet rs = null;
            Connection con3 = null;
            Conexiones conect3 = new Conexiones();
            con3 = conect3.getConnection();
            Statement Sent = con3.createStatement();
            rs = Sent.executeQuery("select * from Arreglos");
            while(rs.next()){
                this.jComboBox1.addItem(rs.getString("Arreglo"));
            }
            contador++;
        }catch (SQLException e){
        }
        //para combo box zonas
        
        
        try{
            ResultSet rs = null;
            Connection con3 = null;
            Conexiones conect3 = new Conexiones();
            con3 = conect3.getConnection();
            Statement Sent = con3.createStatement();
            rs = Sent.executeQuery("select * from Zonas");
            while(rs.next()){
                this.jComboBox2.addItem(rs.getString("Zona"));
            }
            contador2++;
        }catch (SQLException e){
        }
    }
    public void desabilitar(){
        TextNombre.setEnabled(false);
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField8.setEnabled(false);
        jTextField9.setEnabled(false);
        jTextField10.setEnabled(false);
        jTextField12.setEnabled(false);
        TextNombre1.setEnabled(false);
        jTextField15.setEnabled(false);
        jTextField11.setEnabled(false);
        FechaVencimiento.setEnabled(false);
        descuento.setEnabled(false);
        jTextField13.setEnabled(false);
        jTextField14.setEnabled(false);       
        jTextField16.setEnabled(false);             
        jTextArea1.setEnabled(false);
        jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        jRadioButton3.setEnabled(false);
        FechaEntrega.setEnabled(false);
        FechaPedido.setEnabled(false);
        nuevo1.setEnabled(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jTextField17.setVisible(false);
        Zona.setVisible(false);
        nuevo.requestFocus();
        jButton3.setEnabled(false);
    }
    public void habilitar(){
        TextNombre.setEnabled(true);
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        descuento.setEnabled(true);
        jTextField6.setEnabled(true);
        jTextField7.setEnabled(true);
        jTextField8.setEnabled(true);
        jTextField9.setEnabled(true);
        jTextField10.setEnabled(true);
        jTextField12.setEnabled(true);
        TextNombre1.setEnabled(true);
        jTextField15.setEnabled(true);
        jTextField11.setEnabled(true);
        FechaVencimiento.setEnabled(true);
        jTextField13.setEnabled(true);
        jTextField14.setEnabled(true);
        jTextField16.setEnabled(true);
        
        jTextArea1.setEnabled(true);
         jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        jRadioButton3.setEnabled(true);
        FechaEntrega.setEnabled(true);
        FechaPedido.setEnabled(true);
        
        nuevo1.setEnabled(true);
        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(true);
       
    }
    public void limpiar(){
        LabelFactura.setVisible(false);
        NFactura.setVisible(false);
        NFactura.setText("");
        TextNombre.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("0");
        descuento.setText("0");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        TextNombre1.setText("");
        jTextField12.setText("");
        jTextField15.setText("");
        jTextField11.setText("");
        FechaVencimiento.setCalendar(null);
        jTextField13.setText("");
        jTextField14.setText("");
        jLabel28.setText("");
        jTextField16.setText("");       
        jTextArea1.setText("");
        FechaEntrega.setCalendar(null);
        FechaPedido.setCalendar(null);
    
        jLabel23.setText("");
        jLabel30.setText("");
        jLabel31.setText("");
        Zona.setText("");
        IdZona.setText("");
        jTextField17.setText("");
        Status.setText("");
      
        
    }
    public void SumarPrecios(){
        float precio=0,envio=0,adicional=0,descuento = 0, total=0;
        
        precio = Float.parseFloat(jTextField5.getText().trim());
        if (jTextField5.getText().isEmpty()){precio=0;}

        envio = Float.parseFloat(jTextField14.getText().trim());
        if (jTextField14.getText().isEmpty()){envio=0;}
        
        adicional = Float.parseFloat(jTextField6.getText().trim());
        if (jTextField6.getText().isEmpty()){adicional=0;}
        
        descuento = Float.parseFloat(this.descuento.getText().trim());
        if (this.descuento.getText().isEmpty()){descuento = 0; }
        total = precio + envio + adicional - descuento;
        jLabel28.setText("" + total);
        
    }
    public void vaciarTabla(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String titulos[] = {"No.","Cliente","Arreglo","Fecha de Entrega",
            "Precio Total","Telefono del cliente","Nombre del Receptor",
            "Direccion del Receptor", "Zona" ,"Observaciones","Telefono del Receptor","Nit del Comprador",
            "Direccion Fiscal","Nombre de Factura","Correo del Cliente","Precio del Arreglo",
            "Precio de Envio","Adicional","Fecha de Pedido","No Factura","IdArreglo","IdZona","NoEnvio","Tipo de transaccion","Descuento"};
        model = new DefaultTableModel(null,titulos);
         jTable1.setModel(model);
    }
        
//    public void vaciarTabla(){
//        DefaultTableModel Modelo = (DefaultTableModel) jTable1.getModel();
//        String titulos[] = {"No.","Cliente","Arreglo","entregar","Precio total"};
//        Modelo = new DefaultTableModel(null,titulos);
//        jTable1.setModel(Modelo);
//    }
    public void vaciarTabla2(){
        DefaultTableModel modelo2 = (DefaultTableModel) jTable2.getModel();
        String titulos[] = {"ID","Nombre","Telefono","Nit","correo","Dirección fiscal","Nombre de Factura"};
        modelo2 = new DefaultTableModel(null,titulos);
         jTable2.setModel(modelo2);
    }
    
public void verDatos(){
        try {
            Connection con1 = null;
            DefaultTableModel miModelo = (DefaultTableModel) jTable1.getModel();
            Conexiones conect1 = new Conexiones();
            con1 = conect1.getConnection();
            String dts[] = new String[27];
            String sql = "select * from Comprador";
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int pedidocont=0;
            while(rs.next()){
//                int pedido=1;
                pedidocont++;
                dts[0] = rs.getString("NumeroPedido");
                this.NPedido.setText(String.valueOf(rs.getInt("NumeroPedido")));
//               
                dts[1] = rs.getString("NombreComprador");
                dts[2] = rs.getString("NombreArreglo");
                dts[3] = rs.getString("FechaEntrega");
                dts[4] = rs.getString("PrecioTotal");
                dts[5] = rs.getString("TelefonoComprador");
                dts[6] = rs.getString("NombreReceptor");
                dts[7] = rs.getString("DireccionReceptor");
                dts[8] = rs.getString("Zona");
                dts[9] = rs.getString("Observaciones");
                dts[10] = rs.getString("TelefonoReceptor");
                dts[11] = rs.getString("NitComprador");
                dts[12] = rs.getString("DireccionFiscal");
                dts[13] = rs.getString("NombreFactura");               
                dts[14] = rs.getString("CorreoComprador");
                dts[15] = rs.getString("PrecioArreglo");
                dts[16] = rs.getString("PrecioEnvio");
                dts[17] = rs.getString("Adicional");
                
//                dts[18] = rs.getString("NoTargeta");
//                dts[19] = rs.getString("VencimientoTargeta");
//                dts[20] = rs.getString("CodigoSeguro");
//                dts[21] = rs.getString("NoDeposito");
                dts[18] = rs.getString("FechaPedido");
                
                dts[19] = rs.getString("NoFactura");
                dts[20] = rs.getString("IdArreglo");
                dts[21] = rs.getString("IdZona");
                dts[22] = rs.getString("NoEnvio");
                dts[23] = rs.getString("TipoDePago");
                dts[24] = rs.getString("Descuento");
                
               
//                pedido ++;
                miModelo.addRow(dts);
            }
            
             if (pedidocont==0){
                NPedido.setText("0");
                }
            int Pedido=Integer.parseInt(NPedido.getText().trim());
            Pedido=Pedido+1;
            NPedido.setText(""+Pedido);
            
            jTable1.setModel(miModelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
/**    public void verDatos(){
*        try {
 *           int pedido=1;
  *          Connection cone = null;
*            DefaultTableModel miModelo = (DefaultTableModel) jTable1.getModel();
*            Conexiones conect1 = new Conexiones();
*            cone = conect1.getConnection();
*            String dts[]=new String[5];
*            String sql = "select * from Comprador";
*            Statement st = cone.createStatement();
*            ResultSet rs = st.executeQuery(sql);
*           
*            while (rs.next()){
*                dts[0] = rs.getString("NumeroPedido");
*                this.NPedido.setText(String.valueOf(rs.getInt("NumeroPedido")));
*                
*                
*                
*                dts[1] = rs.getString("NombreComprador");
*                dts[2] = rs.getString("NombreArreglo");
*                dts[3] = rs.getString("FechaEntrega");
*                dts[4] = rs.getString("PrecioTotal");
*                pedido++;
*                miModelo.addRow(dts);
*                
*            } 
 *           int Pedido=Integer.parseInt(NPedido.getText().trim());
 *           Pedido=Pedido+1;
 *           NPedido.setText(""+Pedido);
 *   //            String dts[] = new String[5];
 *   //            String sql = "select * from Pedido";
 *   //            Statement st = con1.createStatement();
 *   //            ResultSet rs = st.executeQuery(sql);
 *   //            while(rs.next()){
 *   //                dts[0] = rs.getString("Id_proveedores");
 *   //                dts[1] = rs.getString("nombre_proveedor");
 *   //                dts[2] = rs.getString("telefono");
 *   //                dts[3] = rs.getString("direccion");
 *   //                dts[4] = rs.getString("correo");
 *   //                miModelo.addRow(dts);
 *   //            }
 *           jTable1.setModel(miModelo);
 *       } catch (SQLException e) {
 *           Status.setText("NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA");
 *       }
 *   }
*/
public void MostrarElementoTabla(){

 limpiar();
 
  jButton3.setEnabled(true);
        try
        {
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            int fila = jTable1.getSelectedRow();
            NPedido.setText(jTable1.getValueAt(fila, 0).toString()); //no.
            TextNombre.setText(jTable1.getValueAt(fila, 1).toString());// cliente
            jTextField17.setText(jTable1.getValueAt(fila, 2).toString());//arreglo
             jTextField17.setVisible(true);
            jTextField17.setEnabled(false); 
            String fechaHora= (jTable1.getValueAt(fila,3).toString()); // fecha
             String solofecha = fechaHora.substring(0,10);
             java.util.Date fechaDate = formato.parse(solofecha.trim());
            FechaEntrega.setDate(fechaDate);
            jLabel28.setText(jTable1.getValueAt(fila, 4).toString());//Precio total
            jTextField9.setText(jTable1.getValueAt(fila, 5).toString());//telefono del cliente
            jTextField7.setText(jTable1.getValueAt(fila, 6).toString());//nombre del receptor
            jTextField8.setText(jTable1.getValueAt(fila, 7).toString());//direccion de entrega
            Zona.setText(jTable1.getValueAt(fila, 8).toString());//Zona
            jTextArea1.setText(jTable1.getValueAt(fila, 9).toString());//observaciones
            jTextField2.setText(jTable1.getValueAt(fila, 10).toString());//telefono del receptor
            jTextField1.setText(jTable1.getValueAt(fila, 11).toString());//Nit del comprador    
            jTextField15.setText(jTable1.getValueAt(fila, 12).toString());//direccion fiscal
            TextNombre1.setText(jTable1.getValueAt(fila, 13).toString());//nombreFactura
            jTextField3.setText(jTable1.getValueAt(fila, 14).toString());//correo del cliente
            jTextField5.setText(jTable1.getValueAt(fila, 15).toString());//precio del arreglo
            jTextField14.setText(jTable1.getValueAt(fila, 16).toString());//Preciio de envio
            jTextField6.setText(jTable1.getValueAt(fila, 17).toString());//precio adicional
            
//            if(jTable1.getValueAt(fila,18)==null){}
//            else{
//            jTextField11.setText(jTable1.getValueAt(fila, 18).toString());//No targeta
//            }
//            if(jTable1.getValueAt(fila,19)==null){
//            
//            }
            //vencimiento de la targeta
//            else{
//            String vencimiento = (jTable1.getValueAt(fila,19).toString());
//                try {
//                    String solofechavencimiento = vencimiento.substring(0,10);
//                    java.util.Date fechavencimiento = formato.parse(solofechavencimiento.trim());
//            FechaVencimiento.setDate(fechavencimiento);
//                } catch (Exception e) {
//                    String solofechavencimiento = vencimiento.substring(0,9);
//                    java.util.Date fechavencimiento = formato.parse(solofechavencimiento.trim());
//            FechaVencimiento.setDate(fechavencimiento);
//                }
//            
//         
//            }
//            
//            if(jTable1.getValueAt(fila,20)!=null){
//            jTextField13.setText(jTable1.getValueAt(fila, 20).toString());//Codigo seguro
//            }            
//            if(jTable1.getValueAt(fila,21)!=null){
//            jTextField16.setText(jTable1.getValueAt(fila,21).toString());//numero de deposito
//            } 
//            
            String Fpedido = (jTable1.getValueAt(fila,18).toString());//fecha en la que se hizo el pedido
            try {
                         String solofechapedido = Fpedido.substring(0,10);
            java.util.Date fechapedido = formato.parse(solofechapedido.trim());
              FechaPedido.setDate(fechapedido);
            } catch (Exception e) {
                         String solofechapedido = Fpedido.substring(0,9);
            java.util.Date fechapedido = formato.parse(solofechapedido.trim());
              FechaPedido.setDate(fechapedido);
            }
   
          
            LabelFactura.setVisible(true);
            NFactura.setVisible(true);
            jTextField10.setText(jTable1.getValueAt(fila, 19).toString());//numero de factura
            NFactura.setText(jTextField10.getText());
            jTextField4.setText(jTable1.getValueAt(fila,20).toString());//idArreglo
            IdZona.setText(jTable1.getValueAt(fila, 21).toString());//id zona
            jTextField12.setText(jTable1.getValueAt(fila, 22).toString());//no envío
            Pago = jTable1.getValueAt(fila, 23).toString();
            descuento.setText(jTable1.getValueAt(fila,24).toString());
            
////            
//            "No.","Cliente","Arreglo","Fecha de Entrega",
//            "Precio Total","Telefono del cliente","Nombre del Receptor",
//            "Direccion del Receptor", "Zona" ,"Observaciones","Telefono del Receptor","Nit del Comprador",
//            "Direccion Fiscal","Nombre de Factura","Correo del Cliente","Precio del Arreglo",
//            "Precio de Envio","Adicional","No Targeta","Vencimiento de Targeta"
//                ,"CodigoSeguro","No Deposito","Fecha de Pedido","No Factura","IdArreglo","IdZona"
//          jLabel31.setText(formato.format(FechaVencimiento.getDate()));
             
            Zona.setVisible(true);
            Zona.setEnabled(false);
           
            
            
            
            nuevo.setEnabled(false);
            guardar.setEnabled(false);
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            
            
//            if(jTextField16.getText().isEmpty()){
//            jRadioButton1.setSelected(true);
//            }
//            else{
//                jRadioButton2.setSelected(true);
//            }
//             if(jTextField11.getText().isEmpty()&& jTextField16.getText().isEmpty()){
//            jRadioButton3.setSelected(true);
//            }
             
            jButton3.setEnabled(false);
            jButton1.setSelected(false);
jButton2.setSelected(false); 
 jButton3.setSelected(false);
            
// jRadioButton1.setEnabled(false);
// jRadioButton2.setEnabled(false);
// jRadioButton3.setEnabled(false);
// jTextField1.setEnabled(false);
// FechaVencimiento.setEnabled(false);
//  jTextField11.setEnabled(false);
// jTextField13.setEnabled(false);
// jTextField16.setEnabled(false);
            verClientes();
            jButton5.setEnabled(true);
        } catch (Exception ex)
        {
          
            Status.setText("ERROR AL SELECCIONAR UN EQUIPO : " + ex.getMessage());
            desabilitar();
        }

}
public void verClientes(){
    vaciarTabla2();
    
     try {
            Connection con1 = null;
            DefaultTableModel miModelo = (DefaultTableModel) jTable2.getModel();
            Conexiones conect1 = new Conexiones();
            con1 = conect1.getConnection();
            String dts[] = new String[7];
            String sql = "select * from Clientes";
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(sql);
//            int noclientecont =0;
            while(rs.next()){
//   
//                noclientecont++;
                dts[0] = rs.getString("IdCliente");               
                dts[1] = rs.getString("NombreCliente");
                dts[2] = rs.getString("Telefono");
                dts[3] = rs.getString("Nit");
                dts[4] = rs.getString("Correo");
                dts[5] = rs.getString("DireccionFiscal");
                dts[6] = rs.getString("NombreFactura");
                this.IdCliente.setText(String.valueOf(rs.getInt("IdCliente")));
               
//                pedido ++;
                miModelo.addRow(dts);
            }
//            
//            if (noclientecont==0){
//                IdCliente.setText("0");
//                }
//            int Id=Integer.parseInt(IdCliente.getText().trim());
//            Id=Id+1;
//            IdCliente.setText(""+Id);
            jTable2.setModel(miModelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS CLIENTES", "Error", JOptionPane.ERROR_MESSAGE);
        }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tPago = new javax.swing.ButtonGroup();
        LabelPedido = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        nuevo = new javax.swing.JButton();
        FechaVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel38 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        Status = new javax.swing.JLabel();
        nuevo1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        NPedido = new javax.swing.JLabel();
        IdCliente = new javax.swing.JLabel();
        LabelFactura = new javax.swing.JLabel();
        NFactura = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        descuento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextNombre = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TextNombre1 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Zona = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        IdZona = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField8 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        FechaEntrega = new com.toedter.calendar.JDateChooser();
        FechaPedido = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        LabelPedido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        guardar.setText("GUARDAR PEDIDO");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel24.setText("OBSERVACIONES:");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel19.setText("No. Tarjeta:");

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel20.setText("vence:");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel21.setText("Código seguro:");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel25.setText("Pago con tarjeta");

        tPago.add(jRadioButton1);

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setText("Pago con depósito");

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel22.setText("No de depósito");

        tPago.add(jRadioButton2);

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel26.setText("Ninguno");

        tPago.add(jRadioButton3);

        nuevo.setText("NUEVO PEDIDO");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31))
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel26)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nuevo)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FechaVencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(78, 78, 78)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jRadioButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(FechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel38.setText("Tipo de pago:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar Pedido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setText("Status:");

        Status.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        nuevo1.setText("Cancelar");
        nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19", "Title 20"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setMinimumSize(new java.awt.Dimension(500, 432));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setMinWidth(70);
        }

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel37.setText("Pedidos:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel39.setText("Clientes:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel39))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setText("Arreglo:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Descripción de la compra:");

        jTextField14.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField14FocusLost(evt);
            }
        });
        jTextField14.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField14InputMethodTextChanged(evt);
            }
        });
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField14KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField14KeyTyped(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel27.setText("Precio envio:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setText("Adicional:");

        jTextField6.setText("0");
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel17.setText("Precio total:");

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel36.setText("Pedido No.");

        NPedido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        NPedido.setText("0");

        LabelFactura.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LabelFactura.setText("Factura No.");

        NFactura.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        NFactura.setText("0");

        jLabel40.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel40.setText("Descuento:");

        descuento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                descuentoFocusLost(evt);
            }
        });
        descuento.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                descuentoInputMethodTextChanged(evt);
            }
        });
        descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descuentoActionPerformed(evt);
            }
        });
        descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descuentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descuentoKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("Subtotal");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(LabelFactura)
                                .addGap(18, 18, 18)
                                .addComponent(NFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextField17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(IdCliente))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel40)
                        .addGap(6, 6, 6)
                        .addComponent(descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(NPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(LabelFactura)
                    .addComponent(NFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(IdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Datos del comprador:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        TextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNombreActionPerformed(evt);
            }
        });
        TextNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextNombreKeyTyped(evt);
            }
        });

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Telefono:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Nit:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Correo:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Nombre Factura:");

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel29.setText("Dirección fiscal:");

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel32.setText("No de factura:");

        jButton3.setText("Registrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextNombre1))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(0, 0, 0))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(TextNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel33.setText("Asignar No de envío:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Datos de entrega: ");

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel34.setText("Asignar zona:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Fecha de entrega:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setText("Nombre de receptor:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("Fecha de pedido:");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel16.setText("Telefono del receptor:");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel15.setText("Dirección:");

        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel14))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel33))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel34))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField7)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IdZona, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Zona, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Zona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(FechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setText("Ver tabla completa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Ver pedido");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nuevo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LabelPedido))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(150, 150, 150))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jLabel35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(guardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nuevo1)))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // BOTON DE GUARDAR:
        // 
        //
        
        int valor = JOptionPane.showConfirmDialog(this,"Desea guardar los cambios? ","Advertencia",JOptionPane.YES_NO_OPTION);
            if(valor == JOptionPane.YES_OPTION)
  
            {
        
        //Validar campo: Nombre del comprador
        if (TextNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta el nombre del cliente", "Advertencia", JOptionPane.WARNING_MESSAGE);
            TextNombre.requestFocus();
        }
        
        //validar campo Telefono del Comprador
        
        else if (jTextField9.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta el telefono del cliente ", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jTextField9.requestFocus();
        }
        
        else if (FechaPedido.getDate() ==null)
        {
            JOptionPane.showMessageDialog(this, "Falta la fecha en la que se hizo pedido","Advertencia",JOptionPane.WARNING_MESSAGE);
            FechaPedido.requestFocus();
        }
          else if (FechaEntrega.getDate()==null)
        {
            JOptionPane.showMessageDialog(this, "Falta la fecha de la entrega","Advertencia",JOptionPane.WARNING_MESSAGE);
            FechaPedido.requestFocus();
        }
        else if (jTextField17.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta el nombre del arreglo","Advertencia",JOptionPane.WARNING_MESSAGE);
            jComboBox1.requestFocus();
               
        }
        else if (jTextField5.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta el precio del arreglo","Advertencia",JOptionPane.WARNING_MESSAGE);
            jComboBox1.requestFocus();
               
        }
        else if (jTextField14.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta el precio de envío","Advertencia",JOptionPane.WARNING_MESSAGE);
            jTextField14.requestFocus();
               
        }
                  else if(jTextField12.getText().trim().isEmpty()){
                      
                       JOptionPane.showMessageDialog(this, "Falta el numero de envio","Advertencia",JOptionPane.WARNING_MESSAGE);
                       jTextField12.requestFocus();
                      }
        else if (jTextField8.getText().isEmpty()){
          JOptionPane.showMessageDialog(this, "Falta la dirección de envío","Advertencia",JOptionPane.WARNING_MESSAGE);
    jTextField8.requestFocus();
          }
             
        else if (Zona.getText().isEmpty()){
          JOptionPane.showMessageDialog(this, "Falta la Zona de envío","Advertencia",JOptionPane.WARNING_MESSAGE);
    Zona.requestFocus();
          }
         
        else
        {
            
            java.sql.Date edt1= new java.sql.Date(FechaPedido.getDate().getTime());
            
                java.sql.Date edt2= new java.sql.Date(FechaEntrega.getDate().getTime());
                String dt1 = formato.format(edt1);
                String dt2 = formato.format(edt2);
            try
            {                
                
//                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
             
//                Connection con = null;
//                Conexion conect = new Conexion();
//                con = conect.getConnection();
//                Statement st = con.createStatement();
//                Connection con = null;
//                Conexiones conect = new Conexiones();
//                con = conect.getConnection();
//                Statement st = con.createStatement();
//                
                  jLabel23.setText(formato2.format(FechaPedido.getDate()));
        
                    jLabel30.setText(formato2.format(FechaEntrega.getDate()));
                
                 if(jRadioButton1.isSelected()){
                     //para targeta de pago
                     
                      if (jTextField11.getText().isEmpty())
                          //restricciones para validar la targeta
                            {
                                JOptionPane.showMessageDialog(this, "Falta el numero de targeta","Advertencia",JOptionPane.WARNING_MESSAGE);
                                jTextField11.requestFocus();

                            }
                      else if(FechaVencimiento.getDate()==null){
                      
                       JOptionPane.showMessageDialog(this, "Falta la fecha de vencimiento de la tergeta","Advertencia",JOptionPane.WARNING_MESSAGE);
                       FechaVencimiento.requestFocus();
                      }

                          
               else if (jTextField13.getText().isEmpty()){
              JOptionPane.showMessageDialog(this, "Falta el Código Seg.","Advertencia",JOptionPane.WARNING_MESSAGE);
            jTextField13.requestFocus();
              }
               
                      else{   
                   
              Connection con = null;
                Conexiones conect = new Conexiones();
                con = conect.getConnection();
                Statement st = con.createStatement();
                
               String sql = "insert into Comprador"
                                + "(NombreComprador,TelefonoComprador,NitComprador,"
                                + "CorreoComprador,NombreFactura,NombreArreglo,PrecioArreglo,"
                                + "Adicional,PrecioEnvio,PrecioTotal,DireccionFiscal,"
                                + "NombreReceptor,TelefonoReceptor,DireccionReceptor,NoTargeta,"
                               + "CodigoSeguro,Observaciones,FechaPedido,FechaEntrega,VencimientoTargeta,"
                       + "Zona,NoFactura,IdArreglo,IdZona,NoEnvio,"
                       + "FechaPedidoDate,FechaEntregaDate,FechaVencimientoDate,TipoDePago,Descuento) "
                            + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, TextNombre.getText().trim());
                pst.setString(2, jTextField9.getText().trim());
                pst.setString(3, jTextField1.getText().trim());
                pst.setString(4, jTextField3.getText().trim());
                pst.setString(5, TextNombre1.getText().trim());
                pst.setString(6, jTextField17.getText().trim());
                pst.setString(7, jTextField5.getText().trim());
                pst.setString(8, jTextField6.getText().trim());
                pst.setString(9, jTextField14.getText().trim());
                pst.setString(10, jLabel28.getText().trim());
                pst.setString(11, jTextField15.getText().trim());
                pst.setString(12, jTextField7.getText().trim());
                //if(jTextField2.getText().isEmpty()){ jTextField2.setText("Ninguno");}
                pst.setString(13, jTextField2.getText().trim());
                pst.setString(14, jTextField8.getText().trim());
                pst.setString(15, jTextField11.getText().trim());
                pst.setString(16, jTextField13.getText().trim());
                pst.setString(17, jTextArea1.getText().trim());                
                pst.setString(18, dt1);
                
//                pst.setString(17, jLabel23.getText().trim());                
                pst.setString(19, dt2);
                
//                pst.setString(18, jLabel23.getText().trim());
//                pst.setString(19, jLabel30.getText().trim());
//                java.sql.Date fv= new java.sql.Date(FechaVencimiento.getDate().getTime());
//                pst.setDate(20, fv);
//                jLabel31.setText(formato.format(FechaVencimiento.getDate()));
//                pst.setString(20, jLabel31.getText().trim());
                java.sql.Date efv= new java.sql.Date(FechaPedido.getDate().getTime());             
                String fv = formato.format(efv);  
                pst.setString(20, fv);
                pst.setString(21, Zona.getText().trim());
                pst.setString(22, jTextField10.getText().trim());
                pst.setInt(23, Integer.parseInt(jTextField4.getText().trim()));
                pst.setInt(24, Integer.parseInt(IdZona.getText().trim()));
                pst.setInt(25, Integer.parseInt(jTextField12.getText().trim()));
               pst.setDate(26,edt1);
               pst.setDate(27,edt2);
               pst.setDate(28,efv);
               pst.setString(29,"Tarjeta");
               pst.setString(30,descuento.getText());
               int n = pst.executeUpdate();
                if (n > 0)
                {
                    Status.setText("DATOS GUARDADOS CORRECTAMENTE!");
                    limpiar();
                    vaciarTabla();
                    verDatos();
                    nuevo.setEnabled(true);
                    guardar.setEnabled(false);
           
                    desabilitar();
                }
                      }
            }
                else if(jRadioButton2.isSelected()){
                    
                 
                    //para deposito
                    if (jTextField16.getText().isEmpty())
                          //restricciones para validar el depósito
        {
            JOptionPane.showMessageDialog(this, "Falta el numero de depósito","Advertencia",JOptionPane.WARNING_MESSAGE);
            jTextField16.requestFocus();
               
        }
                    else{    
                      Connection con = null;
                Conexiones conect = new Conexiones();
                con = conect.getConnection();
                Statement st = con.createStatement();
                
                 String sql = "insert into Comprador"
                                + "(NombreComprador,TelefonoComprador,NitComprador,"
                                + "CorreoComprador,NombreFactura,NombreArreglo,PrecioArreglo,"
                                + "Adicional,PrecioEnvio,PrecioTotal,DireccionFiscal,"
                                + "NombreReceptor,TelefonoReceptor,DireccionReceptor,NoDeposito,"
                                 + "Observaciones,FechaPedido,FechaEntrega,Zona,NoFactura,IdArreglo,IdZona,"
                         + "NoEnvio,FechaPedidoDate,FechaEntregaDate,TipoDePago,Descuento) "
                            + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, TextNombre.getText().trim());
                pst.setString(2, jTextField9.getText().trim());
                pst.setString(3, jTextField1.getText().trim());
                pst.setString(4, jTextField3.getText().trim());
                pst.setString(5, TextNombre1.getText().trim());
                pst.setString(6, jTextField17.getText().trim());
                pst.setString(7, jTextField5.getText().trim());
                pst.setString(8, jTextField6.getText().trim());
                pst.setString(9, jTextField14.getText().trim());
                pst.setString(10, jLabel28.getText().trim());
                pst.setString(11, jTextField15.getText().trim());
                pst.setString(12, jTextField7.getText().trim());
                pst.setString(13, jTextField2.getText().trim());
                pst.setString(14, jTextField8.getText().trim());
                pst.setString(15, jTextField16.getText().trim());
                pst.setString(16, jTextArea1.getText().trim());
                
                pst.setString(17, dt1);
//                pst.setString(17, jLabel23.getText().trim());
                
                pst.setString(18, dt2);
//                pst.setString(18, jLabel30.getText().trim());
                pst.setString(19, Zona.getText().trim());
                pst.setString(20, jTextField10.getText().trim());
                pst.setInt(21, Integer.parseInt(jTextField4.getText().trim()));
                pst.setInt(22, Integer.parseInt(IdZona.getText().trim()));
                pst.setInt(23, Integer.parseInt(jTextField12.getText().trim()));
                pst.setDate(24, edt1);
                pst.setDate(25, edt2);
                pst.setString(26,"Deposito");
                 pst.setString(27,descuento.getText());
                
                int n = pst.executeUpdate();
                if (n > 0)
                {
                    Status.setText("DATOS GUARDADOS CORRECTAMENTE");
                    limpiar();
                    vaciarTabla();
                    verDatos();
                    nuevo.setEnabled(true);
                    guardar.setEnabled(false);
             
                    desabilitar();
                }
                
                            }
                 } 
                else{
                
                    //sin deposito ni targeta
                Connection con = null;
                Conexiones conect = new Conexiones();
                con = conect.getConnection();
                Statement st = con.createStatement();
//                jLabel23.setText(formato.format(FechaPedido.getDate()));
//                 jLabel30.setText(formato.format(FechaEntrega.getDate()));
                
               String sql = "insert into Comprador"
                                + "(NombreComprador,TelefonoComprador,NitComprador,"
                                + "CorreoComprador,NombreFactura,NombreArreglo,PrecioArreglo,"
                                + "Adicional,PrecioEnvio,PrecioTotal,DireccionFiscal,"
                                + "NombreReceptor,TelefonoReceptor,DireccionReceptor,"
                               + "NoTargeta,Observaciones,FechaPedido,FechaEntrega,Zona,NoFactura,IdArreglo,IdZona,NoEnvio,FechaPedidoDate,FechaEntregaDate,TipoDePago,Descuento) "
                            + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, TextNombre.getText().trim());
                pst.setString(2, jTextField9.getText().trim());
                pst.setString(3, jTextField1.getText().trim());
                pst.setString(4, jTextField3.getText().trim());
                pst.setString(5, TextNombre1.getText().trim());
                pst.setString(6, jTextField17.getText().trim());
                pst.setString(7, jTextField5.getText().trim());
                pst.setString(8, jTextField6.getText().trim());
                pst.setString(9, jTextField14.getText().trim());
                pst.setString(10, jLabel28.getText().trim());
                pst.setString(11, jTextField15.getText().trim());
                pst.setString(12, jTextField7.getText().trim());
                pst.setString(13, jTextField2.getText().trim());
                pst.setString(14, jTextField8.getText().trim());
                pst.setString(15, jTextField11.getText().trim());
               pst.setString(16, jTextArea1.getText().trim());
               
                pst.setString(17, dt1);
//                pst.setString(17, jLabel23.getText().trim());
                
                pst.setString(18, dt2);
//               pst.setString(17, jLabel23.getText().trim());
//               pst.setString(18, jLabel30.getText().trim());
               pst.setString(19, Zona.getText().trim());
                pst.setString(20, jTextField10.getText().trim());
                pst.setInt(21, Integer.parseInt(jTextField4.getText().trim()));
                pst.setInt(22, Integer.parseInt(IdZona.getText().trim()));
                pst.setInt(23, Integer.parseInt(jTextField12.getText().trim()));
                pst.setDate(24, edt1);
                pst.setDate(25, edt2);
                pst.setString(26, "Ninguno");
                 pst.setString(27,descuento.getText());
                int n = pst.executeUpdate();
                if (n > 0)
                {
                    Status.setText("DATOS GUARDADOS CORRECTAMENTE");
                    limpiar();
                    vaciarTabla();
                    
                    nuevo.setEnabled(true);
                    guardar.setEnabled(false);
                  verDatos();
                    desabilitar();
                }
                
                }
            } catch (SQLException | HeadlessException e)
            {
                Status.setText(""+e);
                JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO GUARDADOS CORRECTAMENTE", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


            }
    }//GEN-LAST:event_guardarActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // Boton NUEVO PEDIDO
        
       
        
        contador=0;
        contador2=0;
        limpiar();
        habilitar();
       java.util.Date fecha=new java.util.Date();
//        formato.format(fecha);
        FechaPedido.setDate(fecha);
        jRadioButton3.setSelected(true);
        nuevo.setEnabled(false);
        guardar.setEnabled(true);
        jButton3.setEnabled(true);
        vaciarTabla();
        verDatos();

        llenarcombobox();
        
    }//GEN-LAST:event_nuevoActionPerformed

    private void jTextField14InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField14InputMethodTextChanged
                                                  
    }//GEN-LAST:event_jTextField14InputMethodTextChanged

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo1ActionPerformed
        // TODO add your handling code here:
//         String pr;
//        pr=FechaPedido.getDateFormatString();
//        JOptionPane.showMessageDialog(this, "DATOS GUARDADOS CORRECTAMENTE"+pr);
//    

//            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
////            formato.format(FechaPedido.getDate());
//            String uno,dos;
//            uno = formato.format(FechaPedido.getDate());
//            
//        JOptionPane.showMessageDialog(this, "DS "+uno);
//        JOptionPane.showMessageDialog(this, "DATOS "+formato.format(FechaEntrega.getDate()));
            

            int valor = JOptionPane.showConfirmDialog(this,"Si cancela se borra el formulario, desea continuar?","Advertencia",JOptionPane.YES_NO_OPTION);
            if(valor == JOptionPane.YES_OPTION){

            limpiar();
            desabilitar();
            
            nuevo.setEnabled(true);
            guardar.setEnabled(false);
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton5.setEnabled(false);
            Status.setText("Formulario Borrado");
            }
            
    }//GEN-LAST:event_nuevo1ActionPerformed

    private void TextNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextNombreKeyTyped
        // solo letras
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)){
            Status.setText("Ingrese Letras por favor");
            getToolkit().beep();
            evt.consume();
        }
        
    }//GEN-LAST:event_TextNombreKeyTyped

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            Status.setText("Ingrese numeros por favor");
        }
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
char validar = evt.getKeyChar();
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            Status.setText("Ingrese numeros por favor");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
char validar = evt.getKeyChar();
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            Status.setText("Ingrese numeros por favor");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyTyped
char validar = evt.getKeyChar();
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            Status.setText("Ingrese numeros por favor");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
char validar = evt.getKeyChar();
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            Status.setText("Ingrese numeros por favor");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
char validar = evt.getKeyChar();
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            Status.setText("Ingrese numeros por favor");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyTyped

    private void TextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNombreActionPerformed
        // TODO add your handling code here:
        
   
    }//GEN-LAST:event_TextNombreActionPerformed

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
        
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            Status.setText("Ingrese Letras por favor");
        }
    }//GEN-LAST:event_jTextField7KeyTyped
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Boton de editar
        
        switch(editar){
            case 0: habilitar();
            editar = 1;
            jButton1.setText("Guardar Cambios");
            break;
            case 1:
        
        
               
        
           int valor = JOptionPane.showConfirmDialog(this,"Desea guardar los cambios?","Advertencia",JOptionPane.YES_NO_OPTION);
            if(valor == JOptionPane.YES_OPTION){

          
       
      
        
        //Validar campo: Nombre del comprador
        if (TextNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta el nombre del cliente", "Advertencia", JOptionPane.WARNING_MESSAGE);
            TextNombre.requestFocus();
        }
        
        //validar campo Telefono del Comprador
        
        else if (jTextField9.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta el telefono del cliente ", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jTextField9.requestFocus();
        }
        
        else if (FechaPedido.getDate() ==null)
        {
            JOptionPane.showMessageDialog(this, "Falta la fecha en la que se hizo pedido","Advertencia",JOptionPane.WARNING_MESSAGE);
            FechaPedido.requestFocus();
        }
          else if (FechaEntrega.getDate()==null)
        {
            JOptionPane.showMessageDialog(this, "Falta la fecha de la entrega","Advertencia",JOptionPane.WARNING_MESSAGE);
            FechaPedido.requestFocus();
        }
        else if (jTextField17.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta el nombre del arreglo","Advertencia",JOptionPane.WARNING_MESSAGE);
            jComboBox1.requestFocus();
               
        }
        else if (jTextField5.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta el precio del arreglo","Advertencia",JOptionPane.WARNING_MESSAGE);
            jComboBox1.requestFocus();
               
        }
        else if (jTextField14.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta el precio de envío","Advertencia",JOptionPane.WARNING_MESSAGE);
            jTextField14.requestFocus();
               
        }
                  
        else if (jTextField8.getText().isEmpty()){
          JOptionPane.showMessageDialog(this, "Falta la dirección de envío","Advertencia",JOptionPane.WARNING_MESSAGE);
    jTextField8.requestFocus();
          }
             
        else if (Zona.getText().isEmpty()){
          JOptionPane.showMessageDialog(this, "Falta la Zona de envío","Advertencia",JOptionPane.WARNING_MESSAGE);
    Zona.requestFocus();
          }
         
        
        
        else
        {
//            java.sql.Date dt1= new java.sql.Date(FechaPedido.getDate().getTime());
//                java.sql.Date dt2= new java.sql.Date(FechaEntrega.getDate().getTime());
             java.sql.Date edt1= new java.sql.Date(FechaPedido.getDate().getTime());
                java.sql.Date edt2= new java.sql.Date(FechaEntrega.getDate().getTime());
                String dt1 = formato.format(edt1);
                String dt2 = formato.format(edt2);
                
                
                
          
            try
            {                
              
//                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
             
//                Connection con = null;
//                Conexion conect = new Conexion();
//                con = conect.getConnection();
//                Statement st = con.createStatement();
//                Connection con = null;
//                Conexiones conect = new Conexiones();
//                con = conect.getConnection();
//                Statement st = con.createStatement();
//                
                  jLabel23.setText(formato.format(FechaPedido.getDate()));
        
                    jLabel30.setText(formato.format(FechaEntrega.getDate()));
                
                 if(jRadioButton1.isSelected()){
                     //para targeta de pago
                     
                      if (jTextField11.getText().isEmpty())
                          //restricciones para validar la targeta
                            {
                                JOptionPane.showMessageDialog(this, "Falta el numero de targeta","Advertencia",JOptionPane.WARNING_MESSAGE);
                                jTextField11.requestFocus();

                            }
                      else if(FechaVencimiento.getDate()==null){
                      
                       JOptionPane.showMessageDialog(this, "Falta la fecha de vencimiento de la tergeta","Advertencia",JOptionPane.WARNING_MESSAGE);
                       FechaVencimiento.requestFocus();
                      }

                          
               else if (jTextField13.getText().isEmpty()){
              JOptionPane.showMessageDialog(this, "Falta el Código Seg.","Advertencia",JOptionPane.WARNING_MESSAGE);
            jTextField13.requestFocus();
              }
               
                      else{   
                   
              Connection con = null;
                Conexiones conect = new Conexiones();
                con = conect.getConnection();
                Statement st = con.createStatement();
               String sql = "update Comprador set NombreComprador = ?, TelefonoComprador = ?, NitComprador = ?, "
                       + "CorreoComprador = ?, NombreFactura = ?, NombreArreglo=?, "
                       + "PrecioArreglo=?, Adicional=?,PrecioEnvio=?,"
                       + "PrecioTotal=?,DireccionFiscal=?,"
                    + "NombreReceptor=?,TelefonoReceptor=?,DireccionReceptor=?,NoTargeta=?,"
                    + "CodigoSeguro=?,Observaciones=?,FechaPedido=?,"
                       + "FechaEntrega=?,VencimientoTargeta=?,Zona=?,"
                       + "NoFactura=?,IdArreglo=?,IdZona=?, NoDeposito=?, TipoDePago=? , Descuento=? where NumeroPedido = ?"; 
//              
//                                
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, TextNombre.getText().trim());
                pst.setString(2, jTextField9.getText().trim());
                pst.setString(3, jTextField1.getText().trim());
                pst.setString(4, jTextField3.getText().trim());
                pst.setString(5, TextNombre1.getText().trim());
                pst.setString(6, jTextField17.getText().trim());
                pst.setString(7, jTextField5.getText().trim());
                pst.setString(8, jTextField6.getText().trim());
                pst.setString(9, jTextField14.getText().trim());
                pst.setString(10, jLabel28.getText().trim());
                pst.setString(11, jTextField15.getText().trim());
                pst.setString(12, jTextField7.getText().trim());
                //if(jTextField2.getText().isEmpty()){ jTextField2.setText("Ninguno");}
                pst.setString(13, jTextField2.getText().trim());
                pst.setString(14, jTextField8.getText().trim());
                pst.setString(15, jTextField11.getText().trim());
                pst.setString(16, jTextField13.getText().trim());
                pst.setString(17, jTextArea1.getText().trim());                
                pst.setString(18, dt1);
//                pst.setString(17, jLabel23.getText().trim());                
                pst.setString(19, dt2);
                
//                pst.setString(18, jLabel23.getText().trim());
//                pst.setString(19, jLabel30.getText().trim());
                 java.sql.Date efv= new java.sql.Date(FechaPedido.getDate().getTime());             
                String fv = formato.format(efv);          
//                java.sql.Date fv= new java.sql.Date(FechaVencimiento.getDate().getTime());
                pst.setString(20, fv);
//                jLabel31.setText(formato.format(FechaVencimiento.getDate()));
//                pst.setString(20, jLabel31.getText().trim());
                pst.setString(21, Zona.getText().trim());
                pst.setString(22, jTextField10.getText().trim());
                pst.setInt(23, Integer.parseInt(jTextField4.getText().trim()));
                pst.setInt(24, Integer.parseInt(IdZona.getText().trim()));
                pst.setString(25, "");//borrar no de deposito
                pst.setString(26,"Tarjeta");
                pst.setString(27,descuento.getText());
                pst.setInt(28, Integer.parseInt(NPedido.getText()));
                
//                pst.setDate(27,edt1);
//               pst.setDate(28,edt2);
//               pst.setDate(29,efv);
                int n = pst.executeUpdate();
                if (n > 0)
                {
                    Status.setText("DATOS ACTUALIZADOS CORRECTAMENTE!");
                    limpiar();
                    vaciarTabla();
                    verDatos();
                    nuevo.setEnabled(true);
                    guardar.setEnabled(false);
           
                    desabilitar();
                }
                      }
            }
                else if(jRadioButton2.isSelected()){
                    
                 
                    //para deposito
                    if (jTextField16.getText().isEmpty())
                          //restricciones para validar el depósito
        {
            JOptionPane.showMessageDialog(this, "Falta el numero de depósito","Advertencia",JOptionPane.WARNING_MESSAGE);
            jTextField16.requestFocus();
               
        }
                    else{    
                      Connection con = null;
                Conexiones conect = new Conexiones();
                con = conect.getConnection();
                Statement st = con.createStatement();
               // "update Comprador set nombre_proveedor = ?, telefono = ?, direccion = ?, correo = ? where NumeroPedido = ?";
                 String sql = "update Comprador set NombreComprador=?,TelefonoComprador=?,NitComprador=?,"
                                + "CorreoComprador=?,NombreFactura=?,NombreArreglo=?,PrecioArreglo=?,"
                                + "Adicional=?,PrecioEnvio=?,PrecioTotal=?,DireccionFiscal=?,"
                                + "NombreReceptor=?,TelefonoReceptor=?,DireccionReceptor=?,NoDeposito=?,"
                                 + "Observaciones=?,FechaPedido=?,FechaEntrega=?,Zona=?,NoFactura=?,IdArreglo=?,"
                         + "IdZona=?,NoTargeta=?,CodigoSeguro=?,TipoDePago=?,Descuento=?  where NumeroPedido = ?";
                       
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, TextNombre.getText().trim());
                pst.setString(2, jTextField9.getText().trim());
                pst.setString(3, jTextField1.getText().trim());
                pst.setString(4, jTextField3.getText().trim());
                pst.setString(5, TextNombre1.getText().trim());
                pst.setString(6, jTextField17.getText().trim());
                pst.setString(7, jTextField5.getText().trim());
                pst.setString(8, jTextField6.getText().trim());
                pst.setString(9, jTextField14.getText().trim());
                pst.setString(10, jLabel28.getText().trim());
                pst.setString(11, jTextField15.getText().trim());
                pst.setString(12, jTextField7.getText().trim());
                pst.setString(13, jTextField2.getText().trim());
                pst.setString(14, jTextField8.getText().trim());
                pst.setString(15, jTextField16.getText().trim());
                pst.setString(16, jTextArea1.getText().trim());
                
                
                pst.setString(17, dt1);
//                pst.setString(17, jLabel23.getText().trim());
                
                pst.setString(18, dt2);
//                pst.setString(18, jLabel30.getText().trim());
                pst.setString(19, Zona.getText().trim());
                pst.setString(20, jTextField10.getText().trim());
                pst.setInt(21, Integer.parseInt(jTextField4.getText().trim()));
                pst.setInt(22, Integer.parseInt(IdZona.getText().trim()));
                pst.setString(23, "");//no targeta
                pst.setString(24, "");//codigo seguro
                pst.setString(25,"Deposito");
                pst.setString(26,descuento.getText());
                pst.setInt(27, Integer.parseInt(NPedido.getText()));
//                pst.setDate(26,edt1);
//               pst.setDate(27,edt2);
              
                int n = pst.executeUpdate();
                if (n > 0)
                {
                    Status.setText("DATOS ACTUALIZADOS CORRECTAMENTE");
                    limpiar();
                    vaciarTabla();
                    verDatos();
                    nuevo.setEnabled(true);
                    guardar.setEnabled(false);
             
                    desabilitar();
                }
                
                            }
                 } 
                else if(jRadioButton3.isSelected()){
                
                    //sin deposito ni targeta
                Connection con = null;
                Conexiones conect = new Conexiones();
                con = conect.getConnection();
                Statement st = con.createStatement();
//                jLabel23.setText(formato.format(FechaPedido.getDate()));
//                 jLabel30.setText(formato.format(FechaEntrega.getDate()));
                
               String sql = "update Comprador set NombreComprador=?,TelefonoComprador=?,NitComprador=?,"
                                + "CorreoComprador=?,NombreFactura=?,NombreArreglo=?,PrecioArreglo=?,"
                                + "Adicional=?,PrecioEnvio=?,PrecioTotal=?,DireccionFiscal=?,"
                                + "NombreReceptor=?,TelefonoReceptor=?,DireccionReceptor=?,"
                               + "Observaciones=?,FechaPedido=?,FechaEntrega=?,Zona=?,NoFactura=?,IdArreglo=?,"
                       + "IdZona=?,NoTargeta=?,CodigoSeguro=?, NoDeposito=?, TipoDePago=?, Descuento=? where NumeroPedido = ?";
                           
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, TextNombre.getText().trim());
                pst.setString(2, jTextField9.getText().trim());
                pst.setString(3, jTextField1.getText().trim());
                pst.setString(4, jTextField3.getText().trim());
                pst.setString(5, TextNombre1.getText().trim());
                pst.setString(6, jTextField17.getText().trim());
                pst.setString(7, jTextField5.getText().trim());
                pst.setString(8, jTextField6.getText().trim());
                pst.setString(9, jTextField14.getText().trim());
                pst.setString(10, jLabel28.getText().trim());
                pst.setString(11, jTextField15.getText().trim());
                pst.setString(12, jTextField7.getText().trim());
                pst.setString(13, jTextField2.getText().trim());
                pst.setString(14, jTextField8.getText().trim());
               
               pst.setString(15, jTextArea1.getText().trim());
               
                pst.setString(16, dt1);
//                pst.setString(17, jLabel23.getText().trim());
                
                pst.setString(17, dt2);
//               pst.setString(17, jLabel23.getText().trim());
//               pst.setString(18, jLabel30.getText().trim());
               pst.setString(18, Zona.getText().trim());
                pst.setString(19, jTextField10.getText().trim());
                pst.setInt(20, Integer.parseInt(jTextField4.getText().trim()));
                pst.setInt(21, Integer.parseInt(IdZona.getText().trim()));
                pst.setString(22, "");//no targeta
                pst.setString(23, "");//codigoseguro
                pst.setString(24, "");//no de deposito
                pst.setString(25,"Ninguno");
                pst.setString(26,descuento.getText());
                pst.setInt(27, Integer.parseInt(NPedido.getText()));

//                pst.setDate(26,edt1);
//               pst.setDate(27,edt2);
           
               
                int n = pst.executeUpdate();
                if (n > 0)
                {
                    Status.setText("DATOS ACTUALIZADOS CORRECTAMENTE");
                    limpiar();
                    vaciarTabla();
                    verDatos();
                    nuevo.setEnabled(true);
                    guardar.setEnabled(false);
                  
                    desabilitar();
                }
                
                }
                else{
                
                Connection con = null;
                Conexiones conect = new Conexiones();
                con = conect.getConnection();
                Statement st = con.createStatement();
//                jLabel23.setText(formato.format(FechaPedido.getDate()));
//                 jLabel30.setText(formato.format(FechaEntrega.getDate()));
                
               String sql = "update Comprador set NombreComprador=?,TelefonoComprador=?,NitComprador=?,"
                                + "CorreoComprador=?,NombreFactura=?,NombreArreglo=?,PrecioArreglo=?,"
                                + "Adicional=?,PrecioEnvio=?,PrecioTotal=?,DireccionFiscal=?,"
                                + "NombreReceptor=?,TelefonoReceptor=?,DireccionReceptor=?,"
                               + "Observaciones=?,FechaPedido=?,FechaEntrega=?,Zona=?,NoFactura=?,IdArreglo=?,"
                       + "IdZona=?,Descuento=? where NumeroPedido = ?";
                           
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, TextNombre.getText().trim());
                pst.setString(2, jTextField9.getText().trim());
                pst.setString(3, jTextField1.getText().trim());
                pst.setString(4, jTextField3.getText().trim());
                pst.setString(5, TextNombre1.getText().trim());
                pst.setString(6, jTextField17.getText().trim());
                pst.setString(7, jTextField5.getText().trim());
                pst.setString(8, jTextField6.getText().trim());
                pst.setString(9, jTextField14.getText().trim());
                pst.setString(10, jLabel28.getText().trim());
                pst.setString(11, jTextField15.getText().trim());
                pst.setString(12, jTextField7.getText().trim());
                pst.setString(13, jTextField2.getText().trim());
                pst.setString(14, jTextField8.getText().trim());
               
               pst.setString(15, jTextArea1.getText().trim());
               
                pst.setString(16, dt1);
//                pst.setString(17, jLabel23.getText().trim());
                
                pst.setString(17, dt2);
//               pst.setString(17, jLabel23.getText().trim());
//               pst.setString(18, jLabel30.getText().trim());
               pst.setString(18, Zona.getText().trim());
                pst.setString(19, jTextField10.getText().trim());
                pst.setInt(20, Integer.parseInt(jTextField4.getText().trim()));
                pst.setInt(21, Integer.parseInt(IdZona.getText().trim()));
                pst.setString(22,descuento.getText());
                pst.setInt(23, Integer.parseInt(NPedido.getText()));
                

//                pst.setDate(26,edt1);
//               pst.setDate(27,edt2);
           
               
                int n = pst.executeUpdate();
                if (n > 0)
                {
                    Status.setText("DATOS ACTUALIZADOS CORRECTAMENTE");
                    limpiar();
                    vaciarTabla();
                    verDatos();
                    nuevo.setEnabled(true);
                    guardar.setEnabled(false);
                  
                    desabilitar();
                }
                
                
                }
            } catch (SQLException | HeadlessException e)
            {
                Status.setText(""+e);
                JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO ACTUALIZADOS CORRECTAMENTE", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
            }
             jButton1.setText("Editar");
            break;
        }
            
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        int fila = jTable1.getSelectedRow();
        if (fila == -1)
        {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            int opc = JOptionPane.showConfirmDialog(this, "¿ESTA SEGURO QUE DESEA ELIMINAR EL PEDIDO "+NPedido.getText()+"?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION)
            {
                try
                {
                    Connection con = null;
                    Conexiones conect = new Conexiones();
                    con = conect.getConnection();
                    Statement st = con.createStatement();
                    String sql = "delete from Comprador where NumeroPedido = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setInt(1, Integer.parseInt(NPedido.getText()));
                    int n = pst.executeUpdate();
                    if (n > 0)
                    {
                        JOptionPane.showMessageDialog(this, "DATOS ELIMINADOS CORRECTAMENTE");
                        limpiar();
                        vaciarTabla();
                        verDatos();
                        nuevo.setEnabled(true);
                        guardar.setEnabled(false);
                        jButton1.setEnabled(false);
                        jButton2.setEnabled(false);
                        desabilitar();
                    }
                } catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(this, "DATOS NO ELIMINADOS CORRECTAMENTE" + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
//        SumarPrecios();
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
       
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyPressed
       
    }//GEN-LAST:event_jTextField14KeyPressed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
 jComboBox2.transferFocus();
        try{
            if(this.contador>0){
                Connection con2 = null;
                Conexiones conect2 = new Conexiones();
                con2 = conect2.getConnection();
                Statement st2 = con2.createStatement();
                ResultSet rs1 = st2.executeQuery("select * from Zonas where IdZona = '" + this.jComboBox2.getSelectedIndex() + "'");
                rs1.next();
                this.IdZona.setText(String.valueOf(rs1.getInt("IdZona")));
                this.Zona.setText(String.valueOf(rs1.getString("Zona")));
               
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        jComboBox1.transferFocus();
        try{
            if(this.contador>0){
                Connection con2 = null;
                Conexiones conect2 = new Conexiones();
                con2 = conect2.getConnection();
                Statement st2 = con2.createStatement();
                ResultSet rs1 = st2.executeQuery("select * from Arreglos where IdArreglo = '" + this.jComboBox1.getSelectedIndex() + "'");
                rs1.next();
                this.jTextField4.setText(String.valueOf(rs1.getString("IdArreglo")));
                this.jTextField17.setText(String.valueOf(rs1.getString("Arreglo")));
                this.jTextField5.setText(String.valueOf(rs1.getString("PrecioArreglo")));
         
                

            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained
        // TODO add your handling code here:
        SumarPrecios();
    }//GEN-LAST:event_jTextField7FocusGained

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
char validar = evt.getKeyChar();
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            Status.setText("Ingrese numeros por favor");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        editar=0;      
        desabilitar();
       
         if (guardar.isEnabled()==true){
           int valor = JOptionPane.showConfirmDialog(this,"Se borrará el formulario actual, desea continuar?","Advertencia",JOptionPane.YES_NO_OPTION);
            if(valor == JOptionPane.YES_OPTION){

            MostrarElementoTabla();
            }
       }
       else{
       MostrarElementoTabla();
       
       }
          nuevo.setEnabled(true);
        jButton1.setText("Editar");
        jButton1.setEnabled(true);
        
        
       
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void TextNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextNombreKeyPressed
  DefaultTableModel model = new DefaultTableModel();  
    Statement st = null;
    ResultSet rs = null;
    Connection con2 = null;
        String titulos[] = {"ID","Nombre","Telefono","Nit","correo","Dirección fiscal"};
        String[] registros = new String[10];
        
        String sql = "SELECT * FROM Clientes WHERE NombreCliente LIKE '%" + TextNombre.getText().trim() + "%'";
        
        model = new DefaultTableModel(null, titulos);
        Conexiones conect1 = new Conexiones();
        con2 = conect1.getConnection();
        
        try
        {
            st = (Statement) con2.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                registros[0] = rs.getString("IdCliente");
                registros[1] = rs.getString("NombreCliente");
                registros[2] = rs.getString("Telefono");
                registros[3] = rs.getString("Nit");
                registros[4] = rs.getString("Correo");
                registros[5] = rs.getString("DireccionFiscal");               
                
                model.addRow(registros);
            }
            jTable2.setModel(model);
        } catch (SQLException ex)
        {
            System.out.println("ERROR AL BUSCAR LOS DATOS : " + ex.getMessage());
        }
        
    }//GEN-LAST:event_TextNombreKeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
     DefaultTableModel model = new DefaultTableModel();  
    Statement st = null;
    ResultSet rs = null;
    Connection con2 = null;
        String titulos[] = {"ID","Nombre","Telefono","Nit","correo","Dirección fiscal"};
        String[] registros = new String[10];
        
        String sql = "SELECT * FROM Clientes WHERE Nit LIKE '%" + jTextField1.getText().trim() + "%'";
        
        model = new DefaultTableModel(null, titulos);
        Conexiones conect1 = new Conexiones();
        con2 = conect1.getConnection();
        
        try
        {
            st = (Statement) con2.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                registros[0] = rs.getString("IdCliente");
                registros[1] = rs.getString("NombreCliente");
                registros[2] = rs.getString("Telefono");
                registros[3] = rs.getString("Nit");
                registros[4] = rs.getString("Correo");
                registros[5] = rs.getString("DireccionFiscal");               
                
                model.addRow(registros);
            }
            jTable2.setModel(model);
        } catch (SQLException ex)
        {
            System.out.println("ERROR AL BUSCAR LOS DATOS : " + ex.getMessage());
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        jButton3.setEnabled(false);
        if(TextNombre.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "Falta el nombre del Cliente","Advertencia",JOptionPane.WARNING_MESSAGE);
        jTextField1.requestFocus();
        }
        
        
        else{  
                  try{ 
                      
              Connection con = null;
                Conexiones conecti = new Conexiones();
                con = conecti.getConnection();
                Statement st = con.createStatement();
                
               String sql = "insert into Clientes(NombreCliente,Telefono,Nit,Correo,DireccionFiscal,NombreFactura) values (?,?,?,?,?,?)";
               PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, TextNombre.getText().trim());
                pst.setString(2, jTextField9.getText().trim());
                pst.setString(3, jTextField1.getText().trim());
                pst.setString(4, jTextField3.getText().trim());
                pst.setString(5, jTextField15.getText().trim());
                pst.setString(6, TextNombre1.getText().trim());
                
                int n = pst.executeUpdate();
                
                if (n > 0)
                {
                    Status.setText("CLIENTE GUARDADO CORRECTAMENTE");
                    
                    vaciarTabla2();
                    verClientes();
                    
                   
                }
                }
        catch (SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null, e);
                JOptionPane.showMessageDialog(this, "EL CLIENTE NO HA SIDO GUARDADO CORRECTAMENTE", "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField14FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField14FocusLost
        if(jTextField6.getText().trim().isEmpty()||jTextField14.getText().trim().isEmpty()||jTextField5.getText().trim().isEmpty()){}
       else{
        SumarPrecios();
       }
    }//GEN-LAST:event_jTextField14FocusLost

    private void jTextField6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusLost
        if(jTextField6.getText().trim().isEmpty()||jTextField14.getText().trim().isEmpty()||jTextField5.getText().trim().isEmpty()){}
       else{
        SumarPrecios();
       }
    }//GEN-LAST:event_jTextField6FocusLost

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
     jButton3.setEnabled(false);
        if (guardar.isEnabled()==true){
           int valor = JOptionPane.showConfirmDialog(this,"Se borrarán los datos del cliente actual, desea continuar?","Advertencia",JOptionPane.YES_NO_OPTION);
            if(valor == JOptionPane.YES_OPTION){

          
        try
        {
          
            int fila = jTable2.getSelectedRow();
           
            TextNombre.setText(jTable2.getValueAt(fila, 1).toString());// cliente
            jTextField9.setText(jTable2.getValueAt(fila, 2).toString());//telefono
            jTextField1.setText (jTable2.getValueAt(fila,3).toString()); // nit
            jTextField3.setText(jTable2.getValueAt(fila, 4).toString());//correo
            jTextField15.setText(jTable2.getValueAt(fila, 5).toString());//telefono del cliente    
            TextNombre1.setText(jTable2.getValueAt(fila,6).toString());
        } catch (Exception ex)
        {
          
            Status.setText("ERROR AL SELECCIONAR UN EQUIPO : " + ex.getMessage());
            
        }
            }
       }
      
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Buscar Buscar = new Buscar();
        Interfaz.Fondo.add (Buscar);
        Buscar.setVisible(true);
        Buscar.toFront();
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//           try {
////            Conexiones conect = new Conexiones();
////            Connection conn = null; 
////            conn =   conect.getConnection();
//            JasperReport reporte = null;
////            System.getProperty("user.dir")+
//            String master = System.getProperty("user.dir")+"\\src\\Reportes\\ReporteDePedido.jasper";
//             reporte = (JasperReport)JRLoader.loadObjectFromFile(master);
//            Map parametro = new HashMap();
//            parametro.put("NoPedido",NPedido.getText().trim() );
//            parametro.put("Cliente",TextNombre.getText().trim() );
//            parametro.put("Telefono",jTextField9.getText().trim() );
//            parametro.put("Correo",jTextField3.getText().trim() );
//            JasperPrint j = JasperFillManager.fillReport(reporte, parametro, new JREmptyDataSource() );
//            JasperViewer jv = new JasperViewer(j,false);
////            JasperViewer jv = new JasperViewer(j,true);
////            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//            jv.setTitle("Reporte de Pedido");
//            jv.setVisible(true);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, " ERRONEO " + e);  
//        }
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
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void descuentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descuentoFocusLost
        SumarPrecios();
    }//GEN-LAST:event_descuentoFocusLost

    private void descuentoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_descuentoInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_descuentoInputMethodTextChanged

    private void descuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descuentoActionPerformed

    private void descuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descuentoKeyPressed
      
    }//GEN-LAST:event_descuentoKeyPressed

    private void descuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descuentoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            Status.setText("Ingrese numeros por favor");
        }
    }//GEN-LAST:event_descuentoKeyTyped
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaEntrega;
    private com.toedter.calendar.JDateChooser FechaPedido;
    private com.toedter.calendar.JDateChooser FechaVencimiento;
    private javax.swing.JLabel IdCliente;
    private javax.swing.JTextField IdZona;
    private javax.swing.JLabel LabelFactura;
    private javax.swing.JLabel LabelPedido;
    private javax.swing.JLabel NFactura;
    private javax.swing.JLabel NPedido;
    private javax.swing.JLabel Status;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JTextField TextNombre1;
    private javax.swing.JTextField Zona;
    private javax.swing.JTextField descuento;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton nuevo;
    private javax.swing.JButton nuevo1;
    public static javax.swing.ButtonGroup tPago;
    // End of variables declaration//GEN-END:variables
}
