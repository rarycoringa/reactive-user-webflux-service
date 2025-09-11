package br.edu.ufrn.ingestion.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class IngestionGraphQLController {
    @QueryMapping
    public String hello(@Argument String name) {
        return new String("Hello, " + name + "!");
    }
}
