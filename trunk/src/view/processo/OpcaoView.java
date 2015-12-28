package view.processo;

import controler.processo.OpcaoControler;
import javax.swing.JOptionPane;
import model.processo.*;

public class OpcaoView extends javax.swing.JDialog {

    public OpcaoView(java.awt.Frame parent, boolean modal,FinalizacaoView fin) {
        super(parent, modal);
        this.fin = fin;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtnome = new javax.swing.JTextField();
        jtvalor = new javax.swing.JTextField();
        jlnome = new javax.swing.JLabel();
        jlvalor = new javax.swing.JLabel();
        jbtcancelar = new javax.swing.JButton();
        jbtgravar = new javax.swing.JButton();

        setTitle("Opções");
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jlnome.setText("Nome:");

        jlvalor.setText("Valor:");

        jbtcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/progress_stop.gif"))); // NOI18N
        jbtcancelar.setText("Cancelar");
        jbtcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtcancelarActionPerformed(evt);
            }
        });

        jbtgravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/save_edit.gif"))); // NOI18N
        jbtgravar.setText("Gravar");
        jbtgravar.setToolTipText("");
        jbtgravar.setPreferredSize(new java.awt.Dimension(95, 25));
        jbtgravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtgravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtnome, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtcancelar)
                                .addGap(8, 8, 8)
                                .addComponent(jbtgravar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtvalor, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlvalor)
                        .addContainerGap(218, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlnome)
                        .addContainerGap(215, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlnome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlvalor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jbtgravar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtcancelar))
                .addGap(17, 17, 17))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-264)/2, (screenSize.height-205)/2, 264, 205);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtcancelarActionPerformed
        jtnome.setText("");
        jtvalor.setText("");
        this.dispose();
    }//GEN-LAST:event_jbtcancelarActionPerformed

    private void jbtgravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtgravarActionPerformed
        
        montaOpcao();
        controler = new OpcaoControler();
        opcaodata = new OpcaoData(fin.finalizacao);
        controler.gravarOpcao(opcao);
        opcaodata.atualizaDados(fin.finalizacao);
        fin.atualizaTables(opcaodata);
        this.dispose();

    }//GEN-LAST:event_jbtgravarActionPerformed

    private void montaOpcao()
    {
        if(jtnome.getText().compareToIgnoreCase("") == 0)
        {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser nulo,verifique!","Erro",0);
            return;
        }
        if(jtvalor.getText().compareToIgnoreCase("")== 0)
        {
            JOptionPane.showMessageDialog(null, "Campo valor não pode ser nulo,verifique!","Erro",0);
            return;
        }

       opcao = new Opcao();

       try
       {
           opcao.setId(codigo);
       }
       catch(NumberFormatException e)
       {
           opcao.setId(0);
       }

       opcao.setNome(jtnome.getText());
       opcao.setValor(jtvalor.getText());
       opcao.setFinalizacao(fin.finalizacao.getId());
       opcao.setStatus(0);
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OpcaoView dialog = new OpcaoView(new javax.swing.JFrame(), true, new FinalizacaoView());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtcancelar;
    private javax.swing.JButton jbtgravar;
    private javax.swing.JLabel jlnome;
    private javax.swing.JLabel jlvalor;
    public javax.swing.JTextField jtnome;
    public javax.swing.JTextField jtvalor;
    // End of variables declaration//GEN-END:variables
    private FinalizacaoView fin;
    private Opcao opcao;
    private OpcaoDao opcaodao;
    private OpcaoData opcaodata;
    public int codigo;
    private OpcaoControler controler;
}
