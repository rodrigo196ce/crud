package br.com.crud.beta.service;

import br.com.crud.beta.dto.EditarDto;
import br.com.crud.beta.model.User;
import br.com.crud.beta.repository.UserRepository;
import br.com.crud.beta.util.CrudUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CrudUtil crudUtil;

    public void save(User user){
        this.userRepository.save(user);
    }
    public User findById(String id){
        return this.userRepository.findUserById(Integer.valueOf(id));
    }
    public EditarDto findByIdAndAttributes(User user,EditarDto editarDto){
        editarDto.setId(user.getId());
        editarDto.setNome(user.getNome());
        editarDto.setDataNascimento(crudUtil.formatarLocalDateByString(user.getDataNascimento()));
        editarDto.setEmail(user.getEmail());
        editarDto.setTelefone(user.getTelefone());
        editarDto.setRua(user.getRua());
        editarDto.setNumero(user.getNumero());
        editarDto.setComplemento(user.getComplemento());
        editarDto.setBairro(user.getBairro());
        editarDto.setCidade(user.getCidade());
        editarDto.setCep(user.getCep());
        return editarDto;
    }
    @Transactional
    public void realizarEdicao(User user,EditarDto editarDto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataNascimento = LocalDate.parse(editarDto.getDataNascimento(),formatter);
        user.setNome(editarDto.getNome());
        user.setDataNascimento(dataNascimento);
        user.setEmail(editarDto.getEmail());
        user.setTelefone(editarDto.getTelefone());
        user.setRua(editarDto.getRua());
        user.setNumero(editarDto.getNumero());
        user.setComplemento(editarDto.getComplemento());
        user.setBairro(editarDto.getBairro());
        user.setCidade(editarDto.getCidade());
        user.setCep(editarDto.getCep());
    }

}
