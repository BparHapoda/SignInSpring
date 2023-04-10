package org.example.repositories;

import org.example.models.User;

public interface UserRepository {
    void save (User user);
    boolean isUser(String login);

    String getPasswordByLogin(String login);
}
