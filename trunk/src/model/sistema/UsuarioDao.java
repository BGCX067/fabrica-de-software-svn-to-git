package model.sistema;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Util.FabricaConexoes;

public class UsuarioDao 
{

	private String sql;
	private PreparedStatement stm;
	private ResultSet rs;
	private ArrayList<Usuario> list;
	private Usuario user;
	
	public void insertUsuario(Usuario user)throws SQLException
	{
            sql = "INSERT INTO USUARIO (nome, login, senha, email) VALUES (?,?,?,?)";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);

            stm.setString(1, user.getNome());
            stm.setString(2, user.getLogin());
            stm.setString(3, user.getSenha());
            stm.setString(4, user.getEmail());
            stm.execute();

            stm.close();
            FabricaConexoes.closeConnection();
	}
	
	public ArrayList<Usuario> getAll()throws SQLException
	{
            sql = "SELECT * FROM USUARIO";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            rs = stm.executeQuery();

            list = new ArrayList<Usuario>();

            while(rs.next())
            {
                user = new Usuario();
                user.setId(rs.getInt("idusuario"));
                user.setNome(rs.getString("nome"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                user.setEmail(rs.getString("email"));

                list.add(user);
        }

            rs.close();
            stm.close();
            FabricaConexoes.closeConnection();

            return list;
	}
	
	public Usuario getUsuario(int id)throws SQLException, NullPointerException
	{
            sql = "SELECT * FROM USUARIO WHERE idusuario = ?";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            user = new Usuario();
            rs.next();
            user.setId(rs.getInt("idusuario"));
            user.setNome(rs.getString("nome"));
            user.setLogin(rs.getString("login"));
            user.setSenha(rs.getString("senha"));
            user.setEmail(rs.getString("email"));

            rs.close();
            stm.close();
            FabricaConexoes.closeConnection();

            return user;
	}

        public Usuario getUsuario(String nome)throws SQLException, NullPointerException
	{
            sql = "SELECT * FROM USUARIO WHERE nome = ?";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setString(1, nome);
            rs = stm.executeQuery();

            user = new Usuario();
            rs.next();
            user.setId(rs.getInt("idusuario"));
            user.setNome(rs.getString("nome"));
            user.setLogin(rs.getString("login"));
            user.setSenha(rs.getString("senha"));
            user.setEmail(rs.getString("email"));

            rs.close();
            stm.close();
            FabricaConexoes.closeConnection();

            return user;
	}



	public Usuario getUsuario(Usuario user)throws SQLException, NullPointerException
	{
            sql = "SELECT * FROM USUARIO WHERE nome = ? AND senha = ?";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setString(1, user.getNome());
            stm.setString(2, user.getSenha());
            rs = stm.executeQuery();
            user = new Usuario();
            rs.next();
            user.setId(rs.getInt("idusuario"));
            user.setNome(rs.getString("nome"));
            user.setLogin(rs.getString("login"));
            user.setSenha(rs.getString("senha"));
            user.setEmail(rs.getString("email"));

            rs.close();
            stm.close();
            FabricaConexoes.closeConnection();

            return user;
	}
        public Usuario getUsuario(String user, String senha)throws SQLException, NullPointerException
	{
            sql = "SELECT * FROM USUARIO WHERE login = ? AND senha = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setString(1, user);
            stm.setString(2, senha);
            rs = FabricaConexoes.returnResult(stm);
            Usuario usua= new Usuario();
            rs.next();
            usua.setId(rs.getInt("idusuario"));
            usua.setNome(rs.getString("nome"));
            usua.setLogin(rs.getString("login"));
            usua.setSenha(rs.getString("senha"));
            usua.setEmail(rs.getString("email"));

            rs.close();
            stm.close();
            FabricaConexoes.closeConnection();

            return usua;
	}
	
	public void updateUsuario(Usuario user)throws SQLException
	{
            sql = "UPDATE usuario SET nome = ?, login = ?, senha = ?, email = ? WHERE idusuario = ?";

            if(!FabricaConexoes.verificaConexao()) 
                FabricaConexoes.getConexao();

            stm = FabricaConexoes.returnStatement(sql);
            stm.setString(1, user.getNome());
            stm.setString(2, user.getLogin());
            stm.setString(3, user.getSenha());
            stm.setString(4, user.getEmail());
            stm.setInt(5, user.getId());

            stm.execute();
            stm.close();
            FabricaConexoes.closeConnection();
	}
	
	public void deleteUsuario(Usuario user)throws SQLException
	{
            sql = "DELETE FROM usuario WHERE idusuario = ?";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, user.getId());

            stm.execute();
            stm.close();

            FabricaConexoes.closeConnection();
	}
}
