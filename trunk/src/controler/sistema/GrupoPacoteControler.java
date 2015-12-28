package controler.sistema;
import model.sistema.UsuarioGrupo;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.sistema.GrupoPacote;
import model.sistema.GrupoPacoteDao;
/**
 *
 * @author Administrador
 */
public class GrupoPacoteControler
{
     private GrupoPacoteDao grupopacotedao;

    public GrupoPacoteControler()
    {
        grupopacotedao = new GrupoPacoteDao();
    }

    public void excluir(GrupoPacote grupopacote)
    {
        try
        {
           if(grupopacotedao.deleteGrupoPacote(grupopacote)) JOptionPane.showMessageDialog(null, "Pacote removido com sucesso.");
           else {throw new SQLException();}
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar remover pacote do grupo","Erro",0);
        }
    }

    public void gravar(GrupoPacote grupopacote)
    {
        try
        {
            if(grupopacote.getId_pacote() != 0 && grupopacote.getId_grupo() != 0)
            {                
                if(!grupopacotedao.insertGrupoPacote(grupopacote))
                {
                    throw new SQLException();
                }
            }
            JOptionPane.showMessageDialog(null, "Pacote associado com sucesso.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar gravar: " + e.getMessage(),"Erro",0);
        }
    }


}
