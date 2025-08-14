package br.com.cardosofiles.vacancy_management_server.modules.company.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cardosofiles.vacancy_management_server.modules.company.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {



}
