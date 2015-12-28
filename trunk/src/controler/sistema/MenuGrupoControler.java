package controler.sistema;
import model.sistema.MenuGrupoDao;
import model.sistema.MenuGrupoData;
import model.sistema.MenuGrupo;
import javax.swing.JOptionPane;
import java.sql.SQLException;
/**
 *
 * @author Administrador
 */
public class MenuGrupoControler
{
     private MenuGrupoDao menugrupodao;

    public MenuGrupoControler()
    {
        menugrupodao = new MenuGrupoDao();
    }

    public void excluir(MenuGrupo menugrupo)
    {
        try
        {
           if(menugrupodao.deleteMenuGrupo(menugrupo)) JOptionPane.showMessageDialog(null, "Menu removido com sucesso.");
           else {throw new SQLException();}
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar remover menu do grupo","Erro",0);
        }
    }

    public void gravar(MenuGrupo menugrupo)
    {
        try
        {
            if(menugrupo.getIdItem() != 0 && menugrupo.getIdGrupo() != 0)
            {                
                if(!menugrupodao.insertMenuGrupo(menugrupo))
                {
                    if(!menugrupodao.updateMenuGrupo(menugrupo)) throw new SQLException();
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Menu associado com sucesso.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar gravar: " + e.getMessage(),"Erro",0);
        }
    }


}
