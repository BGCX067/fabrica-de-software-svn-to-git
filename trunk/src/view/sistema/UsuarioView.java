package view.sistema;

import controler.sistema.UsuarioControler;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.sistema.Usuario;
import model.sistema.UsuarioData;
import Util.FabricaConexoes;
import execoes.CamposException;
import java.sql.SQLException;

public class UsuarioView extends javax.swing.JInternalFrame {

    public UsuarioView()
    {
        userdata = new UsuarioData();
        controler = new UsuarioControler();
        initComponents();
        tblusuarios.getSelectionModel().addListSelectionListener(selectionListener);
        tblusuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       // tblusuarios.setRowSelectionInterval(0, 0);    
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlcadastro = new javax.swing.JPanel();
        email = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        login = new javax.swing.JTextField();
        lblnome = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lblogin = new javax.swing.JLabel();
        lblsenha = new javax.swing.JLabel();
        jPanel_campos = new javax.swing.JPanel();
        lblcodigo = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        lblconfsenha = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        confsenha = new javax.swing.JPasswordField();
        pnlpesquisa = new javax.swing.JPanel();
        lblpesquisar = new javax.swing.JLabel();
        pesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblusuarios = new javax.swing.JTable();
        pnlbotoes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnsalvar = new javax.swing.JButton();
        btnnovo = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnalterar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de usuários");
        setAutoscrolls(true);
        setMaximumSize(null);
        setName("usuarioview"); // NOI18N
        setVisible(true);

        pnlcadastro.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do usuário"));
        pnlcadastro.setFont(new java.awt.Font("Tahoma", 1, 11));

        email.setEditable(false);

        nome.setEditable(false);
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        login.setEditable(false);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        lblnome.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblnome.setText("Nome :");

        lblemail.setText("Email :");

        lblogin.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblogin.setText("Login :");

        lblsenha.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblsenha.setText("Senha :");

        jPanel_campos.setLayout(new java.awt.GridBagLayout());

        lblcodigo.setText("Código:");

        codigo.setEditable(false);
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        lblconfsenha.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblconfsenha.setText("Conf. Senha:");

        senha.setEditable(false);

        confsenha.setEditable(false);

        javax.swing.GroupLayout pnlcadastroLayout = new javax.swing.GroupLayout(pnlcadastro);
        pnlcadastro.setLayout(pnlcadastroLayout);
        pnlcadastroLayout.setHorizontalGroup(
            pnlcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_campos, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
            .addGroup(pnlcadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlcadastroLayout.createSequentialGroup()
                        .addComponent(lblnome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                .addGap(167, 167, 167))
            .addGroup(pnlcadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblcodigo)
                .addContainerGap(439, Short.MAX_VALUE))
            .addGroup(pnlcadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(385, Short.MAX_VALUE))
            .addGroup(pnlcadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addGroup(pnlcadastroLayout.createSequentialGroup()
                        .addComponent(lblemail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(167, 167, 167))
            .addGroup(pnlcadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlcadastroLayout.createSequentialGroup()
                        .addGroup(pnlcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblsenha)
                            .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblconfsenha)
                            .addComponent(confsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblogin, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(login, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(204, 204, 204))
        );
        pnlcadastroLayout.setVerticalGroup(
            pnlcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcadastroLayout.createSequentialGroup()
                .addComponent(lblcodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlcadastroLayout.createSequentialGroup()
                        .addComponent(lblsenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblemail))
                    .addGroup(pnlcadastroLayout.createSequentialGroup()
                        .addComponent(lblconfsenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jPanel_campos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlpesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuários cadastrados"));

        lblpesquisar.setText("Pesquisar: ");

        pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisaKeyReleased(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblusuarios.setModel(userdata);
        tblusuarios.setGridColor(new java.awt.Color(102, 102, 102));
        tblusuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblusuarios);

        javax.swing.GroupLayout pnlpesquisaLayout = new javax.swing.GroupLayout(pnlpesquisa);
        pnlpesquisa.setLayout(pnlpesquisaLayout);
        pnlpesquisaLayout.setHorizontalGroup(
            pnlpesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlpesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlpesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addComponent(lblpesquisar)
                    .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlpesquisaLayout.setVerticalGroup(
            pnlpesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlpesquisaLayout.createSequentialGroup()
                .addComponent(lblpesquisar)
                .addGap(3, 3, 3)
                .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(348, 348, 348))
        );

        pnlbotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/save_edit.gif"))); // NOI18N
        btnsalvar.setText("Salvar");
        btnsalvar.setEnabled(false);
        btnsalvar.setMaximumSize(null);
        btnsalvar.setMinimumSize(null);
        btnsalvar.setPreferredSize(null);
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });

        btnnovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/newfile_wiz.gif"))); // NOI18N
        btnnovo.setText("Novo");
        btnnovo.setMaximumSize(null);
        btnnovo.setMinimumSize(null);
        btnnovo.setPreferredSize(null);
        btnnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnovoActionPerformed(evt);
            }
        });

        btnexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/delete_edit.gif"))); // NOI18N
        btnexcluir.setText("Excluir");
        btnexcluir.setMaximumSize(null);
        btnexcluir.setMinimumSize(null);
        btnexcluir.setPreferredSize(null);
        btnexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/progress_stop.gif"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.setEnabled(false);
        btncancelar.setMaximumSize(null);
        btncancelar.setMinimumSize(null);
        btncancelar.setPreferredSize(null);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnalterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/synced.gif"))); // NOI18N
        btnalterar.setText("Alterar");
        btnalterar.setMaximumSize(null);
        btnalterar.setMinimumSize(null);
        btnalterar.setPreferredSize(null);
        btnalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlbotoesLayout = new javax.swing.GroupLayout(pnlbotoes);
        pnlbotoes.setLayout(pnlbotoesLayout);
        pnlbotoesLayout.setHorizontalGroup(
            pnlbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
            .addGroup(pnlbotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnalterar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlbotoesLayout.setVerticalGroup(
            pnlbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbotoesLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnalterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnnovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlcadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlbotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlpesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlcadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlbotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-520)/2, (screenSize.height-547)/2, 520, 547);
    }// </editor-fold>//GEN-END:initComponents

    private void btnalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterarActionPerformed
       
        statusEdicao();
    }//GEN-LAST:event_btnalterarActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
      
    }//GEN-LAST:event_nomeActionPerformed

