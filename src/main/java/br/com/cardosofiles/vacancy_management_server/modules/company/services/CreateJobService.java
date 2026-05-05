package br.com.cardosofiles.vacancy_management_server.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cardosofiles.vacancy_management_server.modules.company.dto.CreateJobRequestDTO;
import br.com.cardosofiles.vacancy_management_server.modules.company.dto.CreateJobResponseDTO;
import br.com.cardosofiles.vacancy_management_server.modules.company.entities.JobEntity;
import br.com.cardosofiles.vacancy_management_server.modules.company.repositories.JobRepository;

@Service
public class CreateJobService {

    @Autowired
    private JobRepository jobRepository;

    public CreateJobResponseDTO execute(CreateJobRequestDTO dto) {

        var entity = new JobEntity();
        entity.setDescription(dto.getDescription());
        entity.setBenefits(dto.getBenefits());
        entity.setLevel(dto.getLevel());
        entity.setCompanyId(dto.getCompanyId());

        var saved = this.jobRepository.save(entity);

        return CreateJobResponseDTO.builder()
                .id(saved.getId())
                .description(saved.getDescription())
                .benefits(saved.getBenefits())
                .level(saved.getLevel())
                .companyId(saved.getCompanyId())
                .createdAt(saved.getCreatedAt())
                .build();
    }
}
