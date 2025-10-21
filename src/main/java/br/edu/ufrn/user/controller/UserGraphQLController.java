package br.edu.ufrn.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.edu.ufrn.user.record.CreateUserDTO;
import br.edu.ufrn.user.record.UserDTO;
import br.edu.ufrn.user.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserGraphQLController {

    @Autowired
    private UserService userService;

    @QueryMapping
    public Flux<UserDTO> getAll() {
        return userService.getAll();
    }
    
    @QueryMapping
    public Mono<UserDTO> getById(@Argument String id) {
        return userService.getById(id);
    }
    
    @MutationMapping
    public Mono<UserDTO> save(@Argument("createUserInput") CreateUserDTO createUserDTO) {
        return userService.save(createUserDTO);
    }
    
    @MutationMapping
    public Mono<Void> delete(@Argument String id) {
        return userService.delete(id);
    }
    
}
