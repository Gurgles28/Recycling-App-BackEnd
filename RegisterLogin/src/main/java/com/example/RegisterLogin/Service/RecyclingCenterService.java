package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.DTO.RecyclingCenterDTO;
import com.example.RegisterLogin.Entity.RecyclingCenter;

import java.util.List;

public interface RecyclingCenterService {

    String addCenter(RecyclingCenterDTO recyclingCenterDTO);
    List<RecyclingCenter> getAllCenters();
}
