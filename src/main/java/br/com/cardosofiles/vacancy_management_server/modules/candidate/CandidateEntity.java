package br.com.cardosofiles.vacancy_management_server.modules.candidate;

import java.util.UUID;
import lombok.Data;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;
    private String userName;
    private String email;
    private String password;
    private String description;
    private String curriculum;

}
