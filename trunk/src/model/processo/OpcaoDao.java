package model.processo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Util.FabricaConexoes;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class OpcaoDao
{
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;
    private String sql;
    private Opcao opcao;
    private ArrayList<Opcao> list;
	
    public void insertOpcao(Opcao opcao)throws SQLException
    {
        sql = "INSERT INTO OPCAO (FINALIZACAO, NOME, VALOR,STATUS) VALUES (?,?,?,?)";

        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);

        stm.setInt(1, opcao.getFinalizacao());
        stm.setString(2, opcao.getNome());
        stm.setString(3, opcao.getValor());
        stm.setInt(4, opcao.getStatus());
        stm.execute();
        FabricaConexoes.closeConnection();
    }

    public void inserOpcao(ArrayList<Opcao> list, int finalizacao) throws SQLException
    {
        for(Opcao op : list)
        {
            op.setFinalizacao(finalizacao);
            insertOpcao(op);
        }
    }
	
    public ArrayList<Opcao> getAll(int finalizacao)throws SQLException
    {
        sql = "SELECT * FROM OPCAO WHERE FINALIZACAO = ?";

        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);

        stm.setInt(1, finalizacao);
        rs = stm.executeQuery();
        list = new ArrayList<Opcao>();

        while(rs.next())
        {    
            opcao = new Opcao();
            opcao.setId(rs.getInt("idopcao"));
            opcao.setFinalizacao(rs.getInt("finalizacao"));
            opcao.setNome(rs.getString("nome"));
            opcao.setValor(rs.getString("valor"));
            list.add(opcao);
        }
        FabricaConexoes.closeConnection();
        return list;

    }

    public void updateOpcao(Opcao opcao)throws SQLException
    {
        sql = "UPDATE OPCAO SET nome = ?,valor =?, status =? where idopcao = ?";

        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);

        stm.setString(1, opcao.getNome());
        stm.setString(2, opcao.getValor());
        stm.setInt(3, opcao.getStatus());
        stm.setInt(4, opcao.getId());
        stm.execute();
        stm.close();
        FabricaConexoes.closeConnection();
    }

    public void deleteOpcao(Opcao opcao)throws SQLException
    {
        sql = "DELETE FROM OPCAO WHERE IDOPCAO = ?";


        if(!FabricaConexoes.verificaConexao())FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, opcao.getId());
        stm.execute();
        stm.close();
        FabricaConexoes.closeConnection();
    }

}
