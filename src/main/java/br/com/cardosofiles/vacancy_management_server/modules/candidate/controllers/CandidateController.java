package br.com.cardosofiles.vacancy_management_server.modules.candidate.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.cardosofiles.vacancy_management_server.modules.candidate.CandidateEntity;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/candidate")
public class CandidateController {


    @PostMapping("/")
    public void create(@Valid @RequestBody CandidateEntity candidateEntity) {
        System.out.println("Candidato");
        System.out.println(candidateEntity.getName());
        System.out.println(candidateEntity.getUserName());
        System.out.println(candidateEntity.getEmail());
        System.out.println(candidateEntity.getPassword());
        System.out.println(candidateEntity.getDescription());
    }

}
