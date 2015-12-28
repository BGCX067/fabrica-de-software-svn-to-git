package model.execucao;

//TODO Fazer a verificação de todas as telas, aquelas que só trazem listagem, realizar a atualização da tabela no componenteshow
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.sql.ResultSet;
import Util.FabricaConexoes;


import Util.MenusTreeModel;
import Util.manipulaConexao;
import com.mysql.jdbc.util.ResultSetUtil;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import model.sistema.Grupo;
import model.sistema.Usuario;
import view.execucao.DestinadoView;

public class ProcAtivDao
{
	
	private PreparedStatement stm;
	private ResultSet rs;
        private ResultSetUtil rs2;
	private String sql;

        public void estanciaTarefasIniciais1(int idprocess,int raiz, int idtarefa, int pai,String desc) throws SQLException
        {//10:49

            boolean executa = false;
            PreparedStatement stm2;
            PreparedStatement stm3;
            ResultSet rs2;
            ResultSet rs3;
            float valor = 0;
            int tempo = 0;            
            String descricao = "";

            sql = "select * from processo_atividade where idproc = "+ idprocess +" and raiz = "+raiz+" and idfin = 0 and link = 0";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            rs = FabricaConexoes.returnResult(stm);
            String hora = "";
            int inicial = 0;
            while(rs.next())
            {
                int idativ,chave,tresp,resp;
                DateFormat dtformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                idativ = rs.getInt("idat");
                chave = rs.getInt("chave");
                tresp = rs.getInt("tipo");
                resp = rs.getInt("idtipo");
                valor = rs.getFloat("valor_tempo");
                tempo = rs.getInt("tempo");
                if(tresp == 2)
                {
                    
                    Transicao trans = new Transicao();
                    new DestinadoView(null, true,trans).setVisible(true);
                    tresp = trans.getTresp();
                    resp = trans.getResp();
                }else if(tresp == 3)
                {

                    Usuario user = manipulaConexao.getUsuarioLogado();
                    tresp = 1;
                    resp = user.getId();

                }

                sql = "select * from ins_processo";
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm2 = FabricaConexoes.returnStatement(sql);
                rs2 = FabricaConexoes.returnResult(stm2);
                rs2.next();
                int ultimo = rs2.getInt("UltimoId");
                FabricaConexoes.closeConnection();
                sql = "update ins_processo set ultimoid = " + ++ultimo;
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm2 = FabricaConexoes.returnStatement(sql);
                stm2.execute();
                
                sql = "insert into transicao (idativ,chave,resp,idresp,dt_inicio,idproc,transicao,pai,idtarefa,solicitante,dt_limite) values (?,?,?,?,?,?,?,?,?,?,?)";
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
                stm.setInt(1, idativ);
                stm.setInt(2, chave);
                stm.setInt(3, tresp);
                stm.setInt(4, resp);
                stm.setInt(6, idprocess);
                stm.setInt(8, pai);
                stm.setInt(9, ultimo);

                Usuario user = manipulaConexao.getUsuarioLogado();
                stm.setString(10, user.getNome());

                if(inicial == 0)
                {
                    stm.setInt(7, idtarefa);

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date());

                    hora = dtformat.format(calendar.getTime());


                    stm.setString(5, hora);
                    
                    int valores = java.lang.Math.round(valor);
                    
                    switch(tempo)
                      {
                        case 0:

                            calendar.add(calendar.SECOND,valores);
                            break;
                        case 1:
                            calendar.add(calendar.MINUTE,valores);
                            break;
                        case 2:
                            calendar.add(calendar.HOUR,valores);
                            break;
                        case 3:
                            calendar.add(calendar.DAY_OF_YEAR,valores);
                            break;
                    }
                     hora = dtformat.format(calendar.getTime());
                     stm.setString(11,hora);
                    

                    // TODO inserir data limite no banco de dados para as tarefas iniciais e depois nas tarefas subsequentes
                    //TODO realizar a inserção da descrição inicial, produzir tela lateral para visualização do mesmo.

                }else
                {
                    sql = "select  idtarefa from transicao where dt_inicio = ? order by idtarefa desc";
                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm2 = FabricaConexoes.returnStatement(sql);
                    stm2.setString(1, hora);
                    rs2 = FabricaConexoes.returnResult(stm2);
                    rs2.next();
                        if(idtarefa == 0)
                        {
                            int id = rs2.getInt("idtarefa");
                            stm.setInt(7, id);
                            
                        }
                        else
                        {
                            stm.setInt(7,idtarefa);
                        }
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date());

                        hora = dtformat.format(calendar.getTime());


                        stm.setString(5, hora);
                        
                        int valores = java.lang.Math.round(valor);

                        switch(tempo)
                          {
                            case 0:

                                calendar.add(calendar.SECOND,valores);
                                break;
                            case 1:
                                calendar.add(calendar.MINUTE,valores);
                                break;
                            case 2:
                                calendar.add(calendar.HOUR,valores);
                                break;
                            case 3:
                                calendar.add(calendar.DAY_OF_YEAR,valores);
                                break;
                        }
                         hora = dtformat.format(calendar.getTime());
                         stm.setString(11,hora);
                        

                }
                if(!executa)
                {
                    stm.execute();
                }
                
                
               // new InsereDescView(null, true, descricao, 0).setVisible(true);

                
                
                
                stm.close();
                FabricaConexoes.closeConnection();
                inicial++;
            }



        }

        public void configuraAtraso(int idtarefa)throws SQLException
        {
            
            sql = "update transicao set status = 1 where idtarefa = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idtarefa);
            stm.execute();
            stm.close();
            FabricaConexoes.closeConnection();
        }


	public void estanciaTarefasIniciais(int idprocess,int raiz, int idtarefa, int seq) throws SQLException
        {
            boolean executa = false;
            PreparedStatement stm2;
            PreparedStatement stm3;
            PreparedStatement stm4;
            ResultSet rs2;
            ResultSet rs3;
            ResultSet rs4;
            float valor = 0;
            int tempo = 0;
            sql = "select * from processo_atividade where idproc = "+ idprocess +" and raiz = "+raiz+" and idfin = 0 and link = 0";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm4 = FabricaConexoes.returnStatement(sql);
            rs = FabricaConexoes.returnResult(stm);
            rs4 = FabricaConexoes.returnResult(stm4);

            String hora = "";
            int inicial = 0;
            
            if(!rs4.next())
            {
                deleteProcesso(rs4, stm4, idtarefa);
            }

            while(rs.next())
            {
                int idativ,chave,tresp,resp;
                DateFormat dtformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                idativ = rs.getInt("idat");
                chave = rs.getInt("chave");
                tresp = rs.getInt("tipo");
                resp = rs.getInt("idtipo");
                valor = rs.getFloat("valor_tempo");
                tempo = rs.getInt("tempo");
                if(tresp == 2)
                {
                    Transicao transi = new Transicao();
                    new DestinadoView(null, true,transi).setVisible(true);
                    tresp = transi.getTresp();
                    resp = transi.getResp();
                }else if(tresp == 3)
                {
                    tresp = 1;
                    Usuario usuario = manipulaConexao.getUsuarioLogado();
                    resp = usuario.getId();
                }
                
                sql = "select * from ins_processo";
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm2 = FabricaConexoes.returnStatement(sql);
                rs2 = FabricaConexoes.returnResult(stm2);
                rs2.next();
                int ultimo = rs2.getInt("UltimoId");
                
                sql = "update ins_processo set ultimoid = " + ++ultimo;
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm2 = FabricaConexoes.returnStatement(sql);
                stm2.execute();
                
                sql = "insert into transicao (idativ,chave,resp,idresp,dt_inicio,idproc,transicao,pai,idtarefa,solicitante,dt_limite) values (?,?,?,?,?,?,?,?,?,?,?)";
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
                stm.setInt(1, idativ);
                stm.setInt(2, chave);
                stm.setInt(3, tresp);
                stm.setInt(4, resp);
                stm.setInt(6, idprocess);
                stm.setInt(9, ultimo);

                Usuario user = manipulaConexao.getUsuarioLogado();
                stm.setString(10, user.getNome());

                if(inicial == 0)
                {
                    stm.setInt(7, idtarefa);
                    //hora = dtformat.format(new Date());
                    //stm.setString(5, hora);

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date());

                    hora = dtformat.format(calendar.getTime());


                    stm.setString(5, hora);

                    int valores = java.lang.Math.round(valor);

                    switch(tempo)
                      {
                        case 0:

                            calendar.add(calendar.SECOND,valores);
                            break;
                        case 1:
                            calendar.add(calendar.MINUTE,valores);
                            break;
                        case 2:
                            calendar.add(calendar.HOUR,valores);
                            break;
                        case 3:
                            calendar.add(calendar.DAY_OF_YEAR,valores);
                            break;
                    }
                     hora = dtformat.format(calendar.getTime());
                     stm.setString(11,hora);




                    stm.setInt(8, seq);
                    sql = "select *  from transicao where idproc= ? and chave = ? and transicao = ?";
                        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                        stm3 = FabricaConexoes.returnStatement(sql);
                        stm3.setInt(1, idprocess);
                        stm3.setInt(2, chave);
                        stm3.setInt(3, idtarefa);
                        rs3 = FabricaConexoes.returnResult(stm3);
                        if(rs3.next())
                        {/*
                         FabricaConexoes.closeConnection();
                         JOptionPane.showMessageDialog(null, "Atividade já iniciada!","Informação",1);
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


                }else
                {
                    sql = "select  idtarefa from transicao where dt_inicio = ? order by idtarefa desc";
                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm2 = FabricaConexoes.returnStatement(sql);
                    stm2.setString(1, hora);
                    rs2 = FabricaConexoes.returnResult(stm2);
                    rs2.next();
                        int id = rs2.getInt("idtarefa");
                        stm.setInt(7, id);
                        //stm.setString(5, dtformat.format(new Date()));

                        Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date());

                    hora = dtformat.format(calendar.getTime());


                    stm.setString(5, hora);

                    int valores = java.lang.Math.round(valor);

                    switch(tempo)
                      {
                        case 0:

                            calendar.add(calendar.SECOND,valores);
                            break;
                        case 1:
                            calendar.add(calendar.MINUTE,valores);
                            break;
                        case 2:
                            calendar.add(calendar.HOUR,valores);
                            break;
                        case 3:
                            calendar.add(calendar.DAY_OF_YEAR,valores);
                            break;
                    }
                     hora = dtformat.format(calendar.getTime());
                     stm.setString(11,hora);



                        stm.setInt(8, seq);
                        sql = "select *  from transicao where idproc= ? and chave = ? and transicao = ?";
                        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                        stm3 = FabricaConexoes.returnStatement(sql);
                        stm3.setInt(1, idprocess);
                        stm3.setInt(2, chave);
                        stm3.setInt(3, id);
                        rs3 = FabricaConexoes.returnResult(stm3);
                        if(rs3.next())
                        {/*
                         FabricaConexoes.closeConnection();
                         JOptionPane.showMessageDialog(null, "Atividade já iniciada!","Informação",1);                         
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
                if(!executa)
                {
                    stm.execute();
                }
                stm.close();
                FabricaConexoes.closeConnection();
                inicial++;
            }
            


        }

        private void deleteProcesso(ResultSet rs4, PreparedStatement stm4, int idtarefa) throws SQLException
        {
            sql = "select * from transicao where transicao = " + idtarefa + " and status != 2";
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm4 = FabricaConexoes.returnStatement(sql);
                rs4 = FabricaConexoes.returnResult(stm4);
                if(!rs4.next())
                {
                    sql = "select * from transicao where  idtarefa = " + idtarefa + " and status != 2";
                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm4 = FabricaConexoes.returnStatement(sql);
                    rs4 = FabricaConexoes.returnResult(stm4);
                    if(!rs4.next())
                    {
                        sql = "delete from transicao where transicao = ? or idtarefa = ?";
                        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                        stm4 = FabricaConexoes.returnStatement(sql);
                        stm4.setInt(1, idtarefa);
                        stm4.setInt(2, idtarefa);
                        stm4.execute();
                    }
                }
                FabricaConexoes.closeConnection();
        }

        public void proximaTarefa(Transicao transicao, int chave, int pai)throws SQLException
        {
            if(transicao.getTransicao() == 0)
            {
                
                estanciaTarefasIniciais(transicao.getIdproc(), chave, transicao.getIdtarefa(), pai);
            }else
            {
                
                estanciaTarefasIniciais(transicao.getIdproc(), chave, transicao.getTransicao(),pai);
            }
        }

        public void carregaFormularios(JTable table)
        {
            Usuario user = manipulaConexao.getUsuarioLogado();
            manipulaConexao.setConexao(user.getLogin(), user.getSenha());
            sql = "select * from tb_formulario";
            manipulaConexao.preenchetable(table, sql);

        }

        public void carregaTarefas(JTable table)
        {
            
            Usuario user = manipulaConexao.getUsuarioLogado();
            manipulaConexao.setConexao(user.getLogin(), user.getSenha());
            ArrayList<Grupo> grupos = manipulaConexao.getGrupoLogado();

            sql = "select  a.idtarefa as 'Código',a.status as 'Prazo', b.nome as 'Atividade', a.solicitante as 'Solicitante', a.dt_limite as 'Data Limite', c.nome as 'Processo', a.transicao as 'Tarefa'"+
                    " from transicao a inner join atividade b on a.idativ = b.idatividade"+
                    " inner join processo c on a.idproc = c.idprocesso" +
                    " where a.status <> 2 "+
                    " and resp = 1 and idresp = "+user.getId();
                    

            for(int i = 0; i < grupos.size() ; i++)
            {

                sql = sql + " or resp = 0 and idresp = "+grupos.get(i).getId();
                

            }
            sql = sql + " and a.status <> 2 order by a.idtarefa asc";
            manipulaConexao.preenchetable(table, sql);
            DateFormat dtformat = new SimpleDateFormat();
            try
                {
                    formataData(table, dtformat,sql);
                }catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
        }
	

        public void formataData(JTable table, DateFormat dtformat, String sqls) throws SQLException
        {

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sqls);
                rs = FabricaConexoes.returnResult(stm);
                int i = 0;
                    while(rs.next())
                    {
                        String Hora = rs.getString("Data Limite").substring(11,13);
                        String Minutos = rs.getString("Data Limite").substring(14,16);
                        String segundos = rs.getString("Data Limite").substring(17,19);
                        dtformat = new SimpleDateFormat("dd/MM/yyyy "+Hora+":"+Minutos+":"+segundos);
                        table.setValueAt(dtformat.format(rs.getDate("Data Limite")), i, 4);
                        if(rs.getInt("Prazo") == 1)
                        {
                            table.setValueAt("ATRASADO", i, 1);
                        }
                        if(rs.getInt("Prazo") == 0)
                        {
                            table.setValueAt("NORMAL", i, 1);
                        }
                        i++;
                    }
                    if(i == 0)
                    {
                        Object[] objeto = new Object[6];
                        objeto[0] = "Código Tarefa";
                        objeto[1] = "Prazo";
                        objeto[2] = "Atividade";
                        objeto[3] = "Solicitante";
                        objeto[4] = "Data Limite";
                        objeto[5] = "Data Final";
                        table.setModel(new DefaultTableModel(objeto, 0));
                    }
                    FabricaConexoes.closeConnection();

        }

        public void formataDataAgenda(JTable table, DateFormat dtformat, String sqls) throws SQLException
        {

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sqls);
                rs = FabricaConexoes.returnResult(stm);
                int i = 0;
                    while(rs.next())
                    {
                        String Hora = rs.getString("Data Início").substring(11,13);
                        String Minutos = rs.getString("Data Início").substring(14,16);
                        String segundos = rs.getString("Data Início").substring(17,19);
                        dtformat = new SimpleDateFormat("dd/MM/yyyy "+Hora+":"+Minutos+":"+segundos);
                        table.setValueAt(dtformat.format(rs.getDate("Data Início")), i, 4);
                        Hora = rs.getString("Data Término").substring(11,13);
                        Minutos = rs.getString("Data Término").substring(14,16);
                        segundos = rs.getString("Data Término").substring(17,19);
                        dtformat = new SimpleDateFormat("dd/MM/yyyy "+Hora+":"+Minutos+":"+segundos);
                        table.setValueAt(dtformat.format(rs.getDate("Data Término")), i, 5);

                        if(rs.getString("Prazo").compareToIgnoreCase("atrasado") == 1)
                        {
                            table.setValueAt("ATRASADO", i, 1);
                        }
                        if(rs.getString("Prazo").compareToIgnoreCase("normal") == 1)
                        {
                            table.setValueAt("NORMAL", i, 1);
                        }
                        i++;
                    }
                    if(i == 0)
                    {
                        Object[] objeto = new Object[6];
                        objeto[0] = "Código Tarefa";
                        objeto[1] = "Prazo";
                        objeto[2] = "Atividade";
                        objeto[3] = "Solicitante";
                        objeto[4] = "Data Início";
                        objeto[5] = "Data Final";
                        table.setModel(new DefaultTableModel(objeto, 0));
                    }
                    FabricaConexoes.closeConnection();

        }


        public boolean consultaPrazo(int idtarefa, boolean msg) throws SQLException
        {
            sql = "select * from transicao where idtarefa = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idtarefa);
            rs = FabricaConexoes.returnResult(stm);
            rs.next();
            int chave = rs.getInt("chave");
            int idproc = rs.getInt("idproc");
            int idativ = rs.getInt("idativ");
            int resp = rs.getInt("resp");
            int idresp = rs.getInt("idresp");
            Date dt_limite = rs.getDate("dt_limite");            
            Date dt_inicio = rs.getDate("dt_inicio");
            String Hora = rs.getString("dt_inicio").substring(11,13);
            String Minutos = rs.getString("dt_inicio").substring(14,16);
            String segundos = rs.getString("dt_inicio").substring(17,19);
            Date d = new Date(dt_inicio.getYear(),dt_inicio.getMonth(),dt_inicio.getDate(),Integer.valueOf(Hora),Integer.valueOf(Minutos),Integer.valueOf(segundos));
            Hora = rs.getString("dt_limite").substring(11,13);
            Minutos = rs.getString("dt_limite").substring(14,16);
            segundos = rs.getString("dt_limite").substring(17,19);
            Date dl = new Date(dt_limite.getYear(),dt_limite.getMonth(),dt_limite.getDate(),Integer.valueOf(Hora),Integer.valueOf(Minutos),Integer.valueOf(segundos));
            DateFormat dtformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");           
            FabricaConexoes.closeConnection();
            /*sql = "select * from processo_atividade where idproc = ? and chave = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idproc);
            stm.setInt(2, chave);
            rs = FabricaConexoes.returnResult(stm);
            rs.next();
            int tempo = rs.getInt("tempo");
            float valor_tempo = rs.getFloat("valor_tempo");
            
           
            Date data_atual;
            long diferenca;
            long hora,min,seg;
            int dia;*/
            //FabricaConexoes.closeConnection();


            Calendar calendar = Calendar.getInstance();
                        calendar.setTime(dl);
                        Calendar calendar2 = Calendar.getInstance();
                        Date dataatual = new Date();
                        calendar2.setTime(new Date(dataatual.getYear(),dataatual.getMonth(),dataatual.getDate(),dataatual.getHours(),dataatual.getMinutes(), dataatual.getSeconds()));
                        if(calendar.compareTo(calendar2) == -1)
                        {
                            if(msg)
                           {
                               JOptionPane.showMessageDialog(null, "Prazo para execução da tarefa expirado!","Vencimento",1);
                           }
                           configuraAtraso(idtarefa);
                           return false;
                            }
                        if(calendar.compareTo(calendar2) == 0)
                        {
                           return true;
                        }
                        if(calendar.compareTo(calendar2) == 1)
                        {
                            return true;
                        }

            /*switch(tempo)
            {

                case 0 :
                        /*
                         * Calendar calendar = Calendar.getInstance();
                         * if(calendar.after)
                         /*
                        data_atual = new Date();
                        dia = data_atual.getDate() - dt_inicio.getDate();
                        diferenca = dt_inicio.getTime() - data_atual.getTime();
                        hora = diferenca / (1000 * 60 * 60);
                        min = diferenca % (1000 * 60 * 60) / (1000 * 60);
                        seg = (diferenca % (1000 * 60 * 60))% (1000 * 60) / 1000;
                        if(dia > 0 || hora > 0 || min > 0 || seg > valor_tempo)
                        {
                           if(msg)
                           {
                               JOptionPane.showMessageDialog(null, "Prazo para execução da tarefa expirado!","Vencimento",1);
                           }
                           configuraAtraso(idtarefa);
                           return false;
                        }
                        break;
                case 1 :
                    /*
                        data_atual = new Date();
                        dia = data_atual.getDate() - dt_inicio.getDate();
                        diferenca = dt_inicio.getTime() - data_atual.getTime();
                        hora = diferenca / (1000 * 60 * 60);
                        min = diferenca % (1000 * 60 * 60) / (1000 * 60);
                        seg = (diferenca % (1000 * 60 * 60))% (1000 * 60) / 1000;
                        if(dia > 0 || hora > 0 || min > valor_tempo)
                        {
                           if(msg)
                           {
                               JOptionPane.showMessageDialog(null, "Prazo para execução da tarefa expirado!","Vencimento",1);
                           }
                           configuraAtraso(idtarefa);
                           return false;
                        }
                        break;
                case 2 :
                        
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(dl);
                        Calendar calendar2 = Calendar.getInstance();
                        Date dataatual = new Date();
                        calendar2.setTime(new Date(dataatual.getYear(),dataatual.getMonth(),dataatual.getDate(),dataatual.getHours(),dataatual.getMinutes(), dataatual.getSeconds()));
                        if(calendar.compareTo(calendar2) == -1)
                        {
                            JOptionPane.showMessageDialog(null,calendar.compareTo(calendar2) );
                            }
                        if(calendar.compareTo(calendar2) == 0)
                        {
                           JOptionPane.showMessageDialog(null,calendar.compareTo(calendar2) );
                        }
                        if(calendar.compareTo(calendar2) == 1)
                        {
                            JOptionPane.showMessageDialog(null,calendar.compareTo(calendar2) );
                        }
                        /*
                        data_atual = new Date();
                        dia = data_atual.getDate() - dt_inicio.getDate();
                        diferenca = dt_inicio.getTime() - data_atual.getTime();
                        hora = diferenca / (1000 * 60 * 60);
                        min = diferenca % (1000 * 60 * 60) / (1000 * 60);
                        seg = (diferenca % (1000 * 60 * 60))% (1000 * 60) / 1000;
                        if(dia > 0 || hora > valor_tempo)
                        {
                           if(msg)
                           {
                               JOptionPane.showMessageDialog(null, "Prazo para execução da tarefa expirado!","Vencimento",1);
                           }
                           configuraAtraso(idtarefa);
                           return false;
                        }
                        //Calculo de datas utilizando a classe calendar.
                        //JOptionPane.showMessageDialog(null, calendar.getTime());
                        break;
                case 3 :
                    /*
                        data_atual = new Date();
                        dia = data_atual.getDate() - dt_inicio.getDate();
                        
                        if(dia > valor_tempo)
                        {
                           if(msg)
                           {
                               JOptionPane.showMessageDialog(null, "Prazo para execução da tarefa expirado!","Vencimento",1);
                           }
                           configuraAtraso(idtarefa);
                           return false;
                        }
                        break;
                default :
                        {
                            return false;
                        }
            }*/
            
            return true;
        }

        public Transicao getTransicao(int idtarefa)throws SQLException 
        {

            sql = "select * from transicao where idtarefa = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
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
            Date dt_limite = rs.getDate("dt_limite");
            String solicitante = rs.getString("solicitante");
            Date dt_inicio = rs.getDate("dt_limite");
            Timestamp data = rs.getTimestamp("dt_inicio");            
            String Hora = rs.getString("dt_limite").substring(11,13);
            String Minutos = rs.getString("dt_limite").substring(14,16);
            String segundos = rs.getString("dt_limite").substring(17,19);
            Date d = new Date(dt_inicio.getYear(),dt_inicio.getMonth(),dt_inicio.getDate(),Integer.valueOf(Hora),Integer.valueOf(Minutos),Integer.valueOf(segundos));
            DateFormat dtformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Transicao t = new Transicao(idtarefa, idativ, idproc, resp, idresp, chave, data, status, transicao,pai,solicitante,d);
            FabricaConexoes.closeConnection();
            return t;
        }
        

        public void gravaTarefa(Transicao transicao,int chave, String obs)throws SQLException
        {
            boolean loop = false;
            int raiz =0;
            sql = "select idfin,raiz from processo_atividade where idproc = ? and chave = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
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
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            if(transicao.getTransicao() == 0)
            {
                stm.setInt(1, transicao.getIdtarefa());
            }else
            {
                stm.setInt(1, transicao.getTransicao());
            }
            rs = FabricaConexoes.returnResult(stm);
            int sequencia;
            if(rs.next())
            {
                sequencia = rs.getInt("sequencia");
                sequencia++;
            }else {sequencia = 1;}
            rs.close();
            FabricaConexoes.closeConnection();
            

            sql = "select * from transicao where idtarefa = ?  and status != 2";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1,transicao.getIdtarefa());
            rs = FabricaConexoes.returnResult(stm);
            if(!rs.next())
            {
                JOptionPane.showMessageDialog(null, "Atividade já iniciada!","Informação",1);
                return;
            }
            Date dt_inicio = transicao.getDt_inicial();
            String ano = rs.getString("dt_inicio").substring(0,4);
            String mes = rs.getString("dt_inicio").substring(5,7);
            String dia = rs.getString("dt_inicio").substring(8,10);
            String Hora = rs.getString("dt_inicio").substring(11,13);
            String Minutos = rs.getString("dt_inicio").substring(14,16);
            String segundos = rs.getString("dt_inicio").substring(17,19);
            
            Date d = new Date(Integer.valueOf(ano),Integer.valueOf(mes),Integer.valueOf(dia),Integer.valueOf(Hora),Integer.valueOf(Minutos),Integer.valueOf(segundos));
            DateFormat dtformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            rs.close();          
            
            FabricaConexoes.closeConnection();



            sql = "insert into agenda (idtarefa,idativ,idproc,idfin,idusuario,sequencia,dt_inicial,dt_final,valor,pai,atraso,solicitante) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            if(transicao.getTransicao() == 0)
            {
                stm.setInt(1, transicao.getIdtarefa());
            }else
            {
                stm.setInt(1, transicao.getTransicao());
            }
            
            stm.setInt(2, transicao.getIdativ());
            stm.setInt(3, transicao.getIdproc());
            stm.setInt(4, idfin);
            stm.setInt(5, manipulaConexao.getUsuarioLogado().getId());
            stm.setInt(6, sequencia);
            stm.setString(7, dtformat.format(transicao.getDt_inicial()));
            Date data = new Date();            
            stm.setString(8, dtformat.format(data));
            if(new ProcAtivDao().permiteValor(transicao, chave) == 0)
            {
                stm.setString(9, "");
            }else if(new ProcAtivDao().permiteValor(transicao, chave) == 1)
                    {
                        stm.setString(9, obs);
                        }else
                            {
                                PreparedStatement stm2;
                                ResultSet rs2;
                                sql = "select valor from finalizacao where idfinalizacao = ?";
                                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                                stm2 = FabricaConexoes.returnStatement(sql);
                                stm2.setInt(1, idfin);
                                rs2 = FabricaConexoes.returnResult(stm2);
                                rs2.next();
                                stm.setString(9, rs2.getString("valor"));
                                FabricaConexoes.closeConnection();

                                }

            stm.setInt(10, transicao.getPai());
            if(transicao.getStatus() == 1)
            {
                stm.setString(11,"ATRASADO");
            }else
            {
                stm.setString(11,"NORMAL");
            }
            stm.setString(12, transicao.getSolicitante());            
            stm.execute();

            


            sql = "select link,processo from processo_atividade where idproc= ? and chave = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, transicao.getIdproc());
            stm.setInt(2, chave);
            rs = FabricaConexoes.returnResult(stm);
            rs.next();
            int link = rs.getInt("link");
            int processo = rs.getInt("processo");
            FabricaConexoes.closeConnection();
            
            if(link != 0)
            {
                if(processo != 0)
                {
                   try{

                        new ProcAtivDao().estanciaTarefasIniciais1(link,0,transicao.getTransicao(),sequencia,"");

                }catch(SQLException sql)
                    {
                    JOptionPane.showMessageDialog(null, sql.getMessage());
                    sql.printStackTrace();
                    }
                }
                else
                {
                sql = "select *  from transicao where idproc= ? and chave = ? and transicao = ? and status != 2";
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
                stm.setInt(1, transicao.getIdproc());
                stm.setInt(2, link);
                stm.setInt(3, transicao.getTransicao());
                rs = FabricaConexoes.returnResult(stm);
                if(rs.next())
                {
                 FabricaConexoes.closeConnection();
                 //JOptionPane.showMessageDialog(null, "Atividade já iniciada!","Informação",1);

                 if(link == raiz)
                 {
                     loop = true;
                 }
                 
                }
                else{
                        FabricaConexoes.closeConnection();
                        sql = "select raiz  from processo_atividade where idproc= ? and chave = ?";
                        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                        stm = FabricaConexoes.returnStatement(sql);
                        stm.setInt(1, transicao.getIdproc());
                        stm.setInt(2, link);
                        rs = FabricaConexoes.returnResult(stm);
                        rs.next();
                        raiz = rs.getInt("raiz");
                        FabricaConexoes.closeConnection();
                        desativaTarefa(transicao.getIdtarefa());
                        proximaTarefa(transicao, raiz,sequencia);
                        
                }
                }
            }
            else
            {
                    desativaTarefa(transicao.getIdtarefa());
                    proximaTarefa(transicao,chave,sequencia);                    
            }
            if(!loop)
            {
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


        private void desativaTarefa(int idtarefa) throws SQLException
        {
                sql = "update transicao set status = 2 where idtarefa = ?";
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
                stm.setInt(1, idtarefa);
                stm.execute();
                stm.close();
                FabricaConexoes.closeConnection();
        }


        public String preencheArvoreFinalizacao(Transicao trans, JTree arvore) throws SQLException
        {

            int chave = trans.getChave();
            int idproc = trans.getIdproc();
            int idativ = trans.getIdativ();
            sql = "select nome,descricao from atividade where idatividade = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idativ);
            rs = FabricaConexoes.returnResult(stm);
            rs.next();
            DefaultMutableTreeNode root = new DefaultMutableTreeNode(rs.getString("Nome"));
            DefaultMutableTreeNode no;
            String retorno = rs.getString("descricao");
            sql = "select * from processo_atividade where idproc = ? and raiz = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idproc);
            stm.setInt(2, chave);
            rs = FabricaConexoes.returnResult(stm);
            ResultSet rs2 = null;
            int idfin = 0;
            while(rs.next())
            {
                chave = rs.getInt("chave");
                idfin = rs.getInt("idfin");
                sql = "select nome from finalizacao where idfinalizacao = ?";
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
                stm.setInt(1, idfin);
                rs2 = FabricaConexoes.returnResult(stm);
                rs2.next();
                String Chave = "";
                                Chave = "";
                                if(chave < 10)
                                {
                                   Chave = "00"+chave;
                                }
                                if(chave>=10 && chave <100)
                                {
                                    Chave = "0"+String.valueOf(chave);
                                }
                                if(chave>=100 && chave<1000)
                                {
                                    Chave = String.valueOf(chave);
                                }

                                no = new DefaultMutableTreeNode("["+Chave+"]-" + rs2.getString("nome"));
                                root.add(no);
            }

            MenusTreeModel model = new MenusTreeModel(root);
            arvore.setModel(model);
            arvore.setCellRenderer(new RenderizarTree());
            for(int i = 0; i< arvore.getRowCount();i++)
                {
                    arvore.expandPath(arvore.getPathForRow(i));
                }
            FabricaConexoes.closeConnection();
            return retorno;
        }


        public int permiteValor(Transicao transicao, int chave)throws SQLException
        {
            sql = "select idfin from processo_atividade where idproc = ? and chave = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, transicao.getIdproc());
            stm.setInt(2, chave);
            rs = FabricaConexoes.returnResult(stm);
            rs.next();
            int idfin = rs.getInt("idfin");
            rs.close();
            FabricaConexoes.closeConnection();

            sql = "select valor from finalizacao where idfinalizacao = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idfin);
            rs = FabricaConexoes.returnResult(stm);
            rs.next();
            String  valor = rs.getString("valor");
            rs.close();
            FabricaConexoes.closeConnection();
            if(valor.compareToIgnoreCase("\\") == 0)
            {
                return 0;
            }else if(valor.compareToIgnoreCase("/") == 0)
            {
                return 1;
            }else {
                    return 2;
                     }

        }
        public String retornaPergunta(Transicao transicao, int chave)throws SQLException
        {
            sql = "select idfin from processo_atividade where idproc = ? and chave = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, transicao.getIdproc());
            stm.setInt(2, chave);
            rs = FabricaConexoes.returnResult(stm);
            rs.next();
            int idfin = rs.getInt("idfin");
            rs.close();
            FabricaConexoes.closeConnection();

            sql = "select pergunta from finalizacao where idfinalizacao = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idfin);
            rs = FabricaConexoes.returnResult(stm);
            rs.next();
            String  valor = rs.getString("pergunta");
            rs.close();
            FabricaConexoes.closeConnection();

            if(valor == null || valor.compareToIgnoreCase("") == 0)
            {
                return("Insira os valores para a finalização: ");
            }else
            {
                return valor;
            }

        }

        public void carregaArvore(int idp,JTree arvore, Transicao trans)
        {
            try{

            java.sql.PreparedStatement stm;
            ResultSet rs=null;
            ResultSet rs1=null;
                    if(trans.getTransicao() == 0)
                    {
                        //JOptionPane.showMessageDialog(null, "Tarefa inicial, não possui histórico!","Alerta",1);
                        //return;
                        trans.setTransicao(trans.getIdtarefa());
                    }

                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm = FabricaConexoes.returnStatement("Select * from agenda where idtarefa = ? and pai = 0 and idproc = ?");
                    stm.setInt(1, trans.getTransicao());
                    
                    stm.setInt(2, idp);
                    rs = FabricaConexoes.returnResult(stm);
                    stm = FabricaConexoes.returnStatement("Select * from Processo where idprocesso = ?");
                    stm.setInt(1, idp);
                    rs1 = FabricaConexoes.returnResult(stm);
                    rs1.next();
                    DefaultMutableTreeNode root = new DefaultMutableTreeNode("|000|-"+rs1.getString("nome"));
                    preencheArvoreHistorico(rs, root,idp);
                    MenusTreeModel model = new MenusTreeModel(root);
                    arvore.setModel(model);
                    FabricaConexoes.closeConnection();
                    arvore.setCellRenderer(new RenderizarTree());
                    for(int i = 0; i< arvore.getRowCount();i++)
                    {
                        arvore.expandPath(arvore.getPathForRow(i));
                    }

            }catch(SQLException sql)
            {
                sql.printStackTrace();
                JOptionPane.showMessageDialog(null, sql.getMessage());
            }
        }


        public void preencheArvoreHistorico(ResultSet rs, DefaultMutableTreeNode no,int processoid) throws SQLException
        {
            java.sql.PreparedStatement stm,stmaux;
            
        if(rs == null)
        {
            return ;
        }

        DefaultMutableTreeNode no2, no3,no4;
        DefaultMutableTreeNode nofin;
        ResultSet rs1 = rs;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet aux = null;
        try{

                while(rs1.next())
                {
                    
                    //inicio do código que nomeia a atividade do link
                   if(FabricaConexoes.verificaConexao())
                        {
                            FabricaConexoes.getConexao();

                        }
                    stm = FabricaConexoes.returnStatement("Select nome from atividade where idatividade = ?");
                    stm.setInt(1, Integer.valueOf(String.valueOf(rs1.getObject("idativ"))));
                    aux = FabricaConexoes.returnResult(stm);
                    aux.next();
                    //fim do código que nomeia a atividade do link
                    int id = rs1.getInt("sequencia");
                    String sequencia = "";
                    if(id < 10)
                    {
                       sequencia = "00"+id;
                    }
                    if(id>=10 && id <100)
                    {
                        sequencia = "0"+String.valueOf(id);
                    }
                    if(id>=100 && id<1000)
                    {
                        sequencia = String.valueOf(id);
                    }

                    no2 = new DefaultMutableTreeNode("("+sequencia+")-" + aux.getObject("nome"));
                    
                    /*Inicio do Código que adiciona o nó da finalização ao nó da Atividade
                     * */
                    if(FabricaConexoes.verificaConexao())
                        {
                            FabricaConexoes.getConexao();

                        }
                    stm = FabricaConexoes.returnStatement("Select nome from finalizacao where idfinalizacao = ?");
                    stm.setInt(1, Integer.valueOf(String.valueOf(rs1.getObject("idfin"))));
                    aux = FabricaConexoes.returnResult(stm);
                    aux.next();
                    //fim do código que nomeia a atividade do link
                    //int idfin = rs1.getInt("idfin");
                    
                    nofin = new DefaultMutableTreeNode("["+sequencia+"]-" + aux.getString("nome"));
                    
                    no3 = new DefaultMutableTreeNode(nofin);
                    
                    // Fim do código de adição do nó Finalização

                    if(FabricaConexoes.verificaConexao())
                    {
                        FabricaConexoes.getConexao();
                    }
                    stm = FabricaConexoes.returnStatement("Select * from agenda where pai = ? and idtarefa = ?");
                    stm.setInt(1, Integer.valueOf(String.valueOf(rs1.getObject("sequencia"))));
                    stm.setInt(2, rs1.getInt("idtarefa"));

                    //stm.setInt(3, processoid);
                    rs2 = FabricaConexoes.returnResult(stm);

                    stm = FabricaConexoes.returnStatement("Select * from agenda where pai = ? and idtarefa = ?");
                    stm.setInt(1, Integer.valueOf(String.valueOf(rs1.getObject("sequencia"))));
                    stm.setInt(2, rs1.getInt("idtarefa"));

                    ResultSet auxiliar = FabricaConexoes.returnResult(stm);

                    if(rs2 != null)
                    {
                       // while(rs2.next())
                        // {
                            if(auxiliar != null)
                            {
                                if(auxiliar.next())
                                {
                                    //JOptionPane.showMessageDialog(null, auxiliar.getInt("idproc"));
                                }
                            }
                            preencheArvoreHistorico(rs2, no3,processoid);     
                        //}
                    }

                    /*
                    if(FabricaConexoes.verificaConexao())
                    {
                        FabricaConexoes.getConexao();
                    }
                    stm = FabricaConexoes.returnStatement("Select * from agenda where pai = ? and idtarefa = ? and idproc <> ?");
                    stm.setInt(1, Integer.valueOf(String.valueOf(rs1.getObject("sequencia"))));
                    stm.setInt(2, rs1.getInt("idtarefa"));
                    stm.setInt(3, processoid);

                    rs2 = FabricaConexoes.returnResult(stm);
                    if(rs2 != null)
                    {
                       // while(rs2.next())
                        // {
                            if(FabricaConexoes.verificaConexao())
                                {
                                    FabricaConexoes.getConexao();
                                }
                                stm = FabricaConexoes.returnStatement("select * from processo where idprocesso = ?");
                                stm.setInt(1, rs.getInt("idproc"));
                                ResultSet rsproc = FabricaConexoes.returnResult(stm);
                                rsproc.next();
                                DefaultMutableTreeNode no5 = new DefaultMutableTreeNode("|000|-"+rsproc.getString("nome"));
                                no3.add(no5);
                                preencheArvoreHistorico(rs2, no5, rs.getInt("idproc"));
                        //}
                    }
                    */
                    
                    no2.add(no3);
                    no.add(no2);
                }
                //FabricaConexoes.closeConnection();
        }catch(SQLException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            FabricaConexoes.closeConnection();

        }
            
        }


        public Agenda getAgenda(int idtarefa) throws SQLException
        {
            Agenda agenda = new Agenda();
            sql = "select * from Agenda where idtarefa = ? and sequencia = 1";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idtarefa);
            rs = FabricaConexoes.returnResult(stm);
            rs.next();

            agenda.setIdtarefa(idtarefa);
            agenda.setIdproc(rs.getInt("idproc"));
            agenda.setIdativ(rs.getInt("idativ"));

            agenda.setIdusuario(rs.getInt("idusuario"));
            agenda.setSolicitante(rs.getString("solicitante"));

            agenda.setPai(rs.getInt("pai"));

            Date dt_inicio = rs.getDate("dt_inicial");
            String Hora = rs.getString("dt_inicial").substring(11,13);
            String Minutos = rs.getString("dt_inicial").substring(14,16);
            String segundos = rs.getString("dt_inicial").substring(17,19);
            Date d = new Date(dt_inicio.getYear(),dt_inicio.getMonth(),dt_inicio.getDate(),Integer.valueOf(Hora),Integer.valueOf(Minutos),Integer.valueOf(segundos));
            DateFormat dtformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            agenda.setDt_inicial(dtformat.format(dt_inicio));

            Date dt_final = rs.getDate("dt_final");
            Hora = rs.getString("dt_final").substring(11,13);
            Minutos = rs.getString("dt_final").substring(14,16);
            segundos = rs.getString("dt_final").substring(17,19);
            Date df = new Date(dt_final.getYear(),dt_final.getMonth(),dt_final.getDate(),Integer.valueOf(Hora),Integer.valueOf(Minutos),Integer.valueOf(segundos));
            agenda.setDt_final(dtformat.format(df));
            FabricaConexoes.closeConnection();
            return agenda;
        }


        public void pesquisaAgenda(JTable tabela, Date dt_inicial, Date dt_final, int cp, int ca, int ct, boolean vdata,int prazo, boolean analitico, boolean contenha, String contem) throws SQLException
        {
            String sequencia = " > 0";
            String p = "%";

            if(contenha)
            {
                contem = "  and a.valor like '%"+ contem +" %' ";
            }
            else
            {
                contem = "";
            }

            if(prazo == 1)
            {
                p = "ATRASADO";
            }
            if(prazo == 2)
            {
                p = "NORMAL";
            }
            DateFormat dtformat = new SimpleDateFormat("yyyy-MM-dd");
            String sql_verifica = "";
            PreparedStatement stm2 = null;
            ResultSet rs2 = null;
            Usuario user = manipulaConexao.getUsuarioLogado();
            if(!analitico)
            {
                sequencia = "= 1";
            }
            sql = "Select c.nome as 'Processo',a.atraso as 'Prazo',b.nome as 'Atividade', a.solicitante as 'Solicitante', a.dt_inicial as 'Data Início', " +
                            "a.dt_final as 'Data Término', a.idtarefa as 'Tarefa' " +
                            "from agenda a inner join atividade b " +
                            "on a.idativ = b.idatividade " +
                            "inner join processo c on a.idproc = c.idprocesso " +
                            " where sequencia " + sequencia + 
                            " and a.atraso like '" +p+ "'" +
                            " and idusuario = " + user.getId() +
                            contem;

            sql_verifica = sql;
                    //sql_verifica = sql_verifica + " and dt_inicial between '"+ dtformat.format(dt_inicial.getTime()) +" 00:00:00' and '"+ dtformat.format(dt_final.getTime()) +" 23:59:59' order by a.idtarefa asc";
                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm = FabricaConexoes.returnStatement(sql_verifica);
                    rs = FabricaConexoes.returnResult(stm);
                    
//                    while(rs.next())
//                    {
//
//                        sql_verifica = "select * from transicao where transicao = ? and status <> 2";
//                        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
//                        stm2 = FabricaConexoes.returnStatement(sql_verifica);
//                        stm2.setInt(1, rs.getInt("Tarefa"));
//                        int teste = rs.getInt("Tarefa");
//                        rs2 = FabricaConexoes.returnResult(stm2);
//
//                        if(rs2.next())
//                        {
//                            sql = sql + " and a.idtarefa <> " + rs.getInt("Tarefa");
//                        }
//                        FabricaConexoes.closeConnection();
//                    }

            if(cp == 0 && ca == 0 && ct == 0)
            {
                    if(vdata)
                    {
                        sql = sql + " and a.dt_inicial between '"+ dtformat.format(dt_inicial.getTime()) +" 00:00:00' and '"+ dtformat.format(dt_final.getTime()) +" 23:59:59' order by a.idtarefa asc";
                        manipulaConexao.preenchetable(tabela, sql);
                        formataDataAgenda(tabela, dtformat,sql);
                    }
                    else
                    {
                        sql = sql + " order by a.idtarefa asc";
                        manipulaConexao.preenchetable(tabela, sql);
                        formataDataAgenda(tabela, dtformat,sql);
                    }
                    

            }else
            {
                    
                    if(cp != 0)
                    {
                        sql = sql + " and a.idproc = "+cp;
                    }
                    if(ca != 0)
                    {
                        sql = sql + " and a.idativ = "+ca;
                    }
                    if(ct != 0)
                    {
                        sql = sql + " and a.idtarefa = "+ct;
                    }
                    
                    if(vdata)
                    {
                        sql = sql + " and a.dt_inicial between '"+ dtformat.format(dt_inicial.getTime()) +" 00:00:00' and '"+ dtformat.format(dt_final.getTime()) +" 23:59:59' order by a.idtarefa asc";
                    }
                    else
                    {
                        sql = sql + " order by a.idtarefa asc";
                    }

                    manipulaConexao.preenchetable(tabela, sql);
                    formataDataAgenda(tabela, dtformat,sql);
            }
            FabricaConexoes.closeConnection();
        }

        public void pesquisa(JTable tabela, Date dt_inicial, Date dt_final, int cp, int ca, int ct, boolean vdata,int prazo, boolean contem,String contenha) throws SQLException
        {
            String like = contenha; //String que recebe os caracteres para pesquisa no campo valor da tabela agenda
            String p = ""; //String que define o critério de pesquisa para tarefas 0 = normais, 1 = atrasadas, 2 = finalizadas
            String inner = ""; // String que adiciona o inner join com a tabela agenda, somente utilizada se o check box "contenha" for ativado
            if(contem)
            {
                inner = " inner join agenda ag on a.transicao = ag.idtarefa ";
            }

            if(prazo == 0)
            {
                p = "<> 2"; //define que a pesquisa pega todas as tarefas que não estejam finalizadas
            }
            if(prazo == 1)
            {
                p = "= 1"; // define a pesquisa para tarefas 
            }
            if(prazo == 2)
            {
                p = "= 0";
            }
            DateFormat dtformat = new SimpleDateFormat("yyyy-MM-dd");
            Usuario user = manipulaConexao.getUsuarioLogado();
            sql = "select  a.idtarefa as 'Id',a.status as 'Prazo', b.nome as 'Atividade', a.solicitante as 'Solicitante',a.dt_limite as 'Data Limite', c.nome as 'Processo',a.transicao as 'Tarefa'"+
                            " from transicao a inner join atividade b on a.idativ = b.idatividade"+
                            " inner join processo c on a.idproc = c.idprocesso"+
                            inner +
                            " where resp = 1 and idresp = "+user.getId();                            ;
            if(cp == 0 && ca == 0 && ct == 0)
            {

                    
                    manipulaConexao.setConexao(user.getLogin(), user.getSenha());
                    ArrayList<Grupo> grupos = manipulaConexao.getGrupoLogado();
                    if(vdata)
                    {
                        sql = sql + " and a.dt_limite >= '"+ dtformat.format(dt_inicial.getTime()) +" 00:00:00' and a.dt_limite <= '"+ dtformat.format(dt_final.getTime()) +" 23:59:59' and a.status "+p+"";
                    }
                    else
                    {
                        sql = sql + " and a.status "+p+"";
                    }
                    if(contem)
                    {
                        sql = sql + " and ag.valor like '%" + like + "%' ";
                    }

                    for(int i = 0; i < grupos.size() ; i++)
                    {

                        sql = sql + " or resp = 0 and idresp = "+grupos.get(i).getId();


                    
                    if(vdata)
                    {
                        sql = sql + " and a.dt_limite >= '"+ dtformat.format(dt_inicial.getTime()) +" 00:00:00' and a.dt_limite <= '"+ dtformat.format(dt_final.getTime()) +" 23:59:59' and a.status "+p+"";
                    }
                    else
                    {
                        sql = sql + " and a.status "+p+"";
                    }
                    if(contem)
                    {
                        sql = sql + " and ag.valor like '%" + like + "%' ";
                    }
                        }
                    sql = sql + " order by a.idtarefa asc";
                    manipulaConexao.preenchetable(tabela, sql);
                    
                    formataData(tabela, dtformat,sql);
            }else
            {
                    
                    manipulaConexao.setConexao(user.getLogin(), user.getSenha());
                    ArrayList<Grupo> grupos = manipulaConexao.getGrupoLogado();

                    if(vdata)
                    {
                        sql = sql + " and a.dt_limite >= '"+ dtformat.format(dt_inicial.getTime()) +" 00:00:00' and a.dt_limite <= '"+ dtformat.format(dt_final.getTime()) +" 23:59:59' and a.status "+p+"";
                    }
                    else
                    {
                        sql = sql + " and a.status "+p+"";
                    }
                    if(cp != 0)
                    {
                        sql = sql + " and a.idproc = "+cp;
                    }
                    if(ca != 0)
                    {
                        sql = sql + " and a.idativ = "+ca;
                    }
                    if(ct != 0)
                    {
                        sql = sql + " and a.idtarefa = "+ct;
                    }
                    if(contem)
                    {
                        sql = sql + " and ag.valor like '%" + like + "%' ";
                    }
                    for(int i = 0; i < grupos.size() ; i++)
                    {

                        sql = sql + " or resp = 0 and idresp = "+grupos.get(i).getId();


                    
                    if(vdata)
                    {
                        sql = sql + " and a.dt_limite >= '"+ dtformat.format(dt_inicial.getTime()) +" 00:00:00' and a.dt_limite <= '"+ dtformat.format(dt_final.getTime()) +" 23:59:59' and a.status "+p+"";
                    }
                    else
                    {
                        sql = sql + " and a.status "+p+"";
                    }
                    if(cp != 0)
                    {
                        sql = sql + " and a.idproc = "+cp;
                    }
                    if(ca != 0)
                    {
                        sql = sql + " and a.idativ = "+ca;
                    }
                    if(ct != 0)
                    {
                        sql = sql + " and a.idtarefa = "+ct;
                    }
                    if(contem)
                    {
                        sql = sql + " and ag.valor like '%" + like + "%' ";
                    }
                        }
                        sql = sql + " order by a.idtarefa asc";
                    
                    manipulaConexao.preenchetable(tabela, sql);                    
                    formataData(tabela, dtformat,sql);
            }
            FabricaConexoes.closeConnection();
        }

        public String setTooltext(int idtarefa) throws SQLException
       {
            sql = "select valor,sequencia from agenda where idtarefa = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();            
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idtarefa);
            rs = FabricaConexoes.returnResult(stm);
            String valor="";
            while(rs.next())
            {
                valor = rs.getString("valor");
            }
            
            stm.close();
            FabricaConexoes.closeConnection();
            return valor;
        }
        public String retornaPrincipal(int idtarefa) throws SQLException
        {
           sql = "select descricao from tb_desc_tarefa where idtarefa = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idtarefa);
            rs = FabricaConexoes.returnResult(stm);
            String valor="";
            while(rs.next())
            {
                valor = rs.getString("descricao");
            }

            stm.close();
            FabricaConexoes.closeConnection();
            return valor;
        }

        public void gravaAnexo(File arquivo, int idtarefa) throws SQLException, Exception
        {

            FileInputStream fis = new FileInputStream(arquivo);
       /* byte[] tmp = new byte[1024];
        byte[] data = null;
        int sz, len = 0;

        while ((sz = fis.read(tmp)) != -1) {
          if (data == null) {
            len = sz;
            data = tmp;
          } else {
            byte[] narr;
            int nlen;

            nlen = len + sz;
            narr = new byte[nlen];
            System.arraycopy(data, 0, narr, 0, len);
            System.arraycopy(tmp, 0, narr, len, sz);
            data = narr;
            len = nlen;
          }
        }
        if (len != data.length) {
          byte[] narr = new byte[len];

          System.arraycopy(data, 0, narr, 0, len);
          data = narr;
        }*/

            sql = "insert into tb_documento_tarefa (documento, id_tarefa, nome) values (?,?,?)";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(2, idtarefa);
            stm.setBinaryStream(1, fis,(int) arquivo.length());
            stm.setString(3, arquivo.getName());
            //JOptionPane.showMessageDialog(null, arquivo.length());
            stm.executeUpdate();
            stm.close();
            arquivo.delete();
            FabricaConexoes.closeConnection();
            }

        public void recuperaAnexo(int id)throws Exception
            {
                sql = "Select * from tb_documento_tarefa where id = " + id + ";";
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
                rs = FabricaConexoes.returnResult(stm);
                File arquivo = new File(rs.getString("nome"));
                FileOutputStream fos = new FileOutputStream(arquivo);

                //fos  =      rs.getBinaryStream("documento");
              }
        public int retornaSequencia(int idtarefa)throws SQLException
        {

            sql = "select sequencia from agenda where idtarefa = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idtarefa);
            rs = FabricaConexoes.returnResult(stm);
            if(rs.next())
            {
                rs.last();                
                return (rs.getRow());

            }else
            {
                return 0;
            }


        }
        
        public String retornaValor(int sequencia, int idtarefa) throws SQLException
        {
            sql = "select a.valor, b.nome , a.dt_final from agenda a inner join usuario b on a.idusuario = b.idusuario where idtarefa = ? and sequencia = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idtarefa);
            stm.setInt(2,sequencia);
            rs = FabricaConexoes.returnResult(stm);
            if(rs.next())
            {
                rs.last();
                //JOptionPane.showMessageDialog(null, rs.getRow());
                DateFormat dtformat = new SimpleDateFormat("dd/MM/yyyy");
                return (rs.getString("valor") + "\n" + "\n Autor: " + rs.getString("nome") + "\n Finalizado em: " + dtformat.format(rs.getDate("dt_final")));

            }else
            {
                return "";
}


        }
        

}

class RenderizarTree extends DefaultTreeCellRenderer implements TreeCellRenderer {
    private Font plainFont, italicFont;

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        String trim = node.toString().substring(0, 1);

        
        if(trim.compareToIgnoreCase("(")==0) {
            setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/configs.gif")));
        }
        else if(trim.compareToIgnoreCase("[")==0) {
            setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/activity.gif")));
        }
        else if(trim.compareToIgnoreCase("{")==0) {
            setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/welcome_item.gif")));
        }else{
            setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/redo_edit.gif")));
        }

        return this;
    }
}
