package br.edu.utfpr.md.webapp.dao;

import br.edu.utfpr.md.model.Carro;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.bson.Document;
import org.bson.types.ObjectId;

public class CarroDAO extends GenericDAO<Carro, ObjectId> {

    @Inject
    private MongoDatabase db;

    private MongoCollection carCollection;

    @PostConstruct
    private void init() {
        this.carCollection = db.getCollection("Carro");
    }

    @Override
    public void insert(Carro obj) {
        Document car = new Document()
                .append("marca", obj.getMarca())
                .append("modelo", obj.getModelo());
        carCollection.insertOne(car);
    }

    @Override
    public void update(Carro obj) {

    }

    @Override
    public void delete(Carro obj) {

    }

    @Override
    public List<Carro> getAll() {
        return null;
    }

    @Override
    public Carro getById(ObjectId id) {
        return null;
    }

}
