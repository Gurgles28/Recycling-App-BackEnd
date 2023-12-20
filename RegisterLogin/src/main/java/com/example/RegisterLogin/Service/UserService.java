package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.DTO.UserDTO;
import com.example.RegisterLogin.Entity.User;
import com.example.RegisterLogin.Response.LoginResponse;

import java.util.List;

public interface UserService {

    String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
}
