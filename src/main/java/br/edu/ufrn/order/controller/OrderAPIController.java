package br.edu.ufrn.order.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class OrderAPIController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return new String("Hello, " + name + "!");
    }
    
    @GetMapping("/{id}")
    public void getOrder(@PathVariable("id") Long id) {

    }

    @GetMapping
    public void getOrders() {

    }

    @PostMapping
    public void createOrder(@RequestBody Object order) {

    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable("id") Long id, @RequestBody Object order) {

    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {

    }
}
