package cl.leonelalejandroppp.api.auth.services;

import cl.leonelalejandroppp.api.auth.dto.LoginDTO;
import cl.leonelalejandroppp.api.auth.dto.LoginResponseDTO;
import cl.leonelalejandroppp.api.auth.dto.RegisterDTO;
import cl.leonelalejandroppp.api.auth.entities.UserEntity;
import cl.leonelalejandroppp.api.common.jwt.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JWTService jwtService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;


    public void register (RegisterDTO registerDTO) {
        this.userService.createUser(registerDTO.toUserEntity());
    }

    public LoginResponseDTO login (LoginDTO loginDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        UserDetails user = this.userService.findByEmail(loginDTO.getEmail());
        String token = jwtService.createToken(user);
        return LoginResponseDTO.builder()
                .token(token)
                .build();
    }


}

