package com.example.priority.repositories;

import com.example.priority.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface AreaRepository extends JpaRepository<Area, Integer> {
    List<Area> findAll();
    Area findByAreaName(String areaName);
}