/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormularioView.java
 *
 * Created on 15/08/2010, 11:33:01
 */

package view.processo;

import Util.manipulaConexao;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.execucao.ProcAtivDao;

/**
 *
 * @author Administrador
 */
public class FormularioView extends javax.swing.JDialog {

    /** Creates new form FormularioView */
    public FormularioView(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        this.id = id;
        initComponents();
        new ProcAtivDao().carregaFormularios(jtbformulario);
        jtbformulario.getSelectionModel().addListSelectionListener(selectionListener);
        jtbformulario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlformulario = new javax.swing.JLabel();
        jtformulario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbformulario = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jb_confirmar = new javax.swing.JButton();
        jb_visualizar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulário");

        jlformulario.setText("Escolha o formulário para finalização :");

        jtformulario.setEditable(false);

        jtbformulario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbformulario.setColumnSelectionAllowed(false);
        jtbformulario.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbformulario);

        jTextField1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setText("Pesquisar...");

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jb_confirmar.setText("Confirmar");
        jb_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_confirmarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_confirmar, new java.awt.GridBagConstraints());

        jb_visualizar.setText("Visualizar");
        jPanel1.add(jb_visualizar, new java.awt.GridBagConstraints());

        jb_cancelar.setText("Cancelar");
        jb_cancelar.setMaximumSize(new java.awt.Dimension(81, 23));
        jb_cancelar.setMinimumSize(new java.awt.Dimension(81, 23));
        jb_cancelar.setPreferredSize(new java.awt.Dimension(81, 23));
        jPanel1.add(jb_cancelar, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlformulario)
                .addGap(116, 116, 116))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtformulario, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlformulario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtformulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_confirmarActionPerformed

        manipulaConexao.insereFormFin(id_form, id);

    }//GEN-LAST:event_jb_confirmarActionPerformed

    private ListSelectionListener selectionListener = new ListSelectionListener()
    {
        public void valueChanged(ListSelectionEvent e)
        {
            int linha = jtbformulario.getSelectedRow();
            if(linha == -1) return;
            jtformulario.setText(String.valueOf(jtbformulario.getValueAt(linha, 1)));
            id_form = Integer.valueOf(String.valueOf(jtbformulario.getValueAt(linha, 0)));
        }
    };



    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioView dialog = new FormularioView(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_confirmar;
    private javax.swing.JButton jb_visualizar;
    private javax.swing.JLabel jlformulario;
    private javax.swing.JTable jtbformulario;
    private javax.swing.JTextField jtformulario;
    // End of variables declaration//GEN-END:variables
    private int id;
    private int id_form;
}
