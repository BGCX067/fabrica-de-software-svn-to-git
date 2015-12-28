package controler.processo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.processo.Finalizacao;
import model.processo.FinalizacaoDao;
import model.processo.OpcaoDao;
import model.processo.Opcao;

public class OpcaoControler
{
    private OpcaoDao dao;

    public OpcaoControler()
    {
        dao = new OpcaoDao();
    }

    public void gravarOpcao(Opcao opcao)
    {
        if(opcao.getId() == 0)
        {
            try
            {
                dao.insertOpcao(opcao);
                
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "Falha ao inserir Opção\n"+e.getMessage(),"Erro",0);
            }
        }
        else
        {
            try
            {
                dao.updateOpcao(opcao);
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "Falha ao gravar Opção\n"+e.getMessage(),"Erro",0);
            }

        }
    }

    public void deleteOpcao(Opcao opcao)
    {
        try
        {
            dao.deleteOpcao(opcao);
            JOptionPane.showMessageDialog(null, "Opção excluída com sucesso.","Exclusão",1);
        }
        catch(SQLException e)
        {
           e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao excluir opção.\n"+ e.getMessage(),"Erro",0);
        }
    }

}
