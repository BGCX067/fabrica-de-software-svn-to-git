
package view.sistema;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import controler.sistema.PacoteControler;
import javax.swing.JOptionPane;
import model.sistema.PacoteDao;
import model.sistema.PacoteData;
import model.sistema.Pacote;
import Util.FabricaConexoes;

public class PacoteView extends javax.swing.JInternalFrame {

    public PacoteView() {
        pacotedata = new PacoteData();
        controler = new PacoteControler();
        initComponents();
        jtbpacotes.getSelectionModel().addListSelectionListener(selectionListener);
        jtbpacotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //jtbgrupos.setRowSelectionInterval(0, 0);***
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlgrupo = new javax.swing.JPanel();
        jtfdescricao = new javax.swing.JTextField();
        jldescricao = new javax.swing.JLabel();
        jbtnovo = new javax.swing.JButton();
        jbtalterar = new javax.swing.JButton();
        jbtexcluir = new javax.swing.JButton();
        jbtcancelar = new javax.swing.JButton();
        jbtsalvar = new javax.swing.JButton();
        jtfid_grupo = new javax.swing.JTextField();
        jlid_grupo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlgrupos_cadastrados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbpacotes = new javax.swing.JTable();
        jtfpesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Cadastro de Pacotes");
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(477, 533));
        setMinimumSize(new java.awt.Dimension(477, 533));
        setVisible(true);

        pnlgrupo.setBorder(javax.swing.BorderFactory.createTitledBorder("Pacote"));
        pnlgrupo.setToolTipText("");

        jtfdescricao.setEnabled(false);
        jtfdescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfdescricaoActionPerformed(evt);
            }
        });

        jldescricao.setText("Descrição: ");

        jbtnovo.setFont(new java.awt.Font("Tahoma", 0, 9));
        jbtnovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/newfile_wiz.gif"))); // NOI18N
        jbtnovo.setText("Novo");
        jbtnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnovoActionPerformed(evt);
            }
        });

        jbtalterar.setFont(new java.awt.Font("Tahoma", 0, 9));
        jbtalterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/synced.gif"))); // NOI18N
        jbtalterar.setText("Alterar");
        jbtalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtalterarActionPerformed(evt);
            }
        });

        jbtexcluir.setFont(new java.awt.Font("Tahoma", 0, 9));
        jbtexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/delete_obj.gif"))); // NOI18N
        jbtexcluir.setText("Excluir");
        jbtexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtexcluirActionPerformed(evt);
            }
        });

        jbtcancelar.setFont(new java.awt.Font("Tahoma", 0, 9));
        jbtcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/progress_stop.gif"))); // NOI18N
        jbtcancelar.setText("Cancelar");
        jbtcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtcancelarActionPerformed(evt);
            }
        });

        jbtsalvar.setFont(new java.awt.Font("Tahoma", 0, 9));
        jbtsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/save_edit.gif"))); // NOI18N
        jbtsalvar.setText("Salvar");
        jbtsalvar.setEnabled(false);
        jbtsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtsalvarActionPerformed(evt);
            }
        });

        jtfid_grupo.setEnabled(false);

        jlid_grupo.setText("Id:");

        javax.swing.GroupLayout pnlgrupoLayout = new javax.swing.GroupLayout(pnlgrupo);
        pnlgrupo.setLayout(pnlgrupoLayout);
        pnlgrupoLayout.setHorizontalGroup(
            pnlgrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlgrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlgrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlid_grupo)
                .addContainerGap(405, Short.MAX_VALUE))
            .addGroup(pnlgrupoLayout.createSequentialGroup()
                .addGroup(pnlgrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlgrupoLayout.createSequentialGroup()
                        .addComponent(jbtnovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtalterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtexcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtcancelar)
                        .addGap(6, 6, 6))
                    .addGroup(pnlgrupoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlgrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfid_grupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(jldescricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(285, 285, 285)))
                .addGroup(pnlgrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jbtsalvar)))
        );
        pnlgrupoLayout.setVerticalGroup(
            pnlgrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlgrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlid_grupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlgrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlgrupoLayout.createSequentialGroup()
                        .addComponent(jtfid_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jldescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(pnlgrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnovo)
                    .addComponent(jbtalterar)
                    .addComponent(jbtexcluir)
                    .addComponent(jbtcancelar)
                    .addComponent(jbtsalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlgrupos_cadastrados.setBorder(javax.swing.BorderFactory.createTitledBorder("Pacotes cadastrados"));

        jtbpacotes.setModel(pacotedata);
        jtbpacotes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbpacotes);

        jtfpesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfpesquisarKeyReleased(evt);
            }
        });

        jLabel1.setText("Pesquisar: ");

        javax.swing.GroupLayout pnlgrupos_cadastradosLayout = new javax.swing.GroupLayout(pnlgrupos_cadastrados);
        pnlgrupos_cadastrados.setLayout(pnlgrupos_cadastradosLayout);
        pnlgrupos_cadastradosLayout.setHorizontalGroup(
            pnlgrupos_cadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlgrupos_cadastradosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlgrupos_cadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(jtfpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        pnlgrupos_cadastradosLayout.setVerticalGroup(
            pnlgrupos_cadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlgrupos_cadastradosLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jtfpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlgrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlgrupos_cadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlgrupos_cadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-477)/2, (screenSize.height-529)/2, 477, 529);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfdescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfdescricaoActionPerformed
       
    }//GEN-LAST:event_jtfdescricaoActionPerformed

    private void jbtcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtcancelarActionPerformed

        limpaCampos();
        status(2);
    }//GEN-LAST:event_jbtcancelarActionPerformed

    private void jbtexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtexcluirActionPerformed
        montaPacote();
        controler.excluirPacote(pacote);
        limpaCampos();
        pacotedata.atualizaDados();
        jtbpacotes.revalidate();
        jtbpacotes.repaint();
    }//GEN-LAST:event_jbtexcluirActionPerformed

    private void jbtnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnovoActionPerformed
        limpaCampos();
        status(1);
    }//GEN-LAST:event_jbtnovoActionPerformed

    private void jbtsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtsalvarActionPerformed
        montaPacote();
        controler.gravar(pacote);
        pacotedata.atualizaDados();
        jtbpacotes.revalidate();
        jtbpacotes.repaint();
        limpaCampos();
        status(2);
    }//GEN-LAST:event_jbtsalvarActionPerformed

    private void jbtalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtalterarActionPerformed
        selectionListener.valueChanged(null);
        if(!jtfid_grupo.isValid())status(1);
    }//GEN-LAST:event_jbtalterarActionPerformed

    private void jtfpesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfpesquisarKeyReleased
        TableRowSorter<TableModel> sorter;
        sorter = new TableRowSorter<TableModel>(jtbpacotes.getModel());
        jtbpacotes.setRowSorter(sorter);
        sorter.setRowFilter(javax.swing.RowFilter.regexFilter(jtfpesquisar.getText(),1));
    }//GEN-LAST:event_jtfpesquisarKeyReleased

    private void montaPacote()
    {
        pacote = new Pacote();

        try
        {
            pacote.setId(Integer.parseInt(jtfid_grupo.getText()));
        }
        catch(NumberFormatException e)
        {
            pacote.setId(0);
        }

        pacote.setDescricao(jtfdescricao.getText());
    }

    private ListSelectionListener selectionListener = new ListSelectionListener()
    {
        public void valueChanged(ListSelectionEvent e)
        {
            //tblusuarios.getModel().getValueAt(tblusuarios.getSelectedRow(), 1));
            int linha = jtbpacotes.getSelectedRow();
            pacote = pacotedata.getPacote(linha);
            jtfdescricao.setText(pacote.getDescricao());
            jtfid_grupo.setText(String.valueOf(pacote.getId()));
            FabricaConexoes.closeConnection();
        }
    };
