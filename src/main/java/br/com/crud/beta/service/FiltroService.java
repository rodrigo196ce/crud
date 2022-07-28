package br.com.crud.beta.service;

import br.com.crud.beta.enums.Cidade;
import br.com.crud.beta.model.User;
import br.com.crud.beta.repository.UserRepository;
import br.com.crud.beta.specification.SpecificationFiltro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@Service
public class FiltroService {

    @Autowired
    UserRepository userRepository;

    public Page<User> filtrar(String nome, LocalDate dataNascimento, String email, String telefone, Cidade cidade,Integer page) {

        return this.userRepository.findAll(Specification
                        .where(
                                SpecificationFiltro.nome(nome))
                        .or(SpecificationFiltro.dataNascimento(dataNascimento))
                        .or(SpecificationFiltro.email(email))
                        .or(SpecificationFiltro.telefone(telefone))
                        .or(SpecificationFiltro.cidade(cidade))
                , PageRequest.of(page, 3, Sort.by("nome")));


//        return this.userRepository.findAll(Specification
//                .where(
//                        SpecificationFiltro.nome(nome)
//                                .or(SpecificationFiltro.dataNascimento(dataNascimento)
//                                        .or(SpecificationFiltro.email(email)
//                                                .or(SpecificationFiltro.telefone(telefone)
//                                                        .or(SpecificationFiltro.cidade(cidade)))))));
    }

}
