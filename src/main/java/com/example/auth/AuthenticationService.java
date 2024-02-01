package com.example.auth;

import com.example.models.entity.ERole;
import com.example.models.entity.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

   private final UserRepository userRepository;

   private final PasswordEncoder passwordEncoder;

   public AuthenticationResponse register(RegisterRequest request) {
      var user = User.builder()
             .firstname(request.getFirstName())
             .lastname(request.getLastName())
             .username(request.getUsername())
             .password(passwordEncoder.encode(request.getPassword()))
             .role(ERole.USER)
             .build();
      userRepository.save(user);
      return null;
   }


   public AuthenticationRequest authenticate(RegisterRequest request) {
      return null;
   }
}
