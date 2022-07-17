package org.example.model;


import org.example.entity.User;

import java.util.List;

public interface UserModel {
     User save(User user);
    List<User> findAll();
    User findById(int id);
    User updated(int id, User user);
    User deleted(int id);
}
