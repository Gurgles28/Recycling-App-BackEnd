package com.example.RegisterLogin.Service.UserIMPL;

import com.example.RegisterLogin.DTO.RecyclingCenterDTO;
import com.example.RegisterLogin.Entity.RecyclingCenter;
import com.example.RegisterLogin.Repo.RecyclingCenterRepo;
import com.example.RegisterLogin.Service.RecyclingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingCenterIMPL implements RecyclingCenterService {

    @Autowired
    private RecyclingCenterRepo recyclingCenterRepo;

    @Override
    public String addCenter(RecyclingCenterDTO recyclingCenterDTO) {
        RecyclingCenter recyclingCenter = new RecyclingCenter(
                recyclingCenterDTO.getId(),
                recyclingCenterDTO.getCounty(),
                recyclingCenterDTO.getCity(),
                recyclingCenterDTO.getCenterAddress(),
                recyclingCenterDTO.getMaterials(),
                recyclingCenterDTO.getName(),
                recyclingCenterDTO.getHours()
        );
        recyclingCenterRepo.save(recyclingCenter);
        return recyclingCenter.getName();
    }

    @Override
    public List<RecyclingCenter> getAllCenters() {
        return recyclingCenterRepo.findAll();
    }
}
