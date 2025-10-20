package br.edu.ufrn.user.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.user.model.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {}
