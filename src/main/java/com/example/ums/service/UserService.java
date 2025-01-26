package com.example.ums.service;

import com.example.ums.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(Long userId);
    void deleteUser(Long userId);
    UserDto updateUserById(Long userId, UserDto updatedUser);
}
