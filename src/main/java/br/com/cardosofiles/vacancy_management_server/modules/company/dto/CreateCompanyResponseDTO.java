package br.com.cardosofiles.vacancy_management_server.modules.company.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCompanyResponseDTO {

    private UUID id;
    private String username;
    private String email;
    private String website;
    private String name;
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

}
