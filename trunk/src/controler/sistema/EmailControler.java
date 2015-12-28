/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controler.sistema;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.sistema.Email;
import model.sistema.EmailDao;

/**
 *
 * @author Magneticos
 */
public class EmailControler
{
    private EmailDao emaildao;

    public EmailControler()
    {
        emaildao = new EmailDao();
    }

    public void excluirEmail(Email email)
    {
        try
        {
           emaildao.deleteEmail(email);
           JOptionPane.showMessageDialog(null, "Email excluido com sucesso.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar excluir email: " + email.getNome());
        }
    }

    public void gravar(Email email)
    {
        try
        {
            if(email.getId() == 0)
                emaildao.insertEmail(email);
            else
                emaildao.updateEmail(email);

            JOptionPane.showMessageDialog(null, "Email gravado com sucesso.");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Falha ao tentar gravar email: " + email.getNome());
        }
    }
}