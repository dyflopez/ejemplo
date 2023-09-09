package com.app.ejemplo.controller;

import com.app.ejemplo.controller.doc.UserDoc;
import com.app.ejemplo.dto.UserDTO;
import com.app.ejemplo.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController implements UserDoc {

    private  final IUserService iUserService;

    @Override
    @PostMapping
    public ResponseEntity create(UserDTO userDTO) {
        return iUserService.create(userDTO);
    }

    @Override
    @GetMapping
    public ResponseEntity getAllUser() {
        return iUserService.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity getUserById(long id) {
        return iUserService.findById(id);
    }

    @Override
    @GetMapping("/email/{email}")
    public ResponseEntity getUserByEmail(String email) {
        return  iUserService.findByEmail(email);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(long id) {
        return iUserService.delete(id);
    }
}
