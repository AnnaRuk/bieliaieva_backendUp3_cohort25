package de.ait.shop.services;

import de.ait.shop.models.User;

import java.util.List;


public interface UsersService {
    User addUser(String email, String password);

    List<User> getAllUsers();

    void updateUser(Long id, String newEmail, String newPassword);
}
