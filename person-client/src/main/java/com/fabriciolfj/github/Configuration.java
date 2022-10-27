package com.fabriciolfj.github;

import io.grpc.ManagedChannel;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;
import jakarta.inject.Singleton;

@Factory
public class Configuration {

    @Singleton
    PersonServiceGrpc.PersonServiceStub reactiveStub(@GrpcChannel("http://${server.host}:${server.port}") ManagedChannel channel) {
        return PersonServiceGrpc.newStub(channel);
    }
}
