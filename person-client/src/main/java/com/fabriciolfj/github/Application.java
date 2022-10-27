package com.fabriciolfj.github;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.micronaut.runtime.Micronaut;
import jakarta.inject.Inject;

public class Application {

    public static void main(String[] args) {
        var request = PersonRequest.newBuilder()
                .setDocument("1221")
                .setName("fabricio")
                .build();

        var response = getStub().send(request);
        System.out.println("Person created " + response.getCode());

        Micronaut.run(Application.class, args);
    }

    private static PersonServiceGrpc.PersonServiceBlockingStub getStub() {
        var channel = ManagedChannelBuilder.forAddress("localhost", 5001)
                .usePlaintext()
                .build();

        return PersonServiceGrpc.newBlockingStub(channel);
    }
}
