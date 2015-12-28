package model.processo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.FabricaConexoes;
import Util.ProcAtiv;
import javax.swing.JOptionPane;

public class AtivProcDao
{
	
	private PreparedStatement stm;
	private ResultSet rs;
	private String sql;
	private Atividade atividade;
	private ArrayList<Atividade> list;

	
	public void insertAtividade(Atividade atividade)throws SQLException
	{
		sql = "INSERT INTO atividade (NOME, DESCRICAO, USER_MODIF, AUTOR, STATUS)" +
				"VALUES(?,?,?,?,?)";
		
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
		stm.setString(1, atividade.getNome());
		stm.setString(2, atividade.getDescricao());
		
		stm.setInt(3, atividade.getUserModif());
		stm.setInt(4, atividade.getAutor());
		stm.setInt(5, atividade.getStatus());
		
		stm.execute();
		
		stm.close();
                FabricaConexoes.closeConnection();
	}
	
	public ArrayList<Atividade> getAll()throws SQLException
	{
		sql = "SELECT * FROM ATIVIDADE";
		
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
		rs = stm.executeQuery();
		
		list = new ArrayList<Atividade>();
		
		while(rs.next())
		{
			atividade = new Atividade();
			atividade.setId(rs.getInt("idatividade"));
			atividade.setNome(rs.getString("nome"));
			atividade.setDescricao(rs.getString("descricao"));
			
			atividade.setUserModif(rs.getInt("User_Modif"));
			atividade.setAutor(rs.getInt("autor"));
			atividade.setStatus(rs.getInt("status"));
			
			list.add(atividade);
		}
		FabricaConexoes.closeConnection();
		return list;
	}

	public Atividade getAtividade(int id)throws SQLException, NullPointerException
{
	sql = "SELECT * FROM ATIVIDADE WHERE idatividade = ?";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
	stm.setInt(1, id);
	rs = stm.executeQuery();
	
	atividade = new Atividade();
	rs.next();
	atividade.setId(rs.getInt("idatividade"));
	atividade.setNome(rs.getString("nome"));
	atividade.setDescricao(rs.getString("descricao"));
	
        atividade.setUserModif(rs.getInt("User_Modif"));
	atividade.setAutor(rs.getInt("autor"));
	atividade.setStatus(rs.getInt("status"));
	
	FabricaConexoes.closeConnection();
	return atividade;
}

      public Finalizacao getFinalizacao(int id)throws SQLException, NullPointerException
      {
        sql = "SELECT * FROM FINALIZACAO WHERE idfinalizacao = ?";
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, id);
        rs = FabricaConexoes.returnResult(stm);
        Finalizacao fin = new Finalizacao();
        rs.next();
        fin.setId(rs.getInt("idfinalizacao"));
        fin.setNome(rs.getString("nome"));
        rs.close();
        stm.close();
        FabricaConexoes.closeConnection();
        return fin;
      }


public Atividade getAtividade(Atividade Atividade)throws SQLException, NullPointerException
{
	sql = "SELECT * FROM ATIVIDADE WHERE nome = ?";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
	stm.setString(1, Atividade.getNome());
	rs = stm.executeQuery();
	atividade = new Atividade();
	rs.next();
	atividade.setId(rs.getInt("idatividade"));
	atividade.setNome(rs.getString("nome"));
	atividade.setDescricao(rs.getString("descricao"));
	
	atividade.setUserModif(rs.getInt("User_Modif"));
	atividade.setAutor(rs.getInt("autor"));
	atividade.setStatus(rs.getInt("status"));
	
	
	rs.close();
	stm.close();
        FabricaConexoes.closeConnection();
	return atividade;
}

public void updateAtividade(Atividade atividade)throws SQLException
{
	sql = "UPDATE atividade SET nome = ?, descricao = ?, user_modif = ?, status = ? WHERE idatividade = ? ";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
	
	stm.setString(1, atividade.getNome());
	stm.setString(2, atividade.getDescricao());
	
	stm.setInt(3, atividade.getUserModif());
	stm.setInt(4, atividade.getStatus());
	
	stm.setInt(5, atividade.getId());
	stm.execute();
	stm.close();
        FabricaConexoes.closeConnection();
	
}

