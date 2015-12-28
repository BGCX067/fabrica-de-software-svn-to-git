
package view.sistema;

import java.sql.SQLException;
import Util.FabricaConexoes;
import Util.manipulaConexao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.sistema.*;
/**
 *
 * @author Administrador
 */
public class LoginView extends javax.swing.JInternalFrame {

    /** Creates new form LoginView */
    public LoginView(Principal principal) {
        this.principal = principal;
        initComponents();
        
        this.requestFocus();
        this.transferFocusUpCycle();
        this.toFront();
        //jtfusuario.requestFocus();
        /*HashSet conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfusuario = new javax.swing.JTextField();
        jtfsenha = new javax.swing.JPasswordField();
        jlusuario = new javax.swing.JLabel();
        jlsenha = new javax.swing.JLabel();
        jbtok = new javax.swing.JButton();
        jbtcancelar = new javax.swing.JButton();
        jbt_string = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Login...");
        setToolTipText("");
        setNextFocusableComponent(jtfusuario);
        setVisible(true);

        jtfusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfusuarioKeyPressed(evt);
            }
        });

        jtfsenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfsenhaKeyPressed(evt);
            }
        });

        jlusuario.setText("Usuário :");

        jlsenha.setText("Senha :");

        jbtok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/step_done.gif"))); // NOI18N
        jbtok.setText("Ok");
        jbtok.setPreferredSize(new java.awt.Dimension(71, 25));
        jbtok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtokActionPerformed(evt);
            }
        });

        jbtcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/showerr_tsk.gif"))); // NOI18N
        jbtcancelar.setText("Sair");
        jbtcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtcancelarActionPerformed(evt);
            }
        });

        jbt_string.setText("String");
        jbt_string.setPreferredSize(new java.awt.Dimension(71, 25));
        jbt_string.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_stringActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlsenha))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlusuario))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfusuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jtfsenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jbtok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtcancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbt_string, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(104, 104, 104)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlusuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jlsenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtcancelar)
                    .addComponent(jbt_string, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-260)/2, (screenSize.height-192)/2, 260, 192);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtokActionPerformed
       FabricaConexoes.setConnect(connection);
       FabricaConexoes.getConexao();
       if(!manipulaConexao.setConexao(jtfusuario.getText(),jtfsenha.getText())) return;
       FabricaConexoes.getConexao();
       if(!FabricaConexoes.verificaConexao())
       {
            principal.statusMenu(1);
            this.dispose();
            ArrayList<Grupo> grupos = new ArrayList<Grupo>();
            ArrayList<MenuGrupo> menus = new ArrayList<MenuGrupo>();
            MenuGrupoDao menugrupodao = new MenuGrupoDao();
            MenuGrupo menugrupo;
            grupos = manipulaConexao.getGrupoLogado();
            for(int i = 0; i < grupos.size(); i++)
            {
                try
                    {
                        Grupo atual = grupos.get(i);
                        menus = menugrupodao.getAllGrupo(atual);
                        for(int cont = 0 ; cont < menus.size(); cont++)
                            {

                                menugrupo = menus.get(cont);
                                if(menugrupo.getFlag() == 1)
                                {
                                    if(menugrupo.getIdItem() == 1)
                                        {
                                            principal.mnigrupo.setEnabled(true);
                                        }
                                    if(menugrupo.getIdItem() == 2)
                                        {
                                            principal.mniusuario.setEnabled(true);
                                        }
                                    if(menugrupo.getIdItem() == 3)
                                        {
                                            //principal.mniemail.setEnabled(true);
                                        }
                                    if(menugrupo.getIdItem() == 4)
                                        {
                                            principal.mniassocia.setEnabled(true);
                                        }
                                    if(menugrupo.getIdItem() == 5)
                                        {
                                            principal.mnipacote.setEnabled(true);
                                        }
                                    if(menugrupo.getIdItem() == 6)
                                        {
                                            principal.mniacessomenu.setEnabled(true);
                                        }
                                    if(menugrupo.getIdItem() == 7)
                                        {
                                            principal.mnilogoff.setEnabled(true);
                                        }
                                    if(menugrupo.getIdItem() == 8)
                                        {
                                            principal.mniassociaproc.setEnabled(true);

                                        }
                                    if(menugrupo.getIdItem() == 9)
                                        {
                                            principal.mniassociapacote.setEnabled(true);

                                        }
                                    if(menugrupo.getIdItem() == 10)
                                        {
                                            principal.mniatividades.setEnabled(true);

                                        }
                                    if(menugrupo.getIdItem() == 11)
                                        {
                                            principal.mnifinalizacoes.setEnabled(true);

                                        }
                                    if(menugrupo.getIdItem() == 12)
                                        {
                                            principal.mniprocessos.setEnabled(true);

                                        }
                                    if(menugrupo.getIdItem() == 13)
                                        {
                                            principal.mniprocesso.setEnabled(true);

                                        }
                                    if(menugrupo.getIdItem() == 14)
                                        {
                                            principal.mnigestao.setEnabled(true);

                                        }
                                    if(menugrupo.getIdItem() == 15)
                                        {
                                            principal.mniagenda.setEnabled(true);

                                        }
                                    if(menugrupo.getIdItem() == 16)
                                        {
                                            principal.mniadiatarefas.setEnabled(true);
                                        }
                                }
                                FabricaConexoes.closeConnection();
                             }
                        }catch(SQLException e)
                                {
                                    FabricaConexoes.closeConnection();
                                    }
                FabricaConexoes.closeConnection();
            }
          principal.mniagendaIniciar();
       }
    }//GEN-LAST:event_jbtokActionPerformed

    private void jbtcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtcancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbtcancelarActionPerformed

    private void jtfusuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfusuarioKeyPressed
        if(evt.getKeyCode() == 10 )
            {
                jtfusuario.transferFocus();
            }
    }//GEN-LAST:event_jtfusuarioKeyPressed

    private void jtfsenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfsenhaKeyPressed
            
            if(evt.getKeyCode() == 10 )
            {
                jbtok.doClick();
            }
    }//GEN-LAST:event_jtfsenhaKeyPressed

    private void jbt_stringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_stringActionPerformed
        connection = JOptionPane.showInputDialog(null,"Informar string de conexão: ","Conexão",1);
    }//GEN-LAST:event_jbt_stringActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbt_string;
    private javax.swing.JButton jbtcancelar;
    private javax.swing.JButton jbtok;
    private javax.swing.JLabel jlsenha;
    private javax.swing.JLabel jlusuario;
    private javax.swing.JPasswordField jtfsenha;
    private javax.swing.JTextField jtfusuario;
    // End of variables declaration//GEN-END:variables
    private Principal principal;
    private String connection = "jdbc:mysql://localhost:3306/producao";
}
