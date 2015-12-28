package controler.sistema;
import controler.processo.*;
import model.sistema.*;
import javax.swing.JOptionPane;
import java.sql.SQLException;
/**
 *
 * @author Administrador
 */
public class ProcessoPacoteControler
{
     private ProcessoPacoteDao procpacdao;

    public ProcessoPacoteControler()
    {
        procpacdao = new ProcessoPacoteDao();
    }

    public void excluir(ProcessoPacote procpac)
    {
        try
        {
           if(procpacdao.deleteProcessoPacote(procpac)) JOptionPane.showMessageDialog(null, "Processo removido com sucesso.");
           else {throw new SQLException();}
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar remover processo do pacote","Erro",0);
        }
    }

    public void gravar(ProcessoPacote procpac)
    {
        try
        {
            if(procpac.getId_processo() != 0 && procpac.getId_pacote() != 0)
            {                
                if(!procpacdao.insertProcessoPacote(procpac))
                {
                    throw new SQLException();
                }
            }
            JOptionPane.showMessageDialog(null, "Processo associado com sucesso.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar gravar: " + e.getMessage(),"Erro",0);
        }
    }


}
