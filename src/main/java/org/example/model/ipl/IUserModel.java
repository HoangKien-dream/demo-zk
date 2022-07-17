package org.example.model.ipl;



import org.example.entity.User;
import org.example.model.UserModel;
import org.example.util.ConnectionHelper;
import org.example.util.DateTimeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IUserModel implements UserModel {

    public User save(User user) {
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.out.println("Can not connection to database");
                return null;
            }
            StringBuilder query = new StringBuilder("INSERT INTO user");
            query.append(" ");
            query.append("(name, phone, gender, birthday)");
            query.append(" ");
            query.append("VALUES");
            query.append(" ");
            query.append("(?, ?, ?, ?)");
            PreparedStatement preparedStatement = cnn.prepareStatement(query.toString());
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getBirthdayString());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<User>();
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.out.println("Can not connection to database");
                return null;
            }
            StringBuilder query = new StringBuilder("SELECT * FROM user");
            PreparedStatement preparedStatement = cnn.prepareStatement(query.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(DateTimeUtil.parseDateFromString(rs.getString("birthday")));
                user.setPhone(rs.getString("phone"));
                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public User findById(int id) {
        User user = new User();
        try{
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null){
                System.out.println("Can not connection to database");
                return null;
            }
            StringBuilder query = new StringBuilder("SELECT * FROM user");
            query.append(" ");
            query.append("WHERE");
            query.append(" ");
            query.append("id");
            query.append(" ");
            query.append("=");
            query.append(" ");
            query.append("?");
            PreparedStatement preparedStatement = cnn.prepareStatement(query.toString());
            preparedStatement.setInt(1,id);
            ResultSet resultSet =  preparedStatement.executeQuery();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setBirthday(resultSet.getDate("birthday"));
            user.setGender(resultSet.getString("gender"));
            user.setPhone(resultSet.getString("phone"));
            return user;
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User updated(int id, User user) {
        return null;
    }

    public User deleted(int id) {
        return null;
    }
}
