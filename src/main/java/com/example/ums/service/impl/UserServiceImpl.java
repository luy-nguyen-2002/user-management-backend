package com.example.ums.service.impl;

import com.example.ums.dto.UserDto;
import com.example.ums.entity.User;
import com.example.ums.exception.ResourceNotFoundException;
import com.example.ums.mapper.UserMapper;
import com.example.ums.repository.UserRepository;
import com.example.ums.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers(){
        List<User> users = this.userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with Id " + userId + " does not exist")
        );
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with Id " + userId + " does not exist")
        );
        this.userRepository.deleteById(userId);
    }

    @Override
    public UserDto updateUserById(Long userId, UserDto updatedUser) {
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with Id " + userId + " does not exist")
        );
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        User updateUserObj = this.userRepository.save(user);
        return UserMapper.mapToUserDto(updateUserObj);
    }
}
