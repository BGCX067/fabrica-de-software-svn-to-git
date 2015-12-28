package controler.sistema;

import Util.AbstractController;
import execoes.CamposException;
import model.sistema.Usuario;
import model.sistema.UsuarioDao;

public class UsuarioControler implements AbstractController<Usuario>
{
    private UsuarioDao userdao;

    public UsuarioControler()
    {
        userdao = new UsuarioDao();
    }

    public void excluirUsuario(Usuario user) throws Exception
    {     
       userdao.deleteUsuario(user);
    }

    private void inserirUsuario(Usuario user) throws Exception
    {
        camposObrigatorios(user);
        userdao.insertUsuario(user);
    }

    private void alterarUsuario(Usuario user) throws Exception
    {
        camposObrigatorios(user);
        userdao.updateUsuario(user);
    }

    public void gravar(Usuario user) throws Exception
    {
        if(user.getId() > 0)
            alterarUsuario(user);
        else
            inserirUsuario(user);
    }
    
    public void camposObrigatorios(Usuario usuario) throws Exception {

        if(usuario != null)
        {
            if(usuario.getNome().trim().length() == 0 || usuario.getNome() == null)
                throw new CamposException("Nome");

            if(usuario.getLogin().trim().length() == 0 || usuario.getLogin() == null)
                throw  new CamposException("Login");

            if(usuario.getSenha().trim().length() == 0 || usuario.getSenha() == null)
                throw new CamposException("Senha");
        }
    }

    public void formatoCampos(Usuario usuario) throws Exception { }
}