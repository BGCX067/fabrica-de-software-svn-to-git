package model.sistema;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Util.FabricaConexoes;
import javax.swing.JOptionPane;

public class MenuGrupoDao
{
    private String sql;
    private PreparedStatement stm;
    private ResultSet rs;
    private ArrayList<MenuGrupo> list;
    private MenuGrupo menugrupo;

    public boolean insertMenuGrupo(MenuGrupo menugrupo)throws SQLException
    {
        try
        {
            sql = "INSERT INTO item_menu_Grupo VALUES (?,?,?)";

            if(!FabricaConexoes.verificaConexao())
                FabricaConexoes.getConexao();

            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, menugrupo.getIdItem());
            stm.setInt(2, menugrupo.getIdGrupo());
            stm.setInt(3, menugrupo.getFlag());
            stm.execute();
            stm.close();
            FabricaConexoes.closeConnection();
            return true;
        }
        catch(SQLException e)
        {
            int erro = e.getErrorCode();

            switch(erro)
            {
                case 1062 :
                return false;
                default :
                JOptionPane.showMessageDialog(null,"Erro interno: "+ e.getErrorCode(),"Erro",0);
                return false;
            }
        }
    }

    public ArrayList<MenuGrupo> getAll()throws SQLException
    {
        sql = "SELECT * FROM item_menu_grupo";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        rs = stm.executeQuery();

        list = new ArrayList<MenuGrupo>();

        while(rs.next())
        {
            menugrupo = new MenuGrupo();
            menugrupo.setIdItem(rs.getInt("ID_ITEM"));
            menugrupo.setIdGrupo(rs.getInt("ID_GRUPO"));
            menugrupo.setFlag(rs.getInt("FLAG_DISP"));
            list.add(menugrupo);
        }

        return list;
    }

    public ArrayList<MenuGrupo> getAllGrupo(Grupo grupo) throws SQLException
    {
        sql = "SELECT * FROM item_menu_grupo where id_grupo = ?";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, grupo.getId());
        rs = stm.executeQuery();

        list = new ArrayList<MenuGrupo>();

        while(rs.next())
        {
            menugrupo = new MenuGrupo();
            menugrupo.setIdItem(rs.getInt("ID_ITEM"));
            menugrupo.setIdGrupo(rs.getInt("ID_GRUPO"));
            menugrupo.setFlag(rs.getInt("FLAG_DISP"));
            list.add(menugrupo);
        }
        return list;
    }

    public MenuGrupo getMenuGrupo(int id_item)throws SQLException, NullPointerException
    {
        sql = "SELECT * FROM ITEM_MENU_GRUPO WHERE id_item = ?";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, id_item);
        rs = stm.executeQuery();

        menugrupo = new MenuGrupo();
        rs.next();
        menugrupo.setIdItem(rs.getInt("ID_ITEM"));
        menugrupo.setIdGrupo(rs.getInt("ID_GRUPO"));
        menugrupo.setFlag(rs.getInt("FLAG_DISP"));

        return menugrupo;
    }

    public MenuGrupo getMenuGrupoId(int id_grupo)throws SQLException, NullPointerException
    {
        sql = "SELECT * FROM ITEM_MENU_GRUPO WHERE id_grupo = ?";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, id_grupo);
        rs = stm.executeQuery();

        menugrupo = new MenuGrupo();
        rs.next();
        menugrupo.setIdItem(rs.getInt("ID_ITEM"));
        menugrupo.setIdGrupo(rs.getInt("ID_GRUPO"));
        menugrupo.setFlag(rs.getInt("FLAG_DISP"));

        return menugrupo;
    }

    public MenuGrupo getMenuGrupo(MenuGrupo menugrupo)throws SQLException, NullPointerException
    {
        sql = "SELECT * FROM ITEM_MENU_GRUPO WHERE id_item = ? AND id_grupo = ? AND flag_disp = ?";

        if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, menugrupo.getIdItem());
        stm.setInt(2, menugrupo.getIdGrupo());
        stm.setInt(3, menugrupo.getFlag());
        rs = stm.executeQuery();
        menugrupo = new MenuGrupo();
        rs.next();
        menugrupo.setIdItem(rs.getInt("id_item"));
        menugrupo.setIdGrupo(rs.getInt("id_grupo"));
        menugrupo.setFlag(rs.getInt("flag_disp"));

        rs.close();
        stm.close();

        return menugrupo;
    }

    public boolean updateMenuGrupo(MenuGrupo menugrupo)throws SQLException
    {
        try
        {
            sql = "UPDATE item_menu_grupo SET flag_disp = ? where id_item = ? and id_grupo = ?";

            if(!FabricaConexoes.verificaConexao())
                FabricaConexoes.getConexao();

            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, menugrupo.getFlag());
            stm.setInt(2,menugrupo.getIdItem());
            stm.setInt(3,menugrupo.getIdGrupo());
            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null,"Menu atualizado com sucesso!","Update", 1);

            return true;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Erro Interno: "+ e.getMessage(),"Erro", 0);
            return false;
        }
    }

    public boolean deleteMenuGrupo(MenuGrupo menugrupo)throws SQLException
    {
        try
        {
            sql = "DELETE FROM item_menu_grupo WHERE id_item = ? and id_grupo = ?";

            if(!FabricaConexoes.verificaConexao())
            FabricaConexoes.getConexao();

            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, menugrupo.getIdItem());
            stm.setInt(2,menugrupo.getIdGrupo());
            stm.execute();
            stm.close();
            return true;
        }
        catch(SQLException sqle)
        {
            JOptionPane.showMessageDialog(null,"Erro interno : "+sqle.getMessage(),"Erro",0);
            return false;
        }
    }
}
