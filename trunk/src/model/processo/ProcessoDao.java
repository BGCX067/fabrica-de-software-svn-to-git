package model.processo;

import Util.FabricaConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.sistema.Usuario;
import model.sistema.UsuarioDao;

public class ProcessoDao
{
    private Connection con;
    private PreparedStatement stm;
    private String sql;
    private ResultSet rs;
    private ArrayList<Processo> list;
    private Processo processo;

    public void insertProcesso(Processo processo) throws SQLException
    {
        sql =   "INSERT INTO PROCESSO" +
                    "(nome, descricao, autor, dta_criacao, versao, status, idgestor)" +
                "VALUES" +
                    "(?, ?, ?, ?, ?, ?,?)";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        stm.setString(1, processo.getNome());
        stm.setString(2, processo.getDescricao());
        stm.setInt(3, processo.getAutor().getId());
        stm.setDate(4, new java.sql.Date(processo.getDatacriacao().getTime()));
        stm.setString(5, processo.getVersao());
        stm.setInt(6, processo.getStatus());
        Usuario user = processo.getGestor();
        stm.setInt(7, user.getId());
        stm.execute();
        stm.close();
        FabricaConexoes.closeConnection();
    }

    public void updateProcesso(Processo processo)throws SQLException
    {
        sql = "UPDATE processo SET " +
                    "nome = ?, " +
                    "descricao = ?, " +
                    "versao = ?, " +
                    "status = ?, " +
                    "idgestor = ? " +
               "WHERE " +
                    "idprocesso = ?";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        stm.setString(1, processo.getNome());
        stm.setString(2, processo.getDescricao());
        stm.setString(3, processo.getVersao());
        stm.setInt(4, processo.getStatus());
        stm.setInt(5, processo.getGestor().getId());
        stm.setInt(6, processo.getIdproceso());
        stm.execute();
        stm.close();
        FabricaConexoes.closeConnection();
    }

    public ArrayList<Processo> getAll()throws SQLException
    {
        sql = "SELECT * FROM PROCESSO";

        UsuarioDao userdao = new UsuarioDao();

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        rs = FabricaConexoes.returnResult(stm);

        list = new ArrayList<Processo>();

        while(rs.next())
        {
            processo = new Processo();
            processo.setIdproceso(rs.getInt("IDPROCESSO"));
            processo.setNome(rs.getString("NOME"));
            processo.setDescricao(rs.getString("DESCRICAO"));
            processo.setAutor(userdao.getUsuario(rs.getInt("AUTOR")));
            processo.setVersao(rs.getString("VERSAO"));
            processo.setStatus(rs.getInt("STATUS"));
            processo.setDatacriacao(rs.getDate("DTA_CRIACAO"));
            processo.setGestor(userdao.getUsuario(rs.getInt("idgestor")));

            list.add(processo);
        }
        FabricaConexoes.closeConnection();
        return list;
    }

    public void deleteProcesso(Processo processo)throws SQLException
    {
        sql = "DELETE FROM processo WHERE idprocesso = ?";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, processo.getIdproceso());
        stm.execute();
        stm.close();
        FabricaConexoes.closeConnection();
    }

    public Processo getProcesso(int id)throws SQLException
    {
        UsuarioDao userdao = new UsuarioDao();

        sql = "SELECT * FROM processo WHERE idprocesso = ?";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, id);
        rs = FabricaConexoes.returnResult(stm);
        processo = new Processo();
        rs.next();
        processo.setIdproceso(rs.getInt("IDPROCESSO"));
        processo.setNome(rs.getString("NOME"));
        processo.setDescricao(rs.getString("DESCRICAO"));
        processo.setAutor(userdao.getUsuario(rs.getInt("AUTOR")));
        processo.setVersao(rs.getString("VERSAO"));
        processo.setStatus(rs.getInt("STATUS"));
        processo.setDatacriacao(rs.getDate("DTA_CRIACAO"));
        processo.setGestor(userdao.getUsuario(rs.getInt("idgestor")));
        return processo;
    }
}
