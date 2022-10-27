package com.fabriciolfj.github;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/api/v1/persons")
public class PersonController {

    @Inject
    PersonServiceGrpc.PersonServiceBlockingStub stub;

    @Post
    public String create(Person person) {
        var request = PersonRequest.newBuilder()
                .setDocument(person.getDocument())
                .setName(person.getName())
                .build();

        var response = stub.send(request);
        return response.getCode();
    }
}
