package org.acme.core;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.StartupEvent;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;

@ApplicationScoped
public class VerticlesDeployer {
    private static final Logger logger = Logger.getLogger(VerticlesDeployer.class);


    public void init(@Observes StartupEvent e, Vertx vertx, Instance<AbstractVerticle> verticles){

        try {
            logger.info("Intentando desplegar los verticles ! ... ! ");

            for (AbstractVerticle verticle : verticles){
                vertx.deployVerticle(verticle, ar ->{
                    if(!ar.succeeded()){
                        logger.info("no se pudo desplegar el verticle: " + verticle.getClass() + "debido a: " + ar.cause());
                        Quarkus.asyncExit();
                    }
                });
            }
        } catch (Exception exc){
            logger.error("error al desplegar alguno de los verticles " + exc.getCause());

        }

    }
}
