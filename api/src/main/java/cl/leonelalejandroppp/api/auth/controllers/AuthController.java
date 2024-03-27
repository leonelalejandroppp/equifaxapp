package cl.leonelalejandroppp.api.auth.controllers;

import cl.leonelalejandroppp.api.auth.dto.LoginDTO;
import cl.leonelalejandroppp.api.auth.dto.LoginResponseDTO;
import cl.leonelalejandroppp.api.auth.dto.RegisterDTO;
import cl.leonelalejandroppp.api.auth.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginDTO loginDTO) {
        return ResponseEntity.ok(this.authService.login(loginDTO));
    }

    @PostMapping("register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO registerDTO) {
        this.authService.register(registerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
