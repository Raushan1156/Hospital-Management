package com.HospitalManagement.repository;

import com.HospitalManagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Boolean existsByUsername(String username);

    Optional<Users> findByUsername(String username);
}
