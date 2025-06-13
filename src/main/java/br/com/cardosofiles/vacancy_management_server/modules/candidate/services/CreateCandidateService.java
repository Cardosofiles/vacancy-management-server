package br.com.cardosofiles.vacancy_management_server.modules.candidate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cardosofiles.vacancy_management_server.exceptions.UserFoundException;
import br.com.cardosofiles.vacancy_management_server.modules.candidate.CandidateEntity;
import br.com.cardosofiles.vacancy_management_server.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity excecute(CandidateEntity candidateEntity) {
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.candidateRepository.save(candidateEntity);
    }
}
