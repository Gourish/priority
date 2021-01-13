package com.example.priority.repositories;


import com.example.priority.model.UserPriority;
import com.example.priority.model.UserPriorityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface UserPriorityRepository extends JpaRepository<UserPriority, UserPriorityId> {
    List<UserPriority> findAll();

}
