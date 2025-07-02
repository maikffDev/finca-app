package com.finca.app.infrastructure.controllers;

import com.finca.app.application.dto.user.UserDtoRequest;
import com.finca.app.application.dto.user.UserDtoResponse;
import com.finca.app.application.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDtoResponse> create(@Valid @RequestBody UserDtoRequest userDtoRequest){
        return new ResponseEntity<>(userService.create(userDtoRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public UserDtoResponse getById(@PathVariable("id") Long userId){
        return userService.getById(userId);
    }

    @GetMapping("/getByUsername/{user}")
    public UserDtoResponse getByUsername(@PathVariable("user") String username) {
        return userService.getByUsername(username);
    }

    @PutMapping("/{id}")
    public UserDtoResponse update(@PathVariable("id") Long userId, @RequestBody UserDtoRequest userDTORequest) {
        return userService.update(userId, userDTORequest);
    }

    @DeleteMapping("/{id}")
    public UserDtoResponse delete(@PathVariable("id") Long userId){
        return userService.delete(userId);
    }

    @DeleteMapping("/logicalDeletion/{id}")
    public UserDtoResponse logicalDeletion(@PathVariable("id") Long userId) {
        return userService.logicalDeletion(userId);
    }
}
