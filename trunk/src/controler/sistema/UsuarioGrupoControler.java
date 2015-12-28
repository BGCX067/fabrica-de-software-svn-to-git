package controler.sistema;
import model.sistema.UsuarioGrupoDao;
import model.sistema.UsuarioGrupo;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class UsuarioGrupoControler
{
     private UsuarioGrupoDao usergrupodao;

    public UsuarioGrupoControler()
    {
        usergrupodao = new UsuarioGrupoDao();
    }

    public void excluir(UsuarioGrupo usergrupo)
    {
        try
        {
           if(usergrupodao.deleteUsuarioGrupo(usergrupo)) JOptionPane.showMessageDialog(null, "Usuário removido com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
           else {throw new SQLException();}
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar remover usuário do grupo","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void gravar(UsuarioGrupo usergrupo)
    {
        try
        {
            if(usergrupo.getId_Usua() != 0 && usergrupo.getId_Grupo() != 0)
            {                
                if(!usergrupodao.insertUsuarioGrupo(usergrupo))
                {
                    throw new SQLException();
                }
            }
            JOptionPane.showMessageDialog(null, "Usuário associado com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar associar usuário ao grupo" ,"Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
