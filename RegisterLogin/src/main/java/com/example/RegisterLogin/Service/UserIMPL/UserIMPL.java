package com.example.RegisterLogin.Service.UserIMPL;


import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.DTO.UserDTO;
import com.example.RegisterLogin.Entity.User;
import com.example.RegisterLogin.Repo.UserRepo;
import com.example.RegisterLogin.Response.LoginResponse;
import com.example.RegisterLogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void updatePointsByEmail(String email, BigDecimal newPoints) {
        User user = userRepo.findByEmail(email);
        BigDecimal totalPoints = user.getPoints().add(newPoints);
        user.setPoints(totalPoints);
        userRepo.save(user);

    }

    @Override
    public void contributeMaterial(String email, @org.jetbrains.annotations.NotNull String materialType, BigDecimal recycledAmount) {
        User user = userRepo.findByEmail(email);

        switch (materialType) {
            case "Plastic":
                user.setPlasticContrib(user.getPlasticContrib().add(recycledAmount));
                break;
            case "Aluminum":
                user.setAluminumContrib(user.getAluminumContrib().add(recycledAmount));
                break;
            case "Metal":
                user.setMetalContrib(user.getMetalContrib().add(recycledAmount));
                break;
            case "Glass":
                user.setGlassContrib(user.getGlassContrib().add(recycledAmount));
                break;
            case "Paper & Cardboard":
                user.setPaperCardboardContrib(user.getPaperCardboardContrib().add(recycledAmount));
                break;
            case "Electronic Waste":
                user.setElectronicContrib(user.getElectronicContrib().add(recycledAmount));
                break;
            default:
                throw new IllegalArgumentException("Unknown material type: " + materialType);

        }
        userRepo.save(user);
    }

    @Override
    public Map<String, BigDecimal> getAllContribMaterials(String email) {
        User user = userRepo.findByEmail(email);

        Map<String, BigDecimal> contribMaterials = new HashMap<>();
        contribMaterials.put("Plastic", user.getPlasticContrib());
        contribMaterials.put("Aluminum", user.getAluminumContrib());
        contribMaterials.put("Metal", user.getMetalContrib());
        contribMaterials.put("Glass", user.getGlassContrib());
        contribMaterials.put("Paper & Cardboard", user.getPaperCardboardContrib());
        contribMaterials.put("Electronic Waste", user.getElectronicContrib());

        return contribMaterials;
    }

    @Override
    public void deductPoints(String email) {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            BigDecimal currentPoints = user.getPoints();
            user.setPoints(currentPoints.subtract(BigDecimal.valueOf(2000)));
            userRepo.save(user);
        }
    }

    @Override
    public BigDecimal getUserPoints(String email) {
        User user = userRepo.findByEmail(email);
        return user.getPoints();
    }
}