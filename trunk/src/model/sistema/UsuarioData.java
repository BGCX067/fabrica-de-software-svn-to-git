package model.sistema;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class UsuarioData extends AbstractTableModel 
{
	private ArrayList<Usuario> list;
	private UsuarioDao userdao;
        private Usuario user;
	private static final String[] columnNames = {"Codigo","Nome","Login", "E-mail"};
        private static final Class[] columnClasses = {Integer.class, String.class, String.class, String.class};
	
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
		user = list.get(linha);
		
		switch (coluna)
		{
			case 0:
				return user.getId();
			case 1:
				return user.getNome();
                        case 2:
                                return user.getLogin();
                        case 3:
                                return user.getEmail();
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
                list = userdao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }

        public Usuario getUsuario(int linha)
        {
            user = list.get(linha);
            return user;
        }

	public UsuarioData()
	{
            userdao = new UsuarioDao();
            try
            {
                list = userdao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
	}
}
