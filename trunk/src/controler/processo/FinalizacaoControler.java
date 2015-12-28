package controler.processo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.processo.Finalizacao;
import model.processo.FinalizacaoDao;

public class FinalizacaoControler
{
    private FinalizacaoDao dao;

    public FinalizacaoControler()
    {
        dao = new FinalizacaoDao();
    }

    public void gravarFinalizacao(Finalizacao finalizacao)
    {
        if(finalizacao.getId() == 0)
        {
            try
            {
                dao.insertFinalizacao(finalizacao);
                JOptionPane.showMessageDialog(null, "Finalização inserida com sucesso");
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "Falha ao inserir finalização");
            }
        }
        else
        {
            try
            {
                dao.updateFinalizacao(finalizacao);
                JOptionPane.showMessageDialog(null, "Finalizacao gravada com sucesso");
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "Falha ao gravar finalização\n"+e.getMessage());
            }

        }
    }

    public void deleteFinalizacao(Finalizacao finalizacao)
    {
        try
        {
            dao.deleteFinalizacao(finalizacao);
            JOptionPane.showMessageDialog(null, "Finalizacao excluida com sucesso.");
        }
        catch(SQLException e)
        {
           e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao excluir finalização.");
        }
    }

    public ArrayList<Finalizacao> getAll()
    {
        try
        {
            return dao.getAll();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar dados");
            return new ArrayList<Finalizacao>();
        }

    }
}
