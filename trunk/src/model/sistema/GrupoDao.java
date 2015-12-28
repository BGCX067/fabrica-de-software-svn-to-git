
package model.sistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Util.FabricaConexoes;
import java.security.Principal;
import javax.swing.JOptionPane;

public class GrupoDao
{
    private String sql;
    private PreparedStatement stm;
    private ResultSet rs;
    private ArrayList<Grupo> list;
    private Grupo grupo;



public boolean insertGrupo(Grupo grupo)throws SQLException
	{
                try
                {
		sql = "INSERT INTO Grupo (descricao) VALUES (?)";

                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);

		if(grupo.getDescricao().equalsIgnoreCase(""))
                {
                    throw new SQLException("Descrição não pode ser nula!");
                }
                stm.setString(1, grupo.getDescricao());
		stm.execute();

		stm.close();
                return true;
                }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null,"Erro interno: "+ e.getMessage(),"Erro",0);
                   return false;
                }
	}
        public ArrayList<Grupo> getAll()throws SQLException
	{
		sql = "SELECT * FROM GRUPO";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		rs = stm.executeQuery();

		list = new ArrayList<Grupo>();

		while(rs.next())
		{
			grupo = new Grupo();
			grupo.setId(rs.getInt("IDGRUPO"));
			grupo.setDescricao(rs.getString("DESCRICAO"));
			list.add(grupo);
		}

		return list;
	}
        public Grupo getGrupo(int id)throws SQLException, NullPointerException
	{
		sql = "SELECT * FROM GRUPO WHERE idgrupo = ?";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		stm.setInt(1, id);
		rs = stm.executeQuery();

		grupo = new Grupo();
		rs.next();
		grupo.setId(rs.getInt("idgrupo"));
		grupo.setDescricao(rs.getString("Descricao"));


		return grupo;
	}

        public Grupo getGrupo(Grupo grupo)throws SQLException, NullPointerException
	{
		sql = "SELECT * FROM GRUPO WHERE idgrupo = ? AND descricao = ?";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		stm.setInt(1, grupo.getId());
		stm.setString(2, grupo.getDescricao());
		rs = stm.executeQuery();

		grupo = new Grupo();
		rs.next();
		grupo.setId(rs.getInt("idgrupo"));
		grupo.setDescricao(rs.getString("Descricao"));

		rs.close();
		stm.close();


		return grupo;
	}

        public boolean updateGrupo(Grupo grupo)throws SQLException
	{
            try{
		sql = "UPDATE grupo SET descricao = ? WHERE idgrupo = ?";
		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		stm.setString(1, grupo.getDescricao());
		stm.setInt(2, grupo.getId());
		stm.execute();
		stm.close();
                return true;
            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,"Erro Interno: "+ e.getMessage(),"Erro", 0);
                return false;
            }
	}

        public boolean deleteGrupo(Grupo grupo)throws SQLException
	{
		try
                {
                    sql = "DELETE FROM grupo WHERE idgrupo = ?";

                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);

                    int id = grupo.getId();
                    if(id == 0)
                    {
                        throw new SQLException("Não há registro selecionado!");
                    }
                    stm.setInt(1, grupo.getId());

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
