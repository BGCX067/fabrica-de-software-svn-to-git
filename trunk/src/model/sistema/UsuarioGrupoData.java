
package model.sistema;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Administrador
 */
public class UsuarioGrupoData extends AbstractTableModel 
{

    private ArrayList<UsuarioGrupo> list;
	private UsuarioGrupoDao usergrupodao;
        private UsuarioGrupo usergrupo;
	private static final String[] columnNames = {"Código_Usuário","Código_Grupo"};
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
		usergrupo = list.get(linha);

		switch (coluna)
		{
			case 0:
				return usergrupo.getId_Usua();
			case 1:
				return usergrupo.getId_Grupo();
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
                list = usergrupodao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }

        public UsuarioGrupo getUsuarioGrupo(int linha)
        {
            usergrupo = list.get(linha);
            return usergrupo;
        }

	public UsuarioGrupoData()
	{
            usergrupodao = new UsuarioGrupoDao();
            try
            {
                list = usergrupodao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
	}

}
