package model.execucao;

//TODO Fazer a verificação de todas as telas, aquelas que só trazem listagem, realizar a atualização da tabela no componenteshow
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.ResultSet;
import Util.FabricaConexoes;


import Util.MenusTreeModel;
import Util.manipulaConexao;
import com.mysql.jdbc.util.ResultSetUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import model.sistema.Usuario;
import view.execucao.DestinadoView;

public class GestaoDao {

    private PreparedStatement stm,stm2;
    private ResultSet rs,rs3;
    private ResultSetUtil rs2;
    private String sql;

    public void estanciaTarefasIniciais1(int idprocess, int raiz, int idtarefa, int pai) throws SQLException {
        boolean executa = false;
        PreparedStatement stm2;
        PreparedStatement stm3;
        ResultSet rs2;
        ResultSet rs3;

        sql = "select * from processo_atividade where idproc = " + idprocess + " and raiz = " + raiz + " and idfin = 0 and link = 0";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        rs = FabricaConexoes.returnResult(stm);
        String hora = "";
        int inicial = 0;
        while (rs.next()) {
            int idativ, chave, tresp, resp;
            DateFormat dtformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            idativ = rs.getInt("idat");
            chave = rs.getInt("chave");
            tresp = rs.getInt("tipo");
            resp = rs.getInt("idtipo");
            if (tresp == 2) {
                Transicao trans = new Transicao();
                new DestinadoView(null, true, trans).setVisible(true);
                tresp = trans.getTresp();
                resp = trans.getResp();
            }


            sql = "insert into transicao (idativ,chave,resp,idresp,dt_inicio,idproc,transicao,pai) values (?,?,?,?,?,?,?,?)";
            if (!FabricaConexoes.verificaConexao()) {
                FabricaConexoes.getConexao();
            }
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idativ);
            stm.setInt(2, chave);
            stm.setInt(3, tresp);
            stm.setInt(4, resp);
            stm.setInt(6, idprocess);
            stm.setInt(8, pai);
            if (inicial == 0) {
                stm.setInt(7, idtarefa);
                hora = dtformat.format(new Date());
                stm.setString(5, hora);

            } else {
                sql = "select  idtarefa from transicao where dt_inicio = ? order by idtarefa desc";
                if (!FabricaConexoes.verificaConexao()) {
                    FabricaConexoes.getConexao();
                }
                stm2 = FabricaConexoes.returnStatement(sql);
                stm2.setString(1, hora);
                rs2 = FabricaConexoes.returnResult(stm2);
                rs2.next();
                int id = rs2.getInt("idtarefa");
                stm.setInt(7, id);
                stm.setString(5, dtformat.format(new Date()));

            }
            if (!executa) {
                stm.execute();
            }
            stm.close();
            FabricaConexoes.closeConnection();
            inicial++;
        }



    }

    public void configuraAtraso(int idtarefa) throws SQLException {
        sql = "update transicao set status = 1 where idtarefa = ?";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, idtarefa);
        stm.execute();
        stm.close();
        FabricaConexoes.closeConnection();
    }

    public void estanciaTarefasIniciais(int idprocess, int raiz, int idtarefa, int seq) throws SQLException {
        boolean executa = false;
        PreparedStatement stm2;
        PreparedStatement stm3;
        PreparedStatement stm4;
        ResultSet rs2;
        ResultSet rs3;
        ResultSet rs4;
        sql = "select * from processo_atividade where idproc = " + idprocess + " and raiz = " + raiz + " and idfin = 0 and link = 0";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm4 = FabricaConexoes.returnStatement(sql);
        rs = FabricaConexoes.returnResult(stm);
        rs4 = FabricaConexoes.returnResult(stm4);

        String hora = "";
        int inicial = 0;

        if (!rs4.next()) {
            deleteProcesso(rs4, stm4, idtarefa);
        }

        while (rs.next()) {
            int idativ, chave, tresp, resp;
            DateFormat dtformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            idativ = rs.getInt("idat");
            chave = rs.getInt("chave");
            tresp = rs.getInt("tipo");
            resp = rs.getInt("idtipo");
            if (tresp == 2) {
                Transicao transi = new Transicao();
                new DestinadoView(null, true, transi).setVisible(true);
                tresp = transi.getTresp();
                resp = transi.getResp();
            }


            sql = "insert into transicao (idativ,chave,resp,idresp,dt_inicio,idproc,transicao,pai) values (?,?,?,?,?,?,?,?)";
            if (!FabricaConexoes.verificaConexao()) {
                FabricaConexoes.getConexao();
            }
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idativ);
            stm.setInt(2, chave);
            stm.setInt(3, tresp);
            stm.setInt(4, resp);
            stm.setInt(6, idprocess);

            if (inicial == 0) {
                stm.setInt(7, idtarefa);
                hora = dtformat.format(new Date());
                stm.setString(5, hora);
                stm.setInt(8, seq);
                sql = "select *  from transicao where idproc= ? and chave = ? and transicao = ?";
                if (!FabricaConexoes.verificaConexao()) {
                    FabricaConexoes.getConexao();
                }
                stm3 = FabricaConexoes.returnStatement(sql);
                stm3.setInt(1, idprocess);
                stm3.setInt(2, chave);
                stm3.setInt(3, idtarefa);
                rs3 = FabricaConexoes.returnResult(stm3);
                if (rs3.next()) {
                    FabricaConexoes.closeConnection();
                    JOptionPane.showMessageDialog(null, "Atividade já iniciada!", "Informação", 1);
                    executa = true;

                    desativaTarefa(idtarefa);
                    deleteProcesso(rs4, stm4, idtarefa);
                    /*
                    sql = "delete from transicao where idtarefa = ?";
                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm3 = FabricaConexoes.returnStatement(sql);
                    stm3.setInt(1, idtarefa);
                    stm3.execute();
                    stm3.close();
                    FabricaConexoes.closeConnection();*/
                }


            } else {
                sql = "select  idtarefa from transicao where dt_inicio = ? order by idtarefa desc";
                if (!FabricaConexoes.verificaConexao()) {
                    FabricaConexoes.getConexao();
                }
                stm2 = FabricaConexoes.returnStatement(sql);
                stm2.setString(1, hora);
                rs2 = FabricaConexoes.returnResult(stm2);
                rs2.next();
                int id = rs2.getInt("idtarefa");
                stm.setInt(7, id);
                stm.setString(5, dtformat.format(new Date()));
                stm.setInt(8, seq);
                sql = "select *  from transicao where idproc= ? and chave = ? and transicao = ?";
                if (!FabricaConexoes.verificaConexao()) {
                    FabricaConexoes.getConexao();
                }
                stm3 = FabricaConexoes.returnStatement(sql);
                stm3.setInt(1, idprocess);
                stm3.setInt(2, chave);
                stm3.setInt(3, id);
                rs3 = FabricaConexoes.returnResult(stm3);
                if (rs3.next()) {
                    FabricaConexoes.closeConnection();
                    JOptionPane.showMessageDialog(null, "Atividade já iniciada!", "Informação", 1);
                    executa = true;


                    desativaTarefa(id);
                    deleteProcesso(rs4, stm4, id);
                    /*
                    sql = "delete from transicao where idtarefa = ?";
                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm3 = FabricaConexoes.returnStatement(sql);
                    stm3.setInt(1, id);
                    stm3.execute();
                    stm3.close();
                    FabricaConexoes.closeConnection();*/
                }

            }
            if (!executa) {
                stm.execute();
            }
            stm.close();
            FabricaConexoes.closeConnection();
            inicial++;
        }



    }

    private void deleteProcesso(ResultSet rs4, PreparedStatement stm4, int idtarefa) throws SQLException {
        sql = "select * from transicao where transicao = " + idtarefa + " and status != 2";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm4 = FabricaConexoes.returnStatement(sql);
        rs4 = FabricaConexoes.returnResult(stm4);
        if (!rs4.next()) {
            sql = "select * from transicao where  idtarefa = " + idtarefa + " and status != 2";
            if (!FabricaConexoes.verificaConexao()) {
                FabricaConexoes.getConexao();
            }
            stm4 = FabricaConexoes.returnStatement(sql);
            rs4 = FabricaConexoes.returnResult(stm4);
            if (!rs4.next()) {
                sql = "delete from transicao where transicao = ? or idtarefa = ?";
                if (!FabricaConexoes.verificaConexao()) {
                    FabricaConexoes.getConexao();
                }
                stm4 = FabricaConexoes.returnStatement(sql);
                stm4.setInt(1, idtarefa);
                stm4.setInt(2, idtarefa);
                stm4.execute();
            }
        }
    }

    public void proximaTarefa(Transicao transicao, int chave, int pai) throws SQLException {
        if (transicao.getTransicao() == 0) {

            estanciaTarefasIniciais(transicao.getIdproc(), chave, transicao.getIdtarefa(), pai);
        } else {

            estanciaTarefasIniciais(transicao.getIdproc(), chave, transicao.getTransicao(), pai);
        }
    }

    public void carregaTarefas(JTable table) {//utilizado

        Usuario user = manipulaConexao.getUsuarioLogado();


        sql = "select  a.idtarefa as 'Id',a.status as 'Prazo', b.nome as 'Atividade', a.dt_inicio as 'Data Início', c.nome as 'Processo'" +
                ",a.transicao as 'Tarefa' from transicao a inner join atividade b on a.idativ = b.idatividade" +
                " inner join processo c on a.idproc = c.idprocesso" +
                " where c.idgestor = " + user.getId();

        sql = sql + " and a.status  <>  2 order by a.idtarefa asc";
        manipulaConexao.preenchetable(table, sql);
        DateFormat dtformat = new SimpleDateFormat();
        try {
            formataData(table, dtformat);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void formataData(JTable table, DateFormat dtformat) throws SQLException {

        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        rs = FabricaConexoes.returnResult(stm);
        int i = 0;
        while (rs.next()) {
            String Hora = rs.getString("Data Início").substring(11, 13);
            String Minutos = rs.getString("Data Início").substring(14, 16);
            String segundos = rs.getString("Data Início").substring(17, 19);
            dtformat = new SimpleDateFormat("dd/MM/yyyy " + Hora + ":" + Minutos + ":" + segundos);
            table.setValueAt(dtformat.format(rs.getDate("Data Início")), i, 3);
            if (rs.getInt("Prazo") == 1) {
                table.setValueAt("ATRASADO", i, 1);
            }
            if (rs.getInt("Prazo") == 0) {
                table.setValueAt("NORMAL", i, 1);
            }
            i++;
        }
        if (i == 0) {
            Object[] objeto = new Object[5];
            objeto[0] = "Código Tarefa";
            objeto[1] = "Prazo";
            objeto[2] = "Atividade";
            objeto[3] = "Data Início";
            objeto[4] = "Data Final";
            table.setModel(new DefaultTableModel(objeto, 0));
        }
        FabricaConexoes.closeConnection();

    }

    public void formataDataAgenda(JTable table, DateFormat dtformat) throws SQLException {

        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        rs = FabricaConexoes.returnResult(stm);
        int i = 0;
        while (rs.next()) {
            String Hora = rs.getString("Data Início").substring(11, 13);
            String Minutos = rs.getString("Data Início").substring(14, 16);
            String segundos = rs.getString("Data Início").substring(17, 19);
            dtformat = new SimpleDateFormat("dd/MM/yyyy " + Hora + ":" + Minutos + ":" + segundos);
            table.setValueAt(dtformat.format(rs.getDate("Data Início")), i, 3);

            Hora = rs.getString("Data Término").substring(11, 13);
            Minutos = rs.getString("Data Término").substring(14, 16);
            segundos = rs.getString("Data Término").substring(17, 19);
            dtformat = new SimpleDateFormat("dd/MM/yyyy " + Hora + ":" + Minutos + ":" + segundos);
            table.setValueAt(dtformat.format(rs.getDate("Data Término")), i, 4);

            if (rs.getString("Prazo").compareToIgnoreCase("atrasado") == 1) {
                table.setValueAt("ATRASADO", i, 1);
            }
            if (rs.getString("Prazo").compareToIgnoreCase("normal") == 1) {
                table.setValueAt("NORMAL", i, 1);
            }
            i++;
        }
        if (i == 0) {
            Object[] objeto = new Object[5];
            objeto[0] = "Código Tarefa";
            objeto[1] = "Prazo";
            objeto[2] = "Atividade";
            objeto[3] = "Data Início";
            objeto[4] = "Data Final";
            table.setModel(new DefaultTableModel(objeto, 0));
        }
        FabricaConexoes.closeConnection();

    }

    public boolean consultaPrazo(int idtarefa, boolean msg) throws SQLException {
        sql = "select * from transicao where idtarefa = ?";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, idtarefa);
        rs = FabricaConexoes.returnResult(stm);
        rs.next();
        int chave = rs.getInt("chave");
        int idproc = rs.getInt("idproc");
        int idativ = rs.getInt("idativ");
        int resp = rs.getInt("resp");
        int idresp = rs.getInt("idresp");
        Date dt_inicio = rs.getDate("dt_inicio");
        String Hora = rs.getString("dt_inicio").substring(11, 13);
        String Minutos = rs.getString("dt_inicio").substring(14, 16);
        String segundos = rs.getString("dt_inicio").substring(17, 19);
        Date d = new Date(dt_inicio.getYear(), dt_inicio.getMonth(), dt_inicio.getDate(), Integer.valueOf(Hora), Integer.valueOf(Minutos), Integer.valueOf(segundos));
        DateFormat dtformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        FabricaConexoes.closeConnection();
        sql = "select * from processo_atividade where idproc = ? and chave = ?";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, idproc);
        stm.setInt(2, chave);
        rs = FabricaConexoes.returnResult(stm);
        rs.next();
        int tempo = rs.getInt("tempo");
        float valor_tempo = rs.getFloat("valor_tempo");


        Date data_atual;
        long diferenca;
        long hora, min, seg;
        int dia;
        FabricaConexoes.closeConnection();
        switch (tempo) {

            case 0:

                data_atual = new Date();
                dia = data_atual.getDate() - dt_inicio.getDate();
                diferenca = dt_inicio.getTime() - data_atual.getTime();
                hora = diferenca / (1000 * 60 * 60);
                min = diferenca % (1000 * 60 * 60) / (1000 * 60);
                seg = (diferenca % (1000 * 60 * 60)) % (1000 * 60) / 1000;
                if (dia > 0 || hora > 0 || min > 0 || seg > valor_tempo) {
                    if (msg) {
                        JOptionPane.showMessageDialog(null, "Prazo para execução da tarefa expirado!", "Vencimento", 1);
                    }
                    configuraAtraso(idtarefa);
                    return false;
                }
                break;
            case 1:
                data_atual = new Date();
                dia = data_atual.getDate() - dt_inicio.getDate();
                diferenca = dt_inicio.getTime() - data_atual.getTime();
                hora = diferenca / (1000 * 60 * 60);
                min = diferenca % (1000 * 60 * 60) / (1000 * 60);
                seg = (diferenca % (1000 * 60 * 60)) % (1000 * 60) / 1000;
                if (dia > 0 || hora > 0 || min > valor_tempo) {
                    if (msg) {
                        JOptionPane.showMessageDialog(null, "Prazo para execução da tarefa expirado!", "Vencimento", 1);
                    }
                    configuraAtraso(idtarefa);
                    return false;
                }
                break;
            case 2:
                data_atual = new Date();
                dia = data_atual.getDate() - dt_inicio.getDate();
                diferenca = dt_inicio.getTime() - data_atual.getTime();
                hora = diferenca / (1000 * 60 * 60);
                min = diferenca % (1000 * 60 * 60) / (1000 * 60);
                seg = (diferenca % (1000 * 60 * 60)) % (1000 * 60) / 1000;
                if (dia > 0 || hora > valor_tempo) {
                    if (msg) {
                        JOptionPane.showMessageDialog(null, "Prazo para execução da tarefa expirado!", "Vencimento", 1);
                    }
                    configuraAtraso(idtarefa);
                    return false;
                }
                break;
            case 3:
                data_atual = new Date();
                dia = data_atual.getDate() - dt_inicio.getDate();

                if (dia > valor_tempo) {
                    if (msg) {
                        JOptionPane.showMessageDialog(null, "Prazo para execução da tarefa expirado!", "Vencimento", 1);
                    }
                    configuraAtraso(idtarefa);
                    return false;
                }
                break;
            default: {
                return false;

            }
        }
        return true;
    }

    public Transicao getTransicao(int idtarefa) throws SQLException {

        sql = "select * from transicao where idtarefa = ?";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, idtarefa);
        rs = FabricaConexoes.returnResult(stm);
        rs.next();

        int chave = rs.getInt("chave");
        int idproc = rs.getInt("idproc");
        int idativ = rs.getInt("idativ");
        int resp = rs.getInt("resp");
        int idresp = rs.getInt("idresp");
        int transicao = rs.getInt("transicao");
        int status = rs.getInt("status");
        int pai = rs.getInt("pai");
        String solicitante = rs.getString("solicitante");
        Date dt_inicio = rs.getDate("dt_inicio");
        String Hora = rs.getString("dt_inicio").substring(11, 13);
        String Minutos = rs.getString("dt_inicio").substring(14, 16);
        String segundos = rs.getString("dt_inicio").substring(17, 19);
        Date d = new Date(dt_inicio.getYear(), dt_inicio.getMonth(), dt_inicio.getDate(), Integer.valueOf(Hora), Integer.valueOf(Minutos), Integer.valueOf(segundos));
        DateFormat dtformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Transicao t = new Transicao(idtarefa, idativ, idproc, resp, idresp, chave, d, status, transicao, pai, solicitante);
        FabricaConexoes.closeConnection();
        return t;
    }

    public void gravaTarefa(Transicao transicao, int chave, String obs) throws SQLException {
        boolean loop = false;
        int raiz = 0;
        sql = "select idfin,raiz from processo_atividade where idproc = ? and chave = ?";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, transicao.getIdproc());
        stm.setInt(2, chave);
        rs = FabricaConexoes.returnResult(stm);
        rs.next();
        int idfin = rs.getInt("idfin");
        raiz = rs.getInt("raiz");
        rs.close();
        FabricaConexoes.closeConnection();

        sql = "select sequencia from agenda where idtarefa = ? order by sequencia desc";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        if (transicao.getTransicao() == 0) {
            stm.setInt(1, transicao.getIdtarefa());
        } else {
            stm.setInt(1, transicao.getTransicao());
        }
        rs = FabricaConexoes.returnResult(stm);
        int sequencia;
        if (rs.next()) {
            sequencia = rs.getInt("sequencia");
            sequencia++;
        } else {
            sequencia = 1;
        }
        rs.close();
        FabricaConexoes.closeConnection();


        sql = "select * from transicao where idtarefa = ?  and status != 2";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, transicao.getIdtarefa());
        rs = FabricaConexoes.returnResult(stm);
        rs.next();
        Date dt_inicio = transicao.getDt_inicial();
        String Hora = rs.getString("dt_inicio").substring(11, 13);
        String Minutos = rs.getString("dt_inicio").substring(14, 16);
        String segundos = rs.getString("dt_inicio").substring(17, 19);
        Date d = new Date(dt_inicio.getYear(), dt_inicio.getMonth(), dt_inicio.getDate(), Integer.valueOf(Hora), Integer.valueOf(Minutos), Integer.valueOf(segundos));
        DateFormat dtformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        rs.close();
        FabricaConexoes.closeConnection();



        sql = "insert into agenda (idtarefa,idativ,idproc,idfin,idusuario,sequencia,dt_inicial,dt_final,valor,pai,atraso) values(?,?,?,?,?,?,?,?,?,?,?)";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        if (transicao.getTransicao() == 0) {
            stm.setInt(1, transicao.getIdtarefa());
        } else {
            stm.setInt(1, transicao.getTransicao());
        }

        stm.setInt(2, transicao.getIdativ());
        stm.setInt(3, transicao.getIdproc());
        stm.setInt(4, idfin);
        stm.setInt(5, manipulaConexao.getUsuarioLogado().getId());
        stm.setInt(6, sequencia);
        stm.setString(7, dtformat.format(d));
        stm.setString(8, dtformat.format(new Date()));

        if (new GestaoDao().permiteValor(transicao, chave) == 0) {
            stm.setString(9, "");
        } else if (new GestaoDao().permiteValor(transicao, chave) == 1) {
            stm.setString(9, obs);
        } else {
            PreparedStatement stm2;
            ResultSet rs2;
            sql = "select valor from finalizacao where idfinalizacao = ?";
            if (!FabricaConexoes.verificaConexao()) {
                FabricaConexoes.getConexao();
            }
            stm2 = FabricaConexoes.returnStatement(sql);
            stm2.setInt(1, idfin);
            rs2 = FabricaConexoes.returnResult(stm2);
            rs2.next();
            stm.setString(9, rs2.getString("valor"));
            FabricaConexoes.closeConnection();

        }

        stm.setInt(10, transicao.getPai());
        if (transicao.getStatus() == 1) {
            stm.setString(11, "ATRASADO");
        } else {
            stm.setString(11, "NORMAL");
        }
        stm.execute();

        sql = "select link from processo_atividade where idproc= ? and chave = ?";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, transicao.getIdproc());
        stm.setInt(2, chave);
        rs = FabricaConexoes.returnResult(stm);
        rs.next();
        int link = rs.getInt("link");
        FabricaConexoes.closeConnection();

        if (link != 0) {

            sql = "select *  from transicao where idproc= ? and chave = ? and transicao = ? and status != 2";
            if (!FabricaConexoes.verificaConexao()) {
                FabricaConexoes.getConexao();
            }
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, transicao.getIdproc());
            stm.setInt(2, link);
            stm.setInt(3, transicao.getTransicao());
            rs = FabricaConexoes.returnResult(stm);
            if (rs.next()) {
                FabricaConexoes.closeConnection();
                JOptionPane.showMessageDialog(null, "Atividade já iniciada!", "Informação", 1);

                if (link == raiz) {
                    loop = true;
                }

            } else {
                FabricaConexoes.closeConnection();
                sql = "select raiz  from processo_atividade where idproc= ? and chave = ?";
                if (!FabricaConexoes.verificaConexao()) {
                    FabricaConexoes.getConexao();
                }
                stm = FabricaConexoes.returnStatement(sql);
                stm.setInt(1, transicao.getIdproc());
                stm.setInt(2, link);
                rs = FabricaConexoes.returnResult(stm);
                rs.next();
                raiz = rs.getInt("raiz");
                FabricaConexoes.closeConnection();
                desativaTarefa(transicao.getIdtarefa());
                proximaTarefa(transicao, raiz, sequencia);

            }

        } else {
            desativaTarefa(transicao.getIdtarefa());
            proximaTarefa(transicao, chave, sequencia);
        }
        if (!loop) {
            desativaTarefa(transicao.getIdtarefa());
            /*
            sql = "delete from transicao where idtarefa = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, transicao.getIdtarefa());
            stm.execute();
            stm.close();
            rs.close();*/
        }
        FabricaConexoes.closeConnection();
    }

    private void desativaTarefa(int idtarefa) throws SQLException {
        sql = "update transicao set status = 2 where idtarefa = ?";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, idtarefa);
        stm.execute();
        stm.close();
        FabricaConexoes.closeConnection();
    }

    public String preencheArvoreFinalizacao(Transicao trans, JTree arvore) throws SQLException {

        int chave = trans.getChave();
        int idproc = trans.getIdproc();
        int idativ = trans.getIdativ();
        sql = "select nome,descricao from atividade where idatividade = ?";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, idativ);
        rs = FabricaConexoes.returnResult(stm);
        rs.next();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rs.getString("Nome"));
        DefaultMutableTreeNode no;
        String retorno = rs.getString("descricao");
        sql = "select * from processo_atividade where idproc = ? and raiz = ?";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, idproc);
        stm.setInt(2, chave);
        rs = FabricaConexoes.returnResult(stm);
        ResultSet rs2 = null;
        int idfin = 0;
        while (rs.next()) {
            chave = rs.getInt("chave");
            idfin = rs.getInt("idfin");
            sql = "select nome from finalizacao where idfinalizacao = ?";
            if (!FabricaConexoes.verificaConexao()) {
                FabricaConexoes.getConexao();
            }
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idfin);
            rs2 = FabricaConexoes.returnResult(stm);
            rs2.next();
            String Chave = "";
            Chave = "";
            if (chave < 10) {
                Chave = "00" + chave;
            }
            if (chave >= 10 && chave < 100) {
                Chave = "0" + String.valueOf(chave);
            }
            if (chave >= 100 && chave < 1000) {
                Chave = String.valueOf(chave);
            }

            no = new DefaultMutableTreeNode("[" + Chave + "]-" + rs2.getString("nome"));
            root.add(no);
        }

        MenusTreeModel model = new MenusTreeModel(root);
        arvore.setModel(model);
        arvore.setCellRenderer(new RenderizarTree());
        for (int i = 0; i < arvore.getRowCount(); i++) {
            arvore.expandPath(arvore.getPathForRow(i));
        }
        return retorno;
    }

    public int permiteValor(Transicao transicao, int chave) throws SQLException {
        sql = "select idfin from processo_atividade where idproc = ? and chave = ?";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, transicao.getIdproc());
        stm.setInt(2, chave);
        rs = FabricaConexoes.returnResult(stm);
        rs.next();
        int idfin = rs.getInt("idfin");
        rs.close();
        FabricaConexoes.closeConnection();

        sql = "select valor from finalizacao where idfinalizacao = ?";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, idfin);
        rs = FabricaConexoes.returnResult(stm);
        rs.next();
        String valor = rs.getString("valor");
        rs.close();
        FabricaConexoes.closeConnection();

        if (valor.compareToIgnoreCase("\\") == 0) {
            return 0;
        } else if (valor.compareToIgnoreCase("/") == 0) {
            return 1;
        } else {
            return 2;
        }

    }

    public void carregaArvore(int idp, JTree arvore, Transicao trans) {
        try {

            java.sql.PreparedStatement stm;
            ResultSet rs = null;
            ResultSet rs1 = null;
            if (trans.getTransicao() == 0) {
                JOptionPane.showMessageDialog(null, "Tarefa inicial, não possui histórico!", "Alerta", 1);
                return;
            }

            if (!FabricaConexoes.verificaConexao()) {
                FabricaConexoes.getConexao();
            }
            stm = FabricaConexoes.returnStatement("Select * from agenda where idtarefa = ? and pai = 0 and idproc = ?");
            stm.setInt(1, trans.getTransicao());

            stm.setInt(2, idp);
            rs = FabricaConexoes.returnResult(stm);
            stm = FabricaConexoes.returnStatement("Select * from Processo where idprocesso = ?");
            stm.setInt(1, idp);
            rs1 = FabricaConexoes.returnResult(stm);
            rs1.next();
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("|000|-" + rs1.getString("nome"));
            preencheArvoreHistorico(rs, root, idp);
            MenusTreeModel model = new MenusTreeModel(root);
            arvore.setModel(model);
            FabricaConexoes.closeConnection();
            arvore.setCellRenderer(new RenderizarTree());
            for (int i = 0; i < arvore.getRowCount(); i++) {
                arvore.expandPath(arvore.getPathForRow(i));
            }

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void preencheArvoreHistorico(ResultSet rs, DefaultMutableTreeNode no, int processoid) throws SQLException {
        java.sql.PreparedStatement stm;

        if (rs == null) {
            return;
        }

        DefaultMutableTreeNode no2, no3, no4;
        DefaultMutableTreeNode nofin;
        ResultSet rs1 = rs;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet aux = null;
        try {

            while (rs1.next()) {

                //inicio do código que nomeia a atividade do link
                if (FabricaConexoes.verificaConexao()) {
                    FabricaConexoes.getConexao();

                }
                stm = FabricaConexoes.returnStatement("Select nome from atividade where idatividade = ?");
                stm.setInt(1, Integer.valueOf(String.valueOf(rs1.getObject("idativ"))));
                aux = FabricaConexoes.returnResult(stm);
                aux.next();
                //fim do código que nomeia a atividade do link
                int id = rs1.getInt("sequencia");
                String sequencia = "";
                if (id < 10) {
                    sequencia = "00" + id;
                }
                if (id >= 10 && id < 100) {
                    sequencia = "0" + String.valueOf(id);
                }
                if (id >= 100 && id < 1000) {
                    sequencia = String.valueOf(id);
                }

                no2 = new DefaultMutableTreeNode("(" + sequencia + ")-" + aux.getObject("nome"));

                /*Inicio do Código que adiciona o nó da finalização ao nó da Atividade
                 * */
                if (FabricaConexoes.verificaConexao()) {
                    FabricaConexoes.getConexao();

                }
                stm = FabricaConexoes.returnStatement("Select nome from finalizacao where idfinalizacao = ?");
                stm.setInt(1, Integer.valueOf(String.valueOf(rs1.getObject("idfin"))));
                aux = FabricaConexoes.returnResult(stm);
                aux.next();
                //fim do código que nomeia a atividade do link
                //int idfin = rs1.getInt("idfin");

                nofin = new DefaultMutableTreeNode("[" + sequencia + "]-" + aux.getString("nome"));

                no3 = new DefaultMutableTreeNode(nofin);

                // Fim do código de adição do nó Finalização

                if (FabricaConexoes.verificaConexao()) {
                    FabricaConexoes.getConexao();
                }
                stm = FabricaConexoes.returnStatement("Select * from agenda where pai = ? and idtarefa = ? and idproc = ?");
                stm.setInt(1, Integer.valueOf(String.valueOf(rs1.getObject("sequencia"))));
                stm.setInt(2, rs1.getInt("idtarefa"));

                stm.setInt(3, processoid);
                rs2 = FabricaConexoes.returnResult(stm);
                if (rs2 != null) {
                    // while(rs2.next())
                    // {
                    preencheArvoreHistorico(rs2, no3, processoid);
                    //}
                    }
                no2.add(no3);
                no.add(no2);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    public Agenda getAgenda(int idtarefa) throws SQLException {
        Agenda agenda = new Agenda();
        sql = "select * from Agenda where idtarefa = ? and sequencia = 1";
        if (!FabricaConexoes.verificaConexao()) {
            FabricaConexoes.getConexao();
        }
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, idtarefa);
        rs = FabricaConexoes.returnResult(stm);
        rs.next();

        agenda.setIdtarefa(idtarefa);
        agenda.setIdproc(rs.getInt("idproc"));
        agenda.setIdativ(rs.getInt("idativ"));

        agenda.setIdusuario(rs.getInt("idusuario"));


        agenda.setPai(rs.getInt("pai"));

        Date dt_inicio = rs.getDate("dt_inicial");
        String Hora = rs.getString("dt_inicial").substring(11, 13);
        String Minutos = rs.getString("dt_inicial").substring(14, 16);
        String segundos = rs.getString("dt_inicial").substring(17, 19);
        Date d = new Date(dt_inicio.getYear(), dt_inicio.getMonth(), dt_inicio.getDate(), Integer.valueOf(Hora), Integer.valueOf(Minutos), Integer.valueOf(segundos));
        DateFormat dtformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        agenda.setDt_inicial(dtformat.format(d));

        Date dt_final = rs.getDate("dt_final");
        Hora = rs.getString("dt_final").substring(11, 13);
        Minutos = rs.getString("dt_final").substring(14, 16);
        segundos = rs.getString("dt_final").substring(17, 19);
        Date df = new Date(dt_final.getYear(), dt_final.getMonth(), dt_final.getDate(), Integer.valueOf(Hora), Integer.valueOf(Minutos), Integer.valueOf(segundos));
        agenda.setDt_final(dtformat.format(df));
        FabricaConexoes.closeConnection();
        return agenda;
    }

    public void pesquisaAgenda(JTable tabela, Date dt_inicial, Date dt_final, int cp, int ca, int ct, boolean vdata, int prazo,boolean analitico) throws SQLException {
        String p = "%";
        String sequencia = " > 0";
        if (prazo == 1) {
            p = "ATRASADO";
        }
        if (prazo == 2) {
            p = "NORMAL";
        }
        if(!analitico)
            {
                sequencia = "= 1";
            }
        DateFormat dtformat = new SimpleDateFormat("yyyy-MM-dd");
        Usuario user = manipulaConexao.getUsuarioLogado();
        sql = "Select c.nome as 'Processo',a.atraso as 'Prazo',b.nome as 'Atividade', a.dt_inicial as 'Data Início', " +
                "a.dt_final as 'Data Término', a.idtarefa as 'Tarefa' from agenda a inner join atividade b " +
                "on a.idativ = b.idatividade " +
                "inner join processo c on a.idproc = c.idprocesso" +
                " where sequencia" + sequencia + 
                " and a.atraso like '" + p + "'" +
                " and c.idgestor = " + user.getId();

        String sql_verifica = sql;
                    //ql_verifica = sql_verifica + " and dt_inicial between '"+ dtformat.format(dt_inicial.getTime()) +" 00:00:00' and '"+ dtformat.format(dt_final.getTime()) +" 23:59:59' order by a.idtarefa asc";
                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm = FabricaConexoes.returnStatement(sql_verifica);
                    rs = FabricaConexoes.returnResult(stm);

                    while(rs.next())
                    {

                        sql_verifica = "select * from transicao where transicao = ? and status <> 2";
                        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                        stm2 = FabricaConexoes.returnStatement(sql_verifica);
                        stm2.setInt(1, rs.getInt("Tarefa"));
                        int teste = rs.getInt("Tarefa");
                        rs3 = FabricaConexoes.returnResult(stm2);

                        if(rs3.next())
                        {
                            sql = sql + " and a.idtarefa <> " + rs.getInt("Tarefa");
                        }
                        FabricaConexoes.closeConnection();
                    }




        if (cp == 0 && ca == 0 && ct == 0) {
            if (vdata) {
                sql = sql + " and dt_inicial between '" + dtformat.format(dt_inicial.getTime()) + " 00:00:00' and '" + dtformat.format(dt_final.getTime()) + " 23:59:59' order by a.idtarefa asc";
            } else {
                sql = sql + " order by a.idtarefa asc";
            }
            manipulaConexao.preenchetable(tabela, sql);
            formataDataAgenda(tabela, dtformat);
        } else {

            if (cp != 0) {
                sql = sql + " and a.idproc = " + cp;
            }
            if (ca != 0) {
                sql = sql + " and a.idativ = " + ca;
            }
            if (ct != 0) {
                sql = sql + " and a.idtarefa = " + ct;
            }

            if (vdata) {
                sql = sql + " and dt_inicial between '" + dtformat.format(dt_inicial.getTime()) + " 00:00:00' and '" + dtformat.format(dt_final.getTime()) + " 23:59:59' order by a.idtarefa asc";
            } else {
                sql = sql + " order by a.idtarefa asc";
            }

            manipulaConexao.preenchetable(tabela, sql);
            formataDataAgenda(tabela, dtformat);
        }
        FabricaConexoes.closeConnection();
    }

    public void pesquisa(JTable tabela, Date dt_inicial, Date dt_final, int cp, int ca, int ct, boolean vdata, int prazo) throws SQLException {
        String p = "";
        if (prazo == 0) {
            p = "<> 2";
        }
        if (prazo == 1) {
            p = "= 1";
        }
        if (prazo == 2) {
            p = "= 0";
        }
        DateFormat dtformat = new SimpleDateFormat("yyyy-MM-dd");
        Usuario user = manipulaConexao.getUsuarioLogado();

        sql = "select  a.idtarefa as 'Id',a.status as 'Prazo', b.nome as 'Atividade', a.dt_inicio as 'Data Início', c.nome as 'Processo'" +
                " ,a.transicao as 'Tarefa' from transicao a inner join atividade b on a.idativ = b.idatividade" +
                " inner join processo c on a.idproc = c.idprocesso" +
                " where c.idgestor = " + user.getId();


        if (cp == 0 && ca == 0 && ct == 0) {
            if (vdata) {
                sql = sql + " and dt_inicio between '" + dtformat.format(dt_inicial.getTime()) + " 00:00:00' and '" + dtformat.format(dt_final.getTime()) + " 23:59:59' and a.status " + p + " order by a.idtarefa asc";
            } else {
                sql = sql + " and a.status  " + p + " order by a.idtarefa asc";
            }
            manipulaConexao.preenchetable(tabela, sql);
            
            formataData(tabela, dtformat);
        } else {

            if (cp != 0) {
                sql = sql + " and a.idproc = " + cp;
            }
            if (ca != 0) {
                sql = sql + " and a.idativ = " + ca;
            }
            if (ct != 0) {
                sql = sql + " and a.idtarefa = " + ct;
            }
            if (vdata) {
                sql = sql + " and dt_inicio between '" + dtformat.format(dt_inicial.getTime()) + " 00:00:00' and '" + dtformat.format(dt_final.getTime()) + " 23:59:59' and a.status  <>  2 order by a.idtarefa asc";
            } else {
                sql = sql + " and a.status  <>  2 order by a.idtarefa asc";
            }
            manipulaConexao.preenchetable(tabela, sql);
            formataData(tabela, dtformat);
        }

    }
}
