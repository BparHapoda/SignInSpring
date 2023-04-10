package org.example.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.User;
import org.example.repositories.UserRepository;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository repository;

    @Override
    public void signUp(User user) {
        if(!repository.isUser(user.getLogin())){
         repository.save(user);
        }
    }


    @Override
    public boolean signIn(String login, String password) {
        if(repository.getPasswordByLogin(login).equals(password)){
            return true;
        }
        else
        {return false;}
    }
}
