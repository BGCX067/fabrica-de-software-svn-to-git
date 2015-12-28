package model.processo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class FinalizacaoData extends AbstractTableModel
{
        private ArrayList<Finalizacao> list;
        private Finalizacao finalizacao;
        private FinalizacaoDao dao;
	private static final String[] columnNames = {"Codigo", "Descrição","Valor"};
        private static final Class[] columnClasses = { Integer.class, String.class,String.class};

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
            finalizacao = list.get(linha);

            switch (coluna)
            {
                case 0:
                        return finalizacao.getId();
                case 1:
                        return finalizacao.getNome();
                case 2 :
                        if(finalizacao.getValor().compareToIgnoreCase("\\") == 0)
                        {
                          return "Não permite entrada";
                        }
                        else if(finalizacao.getValor().compareToIgnoreCase("/") == 0)
                        {
                          return "Permite entrada";
                        }else
                        {
                          return finalizacao.getValor();
                        }
                default:
                        return "";
            }
	}

	public String getColumnName(int coluna)
	{
            return columnNames[coluna];
	}

        public Finalizacao getFinalizacao(int linha)
        {
            finalizacao = list.get(linha);
            return finalizacao;
        }
        public Finalizacao getFinalizacaoId(int id)
        {
            try{
                dao = new FinalizacaoDao();
                return dao.getFinalizacao(id);
            }catch(SQLException sql)
            {
                return null;
            }
        }

        

        public void setFinalizacao(Finalizacao finalizacao)
        {
            list.add(finalizacao);
        }

        public void removeOpcao(int linha)
        {
            list.remove(linha);
        }

        public FinalizacaoData()
        {
            FinalizacaoDao dao = new FinalizacaoDao();
            try
            {
                list = dao.getAll();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        public FinalizacaoData(boolean verifica)
        {
            FinalizacaoDao dao = new FinalizacaoDao();
            try
            {
                list = dao.getAllAtivos();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        public void limparDados()
        {
            list = new ArrayList<Finalizacao>();
        }

        public void atualizaDados()
        {
            dao = new FinalizacaoDao();
            try
            {
                list = dao.getAll();
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
}
