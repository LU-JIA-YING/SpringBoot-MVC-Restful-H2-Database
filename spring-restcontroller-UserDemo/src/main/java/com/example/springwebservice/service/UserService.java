package com.example.springwebservice.service;

import com.example.springwebservice.controller.dto.request.CreateUserRequest;
import com.example.springwebservice.controller.dto.request.UpdateUserRequest;
import com.example.springwebservice.model.UserRepository;
import com.example.springwebservice.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUserList() {

        List<User> response = userRepository.findAll();

        return response;
    }

    public User getUserById(int id) {
        User response = userRepository.findById(id);
        return response;
    }


    public String createUser(CreateUserRequest request) {

        //新增一個 user資料
        User user = new User();

        //新增資料:user裡的資料是從 request來的
        user.setId(request.getId());
        user.setName(request.getName());
        user.setAge(request.getAge());

        //儲存進DB
        userRepository.save(user);

        //回傳 OK告訴 Controller完成儲存
        return "OK";
    }

    //更改某個 user資料
    public String updateUser(int id, UpdateUserRequest request) {

        //確認 DB中有沒有這筆資料
        User user = userRepository.findById(id);

        //如果修改資料找不到
        //null == user (確定的值要放前面)
        if (null == user) {
            return "FAIL";
        }

        //將要更改的值塞進去
        user.setName(request.getName());
        user.setAge(request.getAge());

        //儲存進DB
        userRepository.save(user);

        //回傳 OK告訴 Controller完成儲存
        return "OK";
    }

    //刪除某個user
    public String deleteUser(int id) {

        User user = userRepository.findById(id);

        if (null == user) {
            return "FAIL";
        }

        Long count = userRepository.deleteById(id);

        return "OK";
    }

} // Class end
