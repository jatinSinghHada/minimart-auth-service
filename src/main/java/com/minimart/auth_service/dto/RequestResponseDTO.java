package com.minimart.auth_service.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonPropertyOrder({
    "userId",
    "firstName",
    "lastName",
    "email",
    "role"
})
public class RequestResponseDTO {

    @NotNull
    private Long userId;
    
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String role;

}
