package com.f1soft.testcrud.configuration;

import com.f1soft.testcrud.entity.Person;
import com.f1soft.testcrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditAwareImpl implements AuditorAware<String> {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Optional<String> getCurrentAuditor() {
        Person person=personRepository.findUserByID(1L);
        return Optional.of(person.getName());
    }
}
