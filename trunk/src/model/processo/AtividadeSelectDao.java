package model.processo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.FabricaConexoes;


public class AtividadeSelectDao
{
	
	private PreparedStatement stm;
	private ResultSet rs;
	private String sql;
	private AtividadeSelect atividadesel;
	private ArrayList<AtividadeSelect> list;

	
	
	
	public ArrayList<AtividadeSelect> getAll()throws SQLException
	{
		sql = "SELECT * FROM ATIVIDADEUSER";
		
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
		rs = FabricaConexoes.returnResult(stm);
		
		list = new ArrayList<AtividadeSelect>();
		
		while(rs.next())
		{
			atividadesel = new AtividadeSelect();
			atividadesel.setId(rs.getInt("Código"));
			atividadesel.setNome(rs.getString("Nome"));
			atividadesel.setAutor(rs.getString("Autor"));
			
			atividadesel.setUserModif(rs.getString("Usuário Modificação"));
			list.add(atividadesel);
		}
		FabricaConexoes.closeConnection();
		return list;
	}

	public AtividadeSelect getAtividadeSelect(int id)throws SQLException, NullPointerException
{
	sql = "SELECT * FROM ATIVIDADEUSER WHERE idatividade = ?";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
	stm.setInt(1, id);
	rs = FabricaConexoes.returnResult(stm);
	
	atividadesel = new AtividadeSelect();
	rs.next();
	atividadesel.setId(rs.getInt("Código"));
	atividadesel.setNome(rs.getString("Nome"));
	atividadesel.setAutor(rs.getString("Autor"));
	
        atividadesel.setUserModif(rs.getString("Usuário Modificação"));

	FabricaConexoes.closeConnection();
	return atividadesel;
}



public AtividadeSelect getAtividadeSelect(AtividadeSelect Atividadesel)throws SQLException, NullPointerException
{
	sql = "SELECT * FROM ATIVIDADE WHERE nome = ?";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
	stm.setString(1, Atividadesel.getNome());
	rs = stm.executeQuery();
	atividadesel = new AtividadeSelect();
	rs.next();
	atividadesel.setId(rs.getInt("Código"));
	atividadesel.setNome(rs.getString("Nome"));
	atividadesel.setAutor(rs.getString("autor"));
	
	atividadesel.setUserModif(rs.getString("Usuário Modificação"));
	
	
	rs.close();
	stm.close();
        FabricaConexoes.closeConnection();
	return atividadesel;
}

}

