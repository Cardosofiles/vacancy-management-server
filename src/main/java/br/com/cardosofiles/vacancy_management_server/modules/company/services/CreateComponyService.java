package br.com.cardosofiles.vacancy_management_server.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cardosofiles.vacancy_management_server.exceptions.UserFoundException;
import br.com.cardosofiles.vacancy_management_server.modules.company.dto.CreateCompanyRequestDTO;
import br.com.cardosofiles.vacancy_management_server.modules.company.dto.CreateCompanyResponseDTO;
import br.com.cardosofiles.vacancy_management_server.modules.company.entities.CompanyEntity;
import br.com.cardosofiles.vacancy_management_server.modules.company.repositories.CompanyRepository;


@Service
public class CreateComponyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CreateCompanyResponseDTO execute(CreateCompanyRequestDTO dto) {

        this.companyRepository
                .findByUsernameOrEmail(dto.getUsername(), dto.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        var entity = new CompanyEntity();
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setWebsite(dto.getWebsite());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        var saved = this.companyRepository.save(entity);

        return CreateCompanyResponseDTO.builder()
                .id(saved.getId())
                .username(saved.getUsername())
                .email(saved.getEmail())
                .website(saved.getWebsite())
                .name(saved.getName())
                .description(saved.getDescription())
                .createdAt(saved.getCreatedAt())
                .build();
    }

}
