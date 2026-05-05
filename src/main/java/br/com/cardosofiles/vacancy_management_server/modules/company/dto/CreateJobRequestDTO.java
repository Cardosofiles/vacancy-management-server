package br.com.cardosofiles.vacancy_management_server.modules.company.dto;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateJobRequestDTO {

    @NotBlank(message = "O campo [description] é obrigatório")
    private String description;

    private String benefits;

    @NotBlank(message = "O campo [level] é obrigatório")
    private String level;

    @NotNull(message = "O campo [companyId] é obrigatório")
    private UUID companyId;

}
