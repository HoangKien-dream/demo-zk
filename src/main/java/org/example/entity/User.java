package org.example.entity;





import org.example.util.DateTimeUtil;

import java.util.Date;


public class User {
    private int id;
    private String name;
    private String phone;
    private String gender;
    private Date birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public User() {
    }

    public User(int id, String name, String phone, String gender, Date birthday) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getBirthdayString(){
        return DateTimeUtil.formatDateToString(this.birthday);
    }
}
