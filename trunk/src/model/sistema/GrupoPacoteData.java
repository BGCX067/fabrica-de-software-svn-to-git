
package model.sistema;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Administrador
 */
public class GrupoPacoteData extends AbstractTableModel 
{

    private ArrayList<GrupoPacote> list;
	private GrupoPacoteDao grupopacotedao;
        private GrupoPacote grupopacote;
	private static final String[] columnNames = {"Código_Grupo","Código_Pacote"};
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
		grupopacote = list.get(linha);

		switch (coluna)
		{
			case 0:
				return grupopacote.getId_grupo();
			case 1:
				return grupopacote.getId_pacote();
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
                list = grupopacotedao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }

        public GrupoPacote getGrupoPacote(int linha)
        {
            grupopacote = list.get(linha);
            return grupopacote;
        }

	public GrupoPacoteData()
	{
            grupopacotedao = new GrupoPacoteDao();
            try
            {
                list = grupopacotedao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
	}

}
