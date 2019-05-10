package com.mdstech.sample;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

public class ReceiverVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> startFuture) {
        vertx.eventBus().consumer("address", (message) -> {
            final JsonObject data = (JsonObject) message.body();
            System.out.println(data.getString("message"));
        });
    }
}
