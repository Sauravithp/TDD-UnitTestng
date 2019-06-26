package com.f1soft.testcrud.service.serviceimpl;

import com.f1soft.testcrud.entity.User;
import com.f1soft.testcrud.exception.DataAlreadyExistsException;
import com.f1soft.testcrud.exception.DataNotFoundException;
import com.f1soft.testcrud.exception.NoChangefoundException;
import com.f1soft.testcrud.repository.UserRepository;
import com.f1soft.testcrud.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        User data=userRepository.findByName(user.getName());
        if (data != null){
            throw new DataAlreadyExistsException(user.getName()+" "+"Already exists");
        }else {
          return userRepository.save(user);
        }
    }

    @Override
    public User updateuser(User user) {
        if(userRepository.findUser(user.getId(),user.getName(),user.getAddress()) !=null ){
            throw new NoChangefoundException("No Changes Found");
        }
        if (userRepository.findUserByID(user.getId()) == null){
            throw new DataNotFoundException("Data Not Found");
        }
        return null;
    }


}


