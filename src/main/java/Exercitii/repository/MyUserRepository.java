package Exercitii.repository;

import Exercitii.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    Optional<MyUser> findByUsername(String username);
}
