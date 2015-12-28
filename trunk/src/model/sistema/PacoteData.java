/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.sistema;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Leandro Mourão
 */
public class PacoteData extends AbstractTableModel
{
    private ArrayList<Pacote> list;
	private PacoteDao pacotedao;
        private Pacote pacote;
	private static final String[] columnNames = {"Código","Descrição"};
        private static final Class[] columnClasses = {Integer.class, String.class};

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
		pacote = list.get(linha);

		switch (coluna)
		{
			case 0:
				return pacote.getId();
			case 1:
				return pacote.getDescricao();
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
                list = pacotedao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }

        public Pacote getPacote(int linha)
        {
            pacote = list.get(linha);
            return pacote;
        }
        public Pacote getPacoteId(int id)
        {
            try{
                return pacotedao.getPacote(id);
            }catch(SQLException sql)
            {
                return null;
            }
        }

	public PacoteData()
	{
            pacotedao = new PacoteDao();
            try
            {
                list = pacotedao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
	}

}
