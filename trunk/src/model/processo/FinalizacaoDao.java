package model.processo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Util.FabricaConexoes;

public class FinalizacaoDao
{
    private PreparedStatement stm;
    private ResultSet rs;
    private String sql;
    private Finalizacao finalizacao;
    private ArrayList<Finalizacao> list;
 	
    public void insertFinalizacao(Finalizacao finalizacao)throws SQLException
    {
        sql = "INSERT INTO finalizacao VALUES (?,?,?,?,?)";

       if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, finalizacao.getId());
        stm.setString(2, finalizacao.getNome());
        stm.setString(3, finalizacao.getValor());
        stm.setInt(4, finalizacao.getStatus());
        stm.setString(5, finalizacao.getPergunta());
        stm.execute();
        stm.close();
 
        FabricaConexoes.closeConnection();
    }
	
    public ArrayList<Finalizacao> getAll()throws SQLException
    {
        sql = "SELECT * FROM FINALIZACAO";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        rs = FabricaConexoes.returnResult(stm);

        list = new ArrayList<Finalizacao>();
        

        while(rs.next())
        {
            finalizacao = new Finalizacao();
            finalizacao.setId(rs.getInt("idfinalizacao"));
            finalizacao.setNome(rs.getString("nome"));
            finalizacao.setValor(rs.getString("Valor"));
            finalizacao.setStatus(rs.getInt("Status"));
            finalizacao.setPergunta(rs.getString("pergunta"));
            list.add(finalizacao);
        }
        FabricaConexoes.closeConnection();
        return list;
    }
    public ArrayList<Finalizacao> getAllAtivos()throws SQLException
    {
        sql = "SELECT * FROM FINALIZACAO where status = 0";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        rs = FabricaConexoes.returnResult(stm);

        list = new ArrayList<Finalizacao>();
        

        while(rs.next())
        {
            finalizacao = new Finalizacao();
            finalizacao.setId(rs.getInt("idfinalizacao"));
            finalizacao.setNome(rs.getString("nome"));
            finalizacao.setValor(rs.getString("Valor"));
            finalizacao.setStatus(rs.getInt("Status"));
            finalizacao.setPergunta(rs.getString("pergunta"));
            list.add(finalizacao);
        }
        FabricaConexoes.closeConnection();
        return list;
    }

    public Finalizacao getFinalizacao(int id)throws SQLException, NullPointerException
    {
        sql = "SELECT * FROM finalizacao WHERE idfinalizacao = ?";

        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, id);
        rs = FabricaConexoes.returnResult(stm);
        finalizacao = new Finalizacao();
        rs.next();
        finalizacao.setId(rs.getInt("idfinalizacao"));
        finalizacao.setNome(rs.getString("nome"));
        finalizacao.setValor(rs.getString("Valor"));
        finalizacao.setStatus(rs.getInt("Status"));
        finalizacao.setPergunta(rs.getString("pergunta"));
        FabricaConexoes.closeConnection();
        return finalizacao;
    }

    public Finalizacao getFinalizacao(Finalizacao Finalizacao)throws SQLException, NullPointerException
    {
        sql = "SELECT * FROM finalizacao WHERE nome = ?";

        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
        stm.setString(1, Finalizacao.getNome());
        rs = FabricaConexoes.returnResult(stm);
        finalizacao = new Finalizacao();
        rs.next();
        finalizacao.setId(rs.getInt("idfinalizacao"));
        finalizacao.setNome(rs.getString("nome"));
        finalizacao.setValor(rs.getString("Valor"));
        finalizacao.setStatus(rs.getInt("Status"));
        finalizacao.setPergunta(rs.getString("pergunta"));
        rs.close();
        stm.close();
        FabricaConexoes.closeConnection();
        return finalizacao;
    }

    public void updateFinalizacao(Finalizacao finalizacao)throws SQLException
    {
        sql = "UPDATE finalizacao SET nome = ? , valor = ?, status = ?, pergunta = ? WHERE idfinalizacao = ?";

        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
        stm.setString(1, finalizacao.getNome());
        stm.setString(2, finalizacao.getValor());
        stm.setInt(3, finalizacao.getStatus());
        stm.setString(4, finalizacao.getPergunta());
        stm.setInt(5, finalizacao.getId());
        stm.execute();
        stm.close();
        FabricaConexoes.closeConnection();
    }

    public void deleteFinalizacao(Finalizacao finalizacao)throws SQLException
    {
        sql = "DELETE FROM finalizacao WHERE idfinalizacao = ?";
              

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, finalizacao.getId());

        stm.execute();
        stm.close();
        FabricaConexoes.closeConnection();
    }
}

