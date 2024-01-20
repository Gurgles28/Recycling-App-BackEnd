package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.DTO.UserDTO;
import com.example.RegisterLogin.Entity.User;
import com.example.RegisterLogin.Response.LoginResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {

    String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
    List<User> getAllUsers();
    void updatePointsByEmail(String email, Optional<Integer> newPoints);
}
