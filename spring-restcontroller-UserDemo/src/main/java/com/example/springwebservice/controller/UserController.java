package com.example.springwebservice.controller;

import com.example.springwebservice.controller.dto.reponse.StatusResponse;
import com.example.springwebservice.controller.dto.request.CreateUserRequest;
import com.example.springwebservice.controller.dto.request.UpdateUserRequest;
import com.example.springwebservice.model.entity.User;
import com.example.springwebservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    //查出全部 user資料
    @GetMapping()
    public List<User> getUserList() {
        List<User> response = userService.getUserList();
        return response;
    }

    //查出某個 user資料
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        User response = userService.getUserById(id);
        return response;
    }

    //新增 user資料
    @PostMapping()
    public StatusResponse createUser(@RequestBody CreateUserRequest request) {
        String response = userService.createUser(request);
        return new StatusResponse(response);
    }

    @PutMapping("/{id}")
    public StatusResponse updateUser(@PathVariable int id, @RequestBody UpdateUserRequest request) {
        String response = userService.updateUser(id,request);
        return new StatusResponse(response);
    }

    @DeleteMapping("/{id}")
    public StatusResponse deleteUser(@PathVariable int id) {
        String response = userService.deleteUser(id);
        return new StatusResponse(response);
    }
} // Class end
