package com.minimart.auth_service.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.minimart.auth_service.dto.RegisterRequestDTO;
import com.minimart.auth_service.dto.RequestResponseDTO;
import com.minimart.auth_service.entity.User;
import com.minimart.auth_service.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public RequestResponseDTO register(RegisterRequestDTO request) {
        // Step1: Find email exists
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Step2: Hash the password using BCryptPasswordEncoder defined in SecurityConfig class
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // Step3: Create object of the user that we want to save in DB
        User user = User.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .password(encodedPassword)
            .role("USER")
            .build();

        // Step4: Call save method to insert in DB
        User savedUser = userRepository.save(user);

        // Step5: Map the saved user object with responseDTO object of user
        return modelMapper.map(savedUser, RequestResponseDTO.class);
    }
}
