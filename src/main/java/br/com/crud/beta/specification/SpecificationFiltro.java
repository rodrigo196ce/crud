package br.com.crud.beta.specification;

import br.com.crud.beta.enums.Cidade;
import br.com.crud.beta.model.User;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class SpecificationFiltro {

    public static Specification<User> nome(String nome){
        return(root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.like(root.get("nome"),"%"+nome+"%");
//        return(root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("nome"),nome);
    }

    public static Specification<User> dataNascimento(LocalDate dataNascimento){
        return(root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("dataNascimento"),dataNascimento);
    }

    public static Specification<User> email(String email){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("email"),email);
    }

    public static Specification<User> telefone(String telefone){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("telefone"),telefone);
    }

    public static Specification<User> cidade(Cidade cidade){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("cidade"),cidade);
    }
}
