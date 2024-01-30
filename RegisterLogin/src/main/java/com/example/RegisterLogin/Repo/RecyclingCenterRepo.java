package com.example.RegisterLogin.Repo;

import com.example.RegisterLogin.Entity.RecyclingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface RecyclingCenterRepo extends JpaRepository<RecyclingCenter, Long> {
 
}
