package com.project.authentication.repository;
/*
JPA Repository is mainly used for managing the data in a Spring Boot Application.
The goal of Spring Data repository abstraction is to significantly reduce the amount of boilerplate code required to implement data access layers for various persistence stores.
*/

import com.project.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//This is a specialization of @Component annotation which is used to indicate that the class provides the mechanism for storage, retrieval, update, delete and search operation on objects.
public interface UserRepository extends JpaRepository<User, String> {
}
