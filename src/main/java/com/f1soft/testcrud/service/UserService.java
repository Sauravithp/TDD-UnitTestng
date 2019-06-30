package com.f1soft.testcrud.service;

import com.f1soft.testcrud.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    List<User> fetchAllUser();
    Boolean deleteUserById(long userId);
}
