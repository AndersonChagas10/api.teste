package br.com.geniustest.api.repository;

import br.com.geniustest.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserByCognitoUsername(String username);
}