package it.nettiva.springram.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import it.nettiva.springram.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}