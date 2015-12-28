/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import atualiza.FabricaConexoes;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class atualizaDao {


    private PreparedStatement stm;
    private ResultSet rs;
    private String sql;

    public String consulta(String datain, String datafin)
    {
        String sql = "select * from vci_consulta_negociacao_vw where data_negociacao between '"
                + datain + "' and '" + datafin +
                "' and indr_status = 'E'and desc_categoria = 'NOVO'"+
                "and parempr_id = '1'"+
                "and indr_compra_vdi = 'N'";
        return sql;
    }

    public void ProcessaEntrada(String sql)
    {
        if(!FabricaConexoes.verificaConexao())
        {
            FabricaConexoes.getConexao();
        }

        stm = FabricaConexoes.returnStatement(sql);
        rs  = FabricaConexoes.returnResult(stm);
        PreparedStatement stm2 = stm;
        ResultSet rs2 = rs;
        
        FabricaConexoes.getConexaoMy();
        try{
        while(rs2.next())
        {
            long id_negociacao = rs2.getLong("ID_NEGOCIACAO");
            long id_vendadireta = rs2.getLong("ID_VENDADIRETA");
            long id_consorcio = rs2.getLong("ID_CONSORCIO");
            Date data_negociacao = rs2.getDate("DATA_NEGOCIACAO");
            Date data_abertura = rs2.getDate("DATA_ABERTURA");
            String status = rs2.getString("INDR_STATUS");
            double valr_desconto = rs2.getDouble("VALR_DESCONTO");
            String status_negociacao = rs2.getString("STATUS_NEGOCIACAO");
            String desc_origem = rs2.getString("DESC_ORIGEM");
            double valr_negocial = rs2.getDouble("VALR_NEGOCIAL");
            double valr_sugerido = rs2.getDouble("VALR_SUGERIDO");
            double valr_faturamento = rs2.getDouble("VALR_FATURAMENTO");
            String numr_cgc = rs2.getString("NUMR_CGC");
            String nome_razao_social = rs2.getString("NOME_RAZAO_SOCIAL");
            String codg_chassis = rs2.getString("CODG_CHASSIS");
            String desc_veiculo = rs2.getString("DESC_VEICULO");
            String codg_modelo = rs2.getString("CODG_MODELO");
            String desc_modelo = rs2.getString("DESC_MODELO");
            String codg_model_group = rs2.getString("CODG_MODEL_GROUP");
            String desc_model_group = rs2.getString("DESC_MODEL_GROUP");
            String categoria = rs2.getString("CATEGORIA");
            String desc_modalidade_compra = rs2.getString("DESC_MODALIDADE_COMPRA");
            long numr_nota_entrada = rs2.getLong("NUMR_NOTA_ENTRADA");
            int serie_nota_entrada = rs2.getInt("SERIE_NOTA_ENTRADA");
            long numr_nota_saida = rs2.getLong("NUMR_NOTA_SAIDA");
            int serie_nota_saida = rs2.getInt("SERIE_NOTA_SAIDA");
            double valr_nota_saida = rs2.getDouble("VALR_NOTA_SAIDA");
            int qtde_dias_estocagem = rs2.getInt("QTDE_DIAS_ESTOCAGEM");
            String nome_usuario = rs2.getString("NOME_USUARIO");
            String desc_logradouro = rs2.getString("DESC_LOGRADOURO");
            String desc_complemento = rs2.getString("DESC_COMPLEMENTO");
            String numr_logradouro = rs2.getString("NUMR_LOGRADOURO");
            String endereco = rs2.getString("ENDERECO");
            String nome_bairro = rs2.getString("NOME_BAIRRO");
            String nome_cidade = rs2.getString("NOME_CIDADE");
            String nome_uf = rs2.getString("NOME_UF");
            String numr_cep = rs2.getString("NUMR_CEP");
            String fone_contato = rs2.getString("FONE_CONTATO");
            String fone_celular = rs2.getString("FONE_CELULAR");
            String numr_cgc_entrada = rs2.getString("NUMR_CGC_ENTRADA");
            String razao_social_entrada  = rs2.getString("NOME_RAZAO_SOCIAL_ENTRADA");
            String email = rs2.getString("EMAIL");
            String financiamento = rs2.getString("DESC_FINANCIAMENTO");
            String desc_cor = rs2.getString("DESC_COR");
            long id_entidade_nf = rs2.getLong("ID_ENTIDADE_NF");

            sql = "Select * from tb_registra_venda_novos where id_dr = " + id_negociacao;
            stm2 = FabricaConexoes.returnStatement(sql);
            rs = FabricaConexoes.returnResult(stm2);
            if(rs.next())
            {
                //JOptionPane.showMessageDialog(null, "já tem");
                
            }else{

            sql = "Insert into tb_registra_venda_novos(ID_DR, ID_VENDADIRETA, ID_CONSORCIO, "
                    + "DATA_NEGOCIACAO, DATA_ABERTURA, STATUS, VALR_DESCONTO, STATUS_NEGOCIACAO "
                    + ",DESC_ORIGEM, VALR_NEGOCIAL, VALR_SUGERIDO, VALR_FATURAMENTO, NUMR_CGC,"
                    + "NOME_RAZAO_SOCIAL, CODG_CHASSIS, DESC_VEICULO, CODG_MODELO, DESC_MODELO, "
                    + "CODG_MODEL_GROUP, DESC_MODEL_GROUP, CATEGORIA, DESC_MODALIDADE_COMPRA, "
                    + "NUMR_NOTA_ENTRADA, SERIE_NOTA_ENTRADA,"
                    + "NUMR_NOTA_SAIDA, SERIE_NOTA_SAIDA, VALR_NOTA_SAIDA,QTDE_DIAS_ESTOCAGEM, NOME_USUARIO,"
                    + "DESC_LOGRADOURO, DESC_COMPLEMENTO, NUMR_LOGRADOURO, ENDERECO, NOME_BAIRRO, "
                    + "NOME_CIDADE, NOME_UF, NUMR_CEP, FONE_CONTATO, FONE_CELULAR, NUMR_CGC_ENTRADA,"
                    + "RAZAO_SOCIAL_ENTRADA, EMAIL,DESC_FINANCIAMENTO,DESC_COR, ID_ENTIDADE_NF ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            stm2 = FabricaConexoes.returnStatement(sql);
            stm2.setLong(1, id_negociacao);
            stm2.setLong(2, id_vendadireta);
            stm2.setLong(3, id_consorcio);
            stm2.setDate(4, data_negociacao);
            stm2.setDate(5, data_abertura);
            stm2.setString(6, status);
            stm2.setDouble(7, valr_desconto);
            stm2.setString(8,status_negociacao);
            stm2.setString(9, desc_origem);
            stm2.setDouble(10, valr_negocial);
            stm2.setDouble(11, valr_sugerido);
            stm2.setDouble(12, valr_faturamento);
            stm2.setString(13, numr_cgc);
            stm2.setString(14, nome_razao_social);
            stm2.setString(15, codg_chassis);
            stm2.setString(16, desc_veiculo);
            stm2.setString(17, codg_modelo);
            stm2.setString(18, desc_modelo);
            stm2.setString(19, codg_model_group);
            stm2.setString(20, desc_model_group);
            stm2.setString(21, categoria);
            stm2.setString(22, desc_modalidade_compra);
            stm2.setLong(23, numr_nota_entrada);
            stm2.setInt(24, serie_nota_entrada);
            stm2.setLong(25, numr_nota_saida);
            stm2.setInt(26, serie_nota_saida);
            stm2.setDouble(27, valr_nota_saida);
            stm2.setInt(28, qtde_dias_estocagem);
            stm2.setString(29, nome_usuario);
            stm2.setString(30, desc_logradouro);
            stm2.setString(31, desc_complemento);
            stm2.setString(32, numr_logradouro);
            stm2.setString(33, endereco);
            stm2.setString(34, nome_bairro);
            stm2.setString(35, nome_cidade);
            stm2.setString(36, nome_uf);
            stm2.setString(37, numr_cep);
            stm2.setString(38, fone_contato);
            stm2.setString(39, fone_celular);
            stm2.setString(40, numr_cgc_entrada);
            stm2.setString(41, razao_social_entrada);
            stm2.setString(42, email);
            stm2.setString(43, financiamento);
            stm2.setString(44, desc_cor);
            stm2.setLong(45, id_entidade_nf);
            stm2.execute();
            }
            }
        
        }catch(Exception exc){
            JOptionPane.showMessageDialog(null, exc.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
        FabricaConexoes.closeConnection();
        FabricaConexoes.closeConnection();
    }

    public void ProcessaIvv()
    {
        try{

        if(!FabricaConexoes.verificaConexao())
        {
            FabricaConexoes.getConexaoMy();
        }
        sql = "select * from tb_registra_venda_novos where ivv = 0";
        stm = FabricaConexoes.returnStatement(sql);
        rs = FabricaConexoes.returnResult(stm);
        ResultSet rs2;
//        File file = new File("C:\\temp.txt");
//        if(file.exists())
//        {
//            file.delete();
//            file = new File("C:\\temp.txt");
//        }
//        FileWriter writer = new FileWriter(file,true);
//        BufferedWriter escrever = new BufferedWriter(writer);

        while(rs.next())
        {
              long id_dr = rs.getLong("ID_DR");
              if(id_dr == 0)
              {
                  id_dr = rs.getLong("ID_VENDADIRETA");
                  if(id_dr ==0 )
                  {
                      id_dr = rs.getLong("ID_CONSORCIO");
                  }
              }
              sql = "select * from tb_parametros where id_parametro = 4";
              stm = FabricaConexoes.returnStatement(sql);
              rs2 = FabricaConexoes.returnResult(stm);
              rs2.next();

              int id_ivv = rs2.getInt("status");

              sql = "select * from tb_parametros where id_parametro = 5";
              stm = FabricaConexoes.returnStatement(sql);
              rs2 = FabricaConexoes.returnResult(stm);
              rs2.next();

              int proc_ivv = rs2.getInt("valor");
              //JOptionPane.showMessageDialog(null, rs2.getInt("valor"));

              sql = "select * from tb_parametros where id_parametro = 6";
              stm = FabricaConexoes.returnStatement(sql);
              rs2 = FabricaConexoes.returnResult(stm);
              rs2.next();

              int fin_ivv = rs2.getInt("valor");

              sql = "select * from tb_parametros where id_parametro = 7";
              stm = FabricaConexoes.returnStatement(sql);
              rs2 = FabricaConexoes.returnResult(stm);
              rs2.next();

              int ativ_ivv = rs2.getInt("valor");

              if(id_ivv == 1)
              {



              }

//            escrever.write(rs.getString("CODG_CHASSIS"));
//            escrever.newLine();
//            escrever.write(rs.getString("NOME_RAZAO_SOCIAL"));
//            escrever.newLine();
//            escrever.write(rs.getString("NUMR_NOTA_SAIDA"));
//            escrever.newLine();
//            escrever.write(rs.getString("SERIE_NOTA_SAIDA"));
//            escrever.newLine();
//            escrever.write(rs.getString("ENDERECO"));
//            escrever.newLine();
//            if(rs.getString("DESC_LOGRADOURO") != null)
//            {
//            escrever.write(rs.getString("DESC_LOGRADOURO"));
//            }else
//
//            {
//            escrever.write("0");
//            }
//            escrever.newLine();
//            if(rs.getString("DESC_COMPLEMENTO") != null){
//            escrever.write(rs.getString("DESC_COMPLEMENTO"));}else{
//                escrever.write("0");
            }
//            escrever.newLine();
//
//            escrever.write(rs.getString("NUMR_LOGRADOURO"));
//            escrever.newLine();
//            escrever.write(rs.getString("NOME_BAIRRO"));
//            escrever.newLine();
//            escrever.write(rs.getString("NOME_CIDADE"));
//            escrever.newLine();
//            escrever.write(rs.getString("NOME_UF"));
//            escrever.newLine();
//            escrever.write(rs.getString("NUMR_CEP"));
//            escrever.newLine();
//            escrever.write(rs.getString("FONE_CONTATO"));
//            escrever.newLine();
//            escrever.write(rs.getString("FONE_CELULAR"));
            
//        }
        
//        escrever.flush();
//        escrever.close();
//        writer.close();
        //file.delete();
        FabricaConexoes.closeConnection();
        }catch(Exception exc)
        {
            exc.printStackTrace();
            JOptionPane.showMessageDialog(null,exc.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

   public void gravaTimers(int id_processo, int id_period, int int_in, int int_fin, int id_int, String hora, boolean domingo, boolean status)
    {
        try{
           if(!FabricaConexoes.verificaConexao()) FabricaConexoes.getConexaoMy();
           CallableStatement proc = null;
           Connection con = FabricaConexoes.retornaconnection();
           
          proc = con.prepareCall("{ call insert_timers(?,?,?,?,?,?,?,?) }");
            proc.setInt(1, id_processo);
            proc.setInt(2, id_period);
            proc.setInt(3, int_in);
            proc.setInt(4, int_fin);
            proc.setInt(5, id_int);
            proc.setString(6, hora);
            proc.setBoolean(7, domingo);
            proc.setBoolean(8, status);

          proc.execute();
          FabricaConexoes.closeConnection();
        }catch(Exception exc)
        {
            JOptionPane.showMessageDialog(null, exc.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
            FabricaConexoes.closeConnection();
        }


//       if(!FabricaConexoes.verificaConexao())
//        {
//            FabricaConexoes.getConexaoMy();
//        }
//        try{
//        sql = "insert into tb_timers(id_processo,id_period,intervalo_inicial,intervalo_final, id_intervalo,hora,gera_sab_dom,status,data_ativacao,data_suspensao) values(?,?,?,?,?,?,?,?,?,?);";
//        stm = FabricaConexoes.returnStatement(sql);
//        stm.setInt(1, id_processo);
//        stm.setInt(2, id_period);
//        stm.setInt(3, int_in);
//        stm.setInt(4, int_fin);
//        stm.setInt(5, id_int);
//        stm.setString(6, hora);
//        stm.setBoolean(7, domingo);
//        stm.setBoolean(8, status);
//        if(status)
//        {
//            stm.setString(9, "NOW()");
//            stm.setString(10, "0000-00-00");
//        }else{
//            stm.setString(10,"NOW()");
//            stm.setString(9, "0000-00-00");
//        }
//        stm.execute();
//        stm.close();
//        FabricaConexoes.closeConnection();
//        }catch(Exception exc)
//        {
//            JOptionPane.showMessageDialog(null, exc.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
//            FabricaConexoes.closeConnection();
//        }




    }

   public void CarregaTimer(int id, String idproc, int period,int intin, int intfin, int inter, String horario,boolean suspender, boolean domingo )
    {
        try{

        if(!FabricaConexoes.verificaConexao())
        {
            FabricaConexoes.getConexaoMy();
        }
        sql = "select * from tb_timers where id_timers = ?";
        stm = FabricaConexoes.returnStatement(sql);
        stm.setInt(1, id);
        rs = FabricaConexoes.returnResult(stm);
        rs.next();
        idproc = rs.getString("id_processo");;
        period = rs.getInt("id_period");
        intin = rs.getInt("intervalo_inicial");
        intfin = rs.getInt("intervalo_final");
        inter = rs.getInt("id_intervalo");
        horario = rs.getString("Hora");
        suspender = rs.getBoolean("status_at");
        domingo = rs.getBoolean("gera_sab_dom");
        JOptionPane.showMessageDialog(null,idproc);
        stm.close();

       }catch(Exception exc)
        {
           JOptionPane.showMessageDialog(null, exc.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
       }
    }


}
