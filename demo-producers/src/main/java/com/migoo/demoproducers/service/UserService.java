package com.migoo.demoproducers.service;

import com.migoo.demoproducers.domain.User;

public interface UserService {
    User findUserById(Long userId);
}
