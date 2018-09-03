package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Usuario;
import javax.inject.Inject;
import javax.validation.Valid;

@Controller
@Path("/auth")
public class AuthController {

    @Inject
    private Result result;

    @Inject
    private Validator validator;

    @Path(value = {"", "/"})
    public void login() { // CARREGA PAGINA DE LOGIN
    }

    @Path("/login")
    @Post
    public void entrar(@Valid Usuario usuario) { // EFETUA LOGIN DO USUARIO

        System.out.println(usuario.getUsuario());
        System.out.println(usuario.getSenha());
        validator.onErrorForwardTo(this).login();
        //result.redirectTo("carro/form");

    }

    @Path("/new")
    @Post
    public void registrar(@Valid Usuario usuario) { //EFETUA CADASTRO DO USUARIO

        System.out.println(usuario.getUsuario());
        System.out.println(usuario.getSenha());
        validator.onErrorForwardTo(this).login();
        result.redirectTo(this).login();
    }

}
