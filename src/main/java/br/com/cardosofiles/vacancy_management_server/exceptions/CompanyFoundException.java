package br.com.cardosofiles.vacancy_management_server.exceptions;

public class CompanyFoundException extends RuntimeException {
    public CompanyFoundException() {
        super("Empresa já existe.");
    }

}
