package br.com.crud.beta.repository;

import br.com.crud.beta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
