package com.Group4.HospitalBedSystem.service;

import com.Group4.HospitalBedSystem.dto.response.UserResponse;
import com.Group4.HospitalBedSystem.entity.UserEntity;
import com.Group4.HospitalBedSystem.repository.UserRepository;
import com.Group4.HospitalBedSystem.service.general.SuccessAndDataResponse;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    // Post methods
    public ResponseEntity<?> saveUser(UserEntity user){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try{
            if (user != null) {
                if (repository.save(user) != null) {
                    result.setSuccess(true);
                    result.setMessage("Added new user");
                    result.setData(user);
                } else {
                    result.setMessage("Failed to add user");
                }
                System.out.println("test");
                result.setData(user);
                return ResponseEntity.ok(result);
            } else {
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    public List<UserEntity> saveUsers(List<UserEntity> users){
//        return repository.saveAll(users);
//    }
//
//    public ResponseEntity<?> saveUsers(List<UserEntity> users){
//        SuccessAndDataResponse result = new SuccessAndDataResponse();
//        try{
//            if (users != null) {
//                List<UserEntity> usersEntity = new ArrayList<>();
//                for (UserEntity userList : users){
//
//                }
//                if (repository.save(user) != null) {
//                    result.setSuccess(true);
//                    result.setMessage("Added new user");
//                    result.setData(user);
//                } else {
//                    result.setMessage("Failed to add user");
//                }
//                result.setData(user);
//                return ResponseEntity.ok(result);
//            } else {
//                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
//            }
//        }catch (Exception e){
//            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    // Get methods
    public ResponseEntity<?> getUsers(){ // get list of objects
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        List<UserEntity> users = repository.findAll();
        if (users != null) {
            result.setSuccess(true);
            result.setMessage("Users found");
            List<UserResponse> userList = new ArrayList<>();
            for(UserEntity user : users){
                userList.add(mapUserEntityToUserDetail(user));
            }
            result.setData(userList);
            return ResponseEntity.ok(result);
        } else {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getUserById(int id){ // get 1 object
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try{
            UserEntity user = repository.findById(id).orElse(null);
            if (user != null){
                result.setSuccess(true);
                result.setMessage("User found.");
                result.setData(this.mapUserEntityToUserDetail(user));
            } else {
                result.setMessage("User not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getUserByName(String name){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try{
            UserEntity user = repository.findUserByName(name);
            if (user != null){
                result.setSuccess(true);
                result.setMessage("User found.");
                result.setData(this.mapUserEntityToUserDetail(user));
            } else {
                result.setMessage("User not found.");
            }
            return  ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete method
    public ResponseEntity<?> deleteUser(int id){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try{
            repository.deleteById(id);
            result.setMessage("Deleted user with id : " + id);
        }catch (Exception e){
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(result);
    }

    // update method
    public ResponseEntity<?> updateUser(UserEntity user){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try{
            UserEntity existUser = repository.findById(user.getId()).orElse(null);
            if (existUser != null) {
                existUser.setName(user.getName());
                existUser.setEmail(user.getEmail());
                if (repository.save(existUser) != null) {
                    result.setSuccess(true);
                    result.setMessage("Successfully update an user");
                    result.setData(existUser);
                } else {
                    result.setMessage("Failed to update an user");
                }
            } else {
                result.setMessage("User not found");
            }
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public UserResponse mapUserEntityToUserDetail(UserEntity userEntity){
        UserResponse data = new UserResponse();
        data.setId(userEntity.getId());
        data.setName(userEntity.getName());
        data.setEmail(userEntity.getEmail());
        data.setDepartment(userEntity.getDepartment());
        data.setPassword(userEntity.getPassword());
        data.setPosition(userEntity.getPosition());
        data.setDepartment(userEntity.getDepartment());
        return data;
    }

    public UserEntity login(String username, String password){
//        UserEntity user = repository.findUsernameAndPassword(username, password);
//        return user;
        return new UserEntity();
    }
}
