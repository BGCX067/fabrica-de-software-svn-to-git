/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.sistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Util.FabricaConexoes;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrador
 */
public class PacoteDao
{

    private String sql;
    private PreparedStatement stm;
    private ResultSet rs;
    private ArrayList<Pacote> list;
    private Pacote pacote;

public boolean insertPacote(Pacote pacote)throws SQLException
	{
                try
                {
		sql = "INSERT INTO Pacote (descricao) VALUES (?)";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);

		if(pacote.getDescricao().equalsIgnoreCase(""))
                {
                    throw new SQLException("Descrição não pode ser nula!");
                }
                stm.setString(1, pacote.getDescricao());
		stm.execute();

		stm.close();
                return true;
                }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null,"Erro interno: "+ e.getMessage(),"Erro",0);
                   return false;
                }
	}
        public ArrayList<Pacote> getAll()throws SQLException
	{
		sql = "SELECT * FROM PACOTE";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		rs = stm.executeQuery();

		list = new ArrayList<Pacote>();

		while(rs.next())
		{
			pacote = new Pacote();
			pacote.setId(rs.getInt("IDPACOTE"));
			pacote.setDescricao(rs.getString("DESCRICAO"));
			list.add(pacote);
		}

		return list;
	}
        public Pacote getPacote(int id)throws SQLException, NullPointerException
	{
		sql = "SELECT * FROM PACOTE WHERE idpacote = ?";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		stm.setInt(1, id);
		rs = stm.executeQuery();

		pacote = new Pacote();
		rs.next();
		pacote.setId(rs.getInt("idpacote"));
		pacote.setDescricao(rs.getString("Descricao"));


		return pacote;
	}

        public Pacote getPacote(Pacote pacote)throws SQLException, NullPointerException
	{
		sql = "SELECT * FROM PACOTE WHERE idpacote = ? AND descricao = ?";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		stm.setInt(1, pacote.getId());
		stm.setString(2, pacote.getDescricao());
		rs = stm.executeQuery();

		pacote = new Pacote();
		rs.next();
		pacote.setId(rs.getInt("idpacote"));
		pacote.setDescricao(rs.getString("Descricao"));

		rs.close();
		stm.close();

		return pacote;
	}

        public boolean updatePacote(Pacote pacote)throws SQLException
	{
            try{
		sql = "UPDATE pacote SET descricao = ? WHERE idpacote = ?";
		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		stm.setString(1, pacote.getDescricao());
		stm.setInt(2, pacote.getId());
		stm.execute();
		stm.close();
                return true;
            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,"Erro Interno: "+ e.getMessage(),"Erro", 0);
                return false;
            }
	}

        public boolean deletePacote(Pacote pacote)throws SQLException
	{
		try
                {
                    sql = "DELETE FROM pacote WHERE idpacote = ?";

                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm = FabricaConexoes.returnStatement(sql);

                    int id = pacote.getId();
                    if(id == 0)
                    {
                        throw new SQLException("Não há registro selecionado!");
                    }
                    stm.setInt(1, pacote.getId());

                    stm.execute();
                    stm.close();
                    return true;
                }catch(SQLException sqle)
                {
                    JOptionPane.showMessageDialog(null,"Erro interno : "+sqle.getMessage(),"Erro",0);
                    return false;
                }
	}


}
