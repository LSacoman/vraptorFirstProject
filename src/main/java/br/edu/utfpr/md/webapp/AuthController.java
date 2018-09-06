package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Usuario;
import br.edu.utfpr.md.webapp.auth.LoggedUser;
import br.edu.utfpr.md.webapp.auth.Public;
import javax.inject.Inject;

@Controller
@Path("/auth")
public class AuthController {

    @Inject
    private Result result;
    @Inject
    private Validator validator;
    @Inject
    private LoggedUser loggedUser;

    @Get(value = {"", "/"})
    public void login() { // CARREGA PAGINA DE LOGIN
    }

    @Post
    @Public
    public void autenticar(Usuario usuario) { // EFETUA LOGIN DO USUARIO
        try {
            if (usuario.getUsuario().equals("admin") && usuario.getSenha().equals("1234")) {
                //CRIAR SEÇÃO DE USUARIO
                usuario.setNome("Administrador");
                this.loggedUser.login(usuario);
                this.result.redirectTo("/car");
            } else {
                validator.add(new SimpleMessage("invalid", "Login e/ou Senha Invalidos!"));
            }
        } catch (NullPointerException e) {
            validator.add(new SimpleMessage("invalid", "Login e/ou Senha Invalidos!"));
        }
        validator.onErrorForwardTo(this).login();
    }

    @Post
    public void registrar(Usuario usuario) { //EFETUA CADASTRO DO USUARIO
        System.out.println(usuario.getUsuario());
        System.out.println(usuario.getSenha());
        validator.onErrorForwardTo(this).login();
        result.redirectTo(this).login();
    }

}
