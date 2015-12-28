
package controler.sistema;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.sistema.Grupo;
import model.sistema.GrupoDao;


public class GrupoControler
{
    private GrupoDao grupodao;

    public GrupoControler()
    {
        grupodao = new GrupoDao();
    }

    public void excluirGrupo(Grupo grupo)
    {
        try
        {
           if(grupodao.deleteGrupo(grupo)) JOptionPane.showMessageDialog(null, "Grupo excluído com sucesso.");
           else {throw new SQLException();}
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar excluir o grupo: " + grupo.getDescricao(),"Erro",0);
        }
    }

    public void gravar(Grupo grupo)
    {
        try
        {
            if(grupo.getId() == 0)
            {
                if(!grupodao.insertGrupo(grupo))
                {
                    throw new SQLException();
                }
            }
            else{
                if(!grupodao.updateGrupo(grupo))
                {
                    throw new SQLException();
                }
            }
            JOptionPane.showMessageDialog(null, "Grupo gravado com sucesso.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar gravar grupo: " + grupo.getDescricao(),"Erro",0);
        }
    }
    
}
