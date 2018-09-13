package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Carro;
import br.edu.utfpr.md.webapp.dao.CarroDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@Path("/car")
public class CarroController {

    @Inject
    private Result result;

    @Inject
    private Validator validator;

    @Inject
    private CarroDAO carroDAO;

    public void teste() {
        System.out.println("TESTE");
    }

    @Path("/new")
    @Get
    public void form() {

    }

    @Path(value = {"", "/"})
    @Get
    public List<Carro> list() {
        result.include("mensagem", "esta é uma mensagem");
        result.include("data", new Date());
        // buscando dados do banco de dados ficticio
        List<Carro> ls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ls.add(new Carro("Marca: " + i, "Modelo: " + i));
        }
        System.out.println(ls);
        return ls;
    }

    @Post
    public void save(@Valid @NotNull Carro carro) {
        validator.onErrorForwardTo(this).form();
        try {
            this.carroDAO.insert(carro);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir Carro!"));
        }
        result.redirectTo(this).list();
    }
}
