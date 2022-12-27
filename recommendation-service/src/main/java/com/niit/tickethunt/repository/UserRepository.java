package com.niit.tickethunt.repository;

import com.niit.tickethunt.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<User, Long> {
}