private void limpaCampos()
{
    jtfid_grupo.setText("");
    jtfdescricao.setText("");
    jtfpesquisar.setText("");

}

/**
 * Método status
 * Método responsável por manipular a visibilidade dos botões 
 * da GrupoView de acordo com a escolha do usuário
 * @param status 
 * O parâmetro status pode ser :
 * 1  = Status "Novo"
 * 2 = Status "Alterar"
 */
private void status(int status)
{
    switch(status)
    {
            case 1 :
                    jtfdescricao.setEnabled(true);
                    jtfpesquisar.setEnabled(false);
                    jbtexcluir.setEnabled(false);
                    jbtnovo.setEnabled(false);
                    jbtalterar.setEnabled(false);
                    jbtsalvar.setEnabled(true);
                    jbtcancelar.setEnabled(true);
                    break;
            case 2 :
                    jtfpesquisar.setEnabled(true);
                    jtfdescricao.setEnabled(false);
                    jbtexcluir.setEnabled(true);
                    jbtnovo.setEnabled(true);
                    jbtalterar.setEnabled(true);
                    jbtsalvar.setEnabled(false);
                    jbtcancelar.setEnabled(true);
                    break;

    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtalterar;
    private javax.swing.JButton jbtcancelar;
    private javax.swing.JButton jbtexcluir;
    private javax.swing.JButton jbtnovo;
    private javax.swing.JButton jbtsalvar;
    private javax.swing.JLabel jldescricao;
    private javax.swing.JLabel jlid_grupo;
    private javax.swing.JTable jtbpacotes;
    private javax.swing.JTextField jtfdescricao;
    private javax.swing.JTextField jtfid_grupo;
    private javax.swing.JTextField jtfpesquisar;
    private javax.swing.JPanel pnlgrupo;
    private javax.swing.JPanel pnlgrupos_cadastrados;
    // End of variables declaration//GEN-END:variables
    private PacoteData pacotedata;
    private PacoteControler controler;
    private Pacote pacote;
}
