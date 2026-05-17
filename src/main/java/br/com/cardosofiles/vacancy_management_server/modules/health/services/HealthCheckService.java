package br.com.cardosofiles.vacancy_management_server.modules.health.services;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import br.com.cardosofiles.vacancy_management_server.modules.health.dto.HealthResponseDTO;

@Service
public class HealthCheckService {

    @Value("${spring.application.name}")
    private String applicationName;

    public HealthResponseDTO execute() {
        return HealthResponseDTO.builder().status("UP").application(applicationName)
                .timestamp(LocalDateTime.now()).build();
    }

}
