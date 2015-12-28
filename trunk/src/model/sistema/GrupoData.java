package model.sistema;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public  class GrupoData extends AbstractTableModel
{
        private ArrayList<Grupo> list;
	private GrupoDao grupodao;
        private Grupo grupo;
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
		grupo = list.get(linha);

		switch (coluna)
		{
			case 0:
				return grupo.getId();
			case 1:
				return grupo.getDescricao();
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
                list = grupodao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }

        public Grupo getGrupo(int linha)
        {
            grupo = list.get(linha);
            return grupo;
        }
        public Grupo getGrupoId(int id)
        {
            try{
                return grupodao.getGrupo(id);
            }catch(SQLException sql)
            {
                return null;
            }
        }

	public GrupoData()
	{
            grupodao = new GrupoDao();
            try
            {
                list = grupodao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
	}
};