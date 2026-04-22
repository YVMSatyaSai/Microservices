package com.practice.user_service.controller;

import com.practice.user_service.dto.*;
import com.practice.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDTO>> createUser(
            @RequestBody CreateUserRequestDTO request ) {
        ApiResponse<UserResponseDTO> response = userService.createUser(request);
        return ResponseEntity.status(
                response.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST
        ).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getUser(@PathVariable Long id) {
        ApiResponse<UserResponseDTO> response = userService.getUserById(id);
        return ResponseEntity.status(
                response.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        ).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequestDTO request) {
        ApiResponse<UserResponseDTO> response = userService.updateUser(id, request);
        return ResponseEntity.status(
                response.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        ).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        ApiResponse<Void> response = userService.deleteUser(id);
        return ResponseEntity.status(
                response.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        ).body(response);
    }

    @GetMapping("/email")
    public void emailSender() {
        userService.triggerEmail();
    }
}
