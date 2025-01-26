package com.example.ums.controller;

import com.example.ums.dto.UserDto;
import com.example.ums.entity.User;
import com.example.ums.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    //build api save user
    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        UserDto saveUser = this.userService.saveUser(userDto);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtos = this.userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto userDto = this.userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId){
        this.userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping({"{id}"})
    public ResponseEntity<UserDto> updateUserById(@PathVariable("id") Long userId, @RequestBody UserDto updatedUser){
        UserDto userDto = this.userService.updateUserById(userId, updatedUser);
        return ResponseEntity.ok(userDto);
    }
}
