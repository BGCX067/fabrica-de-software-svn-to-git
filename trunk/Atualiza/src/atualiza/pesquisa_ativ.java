/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pesquisa.java
 *
 * Created on 20/09/2010, 13:56:27
 */

package atualiza;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Administrador
 */
public class pesquisa_ativ extends javax.swing.JDialog {

    /** Creates new form pesquisa */
    public pesquisa_ativ(java.awt.Frame parent, boolean modal,String sql,int id) {
        super(parent, modal);
        initComponents();
        this.id = id;

        manipulaConexao.preenchetableMy(jtb_pesquisa, sql);

        jtb_pesquisa.getSelectionModel().addListSelectionListener(selectionListener);
        jtb_pesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //pane.add(desc);

        //Cria a reorganização da tabela através do clique na coluna
        jtb_pesquisa.setAutoCreateRowSorter(true);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jtb_pesquisa.getModel());
        jtb_pesquisa.setRowSorter(sorter);
    }


    private ListSelectionListener selectionListener = new ListSelectionListener()
    {
        public void valueChanged(ListSelectionEvent e)
        {
             try{

            int linha = jtb_pesquisa.getSelectedRow();
            if(linha == -1)
            {
                //JOptionPane.showMessageDialog(null, "Não há tarefa selecionada, verifique!");
                return;
            }
            int idtarefa =  Integer.valueOf(String.valueOf(jtb_pesquisa.getValueAt(linha,0)));
            if(idtarefa != 0)
            {
                id = idtarefa;

            }else {id = 0;}

            int idativ =  Integer.valueOf(String.valueOf(jtb_pesquisa.getValueAt(linha,2)));
            if(idtarefa != 0)
            {
                id_ativ = idativ;

            }else {id_ativ = 0;}
            //String desc = String.valueOf(jtbtarefas.getValueAt(linha, 2));
            //jtbtarefas.setToolTipText(desc);
        }catch(Exception exc)
        {
            JOptionPane.showMessageDialog(null, exc.getMessage(),"Erro desconhecido",0);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_pesquisa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jbt_ok = new javax.swing.JButton();
        jbt_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtb_pesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtb_pesquisa);

        jbt_ok.setText("Ok");
        jbt_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_okActionPerformed(evt);
            }
        });
        jPanel1.add(jbt_ok);

        jbt_cancel.setText("Cancelar");
        jbt_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_cancelActionPerformed(evt);
            }
        });
        jPanel1.add(jbt_cancel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-372)/2, 416, 372);
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_okActionPerformed
            
            dispose();
    }//GEN-LAST:event_jbt_okActionPerformed

    private void jbt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_cancelActionPerformed
        id = 0;
        dispose();
    }//GEN-LAST:event_jbt_cancelActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pesquisa_ativ dialog = new pesquisa_ativ(new javax.swing.JFrame(), true,new String(),0);
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
    private javax.swing.JButton jbt_cancel;
    private javax.swing.JButton jbt_ok;
    private javax.swing.JTable jtb_pesquisa;
    // End of variables declaration//GEN-END:variables
    private int id;
    private int id_ativ;

    public int getId_ativ() {
        return id_ativ;
    }

    public void setId_ativ(int id_ativ) {
        this.id_ativ = id_ativ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
