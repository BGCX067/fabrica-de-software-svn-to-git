package model.processo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ProcessoData extends AbstractTableModel
{
        private ArrayList<Processo> list;
        private Processo processo;
        private ProcessoDao dao;
	private static final String[] columnNames = {"Codigo", "Nome", "Autor", "Versao", "Status"};
        private static final Class[] columnClasses = { Integer.class, String.class, String.class, String.class, String.class};

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
            processo = list.get(linha);

            switch (coluna)
            {
                case 0:
                        return processo.getIdproceso();
                case 1:
                        return processo.getNome();
                case 2:
                        return processo.getAutor().getNome();
                case 3:
                        return processo.getVersao();
                case 4:
                        String status = (processo.getStatus() == 0)? "Inativo": "Ativo";
                        return status;
                default:
                        return "";
            }
	}

	public String getColumnName(int coluna)
	{
            return columnNames[coluna];
	}

        public Processo getProcesso(int linha)
        {
            processo = list.get(linha);
            return processo;
        }
        
        public Processo getProcessoId(int id) throws SQLException
        {
            dao = new ProcessoDao();
            return dao.getProcesso(id);
        }

        public void setProcesso(Processo processo)
        {
            list.add(processo);
        }

        public void removeOpcao(int linha)
        {
            list.remove(linha);
        }

        public ProcessoData()
        {
            ProcessoDao dao = new ProcessoDao();
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
            list = new ArrayList<Processo>();
        }

        public void atualizaDados()
        {
            dao = new ProcessoDao();

            try
            {
                this.list = dao.getAll();
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
}
