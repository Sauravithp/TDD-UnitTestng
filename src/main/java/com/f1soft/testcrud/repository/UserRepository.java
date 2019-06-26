package com.f1soft.testcrud.repository;

import com.f1soft.testcrud.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE name=:name", nativeQuery = true)
    User findByName(String name);

    @Query(value = "SELECT * FROM user WHERE id=:id", nativeQuery = true)
    User findUserByID(Long id);

    @Query(value = "SELECT * FROM user WHERE id=:id AND name=:name AND address=:address",nativeQuery = true)
    User findUser(Long id,String name,String address);
}
