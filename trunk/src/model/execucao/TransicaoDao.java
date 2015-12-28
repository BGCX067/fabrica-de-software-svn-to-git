package model.execucao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.FabricaConexoes;


import model.processo.Atividade;

public class TransicaoDao
{
	
	private PreparedStatement stm;
	private ResultSet rs;
	private String sql;
	private Transicao transicao;
	private ArrayList<Transicao> list;

	
	public void insertTransicao(Transicao transicao)throws SQLException
	{
		sql = "INSERT INTO transicao (idtarefa, idativ,chave,resp,idresp,idproc,dt_inicial,transicao)" +
				"VALUES(?,?,?,?,?,?,?)";
		
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
		stm.setInt(1, transicao.getIdtarefa());
		stm.setInt(2, transicao.getIdativ());
		stm.setInt(3, transicao.getChave());
		stm.setInt(4, transicao.getTresp());
		stm.setInt(5, transicao.getResp());
		stm.setInt(6, transicao.getIdproc());
                stm.setDate(7, new java.sql.Date(transicao.getDt_inicial().getTime()));
                stm.setInt(8, transicao.getTransicao());
		stm.execute();
		stm.close();
                FabricaConexoes.closeConnection();
	}
	
	public ArrayList<Transicao> getAll()throws SQLException
	{
		sql = "SELECT * FROM transicao";
		
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
		rs = stm.executeQuery();
		
		list = new ArrayList<Transicao>();
		
		while(rs.next())
		{
			transicao = new Transicao();
			transicao.setIdtarefa(rs.getInt("idtarefa"));
			transicao.setIdativ(rs.getInt("idativ"));
			transicao.setIdproc(rs.getInt("idproc"));
                        transicao.setDt_inicial(rs.getDate("dt_inicio"));
                        transicao.setTresp(rs.getInt("Resp"));
                        transicao.setResp(rs.getInt("idresp"));
                        transicao.setChave(rs.getInt("chave"));
                        transicao.setStatus(rs.getInt("status"));
                        transicao.setTransicao(rs.getInt("transicao"));

			list.add(transicao);
		}
		FabricaConexoes.closeConnection();
		return list;
	}

	public Transicao getTransicao(int idtarefa, int chave)throws SQLException, NullPointerException
{
	sql = "SELECT * FROM transicao WHERE idtarefa = ? and chave = ?";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
	stm.setInt(1, idtarefa);
        stm.setInt(2, chave);
	rs = stm.executeQuery();
	
	transicao = new Transicao();
	rs.next();
	transicao.setIdtarefa(rs.getInt("idtarefa"));
        transicao.setIdativ(rs.getInt("idativ"));
        transicao.setIdproc(rs.getInt("idproc"));
        transicao.setDt_inicial(rs.getDate("dt_inicio"));
        transicao.setTresp(rs.getInt("Resp"));
        transicao.setResp(rs.getInt("idresp"));
        transicao.setChave(rs.getInt("chave"));
	transicao.setStatus(rs.getInt("status"));
        transicao.setTransicao(rs.getInt("transicao"));


	FabricaConexoes.closeConnection();
	return transicao;
}



public Transicao getTransicao(Transicao Transicao)throws SQLException, NullPointerException
{
	return getTransicao(Transicao.getIdtarefa(), Transicao.getChave());
}

public void updateAtividade(Transicao transicao)throws SQLException
{/*
	sql = "UPDATE transicao SET nome = ?, descricao = ?, user_modif = ?, status = ? WHERE idatividade = ? ";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
	
	stm.setString(1, transicao.getNome());
	stm.setString(2, transicao.getDescricao());
	
	stm.setInt(3, transicao.getUserModif());
	stm.setInt(4, transicao.getStatus());
	
	stm.setInt(5, transicao.getId());
	stm.execute();
	stm.close();
        FabricaConexoes.closeConnection();*/
	
}

public void deleteTransicao(Transicao transicao)throws SQLException
{
	sql = "DELETE FROM transicao WHERE idtarefa = ? and chave = ?";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
              stm = FabricaConexoes.returnStatement(sql);
	
	stm.setInt(1, transicao.getIdtarefa());
	stm.setInt(2, transicao.getChave());
	stm.execute();
	stm.close();
	FabricaConexoes.closeConnection();
}

}

