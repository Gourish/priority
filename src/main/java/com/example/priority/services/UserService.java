package com.example.priority.services;

import com.example.priority.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * It checks if the user exists with given userId in user table.
     * @param userId
     * @return
     */
    public boolean doesUserExists(Integer userId)
    {
        return userRepository.existsById(userId);
    }

}
