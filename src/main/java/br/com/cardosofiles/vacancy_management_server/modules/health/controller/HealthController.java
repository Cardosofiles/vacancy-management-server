package br.com.cardosofiles.vacancy_management_server.modules.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cardosofiles.vacancy_management_server.modules.health.services.HealthCheckService;

@RestController
@RequestMapping("/health")
public class HealthController {

    @Autowired
    private HealthCheckService healthCheckService;

    @GetMapping
    public ResponseEntity<Object> check() {
        var result = this.healthCheckService.execute();
        return ResponseEntity.ok().body(result);
    }

}