    private void pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisaKeyReleased
        TableRowSorter<TableModel> sorter;
        sorter = new TableRowSorter<TableModel>(tblusuarios.getModel());
        tblusuarios.setRowSorter(sorter);
        sorter.setRowFilter(javax.swing.RowFilter.regexFilter(pesquisa.getText(),1));
    }//GEN-LAST:event_pesquisaKeyReleased

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
       
    }//GEN-LAST:event_codigoActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
           
        montaUsuario();

        if(confSenha())
        {
            try
            {
                controler.gravar(usuario);
                userdata.atualizaDados();
                tblusuarios.revalidate();
                tblusuarios.repaint();
                limpaCampos();
                statusVisualizacao();
                JOptionPane.showMessageDialog(null, "Gravado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(CamposException e)
            {
                JOptionPane.showMessageDialog(null, "O campo: " + e.getCampo() + " é obrigatório.", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Falha ao tentar gravar o usuario. Contate o administrador do sistema.","Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "A senha informada não confere. Por favor verifique.");
            senha.requestFocus();
        }
    }//GEN-LAST:event_btnsalvarActionPerformed

    private void btnnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnovoActionPerformed
       
        limpaCampos();
        statusEdicao();
    }//GEN-LAST:event_btnnovoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
       
        statusVisualizacao();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed

        try
        {
            montaUsuario();
            controler.excluirUsuario(usuario);
            limpaCampos();
            statusVisualizacao();
            userdata.atualizaDados();
            tblusuarios.revalidate();
            tblusuarios.repaint();
            JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException e)
        {
             JOptionPane.showMessageDialog(null, "O usuario esta referenciado a outras funcionalidades do sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "Falha ao tentar excluir o usuario. \n Contate o administrador do sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnexcluirActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
       
    }//GEN-LAST:event_loginActionPerformed

    private void limpaCampos()
    {
        codigo.setText(null);
        nome.setText(null);
        login.setText(null);
        senha.setText(null);
        confsenha.setText(null);
        email.setText(null);
    }

    private void montaUsuario()
    {
        usuario = new Usuario();

        try
        {
            usuario.setId(Integer.parseInt(codigo.getText()));
        }
        catch(NumberFormatException e)
        {
            usuario.setId(0);
        }

        usuario.setNome(nome.getText());
        usuario.setLogin(login.getText());
        usuario.setSenha(new String(senha.getPassword()));
        usuario.setEmail(email.getText());
    }

    private void statusVisualizacao()
    {
        pesquisa.setEditable(true);
        nome.setEditable(false);
        login.setEditable(false);
        senha.setEditable(false);
        confsenha.setEditable(false);
        email.setEditable(false);
        btnnovo.setEnabled(true);
        btnalterar.setEnabled(true);
        btnexcluir.setEnabled(true);
        btncancelar.setEnabled(false);
        btncancelar.setEnabled(false);
        btnsalvar.setEnabled(false);
        tblusuarios.setEnabled(true);
    }

    private void statusEdicao()
    {
        pesquisa.setEditable(false);
        nome.setEditable(true);
        login.setEditable(true);
        senha.setEditable(true);
        confsenha.setEditable(true);
        email.setEditable(true);
        btnnovo.setEnabled(false);
        btnalterar.setEnabled(false);
        btnexcluir.setEnabled(false);
        btncancelar.setEnabled(true);
        btnsalvar.setEnabled(true);
        userdata.atualizaDados();
        tblusuarios.setEnabled(false);
    }
    
    private boolean confSenha()
    {
       String senha1 = new String(senha.getPassword());
       String senha2 = new String(confsenha.getPassword());
       
       if(senha1.equals(senha2))
           return true;
       else
           return false;
    }

    private ListSelectionListener selectionListener = new ListSelectionListener()
    {
        public void valueChanged(ListSelectionEvent e)
        {
            //tblusuarios.getModel().getValueAt(tblusuarios.getSelectedRow(), 1));
            int linha = tblusuarios.getSelectedRow();
            usuario = userdata.getUsuario(linha);
            codigo.setText(String.valueOf(usuario.getId()));
            nome.setText(usuario.getNome());
            login.setText(usuario.getLogin());
            senha.setText(usuario.getSenha());
            confsenha.setText(usuario.getSenha());
            email.setText(usuario.getEmail());
            FabricaConexoes.closeConnection();
        }
       
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnalterar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnnovo;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JTextField codigo;
    private javax.swing.JPasswordField confsenha;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel_campos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblconfsenha;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblnome;
    private javax.swing.JLabel lblogin;
    private javax.swing.JLabel lblpesquisar;
    private javax.swing.JLabel lblsenha;
    private javax.swing.JTextField login;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField pesquisa;
    private javax.swing.JPanel pnlbotoes;
    private javax.swing.JPanel pnlcadastro;
    private javax.swing.JPanel pnlpesquisa;
    private javax.swing.JPasswordField senha;
    private javax.swing.JTable tblusuarios;
    // End of variables declaration//GEN-END:variables
    private UsuarioData userdata;
    private Usuario usuario;
    private UsuarioControler controler;
}
