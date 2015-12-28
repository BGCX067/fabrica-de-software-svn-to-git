package model.execucao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.FabricaConexoes;


import model.processo.Atividade;

public class AgendaDao
{
	
	private PreparedStatement stm;
	private ResultSet rs;
	private String sql;
	private Agenda agenda;
	private ArrayList<Agenda> list;

	
	public void insertAgenda(Agenda agenda)throws SQLException
	{
		sql = "INSERT INTO agenda (idagenda,idtarefa, idativ, idproc, idfin,idusuario,sequencia,dt_inicial, dt_final)" +
				"VALUES(?,?,?,?,?,?,?,?,?)";
		
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
		stm.setInt(1, agenda.getIdagenda());
		stm.setInt(2, agenda.getIdtarefa());
		stm.setInt(3, agenda.getIdativ());
		stm.setInt(4, agenda.getIdproc());
		stm.setInt(5, agenda.getIdfin());
		stm.setInt(6, agenda.getIdusuario());
                stm.setInt(7, agenda.getSequencia());
                stm.setString(8,agenda.getDt_inicial());
                stm.setString(9,agenda.getDt_final());
		stm.execute();
		
		stm.close();
                FabricaConexoes.closeConnection();
	}
	
	public ArrayList<Agenda> getAll()throws SQLException
	{
		sql = "SELECT * FROM Agenda";
		
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
		rs = stm.executeQuery();
		
		list = new ArrayList<Agenda>();
		
		while(rs.next())
		{
			agenda = new Agenda();
			agenda.setIdagenda(rs.getInt("idagenda"));
			agenda.setIdtarefa(rs.getInt("idtarefa"));
			agenda.setIdativ(rs.getInt("idativ"));
			agenda.setIdproc(rs.getInt("idproc"));
			agenda.setIdfin(rs.getInt("idfin"));
                        agenda.setSequencia(rs.getInt("sequencia"));
			agenda.setIdusuario(rs.getInt("idusuario"));
                        agenda.setDt_inicial(rs.getString("dt_inicial"));
                        agenda.setDt_final(rs.getString("dt_final"));
			list.add(agenda);
		}
		FabricaConexoes.closeConnection();
		return list;
	}

	public Agenda getAgenda(int id)throws SQLException, NullPointerException
{
	sql = "SELECT * FROM AGENDA WHERE idagenda = ?";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
	stm.setInt(1, id);
	rs = stm.executeQuery();
	
	agenda = new Agenda();
	rs.next();
	agenda.setIdagenda(rs.getInt("idagenda"));
        agenda.setIdtarefa(rs.getInt("idtarefa"));
        agenda.setIdativ(rs.getInt("idativ"));
        agenda.setIdproc(rs.getInt("idproc"));
        agenda.setIdfin(rs.getInt("idfin"));
        agenda.setSequencia(rs.getInt("sequencia"));
        agenda.setIdusuario(rs.getInt("idusuario"));
        agenda.setDt_inicial(rs.getString("dt_inicial"));
        agenda.setDt_final(rs.getString("dt_final"));
	
	FabricaConexoes.closeConnection();
	return agenda;
}



public Agenda getAgenda(Agenda Agenda)throws SQLException, NullPointerException
{
	sql = "SELECT * FROM ATIVIDADE WHERE idagenda = ?";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
	stm.setInt(1, Agenda.getIdagenda());
	rs = FabricaConexoes.returnResult(stm);
	agenda = new Agenda();
	rs.next();
	agenda.setIdagenda(rs.getInt("idagenda"));
        agenda.setIdtarefa(rs.getInt("idtarefa"));
        agenda.setIdativ(rs.getInt("idativ"));
        agenda.setIdproc(rs.getInt("idproc"));
        agenda.setIdfin(rs.getInt("idfin"));
        agenda.setSequencia(rs.getInt("sequencia"));
        agenda.setIdusuario(rs.getInt("idusuario"));
        agenda.setDt_inicial(rs.getString("dt_inicial"));
        agenda.setDt_final(rs.getString("dt_final"));
	
	
	rs.close();
	stm.close();
        FabricaConexoes.closeConnection();
	return agenda;
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

public void deleteAgenda(Agenda agenda)throws SQLException
{
	sql = "DELETE FROM agenda WHERE idgenda = ?";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
              stm = FabricaConexoes.returnStatement(sql);
	
	stm.setInt(1, agenda.getIdagenda());
	
	stm.execute();
	stm.close();
	FabricaConexoes.closeConnection();
}

}

