package com.f1soft.testcrud.service.serviceimpl;

import com.f1soft.testcrud.entity.User;
import com.f1soft.testcrud.exception.DataAlreadyExistsException;
import com.f1soft.testcrud.exception.DataNotFoundException;
import com.f1soft.testcrud.exception.NoChangefoundException;
import com.f1soft.testcrud.repository.UserRepository;
import com.f1soft.testcrud.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        User data = userRepository.findByName(user.getName());
        if (data != null) {
            throw new DataAlreadyExistsException(user.getName() + " " + "Already exists");
        } else {
            return userRepository.save(user);
        }
    }

    @Override
    public User updateUser(User user) {
        if (userRepository.findUser(user.getId(), user.getName(), user.getAddress()) != null) {
            throw new NoChangefoundException("No Changes Found");
        }
        User data = userRepository.findUserByID(user.getId());
        if (data == null) {
            throw new DataNotFoundException("Data Not Found");
        } else {
            if (!user.getName().equals(data.getName())) {
                if (userRepository.findByName(user.getName()) != null) {
                    throw new DataAlreadyExistsException(user.getName() + " " + "Already exists");
                }
                data.setName(user.getName());
            }
            if (!user.getAddress().equals(data.getName())) {
                data.setAddress(user.getAddress());
            }
            return userRepository.save(data);
        }
    }

    @Override
    public List<User> fetchAllUser() {
        if(userRepository.findAllUsers() == null){
            throw new DataNotFoundException("Data does not exists");
        }else {
            return userRepository.findAllUsers();
        }
    }

    @Override
    public Boolean deleteUserById(long userId) {
        User data=userRepository.findUserByID(userId);
        if(userRepository.findUserByID(userId) == null){
            throw new DataNotFoundException("Data not found");
        }else {
            userRepository.delete(data);
            return true;
        }

    }


}


