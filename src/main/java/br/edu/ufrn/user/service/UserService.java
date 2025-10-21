package br.edu.ufrn.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufrn.user.model.User;
import br.edu.ufrn.user.record.CreateUserDTO;
import br.edu.ufrn.user.record.UserDTO;
import br.edu.ufrn.user.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Flux<UserDTO> getAll() {
        return userRepository.findAll()
            .map(
                user -> new UserDTO(
                    user.getId(),
                    user.getName(),
                    user.getAge(),
                    user.getCreatedAt()
                )
            );
    }

    public Mono<UserDTO> getById(String id) {
        return userRepository.findById(id)
            .map(
                user -> new UserDTO(
                    user.getId(),
                    user.getName(),
                    user.getAge(),
                    user.getCreatedAt()
                )
            );
    }

    public Mono<UserDTO> save(CreateUserDTO createUserDTO) {
        User userModel = new User(
            createUserDTO.name(),
            createUserDTO.age()
        );

        return userRepository.save(userModel)
            .map(
                user -> new UserDTO(
                    user.getId(),
                    user.getName(),
                    user.getAge(),
                    user.getCreatedAt()
                )
            );
    }

    public Mono<Void> delete(String id) {
        return userRepository.deleteById(id);
    }
    
}
