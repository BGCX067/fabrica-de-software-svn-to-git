package model.sistema;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public  class MenuGrupoData extends AbstractTableModel
{
        private ArrayList<MenuGrupo> list;
	private MenuGrupoDao menugrupodao;
        private MenuGrupo menugrupo;
	private static final String[] columnNames = {"Código Item","Código Grupo","Status"};
        private static final Class[] columnClasses = {Integer.class, Integer.class,Integer.class};

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
		menugrupo = list.get(linha);

		switch (coluna)
		{
			case 0:
				return menugrupo.getIdItem();
			case 1:
				return menugrupo.getIdGrupo();
                        case 2 :
                                return menugrupo.getFlag();
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
                list = menugrupodao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }

        public MenuGrupo getMenuGrupo(int linha)
        {
            menugrupo = list.get(linha);
            return menugrupo;
        }

	public MenuGrupoData()
	{
            menugrupodao = new MenuGrupoDao();
            try
            {
                list = menugrupodao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
	}
};