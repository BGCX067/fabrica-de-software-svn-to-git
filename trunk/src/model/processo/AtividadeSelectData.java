package model.processo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AtividadeSelectData extends AbstractTableModel
{
        private ArrayList<AtividadeSelect> list;
        private AtividadeSelect atividade;
        private AtividadeSelectDao dao;
	private static final String[] columnNames = {"Código","Nome", "Autor","Usuário Modificação"};
        private static final Class[] columnClasses = { Integer.class, String.class,String.class,String.class};

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
                        return atividade.getAutor();
                
                case 3 :
                        return atividade.getUserModif();
                default:
                        return "";
            }
	}

	public String getColumnName(int coluna)
	{
            return columnNames[coluna];
	}

        public AtividadeSelect getAtividade(int linha)
        {
            atividade = list.get(linha);
            return atividade;
        }

        public void setAtividade(AtividadeSelect atividade)
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
        public AtividadeSelectData()
        {
            dao = new AtividadeSelectDao();
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
            list = new ArrayList<AtividadeSelect>();
        }
}
