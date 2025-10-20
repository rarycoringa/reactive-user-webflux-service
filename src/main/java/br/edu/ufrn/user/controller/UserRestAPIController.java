package br.edu.ufrn.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufrn.user.record.CreateUserDTO;
import br.edu.ufrn.user.record.UserDTO;
import br.edu.ufrn.user.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserRestAPIController {
    @Autowired
    private UserService userService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<UserDTO> getAll() {
        return userService.getAll();
    }
    
    @GetMapping("/{id}")
    public Mono<UserDTO> getById(@PathVariable String id) {
        return userService.getById(id);
    }
    
    @PostMapping
    public Mono<UserDTO> save(@RequestBody CreateUserDTO createUserDTO) {
        return userService.save(createUserDTO);
    }
    
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return userService.delete(id);
    }
}
