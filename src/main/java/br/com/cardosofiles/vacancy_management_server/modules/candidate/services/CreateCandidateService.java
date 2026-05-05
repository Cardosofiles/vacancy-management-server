package br.com.cardosofiles.vacancy_management_server.modules.candidate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cardosofiles.vacancy_management_server.exceptions.UserFoundException;
import br.com.cardosofiles.vacancy_management_server.modules.candidate.CandidateEntity;
import br.com.cardosofiles.vacancy_management_server.modules.candidate.CandidateRepository;
import br.com.cardosofiles.vacancy_management_server.modules.candidate.dto.CreateCandidateRequestDTO;
import br.com.cardosofiles.vacancy_management_server.modules.candidate.dto.CreateCandidateResponseDTO;

@Service
public class CreateCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public CreateCandidateResponseDTO execute(CreateCandidateRequestDTO dto) {
        this.candidateRepository
                .findByUsernameOrEmail(dto.getUsername(), dto.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        var entity = new CandidateEntity();
        entity.setName(dto.getName());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setDescription(dto.getDescription());
        entity.setCurriculum(dto.getCurriculum());

        var saved = this.candidateRepository.save(entity);

        return CreateCandidateResponseDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .username(saved.getUsername())
                .email(saved.getEmail())
                .description(saved.getDescription())
                .curriculum(saved.getCurriculum())
                .createdAt(saved.getCreatedAt())
                .build();
    }
}
