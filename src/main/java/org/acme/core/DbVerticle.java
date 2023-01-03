package org.acme.core;


import io.quarkus.reactive.datasource.ReactiveDataSource;
import io.quarkus.vertx.ConsumeEvent;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.PgPool;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class DbVerticle extends AbstractVerticle {

    private static final Logger logger = Logger.getLogger(DbVerticle.class);

    private static final DeliveryOptions dops = new DeliveryOptions();

    @Inject
    @ReactiveDataSource("example")
    PgPool exampleDb;

    @Inject
    EventBus bus;

    @Override
    public void start(Promise promise){

        exampleDb.getConnection(ar -> {
            if(ar.failed()){
                logger.error("error durante la conexion");
                promise.fail(ar.cause());
            } else {
                logger.info("conexion OK");
            }
        });

    }


    // El msg contiene la informacion necesaria para determinar a que Service se envia la solitud
    // para ser procesada.
    @ConsumeEvent("insert")
    public CompletionStage<JsonObject> insert(JsonObject msg){
        return null;
    }

    @ConsumeEvent("delete")
    public CompletionStage<JsonObject> delete(JsonObject msg){
        return null;
    }

    @ConsumeEvent("update")
    public CompletionStage<JsonObject> update(JsonObject msg){
        return null;
    }

    @ConsumeEvent("get")
    public CompletionStage<JsonObject> get(JsonObject msg){
        return null;
    }



}
