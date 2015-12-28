

package view.sistema;
import model.sistema.GrupoData;
import model.sistema.MenuGrupoDao;
import model.sistema.MenuGrupo;
import model.sistema.MenuGrupoData;
import controler.sistema.MenuGrupoControler;
import Util.MenusTreeModel;
import javax.swing.JOptionPane;
import javax.swing.tree.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import model.sistema.Grupo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Util.FabricaConexoes;
import java.awt.MenuContainer;

/**
 *
 * @author Leandro Mourão
 */
public class AcessoMenuView extends javax.swing.JInternalFrame {

    /** Creates new form AcessoMenuView */
    public AcessoMenuView() {
        grupodata = new GrupoData();      
        initComponents();
        jtbgrupos.getSelectionModel().addListSelectionListener(selectionListener);
        jtbgrupos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtmenusliberados.setModel(null);
        int modo = TreeSelectionModel.SINGLE_TREE_SELECTION;
        TreeSelectionModel tsm = jtarvoremenus.getSelectionModel();
        TreeSelectionModel tsm2 = jtmenusliberados.getSelectionModel();
        tsm.setSelectionMode(modo);
        tsm2.setSelectionMode(modo);
    }
private ListSelectionListener selectionListener = new ListSelectionListener()
    {
        public void valueChanged(ListSelectionEvent e)
        {
            //tblusuarios.getModel().getValueAt(tblusuarios.getSelectedRow(), 1));
            int linha = jtbgrupos.getSelectedRow();
            grupo = grupodata.getGrupo(linha);
            atualizaTree();


        }

    };
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpbotoes = new javax.swing.JPanel();
        jbtliberar = new javax.swing.JButton();
        jbtbloquear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jpgrupos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbgrupos = new javax.swing.JTable();
        jpmenus = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtarvoremenus = new javax.swing.JTree();
        jpmenusliberados = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtmenusliberados = new javax.swing.JTree();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Acesso aos Menus");
        setVisible(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jbtliberar.setText("Liberar");
        jbtliberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtliberarActionPerformed(evt);
            }
        });

        jbtbloquear.setText("Bloquear");
        jbtbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtbloquearActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 11));
        jLabel1.setText("Nenhum menu selecionado...");

        javax.swing.GroupLayout jpbotoesLayout = new javax.swing.GroupLayout(jpbotoes);
        jpbotoes.setLayout(jpbotoesLayout);
        jpbotoesLayout.setHorizontalGroup(
            jpbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpbotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpbotoesLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jbtliberar)
                        .addGap(18, 18, 18)
                        .addComponent(jbtbloquear))
                    .addComponent(jLabel1))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jpbotoesLayout.setVerticalGroup(
            jpbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpbotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jpbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtliberar)
                    .addComponent(jbtbloquear))
                .addContainerGap())
        );

        jpgrupos.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupos de Usuários"));

        jtbgrupos.setModel(grupodata);
        jScrollPane3.setViewportView(jtbgrupos);

        javax.swing.GroupLayout jpgruposLayout = new javax.swing.GroupLayout(jpgrupos);
        jpgrupos.setLayout(jpgruposLayout);
        jpgruposLayout.setHorizontalGroup(
            jpgruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
            .addGroup(jpgruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
        );
        jpgruposLayout.setVerticalGroup(
            jpgruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
            .addGroup(jpgruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
        );

        jpmenus.setBorder(javax.swing.BorderFactory.createTitledBorder("Menus"));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Menus");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Sistema");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Grupos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Usuários");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Associa Usuário ao Grupo");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Pacote");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Acesso à Menus");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Associa Processo ao Pacote");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Associa Pacote ao Grupo");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Logoff");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Processo");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Atividades");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Finalizações");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Processos");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Execução");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Processo");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Gestão de processos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Agenda");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Adia Tarefas");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jtarvoremenus.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jtarvoremenus.setAutoscrolls(true);
        jtarvoremenus.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jtarvoremenusValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jtarvoremenus);

        javax.swing.GroupLayout jpmenusLayout = new javax.swing.GroupLayout(jpmenus);
        jpmenus.setLayout(jpmenusLayout);
        jpmenusLayout.setHorizontalGroup(
            jpmenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
        );
        jpmenusLayout.setVerticalGroup(
            jpmenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );

        jpmenusliberados.setBorder(javax.swing.BorderFactory.createTitledBorder("Menus Liberados"));

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jtmenusliberados.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jtmenusliberados);

        javax.swing.GroupLayout jpmenusliberadosLayout = new javax.swing.GroupLayout(jpmenusliberados);
        jpmenusliberados.setLayout(jpmenusliberadosLayout);
        jpmenusliberadosLayout.setHorizontalGroup(
            jpmenusliberadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jpmenusliberadosLayout.setVerticalGroup(
            jpmenusliberadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpmenusliberados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpgrupos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpmenus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpbotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpmenus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpbotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpgrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpmenusliberados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-750)/2, (screenSize.height-550)/2, 750, 550);
    }// </editor-fold>//GEN-END:initComponents

    private void jtarvoremenusValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jtarvoremenusValueChanged

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jtarvoremenus.getLastSelectedPathComponent();

        //if(node == null) JOptionPane.showMessageDialog(rootPane, "sem selecao");
        Object nodeInfo = node.getUserObject();
        if(node.isLeaf())
        {
            if(nodeInfo.toString().compareToIgnoreCase("Usuários") == 0)
            {
                jLabel1.setText("Usuários...");

            }
            if(nodeInfo.toString().compareToIgnoreCase("Grupos") == 0)
            {
                jLabel1.setText("Grupos...");

            }
            if(nodeInfo.toString().compareToIgnoreCase("Email") == 0)
            {
                jLabel1.setText("Email...");

            }
            if(nodeInfo.toString().compareToIgnoreCase("Associa Usuário") == 0)
            {
                jLabel1.setText("Associa Usuários...");

            }
            if(nodeInfo.toString().compareToIgnoreCase("Pacote") == 0)
            {
                jLabel1.setText("Pacotes...");

            }
            if(nodeInfo.toString().compareToIgnoreCase("Logoff") == 0)
            {
                jLabel1.setText("Logoff...");

            }
            if(nodeInfo.toString().compareToIgnoreCase("Acesso à menus") == 0)
            {
                jLabel1.setText("Acesso à menus...");

            }
            if(nodeInfo.toString().compareToIgnoreCase("Atividades") == 0)
            {
                jLabel1.setText("Atividades...");

            }
            if(nodeInfo.toString().compareToIgnoreCase("Finalizações") == 0)
            {
                jLabel1.setText("Finalizações...");

            }
            if(nodeInfo.toString().compareToIgnoreCase("Processos") == 0)
            {
                jLabel1.setText("Processos...");

            }
            if(nodeInfo.toString().compareToIgnoreCase("Processo") == 0)
            {
                jLabel1.setText("Processo...");

            }
            if(nodeInfo.toString().compareToIgnoreCase("Gestão de Processos") == 0)
            {
                jLabel1.setText("Gestão de Processos...");

            }
            if(nodeInfo.toString().compareToIgnoreCase("Agenda") == 0)
            {
                jLabel1.setText("Agenda...");

            }

        }

    }//GEN-LAST:event_jtarvoremenusValueChanged

    private void jbtbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtbloquearActionPerformed
   
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jtmenusliberados.getLastSelectedPathComponent();

        if(node == null)
        {
            JOptionPane.showMessageDialog(null, "Nenhum menu selecionado, verifique!","Erro",0);
            return;
        }
        Object nodeInfo = node.getUserObject();

        if(node.isLeaf())
        {
            if(nodeInfo.toString().compareToIgnoreCase("Usuários") == 0)
            {
                    montaMenuGrupo(2, grupo.getId(), 0);
                    menucontroler = new MenuGrupoControler();
                    menucontroler.gravar(menugrupo);
                    atualizaTree();
            }
            if(nodeInfo.toString().compareToIgnoreCase("Grupos") == 0)
            {
                    montaMenuGrupo(1, grupo.getId(), 0);
                    menucontroler = new MenuGrupoControler();
                    menucontroler.gravar(menugrupo);
                    atualizaTree();
            }
            if(nodeInfo.toString().compareToIgnoreCase("Email") == 0)
            {
                    montaMenuGrupo(3, grupo.getId(), 0);
                    menucontroler = new MenuGrupoControler();
                    menucontroler.gravar(menugrupo);
                    atualizaTree();
            }
            if(nodeInfo.toString().compareToIgnoreCase("Associa Usuários") == 0)
            {
                    montaMenuGrupo(4, grupo.getId(), 0);
                    menucontroler = new MenuGrupoControler();
                    menucontroler.gravar(menugrupo);
                    atualizaTree();
            }
            if(nodeInfo.toString().compareToIgnoreCase("Pacotes") == 0)
            {
                    montaMenuGrupo(5, grupo.getId(), 0);
                    menucontroler = new MenuGrupoControler();
                    menucontroler.gravar(menugrupo);
                    atualizaTree();
            }
            if(nodeInfo.toString().compareToIgnoreCase("Logoff") == 0)
            {
                    montaMenuGrupo(7, grupo.getId(), 0);
                    menucontroler = new MenuGrupoControler();
                    menucontroler.gravar(menugrupo);
                    atualizaTree();
            }
            if(nodeInfo.toString().compareToIgnoreCase("Acesso à Menus") == 0)
            {
                    montaMenuGrupo(6, grupo.getId(), 0);
                    menucontroler = new MenuGrupoControler();
                    menucontroler.gravar(menugrupo);
                    atualizaTree();
            }
            if(nodeInfo.toString().compareToIgnoreCase("Associa Processo") == 0)
            {
                montaMenuGrupo(8, grupo.getId(), 0);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Associa Pacote") == 0)
            {
                montaMenuGrupo(9, grupo.getId(), 0);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Atividades") == 0)
            {
                montaMenuGrupo(10, grupo.getId(), 0);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Finalizações") == 0)
            {
                montaMenuGrupo(11, grupo.getId(), 0);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Processos") == 0)
            {
                montaMenuGrupo(12, grupo.getId(), 0);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Processo") == 0)
            {
                montaMenuGrupo(13, grupo.getId(), 0);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Gestão de Processos") == 0)
            {
                montaMenuGrupo(14, grupo.getId(), 0);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Agenda") == 0)
            {
                montaMenuGrupo(15, grupo.getId(), 0);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Adia Tarefas") == 0)
            {
                montaMenuGrupo(16, grupo.getId(), 0);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
        }
    
    }//GEN-LAST:event_jbtbloquearActionPerformed

    private void jbtliberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtliberarActionPerformed

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jtarvoremenus.getLastSelectedPathComponent();

        if(node == null)
        {
            JOptionPane.showMessageDialog(null, "Nenhum menu selecionado, verifique!","Erro",0);
            return;
        }
        Object nodeInfo = node.getUserObject();
        
        if(node.isLeaf())
        {
            if(nodeInfo.toString().compareToIgnoreCase("Usuários") == 0)
            {
                montaMenuGrupo(2, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();
 
            }
            if(nodeInfo.toString().compareToIgnoreCase("Grupos") == 0)
            {
                montaMenuGrupo(1, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Email") == 0)
            {
                montaMenuGrupo(3, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Associa Usuário") == 0)
            {
                montaMenuGrupo(4, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Pacote") == 0)
            {
                montaMenuGrupo(5, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Logoff") == 0)
            {
                montaMenuGrupo(7, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Acesso à Menus") == 0)
            {
                montaMenuGrupo(6, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Associa Processo") == 0)
            {
                montaMenuGrupo(8, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Associa Pacote") == 0)
            {
                montaMenuGrupo(9, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Atividades") == 0)
            {
                montaMenuGrupo(10, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Finalizações") == 0)
            {
                montaMenuGrupo(11, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Processos") == 0)
            {
                montaMenuGrupo(12, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Processo") == 0)
            {
                montaMenuGrupo(13, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Gestão de Processos") == 0)
            {
                montaMenuGrupo(14, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Agenda") == 0)
            {
                montaMenuGrupo(15, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
            if(nodeInfo.toString().compareToIgnoreCase("Adia Tarefas") == 0)
            {
                montaMenuGrupo(16, grupo.getId(), 1);
                menucontroler = new MenuGrupoControler();
                menucontroler.gravar(menugrupo);
                atualizaTree();

            }
        }

    }//GEN-LAST:event_jbtliberarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        jtbgrupos.setModel(new GrupoData());
    }//GEN-LAST:event_formComponentShown

    private void atualizaTree()
    {
        jtmenusliberados.setModel(null);
        root = new DefaultMutableTreeNode("Menus");
        sistema = new DefaultMutableTreeNode("Sistema");
        processo = new DefaultMutableTreeNode("Processo");
        execucao = new DefaultMutableTreeNode("Execução");
        model = new MenusTreeModel(root);
        int linha = jtbgrupos.getSelectedRow();
        if(linha == -1) return;
        grupo = grupodata.getGrupo(linha);
        menugrupo = new MenuGrupo();
        menugrupodao = new MenuGrupoDao();
        try
            {
                listmenugrupo  = menugrupodao.getAllGrupo(grupo);
                }catch(SQLException e )
                {
                   JOptionPane.showMessageDialog(null, e.getMessage(),"Erro",0);
                }
        for(int i = 0; i < listmenugrupo.size();i++)
        {
            try{
                menugrupo = listmenugrupo.get(i);
                String sql = "select nome,pai,nome_apres from item_menu where id_item = ?";
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
                stm.setInt(1, menugrupo.getIdItem());
                rs = FabricaConexoes.returnResult(stm);
                if(menugrupo.getFlag() == 1)
                {
                    while(rs.next())
                        {

                            if(rs.getString("PAI").compareToIgnoreCase("sistema") == 0)
                            {
                                sistema.add(new DefaultMutableTreeNode(rs.getString("NOME_APRES")));
                            }
                            if(rs.getString("PAI").compareToIgnoreCase("Processo") == 0)
                            {                                
                                processo.add(new DefaultMutableTreeNode(rs.getString("NOME_APRES")));
                            }
                            if(rs.getString("PAI").compareToIgnoreCase("execucao") == 0)
                            {                                
                                execucao.add(new DefaultMutableTreeNode(rs.getString("NOME_APRES")));
                            }

                            }
                              }
                }catch(SQLException e)
                        {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }


        }

        model.adicionaNoRoot(sistema);
        model.adicionaNoRoot(processo);
        model.adicionaNoRoot(execucao);
        jtmenusliberados.setModel(model);
        for(int i = 0; i< jtmenusliberados.getRowCount();i++)
        {
            jtmenusliberados.expandPath(jtmenusliberados.getPathForRow(i));
        }
    }

    private void montaMenuGrupo(int id_item, int id_grupo, int flag_disp)
    {
        menugrupo = new MenuGrupo(id_item,id_grupo,flag_disp);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtbloquear;
    private javax.swing.JButton jbtliberar;
    private javax.swing.JPanel jpbotoes;
    private javax.swing.JPanel jpgrupos;
    private javax.swing.JPanel jpmenus;
    private javax.swing.JPanel jpmenusliberados;
    private javax.swing.JTree jtarvoremenus;
    private javax.swing.JTable jtbgrupos;
    private javax.swing.JTree jtmenusliberados;
    // End of variables declaration//GEN-END:variables
    private GrupoData grupodata ;
    private ArrayList<Grupo> listgrupo;
    private ArrayList<MenuGrupo> listmenugrupo;
    private Grupo grupo;
    private PreparedStatement stm;
    private ResultSet rs;
    private MenusTreeModel model;
    private DefaultMutableTreeNode root,sistema,processo,execucao;
    private MenuGrupo menugrupo;
    private MenuGrupoDao menugrupodao;
    private MenuGrupoControler menucontroler;
}
