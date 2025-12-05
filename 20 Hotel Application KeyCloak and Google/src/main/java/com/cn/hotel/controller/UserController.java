//package com.cn.hotel.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.cn.hotel.dto.UserRequest;
//import com.cn.hotel.model.User;
//import com.cn.hotel.service.UserService;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    UserService userService;
//
//    @GetMapping("/getUsers")
//    public List<User> getUsers() {
//        return userService.getUsers();
//    }
//
//    @GetMapping("/getUsers/{id}")
//    public User getUserById(@PathVariable Long id) {
//        return userService.getUserById(id);
//    }
//
//    @PostMapping("/createUser")
//    public void createUser(@RequestBody UserRequest userRequest)
//    {
//        userService.createUser(userRequest);
//    }
//
//    @DeleteMapping("/remove/id/{id}")
//    public void deleteUserById(@PathVariable Long id)
//    {
//        userService.deleteUserById(id);
//
//    }
//}
