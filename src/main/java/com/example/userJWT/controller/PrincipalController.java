package com.example.userJWT.controller;
import com.example.userJWT.entity.UserEntity;
import com.example.userJWT.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PrincipalController {
    @Autowired
    UserService userService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> getAllUser(){
        return userService.AllUser();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getAllUser(@PathVariable Long id ) {
        return userService.getUserById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postUser(@RequestBody UserEntity userEntity){
        userService.postUser(userEntity);
    }
//    @PostMapping("/dto")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void postUserDto(@RequestBody UserDTO userDTO){
//        userService.postUserDTO(userDTO);
//    }

    @GetMapping("/data/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Map> getMoviminentos(@PathVariable Long id){
        return userService.getMovimientos(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletedUser(@PathVariable Long id){
        userService.deletedByUser(id);
    }
}

