package com.example.RegisterLogin.Service.UserIMPL;


import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.DTO.UserDTO;
import com.example.RegisterLogin.Entity.User;
import com.example.RegisterLogin.Repo.UserRepo;
import com.example.RegisterLogin.Response.LoginResponse;
import com.example.RegisterLogin.Service.UserService;
import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserIMPL implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUserID(),
                userDTO.getAddress(),
                userDTO.getEmail(),
                userDTO.getUserFirstName(),
                userDTO.getUserLastName(),
                this.passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getRole(),
                userDTO.getPoints(),
                userDTO.getPlasticContrib(),
                userDTO.getAluminumContrib(),
                userDTO.getMetalContrib(),
                userDTO.getGlassContrib(),
                userDTO.getPaperCardboardContrib(),
                userDTO.getElectronicContrib()
        );
        userRepo.save(user);
        return user.getEmail();
    }

    UserDTO userDTO;

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exits", false);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void updatePointsByEmail(String email, Optional<Integer> newPoints) {
        User user = userRepo.findByEmail(email);

        if (user != null && newPoints.isPresent()) {
            int currentPoints = user.getPoints();
            int totalPoints = currentPoints + newPoints.get();
            user.setPoints(totalPoints);
            userRepo.save(user);
        }
    }
}
