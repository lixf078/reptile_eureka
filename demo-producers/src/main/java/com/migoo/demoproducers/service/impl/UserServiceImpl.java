package com.migoo.demoproducers.service.impl;

import com.migoo.demoproducers.domain.User;
import com.migoo.demoproducers.repository.UserRepository;
import com.migoo.demoproducers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.get();
    }
}
