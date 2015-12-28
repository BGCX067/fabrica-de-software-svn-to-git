package model.processo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AtividadeData extends AbstractTableModel
{
        private ArrayList<Atividade> list;
        private Atividade atividade;
        private AtividadeDao dao;
	private static final String[] columnNames = {"Codigo","Nome", "Descrição","Usuário Alteração","Autor","Status"};
        private static final Class[] columnClasses = { Integer.class, String.class,String.class,Integer.class,Integer.class,Integer.class};

        public int getColumnCount()
	{
            return columnNames.length;
	}

	public int getRowCount()
	{
            return list.size();
	}

	public Object getValueAt(int linha, int coluna)
	{
            atividade = list.get(linha);

            switch (coluna)
            {
                case 0:
                        return atividade.getId();
                case 1:
                        return atividade.getNome();
                case 2:
                        return atividade.getDescricao();
                
                case 3 :
                        return atividade.getUserModif();
                case 4:
                        return atividade.getAutor();
                case 5:
                       return atividade.getStatus();
                
                default:
                        return "";
            }
	}

	public String getColumnName(int coluna)
	{
            return columnNames[coluna];
	}

        public Atividade getAtividade(int linha)
        {
            atividade = list.get(linha);
            return atividade;
        }
        public Atividade getAtividadeId(int id)
        {
            try{
                return dao.getAtividade(id);
            }catch(SQLException sql)
            {
                return null;
            }
        }

        public void setAtividade(Atividade atividade)
        {
            list.add(atividade);
        }

        public void removeOpcao(int linha)
        {
            list.remove(linha);
        }

        public void atualizaDados()
        {
            try
            {
                list = dao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        public AtividadeData()
        {
            dao = new AtividadeDao();
            try
            {
                list = dao.getAll();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        public void limparDados()
        {
            list = new ArrayList<Atividade>();
        }
}
