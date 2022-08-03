package br.com.crud.beta.repository;

import br.com.crud.beta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User>,
        PagingAndSortingRepository<User,Integer>{

    @Query("select u from User u where u.id = :id")
    User findUserById(@Param("id")Integer id);



}
