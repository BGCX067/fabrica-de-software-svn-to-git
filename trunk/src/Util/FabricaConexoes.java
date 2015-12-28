package Util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class FabricaConexoes 
{
	private static Connection con, oracle;
	private static String connect;

        public static String getConnect() {
            return connect;
        }

        public static void setConnect(String connect) {
            FabricaConexoes.connect = connect;
        }


	public static void getConexao()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connect, "root", "12345");
		} 
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Falha ao tentar conectar com banco de dados.\n"+e.getMessage());
		}

	}
        public static void ConectaOracle()
        {
            try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:oci8:@192.168.10.1:1521:orcl", "DR", "dr$siga21");
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Falha ao tentar conectar com banco de dados.\n"+e.getMessage());
		}
        }
        /*public static void getConexao(String connection)
        {
            try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connection, "root", "12345");
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Falha ao tentar conectar com banco de dados.\n"+e.getMessage());
		}
        }*/
        public static void closeConnection()
        {
            try{
                if(con == null) return;
                con.close();
                con = null;
                }catch(Exception e )
                {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar encerrar conexão.\n"+e.getMessage());
                }
        }

        public static void closeAllConnections()
        {
            try{
                while(con != null)
                {
                con.close();
                con = null;
                }
                }catch(Exception e )
                {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar encerrar conexão.\n"+e.getMessage());
                }
        }


        public static void commitconnection()
        {
            try{
                if(con == null) return;
                con.commit();
                }catch(Exception e )
                {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar encerrar conexão.\n"+e.getMessage());
                }
        }

        public static PreparedStatement returnStatement(String sql)
        {
            PreparedStatement stm;
            try{
                stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                 return stm;
                }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, "Falha :\n"+e.getMessage());
                   return null;
        }
        }

        public static ResultSet returnResult(PreparedStatement stm)
        {
            ResultSet rs;
            try{
                    rs = stm.executeQuery();
                    return rs;
                    }catch(SQLException e)
                        {
                            JOptionPane.showMessageDialog(null, "Falha :\n"+e.getMessage());
                            return null;
                            }
        }

        public static boolean verificaConexao()
        {
            boolean verifica = false;
            try{
                 if(con == null) return false;
                 //verifica = con.isClosed();
                 if(con.isClosed())
                 {
                     verifica = true;
                 }else{
                     verifica = false;
                 }
                 //JOptionPane.showMessageDialog(null, verifica);
                 return verifica;
                }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, "Falha :\n"+e.getMessage());
                   return verifica;
                }
        }
        public static Connection retornaconnection()
        {
            return con;
        }
}

