package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Carro;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class CarroController {

    @Inject
    private Result result;

    @Inject
    private Validator validator;

    public void teste() {
        System.out.println("TESTE");
    }

    public void form() {

    }

    public void list() {

    }

    public void save(@Valid @NotNull Carro carro) {
        validator.onErrorForwardTo(this).form();
        System.out.println(carro.getMarca());
        System.out.println(carro.getModelo());
        /* MODO MANUAL DE VALIDAÇÃO
        if(carro.getMarca() == null || carro.getMarca().isEmpty()){
            validator.add(new SimpleMessage("carro.marca", "Marca é invalida!"));
        }
        if(carro.getModelo()== null || carro.getModelo().isEmpty()){
            validator.add(new SimpleMessage("carro.modelo", "Modelo é invalido!"));
        }
         */

        // SALVAR NA BASE DE DADOS
        // REDIRECIONAR
        result.redirectTo(this).list();
    }
}
