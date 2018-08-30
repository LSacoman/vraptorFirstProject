package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Carro;
import javax.inject.Inject;

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

    public void save(Carro carro) {
        System.out.println(carro.getMarca());
        System.out.println(carro.getModelo());
        
        if(carro.getMarca() == null || carro.getMarca().isEmpty()){
            validator.add(new SimpleMessage("carro.marca", "Marca é invalida!"));
        }
        if(carro.getModelo()== null || carro.getModelo().isEmpty()){
            validator.add(new SimpleMessage("carro.modelo", "Modelo é invalido!"));
        }
        
        validator.onErrorForwardTo(this).form();

        // salvar na data base 
        // redirecionar
        result.redirectTo(this).list();
    }
}
