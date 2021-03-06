/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListaAtivView.java
 *
 * Created on 14/10/2009, 20:30:04
 */

package view.execucao;
import view.processo.*;
import Util.manipulaConexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.processo.Atividade;
import model.processo.AtividadeDao;

/**
 *
 * @author Administrador
 */
public class ConsultaAtivView extends javax.swing.JDialog {

    /** Creates new form ListaAtivView */
    public ConsultaAtivView(java.awt.Frame parent, boolean modal,GestaoView model) {
        super(parent, modal);
        this.model = model;
        initComponents();
        String sql = "select  distinct a.idatividade, a.nome, a.descricao from atividade a inner join atividade_finalizacao b on a.idatividade = b.id_ativ where a.status = 1";
        manipulaConexao.preenchetable(jtbatividade, sql);
        jtbatividade.getSelectionModel().addListSelectionListener(selectionListener);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbatividade = new javax.swing.JTable();
        jtpesquisar = new javax.swing.JTextField();
        jlpesquisar = new javax.swing.JLabel();
        jbtok = new javax.swing.JButton();
        jbtcancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atividades");
        setResizable(false);

        jtbatividade.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbatividade);

        jlpesquisar.setText("Pesquisar");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlpesquisar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jtpesquisar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbtok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbtcancel))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlpesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtcancel)
                    .addComponent(jbtok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-411)/2, (screenSize.height-320)/2, 411, 320);
    }// </editor-fold>//GEN-END:initComponents

    public void alteraModel(String sql)
    {
        manipulaConexao.preenchetable(jtbatividade, sql);
        jtbatividade.getSelectionModel().addListSelectionListener(selectionListener);
    }


    private void jbtokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtokActionPerformed
        try{

            int linha = jtbatividade.getSelectedRow();
            if(linha == -1)
            {
                JOptionPane.showMessageDialog(null, "Não há processo selecionado, verifique!");
                return;
            }
            int idprocesso =  Integer.valueOf(String.valueOf(jtbatividade.getValueAt(linha,0)));
            model.jtfativ.setText(String.valueOf(idprocesso));
            }catch(Exception sql)
            {
                JOptionPane.showMessageDialog(null, sql.getMessage());
            }
        dispose();
    }//GEN-LAST:event_jbtokActionPerformed

    private void jbtcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtcancelActionPerformed

        model.jtfativ.setText("");
        dispose();
    }//GEN-LAST:event_jbtcancelActionPerformed

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
                ConsultaAtivView dialog = new ConsultaAtivView(new javax.swing.JFrame(), true,new GestaoView());
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtcancel;
    private javax.swing.JButton jbtok;
    private javax.swing.JLabel jlpesquisar;
    private javax.swing.JTable jtbatividade;
    private javax.swing.JTextField jtpesquisar;
    // End of variables declaration//GEN-END:variables
    private GestaoView model;
}
