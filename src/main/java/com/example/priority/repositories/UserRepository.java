package com.example.priority.repositories;

import com.example.priority.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    boolean existsById(Integer userid);
}
