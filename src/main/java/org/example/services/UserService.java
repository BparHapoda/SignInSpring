package org.example.services;

import org.example.models.User;

public interface UserService {
    void signUp(User user);


    boolean signIn(String login, String password);
}
