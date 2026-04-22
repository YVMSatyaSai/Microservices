package com.practice.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDTO {

   private Long id;
   private String name;
   private Integer age;
}
