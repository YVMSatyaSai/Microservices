package com.practice.user_service.service;

import com.practice.user_service.dto.*;
import com.practice.user_service.entity.UserEntity;
import com.practice.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public ApiResponse<UserResponseDTO> createUser(CreateUserRequestDTO request) {
        try {
            UserEntity entity = new UserEntity();
            entity.update(request.getName(), request.getAge());

            UserEntity saved = userRepository.save(entity);

            return new ApiResponse<>(
                    true,
                    "User created successfully",
                    new UserResponseDTO(saved.getId(), saved.getName(), saved.getAge())
            );
        } catch (Exception ex) {
            logger.error("Error creating user", ex);
            return new ApiResponse<>(false, "Failed to create user", null);
        }
    }

    public ApiResponse<UserResponseDTO> getUserById(Long id) {
        try {
            UserEntity entity = userRepository.findById(id).orElse(null);

            if (entity == null) {
                return new ApiResponse<>(false, "User not found", null);
            }

            return new ApiResponse<>(
                    true,
                    "User fetched successfully",
                    new UserResponseDTO(entity.getId(), entity.getName(), entity.getAge())
            );
        } catch (Exception ex) {
            log.error("Error fetching user. id={}", id, ex);
            return new ApiResponse<>(false, "Internal server error", null);
        }
    }

    public ApiResponse<List<UserResponseDTO>> getAllUsers() {
        try {
            List<UserResponseDTO> users = userRepository.findAll()
                    .stream()
                    .map(u -> new UserResponseDTO(u.getId(), u.getName(), u.getAge()))
                    .toList();

            return new ApiResponse<>(true, "Users fetched successfully", users);
        } catch (Exception ex) {
            log.error("Error fetching users", ex);
            return new ApiResponse<>(false, "Failed to fetch users", null);
        }
    }

    public ApiResponse<UserResponseDTO> updateUser(Long id, UpdateUserRequestDTO request) {
        try {
            UserEntity entity = userRepository.findById(id).orElse(null);

            if (entity == null) {
                return new ApiResponse<>(false, "User not found", null);
            }

            entity.update(request.getName(), request.getAge());
            UserEntity updated = userRepository.save(entity);

            return new ApiResponse<>(
                    true,
                    "User updated successfully",
                    new UserResponseDTO(updated.getId(), updated.getName(), updated.getAge())
            );
        } catch (Exception ex) {
            log.error("Error updating user. id={}", id, ex);
            return new ApiResponse<>(false, "Failed to update user", null);
        }
    }

    public ApiResponse<Void> deleteUser(Long id) {
        try {
            if (!userRepository.existsById(id)) {
                return new ApiResponse<>(false, "User not found", null);
            }

            userRepository.deleteById(id);
            return new ApiResponse<>(true, "User deleted successfully", null);

        } catch (Exception ex) {
            log.error("Error deleting user. id={}", id, ex);
            return new ApiResponse<>(false, "Failed to delete user", null);
        }
    }
}
