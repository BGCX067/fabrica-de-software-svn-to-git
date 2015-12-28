
package controler.sistema;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.sistema.Pacote;
import model.sistema.PacoteDao;


public class PacoteControler
{
    private PacoteDao pacotedao;

    public PacoteControler()
    {
        pacotedao = new PacoteDao();
    }

    public void excluirPacote(Pacote pacote)
    {
        try
        {
           if(pacotedao.deletePacote(pacote)) JOptionPane.showMessageDialog(null, "Pacote excluído com sucesso.");
           else {throw new SQLException();}
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar excluir o pacote: " + pacote.getDescricao(),"Erro",0);
        }
    }

    public void gravar(Pacote pacote)
    {
        try
        {
            if(pacote.getId() == 0)
            {
                if(!pacotedao.insertPacote(pacote))
                {
                    throw new SQLException();
                }
            }
            else{
                if(!pacotedao.updatePacote(pacote))
                {
                    throw new SQLException();
                }
            }
            JOptionPane.showMessageDialog(null, "Pacote gravado com sucesso.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar gravar grupo: " + pacote.getDescricao(),"Erro",0);
        }
    }
    
}
