package model.execucao;

import model.processo.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class AgendaData extends AbstractTableModel
{
        private ArrayList<Agenda> list;
        private Agenda agenda;
        private AgendaDao dao;
	private static final String[] columnNames = {"Codigo","Código Tarefa", "Código Atividade","Código Processo","Código finalização","Código Usuário","Sequência","Data Inicial","Data Final"};
        private static final Class[] columnClasses = { Integer.class, Integer.class,Integer.class,Integer.class,Integer.class,Integer.class,Integer.class,Date.class,Date.class};

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
            agenda = list.get(linha);

            switch (coluna)
            {
                case 0:
                        return agenda.getIdagenda();
                case 1:
                        return agenda.getIdtarefa();
                case 2:
                        return agenda.getIdativ();
                
                case 3 :
                        return agenda.getIdproc();
                case 4:
                        return agenda.getIdfin();
                case 5:
                       return agenda.getIdusuario();
                case 6 :
                        return agenda.getSequencia();
                case 7 :
                        return agenda.getDt_inicial();
                case 8 :
                        return agenda.getDt_final();
                
                default:
                        return "";
            }
	}

	public String getColumnName(int coluna)
	{
            return columnNames[coluna];
	}

        public Agenda getAgenda(int linha)
        {
            agenda = list.get(linha);
            return agenda;
        }
        public Agenda getAgendaId(int id)
        {
            try{
                return dao.getAgenda(id);
            }catch(SQLException sql)
            {
                return null;
            }
        }

        public void setAgenda(Agenda agenda)
        {
            list.add(agenda);
        }

        

        public void atualizaDados()
        {
            try
            {
                list = dao.getAll();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        public AgendaData()
        {
            dao = new AgendaDao();
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
            list = new ArrayList<Agenda>();
        }
}
