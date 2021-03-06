
package atualiza;

import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;

import java.util.ArrayList;
/**
 *
 * @author Administrador
 */
public class manipulaConexao
{
    private static String usuario;
    private static String senha;

    private static Statement stm = null; //atributo que representa a transição
    public static ResultSet result = null;//atributo que representa os resultados de busca

       
        public static void setUser(String user)
        {
            usuario = user;
        }
        public static void setSenha(String pass)
        {
            senha = pass;
        }
        public static String getUser()
        {
            return usuario;
        }
        public static String getSenha()
        {
            return senha;
        }


       public static void preenchetable(JTable tabela,String query)
       {

           if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
           stm = FabricaConexoes.returnStatement(query);

           try{


            try{
                   //preenche a variável result com o resultado do comando passado para a transação
                   result = stm.executeQuery(query);

                   }catch(SQLException sql)
                   {//mensagem repassada ao usuário em caso de erro
                       JOptionPane.showMessageDialog(null,"Erro ao executar o comando! " + sql.getMessage(),"Erro",0);
                   }

            result.last();//move o ponteiro de result para o último dado do resultado
            int numerolinhas = result.getRow();//insere em uma variável inteiro a quantidade de linhas do resultado
            result.first();//move o ponteiro de result para o primeiro dado do resultado
            ResultSetMetaData meta = result.getMetaData();//insere os dados do resultado para a variavel meta
            int numerocolunas = meta.getColumnCount();//insere em uma variável interio a quantidade de colunas do resultado
            //System.out.println(numerolinhas+","+numerocolunas );
            Object[][] objeto  = new Object[numerolinhas][numerocolunas];//cria um objeto genérico para receber qualquer tipo de dado que tenh sido retornado
            String[] nomes = new String[numerocolunas];//cria uma lista com os nomes das colunas do resultado
            for(int i=0;i<numerolinhas;i++)//looping para preencher o objeto genérico com os dados
            {

              for(int j=0;j<numerocolunas;j++)
              {
                //insere na matriz o dado conforme sua posição(linha)
                objeto[i][j] = result.getObject(j+1);
                nomes[j] = meta.getColumnLabel(j+1);//a lista recebe o nome de coluna correspondente
              }
              //move o ponteiro do result para o próximo dado
              result.next();
            }
            TableModel modelo;
            //cria uma tabela interna para receber os dados
           stm.close();
           result.close();
           FabricaConexoes.closeConnection();
        modelo = new DefaultTableModel(objeto, nomes){
            public boolean isCellEditable(int rowIndex, int mColIndex) { //essa parte do código torna a tabela somente leitura
                return false;
            }



        };
       
            //transcreve os dados para a tabela passada como parâmetro
            tabela.setModel(modelo);

       }catch(SQLException sql)
       {//mensagem repassada ao usuário em caso de erro
           JOptionPane.showMessageDialog(null,"Ocorreu um erro no preenchimento da tabela.\n " + sql.getMessage(),"Erro",0);
           FabricaConexoes.closeConnection();
       }
           FabricaConexoes.closeConnection();
       }

       public static void insereFormFin(int id_form, int id_fin)
        {

           if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexao();
           CallableStatement proc = null;
           Connection con = FabricaConexoes.retornaconnection();

       try
       {
          proc = con.prepareCall("{ call proc_insereformulario(?, ?) }");
          proc.setInt(1,id_form);
          proc.setInt(2, id_fin);
          proc.execute();
          FabricaConexoes.closeConnection();
       }catch(SQLException sql)
       {
            //
       }
            }

       public static void preenchetableMy(JTable tabela,String query)
       {

           if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexaoMy();
           stm = FabricaConexoes.returnStatement(query);

           try{


            try{
                   //preenche a variável result com o resultado do comando passado para a transação
                   result = stm.executeQuery(query);

                   }catch(SQLException sql)
                   {//mensagem repassada ao usuário em caso de erro
                       JOptionPane.showMessageDialog(null,"Erro ao executar o comando! " + sql.getMessage(),"Erro",0);
                   }

            result.last();//move o ponteiro de result para o último dado do resultado
            int numerolinhas = result.getRow();//insere em uma variável inteiro a quantidade de linhas do resultado
            result.first();//move o ponteiro de result para o primeiro dado do resultado
            ResultSetMetaData meta = result.getMetaData();//insere os dados do resultado para a variavel meta
            int numerocolunas = meta.getColumnCount();//insere em uma variável interio a quantidade de colunas do resultado
            //System.out.println(numerolinhas+","+numerocolunas );
            Object[][] objeto  = new Object[numerolinhas][numerocolunas];//cria um objeto genérico para receber qualquer tipo de dado que tenh sido retornado
            String[] nomes = new String[numerocolunas];//cria uma lista com os nomes das colunas do resultado
            for(int i=0;i<numerolinhas;i++)//looping para preencher o objeto genérico com os dados
            {

              for(int j=0;j<numerocolunas;j++)
              {
                //insere na matriz o dado conforme sua posição(linha)
                objeto[i][j] = result.getObject(j+1);
                nomes[j] = meta.getColumnLabel(j+1);//a lista recebe o nome de coluna correspondente
              }
              //move o ponteiro do result para o próximo dado
              result.next();
            }
            TableModel modelo;
            //cria uma tabela interna para receber os dados
           stm.close();
           result.close();
           FabricaConexoes.closeConnection();
        modelo = new DefaultTableModel(objeto, nomes){
            public boolean isCellEditable(int rowIndex, int mColIndex) { //essa parte do código torna a tabela somente leitura
                return false;
            }



        };

            //transcreve os dados para a tabela passada como parâmetro
            tabela.setModel(modelo);

       }catch(SQLException sql)
       {//mensagem repassada ao usuário em caso de erro
           JOptionPane.showMessageDialog(null,"Ocorreu um erro no preenchimento da tabela.\n " + sql.getMessage(),"Erro",0);
           FabricaConexoes.closeConnection();
       }
           FabricaConexoes.closeConnection();
       }




}
