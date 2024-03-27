package cl.leonelalejandroppp.api.config;

import cl.leonelalejandroppp.api.auth.entities.UserEntity;
import cl.leonelalejandroppp.api.auth.enums.Role;
import cl.leonelalejandroppp.api.auth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        this.createUser("hola@hola.cl", "TestApp123!");
        this.createUser("leonelalejandro.cb@gmail.com", "Hunter2!");
    }

    private void createUser (String email, String password) {
        try{
            this.userService.createUser(
                    UserEntity.builder()
                            .email(email)
                            .password(password)
                            .role(Role.USER)
                            .build()
            );

        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
