package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.DTO.UserDTO;
import com.example.RegisterLogin.Entity.User;
import com.example.RegisterLogin.Response.LoginResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface UserService {

    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);

    List<User> getAllUsers();

    User getUserByEmail(String email);

    void updatePointsByEmail(String email, BigDecimal newPoints);

    void contributeMaterial(String email, @org.jetbrains.annotations.NotNull String materialType, BigDecimal recycledAmount);

    Map<String, BigDecimal> getAllContribMaterials(String email);

    void deductPoints(String email);

    BigDecimal getUserPoints(String email);
}