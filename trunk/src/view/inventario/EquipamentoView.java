/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EquipamentoView.java
 *
 * Created on 22/06/2010, 21:31:06
 */

package view.inventario;

/**
 *
 * @author Administrador
 */
public class EquipamentoView extends javax.swing.JInternalFrame {

    /** Creates new form EquipamentoView */
    public EquipamentoView() {
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

        jPcadastro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_hardwares = new javax.swing.JTable();
        dp_inicial = new net.sf.nachocalendar.components.DatePanel();
        jLdata = new javax.swing.JLabel();
        jTnf = new javax.swing.JTextField();
        jLnf = new javax.swing.JLabel();
        jTsr = new javax.swing.JTextField();
        jLsr = new javax.swing.JLabel();
        jTpatrimonio = new javax.swing.JTextField();
        jLpatrimonio = new javax.swing.JLabel();
        jLequipamento = new javax.swing.JLabel();
        jCequipamento = new javax.swing.JComboBox();
        jLfornecedor = new javax.swing.JLabel();
        jTfornecedor = new javax.swing.JTextField();
        jBforncedor = new javax.swing.JButton();
        jLhardwares = new javax.swing.JLabel();
        jLsofwares = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_sofwares = new javax.swing.JTable();
        bt_inserirh = new javax.swing.JButton();
        bt_removerh = new javax.swing.JButton();
        bt_inserirs = new javax.swing.JButton();
        bt_removers = new javax.swing.JButton();
        bt_novo = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Equipamento");
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(765, 546));
        setMinimumSize(new java.awt.Dimension(765, 546));
        setPreferredSize(new java.awt.Dimension(765, 546));
        setVisible(true);

        jPcadastro.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro"));

        tb_hardwares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_hardwares);

        dp_inicial.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLdata.setText("Data de aquisição");

        jTnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTnfActionPerformed(evt);
            }
        });

        jLnf.setText("Nota Fiscal ");

        jTsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTsrActionPerformed(evt);
            }
        });

        jLsr.setText("Sr");

        jTpatrimonio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTpatrimonioActionPerformed(evt);
            }
        });

        jLpatrimonio.setText("Nº Patrimônio");

        jLequipamento.setText("Tipo de Equipamento");

        jCequipamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GABINETE", "MONITOR", "IMPRESSORA", "DATASHOW", "NOTEBOOK", "PERIFÉRICOS" }));

        jLfornecedor.setText("Fornecedor");

        jTfornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfornecedorActionPerformed(evt);
            }
        });

        jBforncedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/help_contents.gif"))); // NOI18N
        jBforncedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBforncedorActionPerformed(evt);
            }
        });

        jLhardwares.setText("Hardwares");

        jLsofwares.setText("Softwares");

        tb_sofwares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tb_sofwares);

        bt_inserirh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/add_obj.gif"))); // NOI18N

        bt_removerh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/delete_edit.gif"))); // NOI18N

        bt_inserirs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/add_obj.gif"))); // NOI18N

        bt_removers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/delete_edit.gif"))); // NOI18N

        bt_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/welcome_editor.gif"))); // NOI18N
        bt_novo.setText("Novo");

        javax.swing.GroupLayout jPcadastroLayout = new javax.swing.GroupLayout(jPcadastro);
        jPcadastro.setLayout(jPcadastroLayout);
        jPcadastroLayout.setHorizontalGroup(
            jPcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPcadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLfornecedor)
                    .addGroup(jPcadastroLayout.createSequentialGroup()
                        .addGroup(jPcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTnf, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLnf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPcadastroLayout.createSequentialGroup()
                                .addComponent(jTsr, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_novo))
                            .addComponent(jLsr))
                        .addGap(78, 78, 78))
                    .addComponent(jLpatrimonio)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPcadastroLayout.createSequentialGroup()
                        .addComponent(jTfornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBforncedor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLdata)
                    .addComponent(jTpatrimonio, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(dp_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLequipamento)
                    .addComponent(jCequipamento, 0, 270, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPcadastroLayout.createSequentialGroup()
                        .addComponent(jLsofwares)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_inserirs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_removers))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPcadastroLayout.createSequentialGroup()
                        .addComponent(jLhardwares)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_inserirh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_removerh))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPcadastroLayout.setVerticalGroup(
            jPcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPcadastroLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPcadastroLayout.createSequentialGroup()
                        .addGroup(jPcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLhardwares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_inserirh, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_removerh, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLsofwares, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                            .addComponent(bt_inserirs, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_removers, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(jPcadastroLayout.createSequentialGroup()
                        .addGroup(jPcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLnf)
                            .addComponent(jLsr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTsr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jLpatrimonio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTpatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLequipamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCequipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLfornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jBforncedor, 0, 0, Short.MAX_VALUE)
                            .addComponent(jTfornecedor))
                        .addGap(29, 29, 29)))
                .addGroup(jPcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPcadastroLayout.createSequentialGroup()
                        .addComponent(jLdata)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dp_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPcadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPcadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-765)/2, (screenSize.height-546)/2, 765, 546);
    }// </editor-fold>//GEN-END:initComponents

    private void jTnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTnfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTnfActionPerformed

    private void jTsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTsrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTsrActionPerformed

    private void jTpatrimonioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTpatrimonioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTpatrimonioActionPerformed

    private void jTfornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfornecedorActionPerformed

    private void jBforncedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBforncedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBforncedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_inserirh;
    private javax.swing.JButton bt_inserirs;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_removerh;
    private javax.swing.JButton bt_removers;
    private net.sf.nachocalendar.components.DatePanel dp_inicial;
    private javax.swing.JButton jBforncedor;
    private javax.swing.JComboBox jCequipamento;
    private javax.swing.JLabel jLdata;
    private javax.swing.JLabel jLequipamento;
    private javax.swing.JLabel jLfornecedor;
    private javax.swing.JLabel jLhardwares;
    private javax.swing.JLabel jLnf;
    private javax.swing.JLabel jLpatrimonio;
    private javax.swing.JLabel jLsofwares;
    private javax.swing.JLabel jLsr;
    private javax.swing.JPanel jPcadastro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTfornecedor;
    private javax.swing.JTextField jTnf;
    private javax.swing.JTextField jTpatrimonio;
    private javax.swing.JTextField jTsr;
    private javax.swing.JTable tb_hardwares;
    private javax.swing.JTable tb_sofwares;
    // End of variables declaration//GEN-END:variables

}
