package cl.leonelalejandroppp.api.auth.dto;

import cl.leonelalejandroppp.api.auth.entities.UserEntity;
import cl.leonelalejandroppp.api.auth.enums.Role;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class RegisterDTO {

    @Email(message = "Email no válido")
    private String email;

    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "La contraseña debe tener al menos 8 caracteres y contener al menos una letra mayúscula, una letra minúscula, un número y un carácter especial"
    )
    @NotNull(message = "La contraseña no puede ser nula")
    private String password;


    public UserEntity toUserEntity () {
        return UserEntity.builder()
                .email(this.getEmail())
                .password(this.getPassword())
                .role(Role.USER)
                .build();
    }
}