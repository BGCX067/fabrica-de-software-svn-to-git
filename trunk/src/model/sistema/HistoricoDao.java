package model.sistema;

import Util.FabricaConexoes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HistoricoDao
{
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;
    private ArrayList<Historico> list;
    private Historico historico;
    private String sql;

    public void insertHistorico(Historico historico) throws SQLException
    {
        sql = "INSERT INTO historico (PROCESSO, EVENTO, VALOR, USUARIO, DATA)" +
              "VALUES (?, ?, ?, ?, ?)";

         if(!FabricaConexoes.verificaConexao())
                FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, historico.getProcesso());
        stm.setString(2, historico.getEvento());
        stm.setString(3, historico.getValor());
        stm.setInt(4, historico.getUsuario());
        stm.setDate(5,(Date) historico.getData());

        stm.execute();
        stm.close();
        FabricaConexoes.closeConnection();
    }

    public ArrayList<Historico> getAll()throws SQLException
    {
        sql = "SELECT * FROM historico";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        rs = stm.executeQuery(sql);

        list = new ArrayList<Historico>();

        while(rs.next())
        {
            historico = new Historico();

            historico.setId(rs.getInt("IDHISTORICO"));
            historico.setProcesso(rs.getInt("PROCESSO"));
            historico.setEvento(rs.getString("EVENTO"));
            historico.setUsuario(rs.getInt("USUARIO"));
            historico.setValor(rs.getString("VALOR"));
            historico.setData(rs.getDate("DATA"));

            list.add(historico);
        }

        FabricaConexoes.closeConnection();
        
        return list;
    }

    public ArrayList<Historico> getAll(int processo) throws SQLException
    {
        sql = "SELECT * FROM historico WHERE processo = ?";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm.setInt(1, processo);

        rs = stm.executeQuery(sql);

        list = new ArrayList<Historico>();

        while(rs.next())
        {
            historico = new Historico();

            historico.setId(rs.getInt("IDHISTORICO"));
            historico.setProcesso(rs.getInt("PROCESSO"));
            historico.setEvento(rs.getString("EVENTO"));
            historico.setUsuario(rs.getInt("USUARIO"));
            historico.setValor(rs.getString("VALOR"));
            historico.setData(rs.getDate("DATA"));

            list.add(historico);
        }

        FabricaConexoes.closeConnection();

        return list;
    }

    public ArrayList<Historico> getHistorico(int id) throws SQLException
    {
        sql = "SELECT * FROM historico WHERE idhistorico = ?";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm.setInt(1, id);

        rs = stm.executeQuery(sql);

        list = new ArrayList<Historico>();

        while(rs.next())
        {
            historico = new Historico();

            historico.setId(rs.getInt("IDHISTORICO"));
            historico.setProcesso(rs.getInt("PROCESSO"));
            historico.setEvento(rs.getString("EVENTO"));
            historico.setUsuario(rs.getInt("USUARIO"));
            historico.setValor(rs.getString("VALOR"));
            historico.setData(rs.getDate("DATA"));

            list.add(historico);
        }

        FabricaConexoes.closeConnection();

        return list;
    }
}
