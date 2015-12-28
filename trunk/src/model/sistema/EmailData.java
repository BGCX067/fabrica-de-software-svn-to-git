package model.sistema;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class EmailData extends AbstractTableModel
{
	private ArrayList<Email> list;
	private EmailDao emaildao;
        private Email email;
	private static final String[] columnNames = {"Codigo","Nome","Email", "Senha", "Pop", "Smtp"};
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
		email = list.get(linha);

		switch (coluna)
		{
			case 0:
				return email.getId();
			case 1:
				return email.getNome();
                        case 2:
                                return email.getSenha();
                        case 3:
                                return email.getPop();
                        case 4:
                                return email.getSmtp();

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
                list = emaildao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }

        public Email getEmail(int linha)
        {
            email = list.get(linha);
            return email;
        }

	public EmailData()
	{
            emaildao = new EmailDao();
            try
            {
                list = emaildao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
	}
}
