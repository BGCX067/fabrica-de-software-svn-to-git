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
public class GrupoPacoteDao
{
    private String sql;
    private PreparedStatement stm;
    private ResultSet rs;
    private ArrayList<GrupoPacote> list;
    private GrupoPacote grupopacote;


public boolean insertGrupoPacote(GrupoPacote grupopacote)throws SQLException
	{
                try
                {
		sql = "INSERT INTO Grupo_Pacote (idgrupo, idpacote) VALUES (?,?)";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);

		if(grupopacote.getId_pacote() == 0 || grupopacote.getId_grupo() == 0)
                {
                    throw new SQLException("Código de referência não encontrado, verifique!");
                }
                stm.setInt(1, grupopacote.getId_grupo());
                stm.setInt(2, grupopacote.getId_pacote());
		stm.execute();

		stm.close();
		
                return true;
                }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null,"Erro interno: "+ e.getMessage(),"Erro",0);
                   return false;
                }
	}
        public ArrayList<GrupoPacote> getAll()throws SQLException
	{
		sql = "SELECT * FROM grupo_pacote";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		rs = stm.executeQuery();

		list = new ArrayList<GrupoPacote>();

		while(rs.next())
		{
			grupopacote = new GrupoPacote();
			grupopacote.setId_pacote(rs.getInt("IDPACOTE"));
			grupopacote.setId_grupo(rs.getInt("IDGRUPO"));
			list.add(grupopacote);
		}

		return list;
	}
        public GrupoPacote getGrupoPacote(int id_pac, int id_grupo)throws SQLException, NullPointerException
	{
		sql = "SELECT * FROM GRUPO_PACOTE WHERE idpacote = ? and idgrupo = ?";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		stm.setInt(1, id_pac);
                stm.setInt(2, id_grupo);
		rs = stm.executeQuery();

		grupopacote = new GrupoPacote();
		rs.next();
		grupopacote.setId_pacote(rs.getInt("idpacote"));
		grupopacote.setId_grupo(rs.getInt("idgrupo"));


		return grupopacote;
	}

        public GrupoPacote getGrupoPacote(GrupoPacote grupopacote)throws SQLException, NullPointerException
	{
		sql = "SELECT * FROM GRUPO WHERE idpacote = ? AND id_grupo = ?";
		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		stm.setInt(1, grupopacote.getId_pacote());
		stm.setInt(2, grupopacote.getId_grupo());
		rs = stm.executeQuery();

		grupopacote = new GrupoPacote();
		rs.next();
		grupopacote.setId_pacote(rs.getInt("idpacote"));
		grupopacote.setId_grupo(rs.getInt("idgrupo"));

		rs.close();
		stm.close();
		

		return grupopacote;
	}

        public boolean deleteGrupoPacote(GrupoPacote grupopacote)throws SQLException
	{
		try
                {
                    sql = "DELETE FROM grupo_pacote WHERE idpacote = ? and idgrupo = ?";

                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm = FabricaConexoes.returnStatement(sql);

                    int id_user = grupopacote.getId_pacote();
                    int id_grupo = grupopacote.getId_grupo();
                    if(id_user == 0 || id_grupo == 0)
                    {
                        throw new SQLException("Não há registro selecionado!");
                    }
                    stm.setInt(1, grupopacote.getId_pacote());
                    stm.setInt(2, grupopacote.getId_grupo());

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
