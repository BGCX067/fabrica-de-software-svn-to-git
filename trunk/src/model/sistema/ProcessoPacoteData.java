
package model.sistema;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Administrador
 */
public class ProcessoPacoteData extends AbstractTableModel
{

    private ArrayList<ProcessoPacote> list;
	private ProcessoPacoteDao procpacdao;
        private ProcessoPacote procpac;
	private static final String[] columnNames = {"Código_Processo","Código_Pacote"};
        private static final Class[] columnClasses = {Integer.class, Integer.class};

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
		procpac = list.get(linha);

		switch (coluna)
		{
			case 0:
				return procpac.getId_processo();
			case 1:
				return procpac.getId_pacote();
			default:
				return "";
		}
	}

	public String getColumnName(int coluna)
	{
		return columnNames[coluna];
	}

        public void atualizaDados()
        {
            try
            {
                list = procpacdao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }

        public ProcessoPacote getProcessoPacote(int linha)
        {
            procpac = list.get(linha);
            return procpac;
        }

	public ProcessoPacoteData()
	{
            procpacdao = new ProcessoPacoteDao();
            try
            {
                list = procpacdao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
	}

}
