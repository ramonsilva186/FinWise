package com.ramonsilva.finwise.Mapper;

import com.ramonsilva.finwise.Dto.UserDTO;
import com.ramonsilva.finwise.Entity.Users;

public class UserMapper {

    public static Users toEntity(UserDTO userDTO) {
        Users user = new Users();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public static UserDTO toDTO(Users user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
