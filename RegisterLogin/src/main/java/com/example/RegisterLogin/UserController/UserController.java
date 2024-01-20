package com.example.RegisterLogin.UserController;

import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.DTO.UserDTO;
import com.example.RegisterLogin.Entity.User;
import com.example.RegisterLogin.Response.LoginResponse;
import com.example.RegisterLogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.RegisterLogin.Repo.UserRepo;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepository;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO) {
        String id = userService.addUser(userDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/updatePoints")
    public ResponseEntity<String> updatePointsByEmail(@RequestParam String email,@RequestParam Optional<Integer> newPoints) {
        userService.updatePointsByEmail(email, newPoints);
        return ResponseEntity.ok("User points updated successfully");
    }

    @PostMapping("/updateContribPoints")
    public ResponseEntity<String> updateContribPointsByEmail(@RequestParam String email,@RequestParam Optional<Integer> newContribPoints) {
        userService.updatePointsByEmail(email, newContribPoints);
        return ResponseEntity.ok("User points updated successfully");
    }
}
