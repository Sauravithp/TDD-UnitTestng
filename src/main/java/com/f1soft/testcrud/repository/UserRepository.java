package com.f1soft.testcrud.repository;

import com.f1soft.testcrud.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE name=:name", nativeQuery = true)
    User findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM user WHERE id=:id", nativeQuery = true)
    User findUserByID(@Param("id")Long id);

    @Query(value = "SELECT * FROM user WHERE id=:id AND name=:name AND address=:address", nativeQuery = true)
    User findUser(@Param("id")Long id,@Param("name") String name, @Param("address")String address);

    @Query(value = "SELECT * from user ", nativeQuery = true)
    Optional<List<User>> findAllUsers();
}
