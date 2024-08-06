package com.Group4.HospitalBedSystem.repository;

import com.Group4.HospitalBedSystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findUserByName(String name);
    UserEntity findUserByUsername(String username);
    UserEntity findUserByEmployeeId(String employeeId);
//    UserEntity findUsernameAndPassword(String username, String password);
}
