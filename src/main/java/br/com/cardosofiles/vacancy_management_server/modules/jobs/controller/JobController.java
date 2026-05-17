package br.com.cardosofiles.vacancy_management_server.modules.jobs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.cardosofiles.vacancy_management_server.modules.jobs.dto.CreateJobRequestDTO;
import br.com.cardosofiles.vacancy_management_server.modules.jobs.services.CreateJobService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobService CreateJobService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateJobRequestDTO dto) {
        try {
            var result = this.CreateJobService.execute(dto);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
