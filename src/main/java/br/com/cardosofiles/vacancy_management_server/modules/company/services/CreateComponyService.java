package br.com.cardosofiles.vacancy_management_server.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cardosofiles.vacancy_management_server.exceptions.UserFoundException;
import br.com.cardosofiles.vacancy_management_server.modules.company.entities.CompanyEntity;
import br.com.cardosofiles.vacancy_management_server.modules.company.repositories.CompanyRepository;


@Service
public class CreateComponyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {

        this.companyRepository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.companyRepository.save(companyEntity);
    }

}
