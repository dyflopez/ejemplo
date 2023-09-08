package com.app.ejemplo.mappers;

import com.app.ejemplo.dto.UserDTO;
import com.app.ejemplo.model.UserEntity;

public class UserMapper {

    public UserMapper() {
    }


    public  static UserEntity changeUserDtoToUserEntity(UserDTO userDTO){

        return  UserEntity
                .builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .age(userDTO.getAge())
                .email(userDTO.getEmail())
                .build();
    }
}
