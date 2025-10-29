package org.example.validering_demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Bruker {

    @NotBlank(message = "fornavn kan ikke være tomt")
    private String fornavn;

    @Email(message = "Ugyldig epost")
    @NotBlank(message = "email kan ikke være tomt")
    private String epost;

    @Size(min = 6, message = "Passord må være minst 6 tegn")
    private String passord;

    @NotBlank(message = "Gjenta passord")
    private String passord2;

    @Pattern(regexp = "^[A-ZÆØÅa-zæøå\\-]+$", message = "Etternavn kan bare inneholde bokstaver")
    private String etternavn;

    public Bruker() {
    }

    public Bruker(String fornavn, String epost, String passord, String etternavn) {
        this.fornavn = fornavn;
        this.epost = epost;
        this.passord = passord;
        this.etternavn = etternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getPassord2() {
        return passord2;
    }

    public void setPassord2(String passord2) {
        this.passord2 = passord2;
    }
}
