package com.TalentHub.demo.service;

import com.TalentHub.demo.entity.User;

import java.util.List;

public interface UserService {
    User createuser(User user);
    List<User>getAllUsers();
    User getUserById(Long id);
}
