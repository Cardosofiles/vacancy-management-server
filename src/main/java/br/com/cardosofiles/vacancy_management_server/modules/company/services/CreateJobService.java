package br.com.cardosofiles.vacancy_management_server.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cardosofiles.vacancy_management_server.modules.company.entities.JobEntity;
import br.com.cardosofiles.vacancy_management_server.modules.company.repositories.JobRepository;

@Service
public class CreateJobService {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {

        return this.jobRepository.save(jobEntity);

    }
}
