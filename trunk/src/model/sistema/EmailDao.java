package model.sistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Util.FabricaConexoes;

public class EmailDao
{
    private Connection con;
    private String sql;
    private PreparedStatement stm;
    private ResultSet rs;
    private ArrayList<Email> list;
    private Email email;


    public void insertEmail(Email email)throws SQLException
    {
        sql = "INSERT INTO EMAIL (nome, email, senha, pop, smtp) VALUES (?,?,?,?,?)";

        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);

        stm.setString(1, email.getNome());
        stm.setString(2, email.getEmail());
        stm.setString(3, email.getSenha());
        stm.setString(4, email.getPop());
        stm.setString(5, email.getSmtp());
        stm.execute();

        stm.close();
        con.close();
    }

    public ArrayList<Email> getAll()throws SQLException
    {
        sql = "SELECT * FROM EMAIL";

        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);

        rs = stm.executeQuery();

        list = new ArrayList<Email>();

        while(rs.next())
        {
                email = new Email();
                email.setId(rs.getInt("idemail"));
                email.setNome(rs.getString("nome"));
                email.setEmail(rs.getString("email"));
                email.setSenha(rs.getString("senha"));
                email.setPop(rs.getString("pop"));
                email.setSmtp(rs.getString("smtp"));

                list.add(email);
        }

        return list;
    }

    public Email getEmail(int id)throws SQLException, NullPointerException
    {
        sql = "SELECT * FROM EMAIL WHERE idemail = ?";

        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);

        stm.setInt(1, id);
        rs = stm.executeQuery();

        email = new Email();
        rs.next();
        email.setId(rs.getInt("idemail"));
        email.setNome(rs.getString("nome"));
        email.setEmail(rs.getString("email"));
        email.setSenha(rs.getString("senha"));
        email.setPop(rs.getString("pop"));
        email.setSmtp(rs.getString("smtp"));

        return email;
    }

    public Email getEmail(Email email)throws SQLException, NullPointerException
    {
        sql = "SELECT * FROM EMAIL WHERE nome = ? AND email= ? AND senha = ? ";

        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);

        stm.setString(1, email.getNome());
        stm.setString(2, email.getEmail());
        stm.setString(3, email.getSenha());
        rs = stm.executeQuery();

        email = new Email();
        rs.next();
        email.setId(rs.getInt("idemail"));
        email.setNome(rs.getString("nome"));
        email.setEmail(rs.getString("email"));
        email.setSenha(rs.getString("senha"));
        email.setPop(rs.getString("pop"));
        email.setSmtp(rs.getString("smtp"));

        rs.close();
        stm.close();
        con.close();

        return email;
    }

    public void updateEmail(Email email)throws SQLException
    {
        sql = "UPDATE email SET nome = ?, email = ?, senha = ?, pop = ?, smtp =? WHERE idemail = ?";

        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);

        stm.setString(1, email.getNome());
        stm.setString(2, email.getEmail());
        stm.setString(3, email.getSenha());
        stm.setString(4, email.getPop());
        stm.setString(5, email.getSmtp());
        stm.setInt(6, email.getId());

        stm.execute();
        stm.close();
        con.close();
    }

    public void deleteEmail(Email email)throws SQLException
    {
        sql = "DELETE FROM email WHERE idemail = ?";

        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);

        stm.setInt(1, email.getId());

        stm.execute();
        stm.close();
        con.close();
    }
}
