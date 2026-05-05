package br.com.cardosofiles.vacancy_management_server.modules.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.cardosofiles.vacancy_management_server.modules.company.entities.CompanyEntity;
import br.com.cardosofiles.vacancy_management_server.modules.company.services.CreateComponyService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CreateComponyService createCompanyService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {

        try {
            var result = this.createCompanyService.execute(companyEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
