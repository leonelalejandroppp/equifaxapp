package cl.leonelalejandroppp.api.auth.services;

import cl.leonelalejandroppp.api.auth.dto.RegisterDTO;
import cl.leonelalejandroppp.api.auth.entities.UserEntity;
import cl.leonelalejandroppp.api.auth.exceptions.EmailExistsException;
import cl.leonelalejandroppp.api.auth.repositories.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserEntityRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity createUser (UserEntity userEntity) {
        this.alreadyExistsEmail(userEntity.getEmail());
        userEntity.setPassword(this.passwordEncoder.encode(userEntity.getPassword()));
        this.userRepository.save(userEntity);
        return userEntity;
    }

    private void alreadyExistsEmail (String email) {
        Boolean exists = this.userRepository.findByEmail(email).isPresent();
        if(exists){
            throw new EmailExistsException("El email ya está registrado");
        }
    }

    public UserEntity findByEmail (String email) {
        return this.userRepository.findByEmail(email).orElseThrow();
    }
}

