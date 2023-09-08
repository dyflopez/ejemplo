package com.app.ejemplo.service;

import com.app.ejemplo.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    ResponseEntity create (UserDTO userDTO) ;


    ResponseEntity findAll();

    ResponseEntity findById(long id);

    ResponseEntity findByEmail(String email);

    ResponseEntity delete(long id);


}
