package automatreitor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Francisco
 */
public class Interfaz extends javax.swing.JFrame {

    private ArrayList<String> estados;
    private ArrayList<String> estadofinal;
    private ArrayList<String> alfabeto;
    private String estadoinicial;
            
    public Interfaz() {
        this.setTitle("Automatreitor");
        estados = new ArrayList<String>();
        alfabeto = new ArrayList<String>();
        estadofinal = new ArrayList<String>();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        C_Estados = new javax.swing.JTextField();
        C_Alfabeto = new javax.swing.JTextField();
        E_Final = new javax.swing.JTextField();
        E_Inicial = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        A_C_Estados = new javax.swing.JButton();
        N_Estados = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        A_Alfabeto = new javax.swing.JButton();
        C_Transiciones = new javax.swing.JButton();
        C_AFD = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        T_transiciones = new javax.swing.JTable();
        Guardar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        C_Estados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_EstadosActionPerformed(evt);
            }
        });
        C_Estados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_EstadosKeyTyped(evt);
            }
        });

        C_Alfabeto.setEnabled(false);
        C_Alfabeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_AlfabetoActionPerformed(evt);
            }
        });

        E_Final.setEnabled(false);
        E_Final.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E_FinalActionPerformed(evt);
            }
        });

        E_Inicial.setEnabled(false);
        E_Inicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E_InicialActionPerformed(evt);
            }
        });

        jLabel1.setText("Σ :");

        jLabel2.setText("N° de estados :");

        jLabel3.setText("S:");

        jLabel4.setText("F:");

        A_C_Estados.setText("Aceptar");
        A_C_Estados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A_C_EstadosActionPerformed(evt);
            }
        });

        N_Estados.setEnabled(false);
        N_Estados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N_EstadosActionPerformed(evt);
            }
        });

        jLabel5.setText("Estados:");

        A_Alfabeto.setText("Agregar");
        A_Alfabeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A_AlfabetoActionPerformed(evt);
            }
        });

        C_Transiciones.setText("Crea transiciones");
        C_Transiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_TransicionesActionPerformed(evt);
            }
        });

        C_AFD.setText("Convertir a AFD");
        C_AFD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_AFDActionPerformed(evt);
            }
        });

        T_transiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(T_transiciones);

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(E_Final, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(E_Inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(C_Alfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(C_Estados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(N_Estados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(C_Transiciones)
                        .addGap(18, 18, 18)
                        .addComponent(C_AFD)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(A_C_Estados)
                        .addComponent(A_Alfabeto))
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C_Estados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(A_C_Estados))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(N_Estados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C_Alfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(A_Alfabeto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(E_Inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(E_Final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C_Transiciones)
                    .addComponent(C_AFD)
                    .addComponent(Guardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void C_EstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_EstadosActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_C_EstadosActionPerformed

    private void C_AlfabetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_AlfabetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C_AlfabetoActionPerformed

    private void E_FinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E_FinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_E_FinalActionPerformed

    private void E_InicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E_InicialActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_E_InicialActionPerformed

    private void A_C_EstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A_C_EstadosActionPerformed

        // TODO add your handling code here:
        
        N_Estados.setText(null);
        E_Inicial.setText(null);
        E_Final.setText(null);
        this.estados.clear();
        this.alfabeto.clear();
        this.estadofinal.clear();
        
        int Cantidad = Integer.parseInt(C_Estados.getText());
        int contador = 0;
    
      try {
      if (Cantidad >= 2){
          while (Cantidad > contador){
             String s = JOptionPane.showInputDialog("Ingrese estado "+contador);
               if (this.estados.contains(s)){
               JOptionPane.showMessageDialog(null, "Ya existe");
           
             }else{
                    this.estados.add(s);
                    contador++;
             }
           }
      }
     
      N_Estados.setText(this.estados.toString());
      System.out.println(this.estados);
        
        
        this.estadoinicial = this.estados.get(0);
        E_Inicial.setText(this.estados.get(0));
    int contador3 = 0;
    int C_f = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de estados finales"));
      if (C_f > 0){
          while (C_f > contador3){
             String f = JOptionPane.showInputDialog("Ingrese estado final");
               if (this.estadofinal.contains(f)){
                   
             }else if(this.estados.contains(f)) {
                    this.estadofinal.add(f);
                    contador3++;
             }else{
             JOptionPane.showMessageDialog(null , "No existe estado","error", JOptionPane.ERROR_MESSAGE);
             }
           }
      }
    E_Final.setText(estadofinal.toString());
    }//GEN-LAST:event_A_C_EstadosActionPerformed
         catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error"); 
         }  
       } 
    
    private void N_EstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N_EstadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_N_EstadosActionPerformed

    private void C_EstadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_EstadosKeyTyped
         char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
    }//GEN-LAST:event_C_EstadosKeyTyped

    private void A_AlfabetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A_AlfabetoActionPerformed
        // TODO add your handling code here:
    int C_Caracteres = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de letras de alfabeto"));
    int contador2 = 0;
    this.alfabeto.clear();
    try {
      if (C_Caracteres > 0){
          while (C_Caracteres > contador2){
             String s = JOptionPane.showInputDialog("Ingrese letra "+contador2);
               if (this.alfabeto.contains(s)){
               JOptionPane.showMessageDialog(null, "Ya existe");
           
             }else{
                    this.alfabeto.add(s);
                    contador2++;
             }
           }
      C_Alfabeto.setText(this.alfabeto.toString());
      }
        
    }catch(Exception e){JOptionPane.showMessageDialog(null, "Error");}
        
    }//GEN-LAST:event_A_AlfabetoActionPerformed

    private void C_TransicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_TransicionesActionPerformed
        // TODO add your handling code here:
        
        if(E_Final.getText().length()!=0 && C_Alfabeto.getText().length() !=0){
        
        }else{ JOptionPane.showMessageDialog(null, "Faltan datos");
        }
    }//GEN-LAST:event_C_TransicionesActionPerformed

    private void C_AFDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_AFDActionPerformed
        // TODO add your handling code here:
        if(E_Final.getText().length()!=0 && C_Alfabeto.getText().length() !=0){
        
        }else{ JOptionPane.showMessageDialog(null, "Faltan datos");
        
        
        }
        
        
        
    }//GEN-LAST:event_C_AFDActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // TODO add your handling code here:
        if(E_Final.getText().length()!=0 && C_Alfabeto.getText().length() !=0){
        
        }else{ JOptionPane.showMessageDialog(null, "Faltan datos");
        
        
        }
    }//GEN-LAST:event_GuardarActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton A_Alfabeto;
    private javax.swing.JButton A_C_Estados;
    private javax.swing.JButton C_AFD;
    private javax.swing.JTextField C_Alfabeto;
    private javax.swing.JTextField C_Estados;
    private javax.swing.JButton C_Transiciones;
    private javax.swing.JTextField E_Final;
    private javax.swing.JTextField E_Inicial;
    private javax.swing.JButton Guardar;
    private javax.swing.JTextField N_Estados;
    private javax.swing.JTable T_transiciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}