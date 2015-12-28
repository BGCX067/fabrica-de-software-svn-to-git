package model.processo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.FabricaConexoes;
import java.security.Principal;
import javax.swing.JOptionPane;
import model.processo.Atividade;

public class AtividadeDao
{
	
	private PreparedStatement stm;
	private ResultSet rs;
	private String sql;
	private Atividade atividade;
	private ArrayList<Atividade> list;

	
	public void insertAtividade(Atividade atividade)throws SQLException
	{
		sql = "INSERT INTO atividade (NOME, DESCRICAO, USER_MODIF, AUTOR, STATUS)" +
				"VALUES(?,?,?,?,?)";
		
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
		stm.setString(1, atividade.getNome());
		stm.setString(2, atividade.getDescricao());
		
		stm.setInt(3, atividade.getUserModif());
		stm.setInt(4, atividade.getAutor());
		stm.setInt(5, atividade.getStatus());
		
		stm.execute();
		
		stm.close();
                FabricaConexoes.closeConnection();
	}
	
	public ArrayList<Atividade> getAll()throws SQLException
	{
		sql = "SELECT * FROM ATIVIDADE";
		
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
		rs = stm.executeQuery();
		
		list = new ArrayList<Atividade>();
		
		while(rs.next())
		{
			atividade = new Atividade();
			atividade.setId(rs.getInt("idatividade"));
			atividade.setNome(rs.getString("nome"));
			atividade.setDescricao(rs.getString("descricao"));
			
			atividade.setUserModif(rs.getInt("User_Modif"));
			atividade.setAutor(rs.getInt("autor"));
			atividade.setStatus(rs.getInt("status"));
			
			list.add(atividade);
		}
		FabricaConexoes.closeConnection();
		return list;
	}

	public Atividade getAtividade(int id)throws SQLException, NullPointerException
{
	sql = "SELECT * FROM ATIVIDADE WHERE idatividade = ?";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
	stm.setInt(1, id);
	rs = stm.executeQuery();
	
	atividade = new Atividade();
	rs.next();
	atividade.setId(rs.getInt("idatividade"));
	atividade.setNome(rs.getString("nome"));
	atividade.setDescricao(rs.getString("descricao"));
	
        atividade.setUserModif(rs.getInt("User_Modif"));
	atividade.setAutor(rs.getInt("autor"));
	atividade.setStatus(rs.getInt("status"));
	
	FabricaConexoes.closeConnection();
	return atividade;
}

      public Finalizacao getFinalizacao(int id)throws SQLException, NullPointerException
      {
        sql = "SELECT * FROM FINALIZACAO WHERE idfinalizacao = ?";
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, id);
        rs = FabricaConexoes.returnResult(stm);
        Finalizacao fin = new Finalizacao();
        rs.next();
        fin.setId(rs.getInt("idfinalizacao"));
        fin.setNome(rs.getString("nome"));
        rs.close();
        stm.close();
        FabricaConexoes.closeConnection();
        return fin;
      }


public Atividade getAtividade(Atividade Atividade)throws SQLException, NullPointerException
{
	sql = "SELECT * FROM ATIVIDADE WHERE nome = ?";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
	stm.setString(1, Atividade.getNome());
	rs = stm.executeQuery();
	atividade = new Atividade();
	rs.next();
	atividade.setId(rs.getInt("idatividade"));
	atividade.setNome(rs.getString("nome"));
	atividade.setDescricao(rs.getString("descricao"));
	
	atividade.setUserModif(rs.getInt("User_Modif"));
	atividade.setAutor(rs.getInt("autor"));
	atividade.setStatus(rs.getInt("status"));
	
	
	rs.close();
	stm.close();
        FabricaConexoes.closeConnection();
	return atividade;
}

public void updateAtividade(Atividade atividade)throws SQLException
{
	sql = "UPDATE atividade SET nome = ?, descricao = ?, user_modif = ?, status = ? WHERE idatividade = ? ";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
        stm = FabricaConexoes.returnStatement(sql);
	
	stm.setString(1, atividade.getNome());
	stm.setString(2, atividade.getDescricao());
	
	stm.setInt(3, atividade.getUserModif());
	stm.setInt(4, atividade.getStatus());
	
	stm.setInt(5, atividade.getId());
	stm.execute();
	stm.close();
        FabricaConexoes.closeConnection();
	
}

public void deleteAtividade(Atividade atividade)throws SQLException
{
	sql = "DELETE FROM atividade WHERE idatividade = ?";
	
        if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
              stm = FabricaConexoes.returnStatement(sql);
	
	stm.setInt(1, atividade.getId());
	
	stm.execute();
	stm.close();
	FabricaConexoes.closeConnection();
}

    public void insertAtividadeFinalizacao(int idativ, int idfin)throws SQLException
        {
            sql = "INSERT INTO ATIVIDADE_FINALIZACAO (ID_ATIV,ID_FIN) VALUES (?,?)";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                  stm = FabricaConexoes.returnStatement(sql);

            stm.setInt(1, idativ);
            stm.setInt(2,idfin);
            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Finalização incluída com sucesso!","Inserção",1);
            FabricaConexoes.closeConnection();

        }
    public void deleteAtividadeFinalizacao(int idativ, int idfin)throws SQLException
        {
            sql = "DELETE FROM ATIVIDADE_FINALIZACAO WHERE ID_ATIV = ? AND ID_FIN = ?";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                  stm = FabricaConexoes.returnStatement(sql);

            stm.setInt(1, idativ);
            stm.setInt(2,idfin);
            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Finalização exclusa com sucesso!","Exclusão",1);
            FabricaConexoes.closeConnection();

        }
        public void insertAtivFin(int idproc, int idat,int chave,int raiz, int idfin, int link)throws SQLException
        {
            sql = "INSERT INTO processo_atividade (IDproc,IDat,chave,raiz,idfin,link) VALUES (?,?,?,?,?,?)";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                  stm = FabricaConexoes.returnStatement(sql);

            stm.setInt(1, idproc);
            stm.setInt(2,idat);
            stm.setInt(3,chave);
            stm.setInt(4,raiz);
            stm.setInt(5,idfin);
            stm.setInt(6,link);
            stm.execute();
            
            stm.close();
            JOptionPane.showMessageDialog(null, "!","Inserção",1);
            FabricaConexoes.closeConnection();

        }

        public void deleteAtivFin(int idproc, int chave)throws SQLException
        {
            sql = "DELETE FROM processo_atividade WHERE IDproc = ? AND chave = ?";

            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                  stm = FabricaConexoes.returnStatement(sql);

            stm.setInt(1, idproc);
            stm.setInt(2,chave);
            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Finalização exclusa com sucesso!","Exclusão",1);
            FabricaConexoes.closeConnection();

        }

}

