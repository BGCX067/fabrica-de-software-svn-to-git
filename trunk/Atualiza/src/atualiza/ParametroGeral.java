/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ParametroGeral.java
 *
 * Created on 28/09/2010, 15:16:17
 */

package atualiza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ParametroGeral extends javax.swing.JInternalFrame {

    /** Creates new form ParametroGeral */
    public ParametroGeral() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        freq_timer = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jcb_timer = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        dias_ivv = new javax.swing.JFormattedTextField();
        jcb_ivv = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Parâmetros Gerais");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Frequência do Timer");

        freq_timer.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        freq_timer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                freq_timerFocusLost(evt);
            }
        });

        jLabel2.setText("( Tempo em minutos ) :");

        jcb_timer.setSelected(true);
        jcb_timer.setText("Timer Ativo");

        jLabel3.setText("Quantidades de Dias para pesquisa: ");

        dias_ivv.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        dias_ivv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dias_ivvFocusLost(evt);
            }
        });

        jcb_ivv.setSelected(true);
        jcb_ivv.setText("IVV Ativo");
        jcb_ivv.setToolTipText("");

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText("Cancelar");
        jPanel2.add(jButton2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(freq_timer, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(dias_ivv, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jcb_timer)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jcb_ivv)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(freq_timer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dias_ivv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jcb_timer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcb_ivv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

    private void freq_timerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_freq_timerFocusLost

        try
        {
            int tempo = Integer.parseInt(freq_timer.getText());

            if(tempo < 5)
            {
                freq_timer.setText("5");
            }

        }catch(NumberFormatException exc)
        {
            freq_timer.setText("5");
        }


    }//GEN-LAST:event_freq_timerFocusLost

    private void dias_ivvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dias_ivvFocusLost
        try
        {

            int dias = Integer.parseInt(dias_ivv.getText());

            if(dias <= 0)
            {                                
                dias_ivv.setText(String.valueOf(dias));
            }else
            {
                dias = dias * -1 ;
                dias_ivv.setText(String.valueOf(dias));
            }
        }catch(NumberFormatException exc)
        {
            dias_ivv.setText("-5");
        }
    }//GEN-LAST:event_dias_ivvFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(!FabricaConexoes.verificaConexao())
        {
            FabricaConexoes.getConexaoMy();
        }
        try{

        sql = "Update tb_parametros set valor = ? where id_parametro = 1";
        stm = FabricaConexoes.returnStatement(sql);
        stm.setString(1,freq_timer.getText());
        stm.execute();

        sql = "Update tb_parametros set valor = ? where id_parametro = 2";
        stm = FabricaConexoes.returnStatement(sql);
        stm.setString(1,dias_ivv.getText());
        stm.execute();

        sql = "Update tb_parametros set valor = ?,status = ? where id_parametro = 3";
        stm = FabricaConexoes.returnStatement(sql);
        stm.setString(1,"TIMER");
        if(jcb_timer.isSelected())
        {
            stm.setInt(2, 1);
        }else  stm.setInt(2, 0);
        stm.execute();

        sql = "Update tb_parametros set valor = ?,status = ? where id_parametro = 4";
        stm = FabricaConexoes.returnStatement(sql);
        stm.setString(1,"IVV");
        if(jcb_ivv.isSelected())
        {
            stm.setInt(2, 1);
        }else  stm.setInt(2, 0);
        stm.execute();

        JOptionPane.showMessageDialog(null, "Parâmetros alterados","Informação",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception exc)
        {
            JOptionPane.showMessageDialog(null, exc.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
            FabricaConexoes.closeConnection();
            this.hide();
        }
        FabricaConexoes.closeConnection();
        //this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void CarregaParametros()
    {
        if(!FabricaConexoes.verificaConexao())
        {
            FabricaConexoes.getConexaoMy();
        }
        try{
        sql = "select * from tb_parametros";
        stm = FabricaConexoes.returnStatement(sql);
        rs = FabricaConexoes.returnResult(stm);
        while(rs.next())
        {
            int id = rs.getInt("id_parametro");
            if(id == 1)
            {
                freq_timer.setText(rs.getString("Valor"));
            }else if(id == 2)
            {
                dias_ivv.setText(rs.getString("Valor"));
            }else if(id == 3)
            {
                int status = rs.getInt("status");
                if(status == 1)
                {
                    jcb_timer.setSelected(true);
                }else{jcb_timer.setSelected(false);}
            }else if(id == 4)
            {
                int status = rs.getInt("status");
                if(status == 1)
                {
                    jcb_ivv.setSelected(true);
                }else{jcb_ivv.setSelected(false);}
            }
        }
        }catch(Exception exc)
        {
            JOptionPane.showMessageDialog(null, exc.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
            FabricaConexoes.closeConnection();
        }
        FabricaConexoes.closeConnection();
    }

    public int getFreq()
    {
        return Integer.parseInt(freq_timer.getText());
    }
    public int getDias()
    {
       return Integer.parseInt(dias_ivv.getText());
    }
    public int getTimer()
    {
        if(jcb_timer.isSelected())
        {
            return 1;
        }else return 0;
    }
    public int getIvv()
    {
        if(jcb_ivv.isSelected())
        {
            return 1;
        }else return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField dias_ivv;
    private javax.swing.JFormattedTextField freq_timer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox jcb_ivv;
    private javax.swing.JCheckBox jcb_timer;
    // End of variables declaration//GEN-END:variables
    private PreparedStatement stm;
    private ResultSet rs;
    private String sql;

}