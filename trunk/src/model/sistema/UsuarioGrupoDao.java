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
public class UsuarioGrupoDao
{
    private String sql;
    private PreparedStatement stm;
    private ResultSet rs;
    private ArrayList<UsuarioGrupo> list;
    private UsuarioGrupo usuariogrupo;


public boolean insertUsuarioGrupo(UsuarioGrupo usuariogrupo)throws SQLException
	{
                try
                {
		sql = "INSERT INTO Usua_Grupo (id_usuario, id_grupo) VALUES (?,?)";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);

		if(usuariogrupo.getId_Usua() == 0 || usuariogrupo.getId_Grupo() == 0)
                {
                    throw new SQLException("Código de referência não encontrado, verifique!");
                }
                stm.setInt(1, usuariogrupo.getId_Usua());
                stm.setInt(2, usuariogrupo.getId_Grupo());
		stm.execute();

		stm.close();
		
                return true;
                }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null,"Erro interno: "+ e.getMessage(),"Erro",0);
                   return false;
                }
	}
        public ArrayList<UsuarioGrupo> getAll()throws SQLException
	{
		sql = "SELECT * FROM usua_GRUPO";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		rs = stm.executeQuery();

		list = new ArrayList<UsuarioGrupo>();

		while(rs.next())
		{
			usuariogrupo = new UsuarioGrupo();
			usuariogrupo.setId_Usua(rs.getInt("ID_USUARIO"));
			usuariogrupo.setId_Grupo(rs.getInt("ID_GRUPO"));
			list.add(usuariogrupo);
		}

		return list;
	}
        public UsuarioGrupo getUsuarioGrupo(int id_user, int id_grupo)throws SQLException, NullPointerException
	{
		sql = "SELECT * FROM Usua_GRUPO WHERE id_usuario = ? and id_grupo = ?";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		stm.setInt(1, id_user);
                stm.setInt(2, id_grupo);
		rs = stm.executeQuery();

		usuariogrupo = new UsuarioGrupo();
		rs.next();
		usuariogrupo.setId_Usua(rs.getInt("id_usuario"));
		usuariogrupo.setId_Grupo(rs.getInt("id_grupo"));


		return usuariogrupo;
	}

        public UsuarioGrupo getUsuarioGrupo(UsuarioGrupo usuariogrupo)throws SQLException, NullPointerException
	{
		sql = "SELECT * FROM GRUPO WHERE id_usuario = ? AND id_grupo = ?";
		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		stm.setInt(1, usuariogrupo.getId_Usua());
		stm.setInt(2, usuariogrupo.getId_Grupo());
		rs = stm.executeQuery();

		usuariogrupo = new UsuarioGrupo();
		rs.next();
		usuariogrupo.setId_Usua(rs.getInt("id_usuario"));
		usuariogrupo.setId_Grupo(rs.getInt("id_grupo"));

		rs.close();
		stm.close();
		

		return usuariogrupo;
	}

        public boolean deleteUsuarioGrupo(UsuarioGrupo usuariogrupo)throws SQLException
	{
		try
                {
                    sql = "DELETE FROM usua_grupo WHERE id_usuario = ? and id_grupo = ?";

                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm = FabricaConexoes.returnStatement(sql);

                    int id_user = usuariogrupo.getId_Usua();
                    int id_grupo = usuariogrupo.getId_Grupo();
                    if(id_user == 0 || id_grupo == 0)
                    {
                        throw new SQLException("Não há registro selecionado!");
                    }
                    stm.setInt(1, usuariogrupo.getId_Usua());
                    stm.setInt(2, usuariogrupo.getId_Grupo());

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
