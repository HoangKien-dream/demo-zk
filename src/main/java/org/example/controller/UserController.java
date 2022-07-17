package org.example.controller;
import org.example.entity.User;
import org.example.service.UserService;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

import java.util.List;

public class UserController  extends SelectorComposer<Component> {

    @Wire
    Listbox listBox;
    @Wire
    Textbox txtName;
    @Wire
    Textbox txtPhone;
    @Wire
    Textbox txtGender;
    @Wire
    Datebox dateBirthday;

    @Override
    public void doAfterCompose(Component window) throws Exception {
        super.doAfterCompose(window);
        listBox.setMultiple(true);
        ListModelArray listModelArray = new ListModelArray(userService.findAll());
        listBox.setModel(listModelArray);
    }
    private final UserService userService = new UserService();
    @Listen("onClick = #btnSave")
    public User save(){
        User user = new User();
        user.setName(txtName.getValue());
        user.setPhone(txtPhone.getValue());
        user.setGender(txtGender.getValue());
        user.setBirthday(dateBirthday.getValue());

        return userService.save(user);
    }
    @Init
    public List<User> findAll(){
        return userService.findAll();
    }
    public User findById(int id){
        return userService.findById(id);
    }
}
