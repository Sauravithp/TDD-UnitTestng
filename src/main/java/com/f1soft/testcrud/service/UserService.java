package com.f1soft.testcrud.service;

import com.f1soft.testcrud.entity.User;

public interface UserService {
    User createUser(User user);
    User updateuser(User user);
}
