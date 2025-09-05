package br.com.projedata.service;

import br.com.projedata.model.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {
    public List<Employee> insertEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        employees.add(new Employee("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        employees.add(new Employee("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        employees.add(new Employee("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        employees.add(new Employee("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        employees.add(new Employee("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        employees.add(new Employee("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        employees.add(new Employee("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        employees.add(new Employee("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        employees.add(new Employee("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
        return employees;
    }

    public void removeEmployeeByName(List<Employee> employees, String name) {
        employees.removeIf(employee -> employee.getName().equals(name));
    }

    public void increaseSalaries(List<Employee> employees, BigDecimal percentage) {
        for (Employee employee : employees) {
            boolean isSalaryIncreased = employee.increaseSalary(percentage);
            if (!isSalaryIncreased) {
                throw new IllegalArgumentException("Erro ao aumentar salarios");
            }
        }
    }

    public Map<String, List<Employee>> groupEmployeesByRole(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getRole));
    }

    public List<Employee> getBirthdayEmployees(List<Employee> employees, int... months) {
        return employees.stream()
                .filter(employee -> {
                    int birthMonth = employee.getDateOfBirth().getMonthValue();
                    for (int month : months) {
                        if (birthMonth == month) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }
    public Optional<Employee> getOldestEmployee(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return Optional.empty();
        }
        return employees.stream()
                .min(Comparator.comparing(Employee::getDateOfBirth));
    }

    public List<Employee> getEmployeesSortedByName(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

}
