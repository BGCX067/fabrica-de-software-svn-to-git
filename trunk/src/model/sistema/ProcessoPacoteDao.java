/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.sistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Util.FabricaConexoes;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrador
 */
public class ProcessoPacoteDao
{

    private String sql;
    private PreparedStatement stm;
    private ResultSet rs;
    private ArrayList<ProcessoPacote> list;
    private ProcessoPacote processopacote;

public boolean insertProcessoPacote(ProcessoPacote processopacote)throws SQLException
	{
                try
                {
		sql = "INSERT INTO pacote_processo (idprocesso, idpacote) VALUES (?,?)";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);

		if(processopacote.getId_processo() == 0 || processopacote.getId_pacote() == 0)
                {
                    throw new SQLException("Código de referência não encontrado, verifique!");
                }
                stm.setInt(1, processopacote.getId_processo());
                stm.setInt(2, processopacote.getId_pacote());
		stm.execute();

		stm.close();
                FabricaConexoes.closeConnection();
                return true;
                }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null,"Erro interno: "+ e.getMessage(),"Erro",0);
                   FabricaConexoes.closeConnection();
                   return false;
                }
	}
        public ArrayList<ProcessoPacote> getAll()throws SQLException
	{
		sql = "SELECT * FROM pacote_processo";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		rs = stm.executeQuery();

		list = new ArrayList<ProcessoPacote>();

		while(rs.next())
		{
			processopacote = new ProcessoPacote();
			processopacote.setId_processo(rs.getInt("IDPROCESSO"));
			processopacote.setId_pacote(rs.getInt("IDPACOTE"));
			list.add(processopacote);
		}
                FabricaConexoes.closeConnection();
		return list;
	}
        public ProcessoPacote getProcessoPacote(int id_proc, int id_pac)throws SQLException, NullPointerException
	{
		sql = "SELECT * FROM pacote_processo WHERE idprocesso = ? and idpacote = ?";

		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		stm.setInt(1, id_proc);
                stm.setInt(2, id_pac);
		rs = stm.executeQuery();

		processopacote = new ProcessoPacote();
		rs.next();
		processopacote.setId_processo(rs.getInt("idprocesso"));
		processopacote.setId_pacote(rs.getInt("idpacote"));

                FabricaConexoes.closeConnection();
		return processopacote;
	}

        public ProcessoPacote getProcessoPacote(ProcessoPacote procpac)throws SQLException, NullPointerException
	{
		sql = "SELECT * FROM pacote_processo WHERE idprocesso = ? AND idpacote = ?";
		if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
		stm = FabricaConexoes.returnStatement(sql);
		stm.setInt(1, procpac.getId_processo());
		stm.setInt(2, procpac.getId_pacote());
		rs = stm.executeQuery();

		procpac = new ProcessoPacote();
		rs.next();
		procpac.setId_processo(rs.getInt("idprocesso"));
		procpac.setId_pacote(rs.getInt("idpacote"));

		rs.close();
		stm.close();
                FabricaConexoes.closeConnection();
		return procpac;
	}

        public boolean deleteProcessoPacote(ProcessoPacote procpac)throws SQLException
	{
		try
                {
                    sql = "DELETE FROM pacote_processo WHERE idprocesso = ? and idpacote = ?";

                    if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                    stm = FabricaConexoes.returnStatement(sql);

                    int idproc = procpac.getId_processo();
                    int idpac = procpac.getId_pacote();
                    if(idproc == 0 || idpac == 0)
                    {
                        throw new SQLException("Não há registro selecionado!");
                    }
                    stm.setInt(1, procpac.getId_processo());
                    stm.setInt(2, procpac.getId_pacote());

                    stm.execute();
                    stm.close();
                    FabricaConexoes.closeConnection();
                    return true;
                }catch(SQLException sqle)
                {
                    JOptionPane.showMessageDialog(null,"Erro interno : "+sqle.getMessage(),"Erro",0);
                    FabricaConexoes.closeConnection();
                    return false;
                }
	}

}
