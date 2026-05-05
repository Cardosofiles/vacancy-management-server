package br.com.cardosofiles.vacancy_management_server.modules.health.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class HealthResponseDTO {

    private String status;
    private String application;
    private LocalDateTime timestamp;

}
