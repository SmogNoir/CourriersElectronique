/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courrierselectronique;

import com.mysql.jdbc.Statement;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aliba
 */
public class ConsulterCourrier1 extends javax.swing.JFrame {

    /**
     * Creates new form ConsulterCourrier1
     */
    DefaultTableModel model;
    public ConsulterCourrier1() {
    initComponents();
    
        showUsersInTable(query);
        model =(DefaultTableModel)jTable1.getModel();
    }
   String query="SELECT * FROM "+Login_Form.jTextField_UserName.getText() ; ;
    
   
     public Connection getConnection() {
    
    
    try {
      String urlPilote ="com.mysql.jdbc.Driver";
        Class.forName(urlPilote);
        System.out.println ("Le pilote a été bien chargé");
        String urlBD ="jdbc:mysql://localhost:3306/Users_db";
        String user  ="root";
        String  password="";
        Connection con =DriverManager.getConnection(urlBD, user, password);
        System.out.println ("Connexion bien établie");
        return con ;
    }
    catch (Exception ex) {
    
    System.out.println(ex.getMessage());    }
        return null;
        
    
    
    
    
    } 
    
    
        public ArrayList<User> ListUsers (String query){
        
        ArrayList<User> usersList= new ArrayList<User>() ;
        Connection con= getConnection() ;
        Statement st ;
        ResultSet rs ;
        try {
            st= (Statement) con.createStatement() ;
            rs=st.executeQuery(query) ;
            User user ;
            while(rs.next()){
            user = new User(
                rs.getString("Message"),
                   rs.getString("Objet")) ;
            usersList.add(user);
             }
        } catch(Exception ex){
        System.out.println(ex.getMessage());}        
        return usersList ; 
        
        }
        
        
      public void showUsersInTable(String OrderQuery){
     ArrayList<User> users = ListUsers (OrderQuery) ;
     DefaultTableModel model=new DefaultTableModel() ;
     model.setColumnIdentifiers(new Object[]{"Message","Objet"});
     Object[] row = new Object[2] ;
     
     for(int i= 0;i<users.size();i++)
     {
         row[1] = users.get(i).getMessage() ;
         row[0] = users.get(i).getObjet() ;
         model.addRow(row);
         
     }
     jTable1.setModel(model);
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Objet"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
int index;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        index= jTable1.getSelectedRow();
        //jTextField1.setText(model.getValueAt(index,0).toString());
         jTextArea1.setText(model.getValueAt(index,0).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_UP || evt.getKeyCode()== KeyEvent.VK_DOWN ){
          index= jTable1.getSelectedRow();
        //jTextField1.setText(model.getValueAt(index,0).toString());  
        jTextArea1.setText(model.getValueAt(index,0).toString());  

        }
    }//GEN-LAST:event_jTable1KeyReleased

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
            java.util.logging.Logger.getLogger(ConsulterCourrier1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsulterCourrier1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsulterCourrier1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsulterCourrier1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsulterCourrier1().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
