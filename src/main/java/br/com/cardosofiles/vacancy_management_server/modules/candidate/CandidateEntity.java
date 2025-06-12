package br.com.cardosofiles.vacancy_management_server.modules.candidate;

import java.util.UUID;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;

    @Pattern(regexp = "^(?!\\s8$).+", message = "Username inválido.")
    private String userName;

    @Email(message = "E-mail inválido.")
    private String email;

    @Length(min = 10, max = 100)
    private String password;

    private String description;
    private String curriculum;

}
