package view.processo;

import Util.FabricaConexoes;
import Util.manipulaConexao;
import controler.processo.ProcessoControler;
import execoes.CamposException;
import java.awt.Color;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.processo.Processo;
import model.processo.ProcessoData;
import model.sistema.Usuario;
import model.sistema.UsuarioDao;

//TODO Validar o funcionamento da pesquisa do gestor do processo
public class ProcessoView extends javax.swing.JInternalFrame {

    public ProcessoView() {
        processodata = new ProcessoData();
        dtformat = new SimpleDateFormat("dd/MM/yyyy");
        initComponents();
        tblprocessos.getSelectionModel().addListSelectionListener(selectionListener);
        tblprocessos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        processocontroler = new ProcessoControler();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jrgstatus = new javax.swing.ButtonGroup();
        pnldadosprocessos = new javax.swing.JPanel();
        lblcodigo = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        lblnome = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        lbldescricao = new javax.swing.JLabel();
        lbldatacriacao = new javax.swing.JLabel();
        lblversao = new javax.swing.JLabel();
        versao = new javax.swing.JTextField();
        pnlstatus = new javax.swing.JPanel();
        rdbativo = new javax.swing.JRadioButton();
        rdbinativo = new javax.swing.JRadioButton();
        jspdescricao = new javax.swing.JScrollPane();
        descricao = new javax.swing.JTextArea();
        datacriacao = new javax.swing.JFormattedTextField();
        autor = new javax.swing.JTextField();
        lblautor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        gestor = new javax.swing.JTextField();
        jbtgestor = new javax.swing.JButton();
        pnlcontroles = new javax.swing.JPanel();
        btninserir = new javax.swing.JButton();
        btnalterar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btngravar = new javax.swing.JButton();
        btnmapeamento = new javax.swing.JButton();
        pnlprocessos = new javax.swing.JPanel();
        jspprocessos = new javax.swing.JScrollPane();
        tblprocessos = new javax.swing.JTable();
        lblpesquisar = new javax.swing.JLabel();
        pesquisar = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Processos");
        setName("processos"); // NOI18N
        setVisible(true);

        pnldadosprocessos.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Processo"));

        lblcodigo.setText("Codigo:");

        codigo.setEditable(false);

        lblnome.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblnome.setText("Nome:");

        nome.setEditable(false);

        lbldescricao.setText("Descrição:");

        lbldatacriacao.setText("Data de criação:");

        lblversao.setText("Versão:");

        versao.setEditable(false);

        pnlstatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        jrgstatus.add(rdbativo);
        rdbativo.setSelected(true);
        rdbativo.setText("Ativo");
        rdbativo.setEnabled(false);
        rdbativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbativoActionPerformed(evt);
            }
        });

        jrgstatus.add(rdbinativo);
        rdbinativo.setText("Inativo");
        rdbinativo.setEnabled(false);

        javax.swing.GroupLayout pnlstatusLayout = new javax.swing.GroupLayout(pnlstatus);
        pnlstatus.setLayout(pnlstatusLayout);
        pnlstatusLayout.setHorizontalGroup(
            pnlstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlstatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdbativo)
                .addGap(18, 18, 18)
                .addComponent(rdbinativo)
                .addContainerGap(431, Short.MAX_VALUE))
        );
        pnlstatusLayout.setVerticalGroup(
            pnlstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rdbativo)
                .addComponent(rdbinativo))
        );

        descricao.setBackground(new java.awt.Color(212, 208, 200));
        descricao.setColumns(20);
        descricao.setEditable(false);
        descricao.setRows(5);
        jspdescricao.setViewportView(descricao);

        datacriacao.setEditable(false);
        datacriacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        autor.setEditable(false);

        lblautor.setText("Autor:");

        jLabel1.setText("Gestor:");

        gestor.setEditable(false);
        gestor.setName("responsavel"); // NOI18N
        gestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestorActionPerformed(evt);
            }
        });

        jbtgestor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/help_contents.gif"))); // NOI18N
        jbtgestor.setEnabled(false);
        jbtgestor.setSelected(true);
        jbtgestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtgestorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnldadosprocessosLayout = new javax.swing.GroupLayout(pnldadosprocessos);
        pnldadosprocessos.setLayout(pnldadosprocessosLayout);
        pnldadosprocessosLayout.setHorizontalGroup(
            pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldadosprocessosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnldadosprocessosLayout.createSequentialGroup()
                        .addGroup(pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnldadosprocessosLayout.createSequentialGroup()
                                .addGroup(pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblautor)
                                    .addComponent(autor, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                                    .addComponent(gestor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtgestor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnldadosprocessosLayout.createSequentialGroup()
                                            .addComponent(lblversao)
                                            .addGap(71, 71, 71))
                                        .addComponent(versao, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblnome)
                                .addComponent(nome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbldescricao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnldadosprocessosLayout.createSequentialGroup()
                                .addGroup(pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblcodigo)
                                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbldatacriacao)
                                    .addComponent(datacriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jspdescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))
                        .addGap(22, 22, 22))
                    .addGroup(pnldadosprocessosLayout.createSequentialGroup()
                        .addComponent(pnlstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(pnldadosprocessosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(553, Short.MAX_VALUE))))
        );
        pnldadosprocessosLayout.setVerticalGroup(
            pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldadosprocessosLayout.createSequentialGroup()
                .addGroup(pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnldadosprocessosLayout.createSequentialGroup()
                        .addComponent(lblcodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datacriacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnldadosprocessosLayout.createSequentialGroup()
                        .addComponent(lbldatacriacao)
                        .addGap(26, 26, 26)))
                .addGap(4, 4, 4)
                .addComponent(lblnome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnldadosprocessosLayout.createSequentialGroup()
                        .addComponent(lblautor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnldadosprocessosLayout.createSequentialGroup()
                        .addComponent(lblversao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(versao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnldadosprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtgestor, 0, 0, Short.MAX_VALUE)
                    .addComponent(gestor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlcontroles.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btninserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/newfile_wiz.gif"))); // NOI18N
        btninserir.setText("Novo");
        btninserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninserirActionPerformed(evt);
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

        btnmapeamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/defaults_ps.gif"))); // NOI18N
        btnmapeamento.setText("Mapeamento");
        btnmapeamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmapeamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlcontrolesLayout = new javax.swing.GroupLayout(pnlcontroles);
        pnlcontroles.setLayout(pnlcontrolesLayout);
        pnlcontrolesLayout.setHorizontalGroup(
            pnlcontrolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcontrolesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btninserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnalterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnexcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnmapeamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btngravar)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnlcontrolesLayout.setVerticalGroup(
            pnlcontrolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcontrolesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlcontrolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btninserir)
                    .addComponent(btnalterar)
                    .addComponent(btnexcluir)
                    .addComponent(btnmapeamento)
                    .addComponent(btncancelar)
                    .addComponent(btngravar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlprocessos.setBorder(javax.swing.BorderFactory.createTitledBorder("Processos"));

        tblprocessos.setModel(processodata);
        tblprocessos.setName("processo"); // NOI18N
        tblprocessos.getTableHeader().setReorderingAllowed(false);
        jspprocessos.setViewportView(tblprocessos);

        lblpesquisar.setText("Pesquisar:");

        pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pesquisarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlprocessosLayout = new javax.swing.GroupLayout(pnlprocessos);
        pnlprocessos.setLayout(pnlprocessosLayout);
        pnlprocessosLayout.setHorizontalGroup(
            pnlprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlprocessosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspprocessos, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addComponent(lblpesquisar)
                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlprocessosLayout.setVerticalGroup(
            pnlprocessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlprocessosLayout.createSequentialGroup()
                .addComponent(lblpesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspprocessos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnldadosprocessos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlcontroles, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlprocessos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnldadosprocessos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlcontroles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlprocessos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-647)/2, (screenSize.height-672)/2, 647, 672);
    }// </editor-fold>//GEN-END:initComponents

    private void rdbativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbativoActionPerformed
        
    }//GEN-LAST:event_rdbativoActionPerformed

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
        corrigeBug();
        Object[] options = {"Sim", "Não"};
        montaObj();
        int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse registro?", "Exclusão de processo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (i == 0) {
            try {
                processocontroler.deleteProcesso(processo);
                processodata.atualizaDados();
                tblprocessos.revalidate();
                tblprocessos.repaint();
                JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso.", "Exclusão de processo", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();

                if (e.getErrorCode() == 1451) {
                    JOptionPane.showMessageDialog(null, "O registro não pode ser excluido pois se encontra referenciado em outras funcionalidades dos sistema", "Alerta", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar excluir o registro, contate o administrador do sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnexcluirActionPerformed

    private void btngravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngravarActionPerformed
        try {
            processocontroler.gravarProcesso(montaObj());
            processodata.atualizaDados();
            tblprocessos.revalidate();
            tblprocessos.repaint();
            JOptionPane.showMessageDialog(null, "Gravado como sucesso");
            setModoVisualizacao();
        } catch (CamposException ex) {
            JOptionPane.showMessageDialog(null, "O campo " + ex.getCampo() + " é obrigátorio.", "Campos obrigátorios", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao tentar gravar processo.", "Falha do sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btngravarActionPerformed

    private void btninserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninserirActionPerformed
        Usuario user = manipulaConexao.getUsuarioLogado();

        limparCampos();
        setModoEdicao();
        datacriacao.setText(dtformat.format(new Date()));
        autor.setText(user.getNome());
        rdbativo.setSelected(true);
        setModoEdicao();
    }//GEN-LAST:event_btninserirActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        limparCampos();
        setModoVisualizacao();        
    }//GEN-LAST:event_btncancelarActionPerformed

    private void pesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarKeyPressed
        TableRowSorter<TableModel> sorter;
        sorter = new TableRowSorter<TableModel>(tblprocessos.getModel());
        tblprocessos.setRowSorter(sorter);
        sorter.setRowFilter(javax.swing.RowFilter.regexFilter(pesquisar.getText(), 1));
    }//GEN-LAST:event_pesquisarKeyPressed

    private void btnalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterarActionPerformed
        corrigeBug();
        setModoEdicao();
    }//GEN-LAST:event_btnalterarActionPerformed

    private void btnmapeamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmapeamentoActionPerformed
        corrigeBug();
        try {
            
                    toBack();

                    if (modelagemview == null) {
                    modelagemview = new ModelagemView(Integer.valueOf(codigo.getText()));

                    getDesktopPane().add(modelagemview);
                }

                modelagemview.setVisible(true);
                modelagemview.toFront();

                try {
                    modelagemview.setSelected(true);
                } catch (PropertyVetoException ex) {
                }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Selecione um processo primeiro.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnmapeamentoActionPerformed

    private void gestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestorActionPerformed
    }//GEN-LAST:event_gestorActionPerformed

    private void jbtgestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtgestorActionPerformed
        new PesquisaUsuarioView(this, true).setVisible(true);
    }//GEN-LAST:event_jbtgestorActionPerformed

    public void setGestor() {
        gestor.setText(getProcesso().getGestor().getNome());
    }

    private void setModoEdicao() {
        nome.setEditable(true);
        descricao.setEditable(true);
        descricao.setBackground(new Color(255, 255, 255));
        versao.setEditable(true);
        btninserir.setEnabled(false);
        btnalterar.setEnabled(false);
        btnexcluir.setEnabled(false);
        btnmapeamento.setEnabled(false);
        btncancelar.setEnabled(true);
        btngravar.setEnabled(true);
        rdbativo.setEnabled(true);
        rdbinativo.setEnabled(true);
        pesquisar.setEditable(false);
        tblprocessos.setEnabled(false);
        jbtgestor.setEnabled(true);
    }

    private void setModoVisualizacao() {
        nome.setEditable(false);
        descricao.setEditable(false);
        descricao.setBackground(new Color(212, 208, 200));
        versao.setEditable(false);
        btninserir.setEnabled(true);
        btnalterar.setEnabled(true);
        btnexcluir.setEnabled(true);
        btnmapeamento.setEnabled(true);
        btncancelar.setEnabled(false);
        btngravar.setEnabled(false);
        rdbativo.setEnabled(false);
        rdbinativo.setEnabled(false);
        pesquisar.setEditable(true);
        tblprocessos.setEnabled(true);
        jbtgestor.setEnabled(false);
    }

    private void limparCampos() {
        codigo.setText(null);
        nome.setText(null);
        descricao.setText(null);
        autor.setText(null);
        versao.setText(null);
        datacriacao.setText(null);
        pesquisar.setText(null);
        gestor.setText(null);
    }

    private Processo montaObj() {
        Usuario user = manipulaConexao.getUsuarioLogado();
        processo = new Processo();

        try {
            processo.setIdproceso(Integer.parseInt(codigo.getText()));
        } catch (NumberFormatException e) {
            processo.setIdproceso(0);
        }

        processo.setNome(nome.getText());
        processo.setDescricao(descricao.getText());
        processo.setAutor(user);
        processo.setVersao(versao.getText());
        processo.setDatacriacao(new Date());
        try
        {
            processo.setGestor(new UsuarioDao().getUsuario(gestor.getText()));
        }catch(Exception exception)
        {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, exception.getMessage(),"Erro",0);
        }
        if (jrgstatus.isSelected(rdbativo.getModel())) {
            processo.setStatus(1);
        } else {
            processo.setStatus(0);
        }

        return processo;
    }
    private ListSelectionListener selectionListener = new ListSelectionListener() {

        public void valueChanged(ListSelectionEvent e) {
            int linha = tblprocessos.getSelectedRow();
            processo = processodata.getProcesso(linha);
            codigo.setText(String.valueOf(processo.getIdproceso()));
            nome.setText(processo.getNome());
            descricao.setText(processo.getDescricao());
            autor.setText(processo.getAutor().getNome());
            versao.setText(processo.getVersao());
            datacriacao.setText(dtformat.format(processo.getDatacriacao()));
            gestor.setText(processo.getGestor().getNome());
            if (processo.getStatus() == 0) {
                rdbinativo.setSelected(true);
            } else {
                rdbativo.setSelected(true);
            }

            FabricaConexoes.closeConnection();
        }
    };

    public void corrigeBug()
    {
        int linha = tblprocessos.getSelectedRow();
            processo = processodata.getProcesso(linha);
            codigo.setText(String.valueOf(processo.getIdproceso()));
            nome.setText(processo.getNome());
            descricao.setText(processo.getDescricao());
            autor.setText(processo.getAutor().getNome());
            versao.setText(processo.getVersao());
            datacriacao.setText(dtformat.format(processo.getDatacriacao()));
            gestor.setText(processo.getGestor().getNome());
            if (processo.getStatus() == 0) {
                rdbinativo.setSelected(true);
            } else {
                rdbativo.setSelected(true);
            }

            FabricaConexoes.closeConnection();
        }


    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField autor;
    private javax.swing.JButton btnalterar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btngravar;
    private javax.swing.JButton btninserir;
    private javax.swing.JButton btnmapeamento;
    private javax.swing.JTextField codigo;
    private javax.swing.JFormattedTextField datacriacao;
    private javax.swing.JTextArea descricao;
    private javax.swing.JTextField gestor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtgestor;
    private javax.swing.ButtonGroup jrgstatus;
    private javax.swing.JScrollPane jspdescricao;
    private javax.swing.JScrollPane jspprocessos;
    private javax.swing.JLabel lblautor;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lbldatacriacao;
    private javax.swing.JLabel lbldescricao;
    private javax.swing.JLabel lblnome;
    private javax.swing.JLabel lblpesquisar;
    private javax.swing.JLabel lblversao;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField pesquisar;
    private javax.swing.JPanel pnlcontroles;
    private javax.swing.JPanel pnldadosprocessos;
    private javax.swing.JPanel pnlprocessos;
    private javax.swing.JPanel pnlstatus;
    private javax.swing.JRadioButton rdbativo;
    private javax.swing.JRadioButton rdbinativo;
    private javax.swing.JTable tblprocessos;
    private javax.swing.JTextField versao;
    // End of variables declaration//GEN-END:variables
    private ProcessoData processodata;
    private ProcessoControler processocontroler;
    private Processo processo = new Processo();
    private DateFormat dtformat;
    private ModelagemView modelagemview;
}
