/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListaAtivView.java
 *
 * Created on 14/10/2009, 20:30:04
 */

package view.processo;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import model.processo.AtivProcDao;
import model.processo.Atividade;
import view.execucao.ConsultaProcView;

/**
 *
 * @author Administrador
 */
public class ListaLinkView extends javax.swing.JDialog {

    /** Creates new form ListaAtivView */
    public ListaLinkView(java.awt.Frame parent, boolean modal,ModelagemView model,int chave_ext) {
        super(parent, modal);
        this.model = model;
        initComponents();
        this.chave_ext = chave_ext;
        jtlinks.setModel(model.jtmodelo.getModel());
        jtlinks.setCellRenderer(new RenderizarTree());
        for(int i = 0; i< jtlinks.getRowCount();i++)
        {
            jtlinks.expandPath(jtlinks.getPathForRow(i));
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtok = new javax.swing.JButton();
        jbtcancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtlinks = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();

        setTitle("Adiciona Links");
        setResizable(false);

        jbtok.setText("OK");
        jbtok.setPreferredSize(new java.awt.Dimension(75, 23));
        jbtok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtokActionPerformed(evt);
            }
        });

        jbtcancel.setText("Cancelar");
        jbtcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtcancelActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jtlinks.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jtlinks);

        jButton1.setText("Link para Processos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jbtcancel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtcancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-542)/2, (screenSize.height-460)/2, 542, 460);
    }// </editor-fold>//GEN-END:initComponents

    public void alteraModel(String sql)
    {
       
    }


    private void jbtokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtokActionPerformed


        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jtlinks.getLastSelectedPathComponent();
        if(node == null) {JOptionPane.showMessageDialog(null, "Não há Atividade selecionada, verifique!","Erro",0);return;}
        Object nodeInfo = node.getUserObject();

        id = model.id;
        String nome = node.toString();
        String trim = nome.substring(1, 4);
        int chave = Integer.valueOf(trim);
        int vtipo = new AtivProcDao().verificaTipo(id, chave);
        if(vtipo == 0)
        {
            try{
                new AtivProcDao().updateAtivFin(chave, chave_ext, id);
                model.carregaArvore(id);
                dispose();
                
                }catch(SQLException s)
                {
                    JOptionPane.showMessageDialog(null, s.getMessage(),"Erro",0);

                }

        }else{return;}
        

    }//GEN-LAST:event_jbtokActionPerformed

    private void jbtcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtcancelActionPerformed
        dispose();
    }//GEN-LAST:event_jbtcancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ConsultaProcView(null, true, this).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private ListSelectionListener selectionListener = new ListSelectionListener()
    {
        public void valueChanged(ListSelectionEvent e)
        {
            
        }
    };

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListaLinkView dialog = new ListaLinkView(new javax.swing.JFrame(), true,new ModelagemView(new Integer(0)), new Integer(0));
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
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtcancel;
    private javax.swing.JButton jbtok;
    private javax.swing.JTree jtlinks;
    // End of variables declaration//GEN-END:variables
    public ModelagemView model;
    public int id;
    public Atividade ativ;
    public int chave_ext;
}
