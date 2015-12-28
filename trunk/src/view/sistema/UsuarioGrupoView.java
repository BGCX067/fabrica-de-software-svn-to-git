package view.sistema;

import Util.FabricaConexoes;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Util.manipulaConexao;
import controler.sistema.UsuarioGrupoControler;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.sistema.GrupoData;
import model.sistema.UsuarioData;
import model.sistema.UsuarioGrupoData;
import model.sistema.UsuarioGrupo;
import model.sistema.Grupo;
import model.sistema.Usuario;

public class UsuarioGrupoView extends javax.swing.JInternalFrame {

    public UsuarioGrupoView() {
        grupodata = new GrupoData();
        userdata = new UsuarioData();
        usergrupodata = new UsuarioGrupoData();
        usergrupocontroler = new UsuarioGrupoControler();
        initComponents();
        jtbgrupos.getSelectionModel().addListSelectionListener(selectionListener);
        jtbgrupos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbgrupos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbusuarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbusua_grupo = new javax.swing.JTable();
        jbtadicionar = new javax.swing.JButton();
        jbtremover = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Associa usuários aos Grupos");
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setNormalBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setVisible(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grupos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jtbgrupos.setModel(grupodata);
        jtbgrupos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbgrupos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbgrupos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(375, 267));
        jPanel2.setRequestFocusEnabled(false);

        jtbusuarios.setModel(userdata);
        jtbusuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jtbusuarios.setAutoscrolls(false);
        jtbusuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbusuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtbusuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuários do Grupo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jtbusua_grupo.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtbusua_grupo);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtadicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/add_obj.gif"))); // NOI18N
        jbtadicionar.setToolTipText("Associa usuário ao grupo");
        jbtadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtadicionarActionPerformed(evt);
            }
        });

        jbtremover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/delete_obj.gif"))); // NOI18N
        jbtremover.setToolTipText("Exclui o usuário do grupo");
        jbtremover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtremoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtadicionar)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtremover)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtadicionar)
                    .addComponent(jbtremover))
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    public JTable getJtbgrupos() {
        return jtbgrupos;
    }

    public void setJtbgrupos(JTable jtbgrupos) {
        this.jtbgrupos = jtbgrupos;
    }

    public JTable getJtbusua_grupo() {
        return jtbusua_grupo;
    }

    public void setJtbusua_grupo(JTable jtbusua_grupo) {
        this.jtbusua_grupo = jtbusua_grupo;
    }

    public JTable getJtbusuarios() {
        return jtbusuarios;
    }

    public void setJtbusuarios(JTable jtbusuarios) {
        this.jtbusuarios = jtbusuarios;
    }

    private void jbtremoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtremoverActionPerformed
    montaUsuarioGrupoExclusao();
    usergrupocontroler.excluir(usergrupo);
    usergrupodata.atualizaDados();
    jtbusua_grupo.revalidate();
    jtbusua_grupo.repaint();
    atualizaTabela();
    }//GEN-LAST:event_jbtremoverActionPerformed

    private void jbtadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtadicionarActionPerformed
    montaUsuarioGrupo();
    usergrupocontroler.gravar(usergrupo);
    usergrupodata.atualizaDados();
    jtbusua_grupo.revalidate();
    jtbusua_grupo.repaint();
    atualizaTabela();
    }//GEN-LAST:event_jbtadicionarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

     /*sql  =  "SELECT a.idusuario as Código, a.nome as Nome from usuario a, usua_grupo b, grupo c where a.idusuario = b.id_usuario and b.id_grupo = c.idgrupo and b.id_grupo = "+grupo.getId()+"";
     manipulaConexao.preenchetable(jtbusua_grupo, sql);*/
    }//GEN-LAST:event_formComponentShown
private ListSelectionListener selectionListener = new ListSelectionListener()
{
    public void valueChanged(ListSelectionEvent e)
    {
        atualizaTabela();
        FabricaConexoes.closeConnection();
    }
};

 private void atualizaTabela()
 {
    int linha = jtbgrupos.getSelectedRow();
    grupo = grupodata.getGrupo(linha);
    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
    jtbusua_grupo.setModel(new DefaultTableModel());
    sql  =  "SELECT a.idusuario as Código, a.nome as Nome from usuario a, usua_grupo b, grupo c where a.idusuario = b.id_usuario and b.id_grupo = c.idgrupo and b.id_grupo = "+grupo.getId()+"";
    manipulaConexao.preenchetable(jtbusua_grupo, sql);
 }


private void montaUsuarioGrupo()
{
    usergrupo = new UsuarioGrupo();
    grupo = new Grupo();
    user = new Usuario();

    try
    {
        int linha  = jtbgrupos.getSelectedRow();
        grupo = grupodata.getGrupo(linha);
        usergrupo.setId_Grupo(grupo.getId());
        linha = jtbusuarios.getSelectedRow();
        user = userdata.getUsuario(linha);
        usergrupo.setId_Usua(user.getId());
    }
    catch(NumberFormatException e)
    {
        usergrupo.setId_Usua(0);
        usergrupo.setId_Grupo(0);
    }
}

private void montaUsuarioGrupoExclusao()
{
    usergrupo = new UsuarioGrupo();
    try
    {
        int linha = jtbgrupos.getSelectedRow();
        grupo = grupodata.getGrupo(linha);
        linha = jtbusua_grupo.getSelectedRow();
        objeto = jtbusua_grupo.getValueAt(linha, 0);
        usergrupo.setId_Usua(Integer.valueOf(objeto.toString()));
        usergrupo.setId_Grupo(grupo.getId());
    }
    catch(NumberFormatException e)
    {
        usergrupo.setId_Grupo(0);
        usergrupo.setId_Usua(0);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtadicionar;
    private javax.swing.JButton jbtremover;
    private javax.swing.JTable jtbgrupos;
    private javax.swing.JTable jtbusua_grupo;
    private javax.swing.JTable jtbusuarios;
    // End of variables declaration//GEN-END:variables
    private GrupoData grupodata;
    private UsuarioData userdata;
    private UsuarioGrupoData usergrupodata;
    private UsuarioGrupo usergrupo;
    private Grupo grupo;
    private Usuario user;
    private UsuarioGrupoControler usergrupocontroler;
    private Object objeto;
    private String sql;
}
