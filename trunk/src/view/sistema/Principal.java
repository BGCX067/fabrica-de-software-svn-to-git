package view.sistema;

import Util.BackgroundedDesktopPane;
import Util.FabricaConexoes;
import Util.manipulaConexao;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.sistema.Usuario;
import view.execucao.AgendaView;
import view.execucao.GestaoView;
import view.execucao.TarefaView;
import view.inventario.FornecedorView;
import view.inventario.HardwaresView;
import view.inventario.SoftwaresView;
import view.inventario.EquipamentoView;
import view.processo.AtividadeView;
import view.processo.FinalizacaoView;
import view.processo.ProcessoView;

//TODO Desenvolver as trigeers para gravacao de logs
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpprincipal = new BackgroundedDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniusuario = new javax.swing.JMenuItem();
        mnigrupo = new javax.swing.JMenuItem();
        mniassocia = new javax.swing.JMenuItem();
        mnipacote = new javax.swing.JMenuItem();
        mniassociaproc = new javax.swing.JMenuItem();
        mniassociapacote = new javax.swing.JMenuItem();
        mniacessomenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        mnilogoff = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mniatividades = new javax.swing.JMenuItem();
        mnifinalizacoes = new javax.swing.JMenuItem();
        mniprocessos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mniprocesso = new javax.swing.JMenuItem();
        mnigestao = new javax.swing.JMenuItem();
        mniagenda = new javax.swing.JMenuItem();
        mniadiatarefas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mnicadastro = new javax.swing.JMenu();
        mniequipamento = new javax.swing.JMenuItem();
        mnihardware = new javax.swing.JMenuItem();
        mnisoftware = new javax.swing.JMenuItem();
        mnifornecedor = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        Sobre = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simp - BPM (SIMulador de Processos)");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(6);
        setFocusCycleRoot(false);
        setMinimumSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jdpprincipal.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jdpprincipalComponentResized(evt);
            }
        });

        jMenu1.setText("Sistema");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        mniusuario.setText("Usuario");
        mniusuario.setEnabled(false);
        mniusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniusuarioActionPerformed(evt);
            }
        });
        jMenu1.add(mniusuario);

        mnigrupo.setText("Grupo");
        mnigrupo.setEnabled(false);
        mnigrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnigrupoActionPerformed(evt);
            }
        });
        jMenu1.add(mnigrupo);

        mniassocia.setText("Associa Usuário ao Grupo");
        mniassocia.setEnabled(false);
        mniassocia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniassociaActionPerformed(evt);
            }
        });
        jMenu1.add(mniassocia);

        mnipacote.setText("Pacotes");
        mnipacote.setEnabled(false);
        mnipacote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnipacoteActionPerformed(evt);
            }
        });
        jMenu1.add(mnipacote);

        mniassociaproc.setText("Associa Processo ao Pacote");
        mniassociaproc.setEnabled(false);
        mniassociaproc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniassociaprocActionPerformed(evt);
            }
        });
        jMenu1.add(mniassociaproc);

        mniassociapacote.setText("Associa Pacote ao Grupo");
        mniassociapacote.setEnabled(false);
        mniassociapacote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniassociapacoteActionPerformed(evt);
            }
        });
        jMenu1.add(mniassociapacote);

        mniacessomenu.setText("Acesso à Menus");
        mniacessomenu.setEnabled(false);
        mniacessomenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniacessomenuActionPerformed(evt);
            }
        });
        mniacessomenu.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                mniacessomenuAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jMenu1.add(mniacessomenu);
        jMenu1.add(jSeparator1);

        mnilogoff.setText("Logoff");
        mnilogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnilogoffActionPerformed(evt);
            }
        });
        jMenu1.add(mnilogoff);

        jMenuItem3.setText("Alterar Senha");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cadastros");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        mniatividades.setText("Atividades");
        mniatividades.setEnabled(false);
        mniatividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniatividadesActionPerformed(evt);
            }
        });
        jMenu2.add(mniatividades);

        mnifinalizacoes.setText("Finalizações");
        mnifinalizacoes.setEnabled(false);
        mnifinalizacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnifinalizacoesActionPerformed(evt);
            }
        });
        jMenu2.add(mnifinalizacoes);

        mniprocessos.setText("Processos");
        mniprocessos.setEnabled(false);
        mniprocessos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniprocessosActionPerformed(evt);
            }
        });
        jMenu2.add(mniprocessos);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Execução");

        mniprocesso.setText("Processo");
        mniprocesso.setEnabled(false);
        mniprocesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniprocessoActionPerformed(evt);
            }
        });
        jMenu3.add(mniprocesso);

        mnigestao.setText("Gestão de processos");
        mnigestao.setEnabled(false);
        mnigestao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnigestaoActionPerformed(evt);
            }
        });
        jMenu3.add(mnigestao);

        mniagenda.setText("Agenda");
        mniagenda.setEnabled(false);
        mniagenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniagendaActionPerformed(evt);
            }
        });
        jMenu3.add(mniagenda);

        mniadiatarefas.setText("Adia Tarefas");
        mniadiatarefas.setEnabled(false);
        mniadiatarefas.setVerifyInputWhenFocusTarget(false);
        jMenu3.add(mniadiatarefas);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Relatorios");
        jMenu4.setEnabled(false);

        jMenuItem1.setText("Relatórios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Inventário");
        jMenu5.setEnabled(false);

        mnicadastro.setText("Cadastro");

        mniequipamento.setText("Equipamento");
        mniequipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniequipamentoActionPerformed(evt);
            }
        });
        mnicadastro.add(mniequipamento);

        mnihardware.setText("Hardware");
        mnihardware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnihardwareActionPerformed(evt);
            }
        });
        mnicadastro.add(mnihardware);

        mnisoftware.setText("Software");
        mnisoftware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnisoftwareActionPerformed(evt);
            }
        });
        mnicadastro.add(mnisoftware);

        mnifornecedor.setText("Fornecedor");
        mnifornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnifornecedorActionPerformed(evt);
            }
        });
        mnicadastro.add(mnifornecedor);

        jMenu5.add(mnicadastro);

        jMenuItem5.setText("Movimentação");
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        Sobre.setText("Sobre");
        Sobre.setEnabled(false);

        jMenuItem2.setText("Versão");
        Sobre.add(jMenuItem2);

        jMenuBar1.add(Sobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpprincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-600)/2, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void mniatividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniatividadesActionPerformed
        if (atividadeview == null) {
            atividadeview = new AtividadeView();
            jdpprincipal.add(atividadeview);
        }

        atividadeview.setVisible(true);
        atividadeview.toFront();

        try {
            atividadeview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_mniatividadesActionPerformed

    private void mniusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniusuarioActionPerformed
       
        userview = new UsuarioView();
   
        if(!findWindow("usuarioview"))
            jdpprincipal.add(userview);

        userview.setVisible(true);//mostra PacoteView se estiver com status HIDE
        userview.toFront();//Move a PacoteView para frente do desktop

        try {
            userview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_mniusuarioActionPerformed

    private void mnifinalizacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnifinalizacoesActionPerformed
        if (finalizacaoview == null) {
            finalizacaoview = new FinalizacaoView();
            jdpprincipal.add(finalizacaoview);
        }

        finalizacaoview.setVisible(true);
        finalizacaoview.toFront();

        try {
            finalizacaoview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_mnifinalizacoesActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void mnigrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnigrupoActionPerformed

        if (grupoview == null) {
            grupoview = new GrupoView();
            jdpprincipal.add(grupoview = new GrupoView());//checa se já existe uma PacoteView na tela
        }
        grupoview.setVisible(true);//mostra PacoteView se estiver com status HIDE
        grupoview.toFront();//Move a PacoteView para frente do desktop

        try {
            grupoview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }

    }//GEN-LAST:event_mnigrupoActionPerformed

    private void mniassociaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniassociaActionPerformed
        if (usergrupoview == null) {
            usergrupoview = new UsuarioGrupoView();
            jdpprincipal.add(usergrupoview);
        }//checa se já existe uma PacoteView na tela
        usergrupoview.dispose();
        usergrupoview = new UsuarioGrupoView();
        jdpprincipal.add(usergrupoview);
        usergrupoview.setVisible(true);//mostra PacoteView se estiver com status HIDE
        usergrupoview.toFront();//Move a PacoteView para frente do desktop
        try {
            usergrupoview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_mniassociaActionPerformed

    private void mnipacoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnipacoteActionPerformed
        if (pacoteview == null) {
            pacoteview = new PacoteView();
            jdpprincipal.add(pacoteview);//checa se já existe uma PacoteView na tela
        }

        pacoteview.setVisible(true);//mostra PacoteView se estiver com status HIDE
        pacoteview.toFront();//Move a PacoteView para frente do desktop

        try {
            pacoteview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_mnipacoteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        statusMenu(2);
        if (login == null) {
            login = new LoginView((this));
            jdpprincipal.add(login);
        }

        login.setVisible(true);

        try {
            login.setSelected(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_formWindowOpened

    private void mnilogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnilogoffActionPerformed
        this.statusMenu(2);
        FabricaConexoes.closeConnection();
        jdpprincipal.removeAll();
        jdpprincipal.repaint();
        fechaJanelas();
        fechaMenus();
        jdpprincipal.add(new LoginView(this));
    }//GEN-LAST:event_mnilogoffActionPerformed

    private void mniacessomenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniacessomenuActionPerformed

        if (acessomenuview == null) {
            acessomenuview = new AcessoMenuView();
            jdpprincipal.add(acessomenuview);
        }

        acessomenuview.setVisible(true);
        acessomenuview.toFront();

        try {
            acessomenuview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_mniacessomenuActionPerformed

    private void mniagendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniagendaActionPerformed

        if (agendaview == null) {
            agendaview = new AgendaView(this);
            jdpprincipal.add(agendaview);
        }//checa se já existe uma PacoteView na tela

        agendaview.setVisible(true);//mostra PacoteView se estiver com status HIDE
        agendaview.toFront();

        Usuario user = manipulaConexao.getUsuarioLogado();
        agendaview.setTitle("Agenda : " + user.getNome());
        //agendaview.tarefas();

        try {
            agendaview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_mniagendaActionPerformed
    public void mniagendaIniciar(){
        mniagendaActionPerformed(null);
    }
    private void mniprocessosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniprocessosActionPerformed

        if (processoview == null) {
            processoview = new ProcessoView();
            jdpprincipal.add(processoview);
        }

        processoview.setVisible(true);
        processoview.toFront();

        try {
            processoview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_mniprocessosActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void mniassociaprocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniassociaprocActionPerformed

        if (procpacview == null) {
            procpacview = new ProcessoPacoteView();
            jdpprincipal.add(procpacview);
        }//checa se já existe uma PacoteView na tela

        procpacview.setVisible(true);//mostra PacoteView se estiver com status HIDE
        procpacview.toFront();//Move a PacoteView para frente do desktop

        try {
            procpacview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_mniassociaprocActionPerformed

    private void mniassociapacoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniassociapacoteActionPerformed
        if (grupopacview == null) {
            grupopacview = new GrupoPacoteView();
            jdpprincipal.add(grupopacview);
        }//checa se já existe uma PacoteView na tela

        grupopacview.setVisible(true);//mostra PacoteView se estiver com status HIDE
        grupopacview.toFront();//Move a PacoteView para frente do desktop

        try {
            grupopacview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_mniassociapacoteActionPerformed

    private void mniprocessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniprocessoActionPerformed
        new TarefaView(this, true, new AgendaView(this)).setVisible(true);
    }//GEN-LAST:event_mniprocessoActionPerformed

    private void mniacessomenuAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_mniacessomenuAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_mniacessomenuAncestorAdded

    private void mnigestaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnigestaoActionPerformed
        if (gestaoview == null) {
            gestaoview = new GestaoView();
            jdpprincipal.add(gestaoview);
        }

        gestaoview.setVisible(true);
        gestaoview.toFront();

        try {
            gestaoview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_mnigestaoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mniequipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniequipamentoActionPerformed

        if (cdsinventarioview == null) {
            cdsinventarioview = new EquipamentoView();
            jdpprincipal.add(cdsinventarioview);
        }

        cdsinventarioview.setVisible(true);
        cdsinventarioview.toFront();

        try {
            cdsinventarioview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }

    }//GEN-LAST:event_mniequipamentoActionPerformed

    private void mnihardwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnihardwareActionPerformed

        if (hardwareview == null) {
            hardwareview = new HardwaresView();
            jdpprincipal.add(hardwareview);
        }

        hardwareview.setVisible(true);
        hardwareview.toFront();

        try {
            hardwareview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }

    }//GEN-LAST:event_mnihardwareActionPerformed

    private void mnisoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnisoftwareActionPerformed
        if (softwareview == null) {
            softwareview = new SoftwaresView();
            jdpprincipal.add(softwareview);
        }

        softwareview.setVisible(true);
        softwareview.toFront();

        try {
            softwareview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_mnisoftwareActionPerformed

    private void mnifornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnifornecedorActionPerformed
        if (fornecedorview == null) {
            fornecedorview = new FornecedorView();
            jdpprincipal.add(fornecedorview);
        }

        fornecedorview.setVisible(true);
        fornecedorview.toFront();

        try {
            fornecedorview.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_mnifornecedorActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
          new AlteraSenha(this, true).setVisible(true);
          mnilogoffActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jdpprincipalComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jdpprincipalComponentResized
        
    }//GEN-LAST:event_jdpprincipalComponentResized

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        
//        Painel_desk.setSize(279, this.getHeight()-100);
//        Painel_agenda.setSize(this.getWidth()-279, this.getHeight()-50);

    }//GEN-LAST:event_formComponentResized

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        

    }//GEN-LAST:event_formWindowStateChanged

    public void statusMenu(int status) {
        switch (status) {
            case 1:
                jMenu1.setEnabled(true);
                jMenu2.setEnabled(true);
                jMenu3.setEnabled(true);
                jMenu4.setEnabled(true);
                break;
            case 2:
                jMenu1.setEnabled(false);
                jMenu2.setEnabled(false);
                jMenu3.setEnabled(false);
                jMenu4.setEnabled(false);
                break;
            default:
                break;
        }
    }
  

    private void fechaJanelas() {
        grupoview = null;
        userview = null;
        pacoteview = null;
        usergrupoview = null;
        userview = null;
        procpacview = null;
        grupopacview = null;
        agendaview = null;
        processoview = null;
        acessomenuview = null;
        atividadeview = null;
        finalizacaoview = null;
        gestaoview = null;
    }

    public void fechaMenus() {
        mnigrupo.setEnabled(false);
        mniusuario.setEnabled(false);
        mnipacote.setEnabled(false);
        mniassocia.setEnabled(false);
        mnilogoff.setEnabled(false);
        mniacessomenu.setEnabled(false);
        mniassociapacote.setEnabled(false);
        mniassociaproc.setEnabled(false);
        mniagenda.setEnabled(false);
        mnigestao.setEnabled(false);
        mniprocesso.setEnabled(false);
        mniprocessos.setEnabled(false);
        mnifinalizacoes.setEnabled(false);
        mniatividades.setEnabled(false);
        mniadiatarefas.setEnabled(false);
    }

    private boolean findWindow(String nome)
    {
        boolean retorno = false;
        JInternalFrame[] frames = jdpprincipal.getAllFrames();

        try
        {
            for(JInternalFrame frame:frames)
            {
                if(frame.getName().equals(nome))
                    retorno = true;
            }
        }
        catch(NullPointerException e)
        {
            retorno = false;
        }

        System.out.println(retorno);
        return retorno;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Principal().setVisible(true);

                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Sobre;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JDesktopPane jdpprincipal;
    public javax.swing.JMenuItem mniacessomenu;
    public javax.swing.JMenuItem mniadiatarefas;
    public javax.swing.JMenuItem mniagenda;
    public javax.swing.JMenuItem mniassocia;
    public javax.swing.JMenuItem mniassociapacote;
    public javax.swing.JMenuItem mniassociaproc;
    public javax.swing.JMenuItem mniatividades;
    private javax.swing.JMenu mnicadastro;
    private javax.swing.JMenuItem mniequipamento;
    public javax.swing.JMenuItem mnifinalizacoes;
    private javax.swing.JMenuItem mnifornecedor;
    public javax.swing.JMenuItem mnigestao;
    public javax.swing.JMenuItem mnigrupo;
    private javax.swing.JMenuItem mnihardware;
    public javax.swing.JMenuItem mnilogoff;
    public javax.swing.JMenuItem mnipacote;
    public javax.swing.JMenuItem mniprocesso;
    public javax.swing.JMenuItem mniprocessos;
    private javax.swing.JMenuItem mnisoftware;
    public javax.swing.JMenuItem mniusuario;
    // End of variables declaration//GEN-END:variables
    //Menu Sistema
    private GrupoView grupoview;
    private UsuarioView userview;
    private UsuarioGrupoView usergrupoview;
    private PacoteView pacoteview;
    private AcessoMenuView acessomenuview;
    private ProcessoPacoteView procpacview;
    private GrupoPacoteView grupopacview;
    //Menu Processo
    private AtividadeView atividadeview;
    private FinalizacaoView finalizacaoview;
    private ProcessoView processoview;
    //Menu Execucao
    private AgendaView agendaview;
    private GestaoView gestaoview;
    //Menu Inventário
    private EquipamentoView cdsinventarioview;
    private HardwaresView hardwareview;
    private SoftwaresView softwareview;
    private FornecedorView fornecedorview;
    //Login
    private LoginView login;
    private static String path = "C:/Java/NetBeans/Simp/src/relatorios/";
    

}
