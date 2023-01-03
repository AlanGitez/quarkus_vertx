package org.acme.core;

import io.quarkus.vertx.web.Route;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.web.RoutingContext;
import org.jboss.logging.Logger;

import javax.inject.Inject;

public class DbQuerys {

    private static final Logger logger = Logger.getLogger(DbQuerys.class);

    private static final DeliveryOptions dops = new DeliveryOptions();

    @Inject
    EventBus bus;

    // Esta ruta es generica. En caso de que queryType sea null, se considera que es get, en cualquier otro caso
    // se resuelve segun su valor. Esta ruta dispara el msg por el bus y de ahi, lo ataja el service que corresponda
    // para la entidad deseada.
    @Route(path = "/:queryType/:entity/:id", methods = Route.HttpMethod.GET)
    public void query (RoutingContext rc){

    }

//    @Route(path = "/insert/:entity/:id", methods = Route.HttpMethod.POST)
//    public void insert (RoutingContext rc){
//
//    }
//
//    @Route(path = "/delete/:entity/:id", methods = Route.HttpMethod.DELETE)
//    public void delete(RoutingContext rc){
//
//    }
//
//    @Route(path = "/update/:entity/:id", methods = Route.HttpMethod.PUT)
//    public void update(RoutingContext rc){
//
//    }
//
//    @Route(path = "/:entity/:id", methods = Route.HttpMethod.GET)
//    public void get(RoutingContext rc){
//
//    }



}
