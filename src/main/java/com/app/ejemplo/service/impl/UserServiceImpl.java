package com.app.ejemplo.service.impl;

import com.app.ejemplo.dto.UserDTO;
import com.app.ejemplo.mappers.UserMapper;
import com.app.ejemplo.model.UserEntity;
import com.app.ejemplo.repository.UserRepository;
import com.app.ejemplo.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private  final UserRepository userRepository;

    @Override
    public ResponseEntity create(UserDTO userDTO) {

        log.debug(
                "user create() request data: \n{}",
                userDTO
        );
        UserEntity userEntity = UserMapper.changeUserDtoToUserEntity(userDTO);

        userEntity = this.userRepository.save(userEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(userEntity);
    }

    @Override
    public ResponseEntity findAll() {
        var result =userRepository.findAll();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity findById(long id) {
        var result =userRepository.findById(id);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity findByEmail(String email) {
        var result =userRepository.findByEmail(email).orElse(new UserEntity());
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity delete(long id) {
        var result = userRepository.findById(id).get();
        userRepository.delete(result);
        return ResponseEntity.status(HttpStatus.FOUND).build();
    }
}
