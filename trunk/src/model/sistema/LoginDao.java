/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.sistema;

import Util.FabricaConexoes;
import Util.manipulaConexao;
import com.mysql.jdbc.util.ResultSetUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class LoginDao {

    private PreparedStatement stm;
    private ResultSet rs;
    private String sql;

    public void alteraSenha(String senha, String nova_senha)throws Exception
    {
        Usuario usuario = manipulaConexao.getUsuarioLogado();
        sql = "Select * from usuario where idusuario = " + usuario.getId() + ";";
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
        rs = FabricaConexoes.returnResult(stm);
        if(rs.next())
        {
            String s = rs.getString("senha");
            if(s.compareToIgnoreCase(senha) != 0)
            {
                JOptionPane.showMessageDialog(null, "Senha antiga não confere!","Alteração de senha",0);
                return;
            }
            sql = "Update usuario set senha = ? where idusuario = ?";
            
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setString(1,nova_senha);
            stm.setInt(2, usuario.getId());
            stm.execute();
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!","Alteração de senha",JOptionPane.INFORMATION_MESSAGE);
            FabricaConexoes.closeConnection();
            FabricaConexoes.closeConnection();
            stm.close();
        }

    }

}
