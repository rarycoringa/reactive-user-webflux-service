package br.edu.ufrn.order.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderGraphQLController {
    @QueryMapping
    public String hello(@Argument String name) {
        return new String("Hello, " + name + "!");
    }

    @QueryMapping
    public void getOrder(Long id) {

    }

    @QueryMapping
    public void getOrders() {

    }

    @MutationMapping
    public void createOrder(Object order) {

    }

    @MutationMapping
    public void updateOrder(Long id, Object order) {

    }

    @MutationMapping
    public void deleteOrder(Long id) {

    }
}
