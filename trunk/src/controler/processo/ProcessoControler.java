package controler.processo;

import Util.AbstractController;
import execoes.CamposException;
import model.processo.Processo;
import model.processo.ProcessoDao;

public class ProcessoControler implements AbstractController<Processo>
{
    ProcessoDao processodao;

    public ProcessoControler()
    {
        processodao = new ProcessoDao();
    }

    private void insertProcesso(Processo processo) throws CamposException, Exception
    {
        camposObrigatorios(processo);
        processodao.insertProcesso(processo);
    }

    public void deleteProcesso(Processo processo) throws Exception
    {
        processodao.deleteProcesso(processo);
    }

    private void alterarProcesso(Processo processo) throws Exception
    {
        camposObrigatorios(processo);
        processodao.updateProcesso(processo);
    }

    public void gravarProcesso(Processo processo) throws CamposException, Exception
    {
        if(processo != null)
        {
            if(processo.getIdproceso() == 0)
               insertProcesso(processo);
           else
               alterarProcesso(processo);
       }
    }

    public void camposObrigatorios(Processo objeto) throws Exception
    {
        if(objeto != null)
        {
            if(objeto.getNome() == null || objeto.getNome().trim().length() <= 0)
            {
                throw new CamposException("Nome");
            }
        }
    }

    public void formatoCampos(Processo objeto) throws Exception
    {
        
    }
}
