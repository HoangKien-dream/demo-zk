package org.example.service;


import org.example.entity.User;
import org.example.model.UserModel;
import org.example.model.ipl.IUserModel;

import java.util.List;
import java.util.Objects;

public class UserService {
    private UserModel userModel = new IUserModel();
    public User save(User user){
        if (Objects.isNull(user)){
            return null;
        }
        System.out.println(user.toString());
        return userModel.save(user);
    }

    public List<User> findAll(){
        List<User> list = userModel.findAll();
        return list;
    }

    public User findById(int id){
        if (id == 0){
            return null;
        }
        return userModel.findById(id);
    }
}
