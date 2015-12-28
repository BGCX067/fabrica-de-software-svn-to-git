
package controler.processo;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.processo.*;



public class AtividadeControler
{
    private AtividadeDao atividadedao;

    public AtividadeControler()
    {
        atividadedao = new AtividadeDao();
    }

    public boolean excluirAtividade(Atividade atividade)
    {
        if(atividade.getId() == 0)
        {
            JOptionPane.showMessageDialog(null, "Nenhum registro selecionado, verifique!","Erro",0);
             return false;
        }
        try{
                atividadedao.deleteAtividade(atividade);
                JOptionPane.showMessageDialog(null, "Atividade excluída com sucesso!","Exclusão",1);
                return true;
                }catch(Exception e)
                        {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir atividade.","Erro",0);
                            return false;
                            }
    }

    public boolean gravarAtividade(Atividade atividade)
    {
        try
            {
                if(atividade.getId() == 0)
                    {
                        atividadedao.insertAtividade(atividade);
                        JOptionPane.showMessageDialog(null, "Atividade incluída com sucesso!","Inserção",1);
                        return true;
                    }
                else
                    {
                        atividadedao.updateAtividade(atividade);
                        JOptionPane.showMessageDialog(null, "Atividade alterada com sucesso!","Alteração",1);
                        return true;
                    }

                }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(null, "Não foi possível inserir a atividade\n"+ e.getMessage(),"Erro",0);
                        return false;
                        }
    }
    
}
