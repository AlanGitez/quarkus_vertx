package org.acme.services;

import io.quarkus.hibernate.orm.PersistenceUnit;
import io.vertx.core.json.JsonObject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import java.util.concurrent.CompletionStage;

//@ApplicationScoped
public class PostServiceImpl implements PostService {


//    @Inject
//    @PersistenceUnit("example")
//    private EntityManagerFactory em;

    @Override
    public CompletionStage<JsonObject> insert() {
        return null;
    }

    @Override
    public CompletionStage<JsonObject> delete() {
        return null;
    }

    @Override
    public CompletionStage<JsonObject> update() {
        return null;
    }

    @Override
    public CompletionStage<JsonObject> get() {
        return null;
    }
}
