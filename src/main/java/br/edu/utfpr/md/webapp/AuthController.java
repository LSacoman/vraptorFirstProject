package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Usuario;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class AuthController {

    @Inject
    private Result result;

    @Inject
    private Validator validator;

    public void login() { // CARREGA PAGINA DE LOGIN
    }

    public void entrar(@Valid @NotNull Usuario user) { // EFETUA LOGIN DO USUARIO
        validator.onErrorForwardTo(this).login();
        
        System.out.println(user.getUsuario());
        System.out.println(user.getSenha());
        //result.redirectTo("carro/form");
    }

    public void registrar(@Valid Usuario user) { //EFETUA CADASTRO DO USUARIO
        validator.onErrorForwardTo(this).login();
        System.out.println(user.getUsuario());
        System.out.println(user.getSenha());
        result.redirectTo(this).login();
    }

}
