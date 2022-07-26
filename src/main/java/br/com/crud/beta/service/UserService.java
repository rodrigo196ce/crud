package br.com.crud.beta.service;

import br.com.crud.beta.model.User;
import br.com.crud.beta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save(User user){
        this.userRepository.save(user);
    }

}
