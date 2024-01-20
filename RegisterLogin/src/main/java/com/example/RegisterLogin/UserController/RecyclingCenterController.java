package com.example.RegisterLogin.UserController;

import com.example.RegisterLogin.DTO.RecyclingCenterDTO;
import com.example.RegisterLogin.Entity.RecyclingCenter;
import com.example.RegisterLogin.Service.RecyclingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/centers")
public class RecyclingCenterController {

    @Autowired
    private RecyclingCenterService recyclingCenterService;

    @PostMapping("/getAllCenters")
    public List<RecyclingCenter> getAllCenters(){
        return recyclingCenterService.getAllCenters();}

    @PostMapping(path = "/saveCenter")
    public String saveCenter(@RequestBody RecyclingCenterDTO recyclingCenterDTO) {
        String id = recyclingCenterService.addCenter(recyclingCenterDTO);
        return id;
    }
}
