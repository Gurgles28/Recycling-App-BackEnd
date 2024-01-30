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

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/updatePoints")
    public ResponseEntity<String> updatePointsByEmail(@RequestParam String email, @RequestParam BigDecimal newPoints) {
        userService.updatePointsByEmail(email, newPoints);
        return ResponseEntity.ok("User points updated successfully");
    }

    @PostMapping("/updateContribPoints")
    public ResponseEntity<String> updateContribPointsByEmail(@RequestParam String email, @RequestParam String materialType, @RequestParam BigDecimal recycledAmount) {
        userService.contributeMaterial(email, materialType, recycledAmount);
        return ResponseEntity.ok("User points updated successfully");
    }

    @GetMapping("/getContribMaterials")
    public ResponseEntity<Map<String, BigDecimal>> getContribMaterialsByEmail(@RequestParam String email) {
        Map<String, BigDecimal> contribMaterials = userService.getAllContribMaterials(email);
        return ResponseEntity.ok(contribMaterials);
    }

    @GetMapping("/getPoints")
    public BigDecimal getUserPoints(@RequestParam String email) {
        return userService.getUserPoints(email);
    }

    @PostMapping("/deductPoints")
    public ResponseEntity<String> deductPoints(@RequestParam String email) {
        userService.deductPoints(email);
        return ResponseEntity.ok("Points deducted");
    }
}