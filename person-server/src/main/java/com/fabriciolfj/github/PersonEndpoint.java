package com.fabriciolfj.github;

import io.grpc.stub.StreamObserver;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class PersonEndpoint extends PersonServiceGrpc.PersonServiceImplBase {

    @Override
    public void send(PersonRequest request, StreamObserver<PersonResponse> responseObserver) {
        System.out.println("Request " + request);
        var response = PersonResponse.newBuilder()
                .setCode(UUID.randomUUID().toString())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
