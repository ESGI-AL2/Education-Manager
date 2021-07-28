package fr.esgi.educationmanager.authentification.app.dto;

import fr.esgi.educationmanager.authentification.domain.Role;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class RegisterDTO {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private Role role;
}
