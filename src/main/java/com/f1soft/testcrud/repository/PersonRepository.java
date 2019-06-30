package com.f1soft.testcrud.repository;

import com.f1soft.testcrud.entity.Person;
import com.f1soft.testcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person,Long> {

    @Query(value = "SELECT * FROM person WHERE id=:id", nativeQuery = true)
    Person findUserByID(@Param("id")Long id);
}
