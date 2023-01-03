package org.acme.services;

import io.vertx.core.json.JsonObject;

import java.util.concurrent.CompletionStage;

public interface CRUDService {
    public CompletionStage<JsonObject> insert();
    public CompletionStage<JsonObject> delete();
    public CompletionStage<JsonObject> update();
    public CompletionStage<JsonObject> get();

}
