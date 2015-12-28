/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HistoricoProcessoView.java
 *
 * Created on 18/11/2009, 08:23:12
 */

package view.execucao;

import Util.FabricaConexoes;
import com.mysql.jdbc.util.ResultSetUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import model.execucao.Agenda;
import model.execucao.Formulario;
import model.execucao.ProcAtivDao;
import model.execucao.Transicao;




/**
 *
 * @author Administrador
 */
public class HistoricoProcessoView extends javax.swing.JDialog {

    /** Creates new form HistoricoProcessoView */
    public HistoricoProcessoView(java.awt.Frame parent, boolean modal, Transicao trans) {
        super(parent, modal);
        initComponents();
        this.trans = trans;
        
        new ProcAtivDao().carregaArvore(trans.getIdproc(), jthistorico, trans);
        
        jthistorico.getSelectionModel().addTreeSelectionListener(selectionListener);

    }


    private TreeSelectionListener selectionListener = new TreeSelectionListener()
    {

        public void valueChanged(TreeSelectionEvent e)
        {

            try{

                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) jthistorico.getLastSelectedPathComponent();
                    if(node == null)
                    {
                        JOptionPane.showMessageDialog(null, "Não há Atividade selecionada, verifique!","Erro",0);
                        return;
                    }

                    Object nodeInfo = node.getUserObject();
                    String nome = node.toString();
                    String trim = nome.substring(1, 4);
                    String separa = nome.substring(0,1);
                    int chave = Integer.valueOf(trim);

                    //Código que atualiza o idproc
                    sql = "select idproc from agenda where idtarefa = ? and sequencia = ?";
                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm = FabricaConexoes.returnStatement(sql);
                    stm.setInt(1, trans.getTransicao());
                    stm.setInt(2, chave);
                    rs = FabricaConexoes.returnResult(stm);
                    rs.next();
                    trans.setIdproc(rs.getInt("idproc"));
                    //fim do código que atualiza o idproc

                    sql = "select * from agenda where idproc = ? and idtarefa = ? and sequencia = ?";
                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm = FabricaConexoes.returnStatement(sql);
                    stm.setInt(1, trans.getIdproc());
                    stm.setInt(2, trans.getTransicao());
                    stm.setInt(3, chave);
                    rs = FabricaConexoes.returnResult(stm);
                    rs.next();
                    Agenda agenda = new Agenda();
                    agenda.setIdagenda(rs.getInt("idagenda"));
                    agenda.setIdtarefa(rs.getInt("idtarefa"));
                    agenda.setIdativ(rs.getInt("idativ"));
                    agenda.setIdproc(rs.getInt("idproc"));
                    agenda.setIdfin(rs.getInt("idfin"));
                    id_finalizacao =  rs.getInt("idfin");
                    agenda.setIdusuario(rs.getInt("idusuario"));
                    agenda.setSequencia(rs.getInt("sequencia"));
                    agenda.setAtraso(rs.getString("Atraso"));
                        String Hora = rs.getString("dt_inicial").substring(11,13);
                        String Minutos = rs.getString("dt_inicial").substring(14,16);
                        String segundos = rs.getString("dt_inicial").substring(17,19);
                        DateFormat dtformat = new SimpleDateFormat("dd/MM/yyyy "+Hora+":"+Minutos+":"+segundos);

                    agenda.setDt_final(dtformat.format(rs.getDate("dt_inicial")));

                        Hora = rs.getString("dt_final").substring(11,13);
                        Minutos = rs.getString("dt_final").substring(14,16);
                        segundos = rs.getString("dt_final").substring(17,19);
                        dtformat = new SimpleDateFormat("dd/MM/yyyy "+Hora+":"+Minutos+":"+segundos);
                        
                    agenda.setDt_final(dtformat.format(rs.getDate("dt_final")));
                    agenda.setValor(rs.getString("valor"));
                    agenda.setPai(rs.getInt("pai"));
                    agenda.setAtraso(rs.getString("atraso"));


                    jtavalor.setText(agenda.getValor());
                    jtxdt.setText(agenda.getDt_final());

                    sql = "select * from atividade where idatividade = ?";
                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm = FabricaConexoes.returnStatement(sql);
                    stm.setInt(1, agenda.getIdativ());
                    rs = FabricaConexoes.returnResult(stm);
                    rs.next();
                    
                    jtadesc.setText(rs.getString("descricao"));

                    
                    sql = "select * from usuario where idusuario = ?";
                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm = FabricaConexoes.returnStatement(sql);
                    stm.setInt(1, agenda.getIdusuario());
                    rs = FabricaConexoes.returnResult(stm);
                    rs.next();

                    jtxusuario.setText(rs.getString("nome"));
                    jtxprazo.setText(agenda.getAtraso());
                    //Código que verifica se há formulario associado a finalização
                    
                    sql = "select id_formulario from tb_item_formulario where id_finalizacao = ?";
                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm = FabricaConexoes.returnStatement(sql);
                    stm.setInt(1,id_finalizacao);
                    rs = FabricaConexoes.returnResult(stm);
                    if(rs.next())
                        {
                            jb_form.setEnabled(true);
                            }
                    else
                    {
                        jb_form.setEnabled(false);
                    }
                    //fim do código que verifica associação da finalização ao formulário
                    FabricaConexoes.closeConnection();

            }catch(SQLException ex)
            {
                ex.printStackTrace();
            }

        }
    };




    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jthistorico = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtadesc = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jtxusuario = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jtxdt = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtavalor = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jbtsair = new javax.swing.JButton();
        jb_form = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jtxprazo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico do Processo");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Histórico"));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jthistorico.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jthistorico);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição da atividade"));
        jPanel2.setToolTipText("");

        jtadesc.setColumns(20);
        jtadesc.setEditable(false);
        jtadesc.setLineWrap(true);
        jtadesc.setRows(5);
        jtadesc.setText(" ");
        jtadesc.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jtadesc);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuário"));

        jtxusuario.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Data da Finalização"));

        jtxdt.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxdt, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxdt, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor inserido"));

        jtavalor.setColumns(20);
        jtavalor.setEditable(false);
        jtavalor.setLineWrap(true);
        jtavalor.setRows(5);
        jtavalor.setText(" ");
        jtavalor.setToolTipText("");
        jtavalor.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jtavalor);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jbtsair.setText("Sair");
        jbtsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtsairActionPerformed(evt);
            }
        });
        jPanel6.add(jbtsair, new java.awt.GridBagConstraints());

        jb_form.setText("Ver formulário...");
        jb_form.setEnabled(false);
        jb_form.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_formActionPerformed(evt);
            }
        });
        jPanel6.add(jb_form, new java.awt.GridBagConstraints());

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Prazo"));

        jtxprazo.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxprazo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxprazo, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-589)/2, 800, 589);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtsairActionPerformed
        dispose();
    }//GEN-LAST:event_jbtsairActionPerformed

    private void jb_formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_formActionPerformed

        new Formulario().mostraFormulario(id_finalizacao);
    }//GEN-LAST:event_jb_formActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HistoricoProcessoView dialog = new HistoricoProcessoView(new javax.swing.JFrame(), true, new Transicao());
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_form;
    private javax.swing.JButton jbtsair;
    private javax.swing.JTextArea jtadesc;
    private javax.swing.JTextArea jtavalor;
    private javax.swing.JTree jthistorico;
    private javax.swing.JTextField jtxdt;
    private javax.swing.JTextField jtxprazo;
    private javax.swing.JTextField jtxusuario;
    // End of variables declaration//GEN-END:variables
    private Transicao trans;
    private PreparedStatement stm;
    private ResultSet rs;
    private ResultSetUtil rs2;
    private String sql;
    private int id_finalizacao;
}
