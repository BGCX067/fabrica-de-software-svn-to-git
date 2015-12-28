/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.execucao;

import Util.FabricaConexoes;
import com.mysql.jdbc.util.ResultSetUtil;
import formularios.Exemplo;
import formularios.Exemplo2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Formulario {

        private PreparedStatement stm;
	private ResultSet rs;
        private ResultSetUtil rs2;
	private String sql;

        public void mostraFormulario(int id_fin)
        {
            int[] id_form;
            try
            {
                sql = "select id_formulario from tb_item_formulario where id_finalizacao = ?";
                if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
                stm = FabricaConexoes.returnStatement(sql);
                stm.setInt(1, id_fin);
                rs = FabricaConexoes.returnResult(stm);
                rs.last();//move o ponteiro de result para o último dado do resultado
                int numerolinhas = rs.getRow();//insere em uma variável inteiro a quantidade de linhas do resultado
                rs.first();//move o ponteiro de result para o primeiro dado do resultado
                id_form = new int[numerolinhas];
                for(int contador = 0;contador<numerolinhas; contador++)
                {
                    id_form[contador] = rs.getInt("id_formulario");
                    formularioespecifico(id_form[contador]);
                    rs.next();
                }
                stm.close();

                FabricaConexoes.closeConnection();
            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(),"Falha",0);
            }

        }

        private void formularioespecifico(int id)
        {

            switch(id)
            {
                case 0:

                    break;
                case 1:
                    new Exemplo(null, true).setVisible(true);
                    break;
                case 2:
                    new Exemplo2(null, true).setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Formulário não encontrado","Erro",0);
                    break;

            }


        }

        public void encontraFin(Transicao transicao, int chave)throws SQLException
        {
            sql = "select idfin from processo_atividade where idproc = ? and chave = ?";
            if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
            stm = FabricaConexoes.returnStatement(sql);
            stm.setInt(1, transicao.getIdproc());
            stm.setInt(2, chave);
            rs = FabricaConexoes.returnResult(stm);
            rs.next();
            int idfin = rs.getInt("idfin");
            rs.close();
            FabricaConexoes.closeConnection();
            mostraFormulario(idfin);
        }
}
