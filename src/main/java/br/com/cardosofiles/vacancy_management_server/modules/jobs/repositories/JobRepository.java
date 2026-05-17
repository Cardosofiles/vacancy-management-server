package br.com.cardosofiles.vacancy_management_server.modules.jobs.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cardosofiles.vacancy_management_server.modules.jobs.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

}
