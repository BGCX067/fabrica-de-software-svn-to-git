
package model.processo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class OpcaoData extends AbstractTableModel
{
    private ArrayList<Opcao> list;
    private Opcao opcao;
    private OpcaoDao dao;
    private static final String[] columnNames = {"Descrição", "Valor"};
    private static final Class[] columnClasses = { String.class, String.class};

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
        opcao = list.get(linha);

        switch (coluna)
        {
            case 0: return opcao.getNome();
            case 1: return opcao.getValor();
            default: return "";
        }
    }

    public String getColumnName(int coluna)
    {
            return columnNames[coluna];
    }

    public Opcao getOpcao(int linha)
    {
        opcao = list.get(linha);
        return opcao;
    }

    public void setOpcao(Opcao opcao)
    {
        list.add(opcao);
    }

    public void removeOpcao(int linha)
    {
        list.remove(linha);
    }

    public OpcaoData(Finalizacao fin)
    {
        atualizaDados(fin);
    }

    public void limparDados()
    {
        list = new ArrayList<Opcao>();
    }

    public void setList(ArrayList<Opcao> list)
    {
        this.list = list;
    }

    public ArrayList<Opcao> getList()
    {
        return this.list;
    }
    public void atualizaDados(Finalizacao fin)
        {
            dao = new OpcaoDao();
            try
            {
                list = dao.getAll(fin.getId());
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
}
