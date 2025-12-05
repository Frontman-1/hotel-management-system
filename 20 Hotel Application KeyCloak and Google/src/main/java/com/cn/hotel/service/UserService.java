//package com.cn.hotel.service;
//
//import java.util.List;
//import org.springframework.stereotype.Service;
//import com.cn.hotel.dto.UserRequest;
//import com.cn.hotel.model.User;
//import com.cn.hotel.repository.UserRepository;
//
//@Service
//public class UserService {
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public List<User> getUsers() {
//        return userRepository.findAll();
//    }
//
//    public User getUserById(Long id) {
//        return userRepository.findById(id).get();
//    }
//
//    public User createUser(UserRequest userRequest) {
//        User user = new User();
//        user.setUsername(userRequest.getUsername());
//        user.setPassword(userRequest.getPassword());
//        user.setRole(userRequest.getRole());
//        user.setEmail(userRequest.getEmail());
//
//        return userRepository.save(user);
//    }
//
//    public void deleteUserById(Long id) {
//        userRepository.deleteById(id);
//    }
//}
