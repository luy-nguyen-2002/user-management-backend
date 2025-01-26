package com.example.ums.mapper;

import com.example.ums.dto.UserDto;
import com.example.ums.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }

    public static User mapToUser(UserDto userDto){
        return new User(userDto.getId(),userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
    }
}
