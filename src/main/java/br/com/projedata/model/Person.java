package br.com.projedata.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    private String name;
    private LocalDate dateOfBirth;


    public Person() {
        this.name = "";
        this.dateOfBirth = LocalDate.now();
    }
    public Person(String name, LocalDate dateOfBirth) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida.");
        }
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida.");
        }
        this.dateOfBirth = dateOfBirth;
    }
    public int getAge() {
        Period birthPeriod = Period.between(dateOfBirth, LocalDate.now());
        return birthPeriod.getYears();
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato de data
        return String.format("Nome: %s; Data de Nascimento: %s;", getName(), getDateOfBirth().format(dateFormat));
    }
}
