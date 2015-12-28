package view.processo;

import controler.processo.FinalizacaoControler;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.processo.Finalizacao;
import model.processo.FinalizacaoData;
import model.processo.Opcao;
import model.processo.OpcaoData;

public class FinalizacaoView extends javax.swing.JInternalFrame {

    public FinalizacaoView()
    {
        finalizacaodata = new FinalizacaoData();
        controller = new FinalizacaoControler();
        initComponents();
        tblfinalizacoes.getSelectionModel().addListSelectionListener(selectionListener);
        tblfinalizacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupstatus = new javax.swing.ButtonGroup();
        groupvalor = new javax.swing.ButtonGroup();
        pnlfinalizacao = new javax.swing.JPanel();
        lblcodigo = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        lbldescricao = new javax.swing.JLabel();
        descricao = new javax.swing.JTextField();
        pnlstatus = new javax.swing.JPanel();
        jrbativo = new javax.swing.JRadioButton();
        jrbinativo = new javax.swing.JRadioButton();
        pnlvalor = new javax.swing.JPanel();
        jrbpermite = new javax.swing.JRadioButton();
        jrbnaopermite = new javax.swing.JRadioButton();
        jrbpadrao = new javax.swing.JRadioButton();
        jtvalorpadrao = new javax.swing.JTextField();
        jcbformulario = new javax.swing.JCheckBox();
        pnlacoes = new javax.swing.JPanel();
        btnnovo = new javax.swing.JButton();
        btnalterar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btngravar = new javax.swing.JButton();
        pnlpesquisa = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblfinalizacoes = new javax.swing.JTable();
        lblpesquisar = new javax.swing.JLabel();
        pesquisar = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Finalizações");
        setVisible(true);

        pnlfinalizacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Finalização"));

        lblcodigo.setText("Código:");

        codigo.setEditable(false);

        lbldescricao.setText("Descrição:");

        descricao.setEditable(false);
        descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descricaoActionPerformed(evt);
            }
        });

        pnlstatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        groupstatus.add(jrbativo);
        jrbativo.setText("Ativo");
        jrbativo.setEnabled(false);
        jrbativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbativoActionPerformed(evt);
            }
        });

        groupstatus.add(jrbinativo);
        jrbinativo.setText("Inativo");
        jrbinativo.setEnabled(false);

        javax.swing.GroupLayout pnlstatusLayout = new javax.swing.GroupLayout(pnlstatus);
        pnlstatus.setLayout(pnlstatusLayout);
        pnlstatusLayout.setHorizontalGroup(
            pnlstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlstatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbativo)
                    .addComponent(jrbinativo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlstatusLayout.setVerticalGroup(
            pnlstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlstatusLayout.createSequentialGroup()
                .addComponent(jrbativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbinativo)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pnlvalor.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor"));

        groupvalor.add(jrbpermite);
        jrbpermite.setText("Permite entrada");
        jrbpermite.setEnabled(false);
        jrbpermite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbpermiteActionPerformed(evt);
            }
        });

        groupvalor.add(jrbnaopermite);
        jrbnaopermite.setText("Não permite entrada");
        jrbnaopermite.setEnabled(false);

        groupvalor.add(jrbpadrao);
        jrbpadrao.setText("Valor padrão");
        jrbpadrao.setEnabled(false);
        jrbpadrao.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jrbpadraoStateChanged(evt);
            }
        });

        jtvalorpadrao.setEditable(false);

        jcbformulario.setText("Exibir formulário");
        jcbformulario.setEnabled(false);

        javax.swing.GroupLayout pnlvalorLayout = new javax.swing.GroupLayout(pnlvalor);
        pnlvalor.setLayout(pnlvalorLayout);
        pnlvalorLayout.setHorizontalGroup(
            pnlvalorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlvalorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlvalorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbpermite)
                    .addGroup(pnlvalorLayout.createSequentialGroup()
                        .addComponent(jrbnaopermite)
                        .addGap(18, 18, 18)
                        .addComponent(jcbformulario, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                    .addGroup(pnlvalorLayout.createSequentialGroup()
                        .addComponent(jrbpadrao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtvalorpadrao, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlvalorLayout.setVerticalGroup(
            pnlvalorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlvalorLayout.createSequentialGroup()
                .addComponent(jrbpermite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlvalorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbnaopermite)
                    .addComponent(jcbformulario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlvalorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbpadrao)
                    .addComponent(jtvalorpadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlfinalizacaoLayout = new javax.swing.GroupLayout(pnlfinalizacao);
        pnlfinalizacao.setLayout(pnlfinalizacaoLayout);
        pnlfinalizacaoLayout.setHorizontalGroup(
            pnlfinalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlfinalizacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlfinalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldescricao)
                    .addComponent(lblcodigo)
                    .addGroup(pnlfinalizacaoLayout.createSequentialGroup()
                        .addComponent(pnlstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlvalor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlfinalizacaoLayout.setVerticalGroup(
            pnlfinalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlfinalizacaoLayout.createSequentialGroup()
                .addComponent(lblcodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlfinalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlvalor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlacoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnnovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/newfile_wiz.gif"))); // NOI18N
        btnnovo.setText("Novo");
        btnnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnovoActionPerformed(evt);
            }
        });

        btnalterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/synced.gif"))); // NOI18N
        btnalterar.setText("Alterar");
        btnalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterarActionPerformed(evt);
            }
        });

        btnexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/delete_edit.gif"))); // NOI18N
        btnexcluir.setText("Excluir");
        btnexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/progress_stop.gif"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.setEnabled(false);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btngravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/save_edit.gif"))); // NOI18N
        btngravar.setText("Gravar");
        btngravar.setEnabled(false);
        btngravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlacoesLayout = new javax.swing.GroupLayout(pnlacoes);
        pnlacoes.setLayout(pnlacoesLayout);
        pnlacoesLayout.setHorizontalGroup(
            pnlacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnalterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnexcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btngravar)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlacoesLayout.setVerticalGroup(
            pnlacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnovo)
                    .addComponent(btnalterar)
                    .addComponent(btnexcluir)
                    .addComponent(btncancelar)
                    .addComponent(btngravar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlpesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder("Finalizações"));

        tblfinalizacoes.setModel(finalizacaodata);
        tblfinalizacoes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblfinalizacoes);

        lblpesquisar.setText("Pesquisar:");

        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlpesquisaLayout = new javax.swing.GroupLayout(pnlpesquisa);
        pnlpesquisa.setLayout(pnlpesquisaLayout);
        pnlpesquisaLayout.setHorizontalGroup(
            pnlpesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlpesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlpesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblpesquisar)
                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlpesquisaLayout.setVerticalGroup(
            pnlpesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlpesquisaLayout.createSequentialGroup()
                .addComponent(lblpesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlfinalizacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(pnlacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(7, 7, 7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlfinalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-516)/2, (screenSize.height-571)/2, 516, 571);
    }// </editor-fold>//GEN-END:initComponents

    private void btnnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnovoActionPerformed
        limpaDados();
        statusEdicao();
        jrbativo.setSelected(true);
        jrbpermite.setSelected(true);
        
    }//GEN-LAST:event_btnnovoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        statusVisualizacao();
        selectionListener.valueChanged(null);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btngravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngravarActionPerformed

            if(!montaFinalizacao(true)) return;
            controller.gravarFinalizacao(finalizacao);
            tblfinalizacoes.setModel(new FinalizacaoData());
            tblfinalizacoes.revalidate();
            tblfinalizacoes.repaint();
            statusVisualizacao();
            selectionListener.valueChanged(null);
     
    }//GEN-LAST:event_btngravarActionPerformed

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
            montaFinalizacao(false);
            controller.deleteFinalizacao(finalizacao);
            tblfinalizacoes.setModel(new FinalizacaoData());
            tblfinalizacoes.revalidate();
            tblfinalizacoes.repaint();
            statusVisualizacao();
            selectionListener.valueChanged(null);

    }//GEN-LAST:event_btnexcluirActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        
    }//GEN-LAST:event_pesquisarActionPerformed

    private void btnalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterarActionPerformed
            if(descricao.getText().compareToIgnoreCase("")==0) return;
            statusEdicao();
            
    }//GEN-LAST:event_btnalterarActionPerformed

    private void jrbativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbativoActionPerformed
        
    }//GEN-LAST:event_jrbativoActionPerformed

    private void descricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descricaoActionPerformed
        
    }//GEN-LAST:event_descricaoActionPerformed

    private void jrbpadraoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jrbpadraoStateChanged
        if(jrbpadrao.isSelected())
        {
            jtvalorpadrao.setEditable(true);
            return;
        }
        else jtvalorpadrao.setEditable(false);
            jtvalorpadrao.setText("");
    }//GEN-LAST:event_jrbpadraoStateChanged

    private void jrbpermiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbpermiteActionPerformed

    }//GEN-LAST:event_jrbpermiteActionPerformed

    public void setOpcao(Opcao opcao)
    {
        
    }

    public void limpaDados()
    {
        codigo.setText("");
        descricao.setText("");
        jtvalorpadrao.setText("");
    }

    private void statusEdicao()
    {
        descricao.setEditable(true);
        btnnovo.setEnabled(false);
        btnalterar.setEnabled(false);
        btnexcluir.setEnabled(false);
        btncancelar.setEnabled(true);
        btngravar.setEnabled(true);
        pesquisar.setEditable(false);
        jrbativo.setEnabled(true);
        jrbinativo.setEnabled(true);
        jrbpermite.setEnabled(true);
        jrbnaopermite.setEnabled(true);
        jrbpadrao.setEnabled(true);
        jcbformulario.setEnabled(true);

    }

    private void statusVisualizacao()
    {
        descricao.setEditable(false);
        btnnovo.setEnabled(true);
        btnalterar.setEnabled(true);
        btnexcluir.setEnabled(true);
        btncancelar.setEnabled(false);
        btngravar.setEnabled(false);
        pesquisar.setEditable(true);
        jrbativo.setEnabled(false);
        jrbinativo.setEnabled(false);
        jrbpermite.setEnabled(false);
        jrbnaopermite.setEnabled(false);
        jrbpadrao.setEnabled(false);
        jcbformulario.setEnabled(false);
    }

    private ListSelectionListener selectionListener = new ListSelectionListener()
    {
        public void valueChanged(ListSelectionEvent e)
        {
            int linha = tblfinalizacoes.getSelectedRow();
            if(linha == -1) return;
            finalizacaodata = new FinalizacaoData();
            finalizacao = finalizacaodata.getFinalizacaoId(Integer.valueOf(String.valueOf(tblfinalizacoes.getValueAt(linha, 0))));
            codigo.setText(String.valueOf(finalizacao.getId()));
            descricao.setText(finalizacao.getNome());
            if(finalizacao.getValor() != null)
            {
                if(finalizacao.getValor().compareToIgnoreCase("\\")==0)
                {
                    jrbnaopermite.setSelected(true);
                    
                }
                else if(finalizacao.getValor().compareToIgnoreCase("/")==0)
                {
                    
                    jrbpermite.setSelected(true);
                    pg = finalizacao.getPergunta();
                }
                else{
                        jtvalorpadrao.setText(finalizacao.getValor());
                        jtvalorpadrao.setEditable(false);
                        jrbpadrao.setSelected(true);
                        }
            }
            if(finalizacao.getStatus()== 0)
            {
                jrbativo.setSelected(true);
            }else
            {
                jrbinativo.setSelected(true);
            }
            
        }
    };

    private ListSelectionListener selectionListenerop = new ListSelectionListener()
    {
        public void valueChanged(ListSelectionEvent e)
        {
            int linha = tblfinalizacoes.getSelectedRow();
            if(linha == -1) return;
            finalizacaodata = new FinalizacaoData();
            finalizacao = finalizacaodata.getFinalizacaoId(Integer.valueOf(String.valueOf(tblfinalizacoes.getValueAt(linha, 0))));
            codigo.setText(String.valueOf(finalizacao.getId()));
            descricao.setText(finalizacao.getNome());
            
        }
    };

    public boolean montaFinalizacao(boolean pergunta)
    {
       finalizacao = new Finalizacao();
      
       try
       {
           finalizacao.setId(Integer.parseInt(codigo.getText()));
       }
       catch(NumberFormatException e)
       {
         finalizacao.setId(0);
       }

       if(descricao.getText().compareToIgnoreCase("") == 0 || descricao.getText() == null)
       {
           JOptionPane.showMessageDialog(null, "Campo descrição não pode ser nulo","Erro de inserção",0);
           return false;
       }
       finalizacao.setNome(descricao.getText());

       if(jrbpermite.isSelected()) 
       {
           finalizacao.setValor("/");
           if(pergunta)
           {
               finalizacao.setPergunta(JOptionPane.showInputDialog(null,"Digite a informação da tela de inserção :",pg));
           }
       }
       if(jrbnaopermite.isSelected()) finalizacao.setValor("\\");
       if(jrbpadrao.isSelected())
       {
           if(jtvalorpadrao.getText().compareToIgnoreCase("") == 0)
               {
                   JOptionPane.showMessageDialog(null, "O campo valor não pode ser nulo, varifique!","Erro",0);
                   return false;
               }
           finalizacao.setValor(jtvalorpadrao.getText());
       }
       if(jrbativo.isSelected())
           {
            finalizacao.setStatus(0);
           }else finalizacao.setStatus(1);
       if(jcbformulario.isSelected())
           {
                new FormularioView(null, closable,finalizacao.getId()).setVisible(true);
           }
       return true;
    }
    public void atualizaTables(OpcaoData op)
    {
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnalterar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btngravar;
    private javax.swing.JButton btnnovo;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField descricao;
    private javax.swing.ButtonGroup groupstatus;
    private javax.swing.ButtonGroup groupvalor;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox jcbformulario;
    private javax.swing.JRadioButton jrbativo;
    private javax.swing.JRadioButton jrbinativo;
    private javax.swing.JRadioButton jrbnaopermite;
    private javax.swing.JRadioButton jrbpadrao;
    private javax.swing.JRadioButton jrbpermite;
    private javax.swing.JTextField jtvalorpadrao;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lbldescricao;
    private javax.swing.JLabel lblpesquisar;
    private javax.swing.JTextField pesquisar;
    private javax.swing.JPanel pnlacoes;
    private javax.swing.JPanel pnlfinalizacao;
    private javax.swing.JPanel pnlpesquisa;
    private javax.swing.JPanel pnlstatus;
    private javax.swing.JPanel pnlvalor;
    private javax.swing.JTable tblfinalizacoes;
    // End of variables declaration//GEN-END:variables
    
    private FinalizacaoData finalizacaodata;
    public Finalizacao finalizacao;
    private FinalizacaoControler controller;
    private String pg = "";
}
