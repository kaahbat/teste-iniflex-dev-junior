package br.com.projedata.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Employee extends Person{
    private BigDecimal salary;
    private String role;

    public Employee() {
        super();
        this.salary = BigDecimal.ZERO;
        this.role = "";
    }

    public Employee(String name, LocalDate birthDate, BigDecimal salary, String role) {
        super(name, birthDate);
        if (salary == null || salary.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid salary.");
        }
        if (role == null || role.isEmpty()) {
            throw new IllegalArgumentException("Invalid role.");
        }
        this.salary = salary;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public boolean increaseSalary(BigDecimal percentage) {
        if (percentage.compareTo(BigDecimal.ZERO) > 0) {
            percentage = percentage.divide(BigDecimal.valueOf(100),RoundingMode.HALF_UP);
            BigDecimal newSalary = percentage.multiply(getSalary()).add(getSalary());
            newSalary = newSalary.setScale(2, RoundingMode.HALF_UP);
            setSalary(newSalary);
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // date format
        DecimalFormatSymbols salaryFormatSymbols = new DecimalFormatSymbols(); // symbols for salary formatting
        salaryFormatSymbols.setDecimalSeparator(',');
        salaryFormatSymbols.setGroupingSeparator('.');
        DecimalFormat salaryFormat = new DecimalFormat("###,###.##", salaryFormatSymbols); // salary format

        return String.format(
                "Name: %s; Birth Date: %s; Age: %d; Salary: %s; Role: %s\n",
                getName(),
                getDateOfBirth().format(dateFormat),
                getAge(),
                salaryFormat.format(getSalary()),
                getRole()
        );
    }
}


