package com.f1soft.testcrud.repositorytest;


import com.f1soft.testcrud.entity.User;
import com.f1soft.testcrud.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UserRepository userRepository;

    @Before
    public void setup() {
        User user = User.builder()
                .name("sauravi")
                .address("baluwatar")
                .build();

        testEntityManager.persist(user);
    }

    @Test
    public void findAllUser_returnsperson(){
      Optional<List<User>> userList= userRepository.findAllUsers();

        assertThat(userList).isEqualTo(userList);
    }

}