public void deleteAtividade(Atividade atividade)throws SQLException
{
	sql = "DELETE FROM atividade WHERE idatividade = ?";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
              stm = FabricaConexoes.returnStatement(sql);
	
	stm.setInt(1, atividade.getId());
	
	stm.execute();
	stm.close();
	FabricaConexoes.closeConnection();
}

    public void insertAtividadeFinalizacao(int idativ, int idfin)throws SQLException
        {
            sql = "INSERT INTO ATIVIDADE_FINALIZACAO (ID_ATIV,ID_FIN) VALUES (?,?)";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                  stm = FabricaConexoes.returnStatement(sql);

            stm.setInt(1, idativ);
            stm.setInt(2,idfin);
            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Finalização incluída com sucesso!","Inserção",1);
            FabricaConexoes.closeConnection();

        }
    public void deleteAtividadeFinalizacao(int idativ, int idfin)throws SQLException
        {
            sql = "DELETE FROM ATIVIDADE_FINALIZACAO WHERE ID_ATIV = ? AND ID_FIN = ?";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                  stm = FabricaConexoes.returnStatement(sql);

            stm.setInt(1, idativ);
            stm.setInt(2,idfin);
            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Finalização exclusa com sucesso!","Exclusão",1);
            FabricaConexoes.closeConnection();

        }
        public boolean insertAtivFin(int idproc, int idat,int chave,int raiz, int idfin, int link,int tipo, int idtipo, int tempo, float valor)throws SQLException
        {
            if(verificaProcesso(idproc)) return false;
            sql = "INSERT INTO processo_atividade (IDproc,IDat,chave,raiz,idfin,link,tipo,idtipo,tempo,valor_tempo) VALUES (?,?,?,?,?,?,?,?,?,?)";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);

            stm.setInt(1, idproc);
            stm.setInt(2,idat);
            stm.setInt(3,chave);
            stm.setInt(4,raiz);
            stm.setInt(5,idfin);
            stm.setInt(6,link);
            stm.setInt(7, tipo);
            stm.setInt(8, idtipo);
            stm.setInt(9, tempo);
            stm.setFloat(10, valor);
            stm.execute();
            stm.close();
            FabricaConexoes.closeConnection();
            return true;
        }

        public void deleteAtivFin(int idproc, int chave)
        {
            sql = "DELETE FROM processo_atividade WHERE IDproc = ? AND chave = ?";
            try{
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                  stm = FabricaConexoes.returnStatement(sql);

            stm.setInt(1, idproc);
            stm.setInt(2,chave);
            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Atividade removida com sucesso!","Exclusão",1);
            FabricaConexoes.closeConnection();
            }catch(SQLException sql)
            {
                JOptionPane.showMessageDialog(null, sql.getMessage(),"Erro",0);
            }
        }

        public int verificaTipo(int idproc, int chave)
        {
            /*
             *  tipos de retorno
             *  0 - Atividade
             *  1 - Finalização
             *  2 - Link
             *  3 - erro
             *  4 - Raiz
             * */
            if(chave == 0) return 4;
            sql = "SELECT * FROM processo_atividade WHERE IDproc = ? AND chave = ?";
            try{
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idproc);
            stm.setInt(2,chave);
            rs = FabricaConexoes.returnResult(stm);
            rs.next();

            if(rs.getInt("idfin") == 0 )
            {
                return 0;
            }
            else if(rs.getInt("idfin") != 0 && rs.getInt("link") == 0)
                    {
                        return 1;
                        } else if(rs.getInt("idfin") != 0 && rs.getInt("link") != 0)
                                    {
                                       return 2;
                                        }else
                                        {
                                         return 3;
                                        }

            }catch(SQLException s)
            {
                JOptionPane.showMessageDialog(null, s.getMessage(),"Erro",0);
                return 3;

            }
        }
        public boolean verificaLink(int chave, int idproc)
        {
            /*
             * retorna true se possui link na chave indicada
             * retorna false se não possui links na chave indicada
             * */
            sql = "SELECT * FROM processo_atividade WHERE link = ? AND idproc = ?";
            try{
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, chave);
            stm.setInt(2, idproc);
            rs = FabricaConexoes.returnResult(stm);
            if(rs.next())
            {
                return true;
            }else
            {
                return false;
            }
            }catch(SQLException s)
            {
                JOptionPane.showMessageDialog(null, s.getMessage(),"Erro",0);
                return false;
            }
        }

        public void deleteLinks(int chave, int idproc)
        {


            try{

                        sql = "UPDATE processo_atividade SET LINK = 0 WHERE link = ? AND idproc = ?";
                        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                        stm = FabricaConexoes.returnStatement(sql);
                        stm.setInt(1, chave);
                        stm.setInt(2,idproc);
                        stm.execute();
                        stm.close();

            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(),"Erro",0);
            }

        }

        public int proximaChave(int idproc)
        {

            sql = "SELECT * FROM processo_atividade WHERE idproc = ? order by chave desc";
            try{
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idproc);
            rs = FabricaConexoes.returnResult(stm);
            if(rs.next())
            {
                int chave = rs.getInt("chave");
                return ++chave;
            }else
            {
                return 0;
            }
            }catch(SQLException s)
            {
                JOptionPane.showMessageDialog(null, s.getMessage(),"Erro",0);
                return 0;
            }
            
        }

        public void deleteFinalizacoes(int chave, int idproc)
        {


            try{

                        sql = "Delete from processo_atividade WHERE raiz = ? AND idproc = ? and idfin != 0";
                        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                        stm = FabricaConexoes.returnStatement(sql);
                        stm.setInt(1, chave);
                        stm.setInt(2,idproc);
                        stm.execute();
                        stm.close();

            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(),"Erro",0);
            }

        }

        public void insereFinalizacoes(int chave, int idproc, int idativ)
        {


            try{
                        ResultSet rsaux;
                        sql = "Select * from atividade_finalizacao WHERE id_ativ = ?";
                        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                        stm = FabricaConexoes.returnStatement(sql);
                        stm.setInt(1, idativ);
                        rs = FabricaConexoes.returnResult(stm);
                        rsaux = rs;
                        while(rsaux.next())
                        {
                            
                            int id = rsaux.getInt("id_fin");
                            int pchave = proximaChave(idproc);
                                                        
                            sql = "insert into processo_atividade values ("+idproc+","+idativ+","+pchave+","+chave+","+id+",0,0,0,0,0,0 )";
                            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                            stm = FabricaConexoes.returnStatement(sql);
                            stm.execute();
                            }

                        stm.close();

            }catch(SQLException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage(),"Erro",0);
            }

        }


        public void updateAtivFin(int link, int chave, int idproc)throws SQLException
        {
            sql = "Update processo_atividade set link = ? where chave = ? and idproc = ?";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, link);
            stm.setInt(2, chave);
            stm.setInt(3, idproc);
            stm.execute();
            stm.close();
            FabricaConexoes.closeConnection();

        }

        public void linkProcesso(int link, int chave, int idproc)throws SQLException
        {
            sql = "Update processo_atividade set link = ? , processo = 1 where chave = ? and idproc = ?";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, link);
            stm.setInt(2, chave);
            stm.setInt(3, idproc);
            stm.execute();
            stm.close();
            FabricaConexoes.closeConnection();

        }
        public boolean updateAtivFin(int tipo, int idtipo, int tempo, float valor_tempo,int chave, int idproc)throws SQLException
        {
            if(verificaProcesso(idproc))
            {
                return false;
            }
            sql = "Update processo_atividade set tipo=?,idtipo=?,tempo=?,valor_tempo=? where chave = ? and idproc = ?";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, tipo);
            stm.setInt(2, idtipo);
            stm.setInt(3, tempo);
            stm.setFloat(4,valor_tempo);
            stm.setInt(5,chave);
            stm.setInt(6,idproc);
            stm.execute();
            stm.close();
            FabricaConexoes.closeConnection();
            return true;
        }


        public void removeLink(int chave, int idproc)throws SQLException
        {
            sql = "Update processo_atividade set link = 0,processo = 0 where chave = ? and idproc = ?";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            
            stm.setInt(1, chave);
            stm.setInt(2, idproc);
            stm.execute();
            stm.close();
            FabricaConexoes.closeConnection();

        }

        public ProcAtiv retornaDados(int chave_ex, int idprocesso)throws SQLException
        {

           int idproc;
           int idativ;
           int chave;
           int raiz;
           int idfin;
           int link;
           int tipo;
           int idtipo;
           int tempo;
           float valor_tempo;
           
           sql = "Select * from processo_atividade where idproc = ? and chave = ?";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);

            stm.setInt(1, idprocesso);
            stm.setInt(2, chave_ex);
            rs = FabricaConexoes.returnResult(stm);

            rs.next();
            idproc = rs.getInt("idproc");
            idativ = rs.getInt("idat");
            chave = rs.getInt("chave");
            raiz = rs.getInt("raiz");
            idfin = rs.getInt("idfin");
            link  = rs.getInt("link");
            tipo = rs.getInt("tipo");
            idtipo = rs.getInt("idtipo");
            tempo = rs.getInt("tempo");
            valor_tempo = rs.getFloat("valor_tempo");
            ProcAtiv processo = new ProcAtiv(idproc, idativ, chave, raiz, idfin, link, tipo, idtipo, tempo, valor_tempo);
            FabricaConexoes.closeConnection();
            return processo;
        }

        public String retornaResp(int tipo,int id) throws SQLException
        {
            if(tipo == 0)
        {

           sql = "select descricao from grupo where idgrupo = ?";
           if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, id);
            rs = FabricaConexoes.returnResult(stm);
            rs.next();
            return rs.getString("Descricao");

        }else if(tipo == 1)
                {
                    sql = "select nome from usuario where idusuario = ?";
                       if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                        stm = FabricaConexoes.returnStatement(sql);
                        stm.setInt(1, id);
                        rs = FabricaConexoes.returnResult(stm);
                        rs.next();
                        return rs.getString("nome");
                    }else if(tipo == 2)
                            {
                                return "Destinado";
                                }else {return "";}
        }

        public int retornaIdResp(String nome, int tipo)throws SQLException
        {
            if(tipo == 0)
        {

           sql = "select idgrupo from grupo where descricao = ?";
           if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setString(1, nome);
            rs = FabricaConexoes.returnResult(stm);
            rs.next();
            return rs.getInt("idgrupo");

        }else if(tipo == 1)
                {
                    sql = "select idusuario from usuario where nome = ?";
                       if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                        stm = FabricaConexoes.returnStatement(sql);
                        stm.setString(1, nome);
                        rs = FabricaConexoes.returnResult(stm);
                        rs.next();
                        return rs.getInt("idusuario");
                    }else if(tipo == 2)
                            {
                                return 0;
                                }else if(tipo == 3)
                                    {
                                        return 3;
                                        }
                                         else {
                                                    return 0;
                                                    }


        }

        public boolean verificaProcesso(int idproc) throws SQLException
        {
            sql = "Select * from transicao where idproc = ? ";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, idproc);
            rs = FabricaConexoes.returnResult(stm);
            if(rs.next())
            {
               JOptionPane.showMessageDialog(null, "Há tarefas ativas para este processo, Verifique!","Alerta",JOptionPane.INFORMATION_MESSAGE);
               return true;
            }else {return false;}
        }

}

