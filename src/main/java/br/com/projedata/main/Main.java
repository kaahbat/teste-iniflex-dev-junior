package br.com.projedata.main;

import br.com.projedata.model.Employee;
import br.com.projedata.service.EmployeeService;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        List<Employee> employees = employeeService.insertEmployees();
        printEmployees("Lista de Funcionários", employees);

        employeeService.removeEmployeeByName(employees, "João");
        printEmployees("Lista de Funcionários Após Remoção", employees);

        employeeService.increaseSalaries(employees, new BigDecimal("10"));
        printEmployees("Lista de Funcionarios Após o aumento salarial", employees);

        Map<String, List<Employee>> employeesByRole = employeeService.groupEmployeesByRole(employees);

        printGroupedEmployees(employeesByRole);


    }
    private static void printEmployees(String title, List<Employee> employees) {
        System.out.println("\n--- " + title + " ---");
        employees.forEach(System.out::println);
    }
    private static void printGroupedEmployees(Map<String, List<Employee>> employeesByRole) {
        System.out.println("\n--- Funcionários Agrupados por Função ---");
        employeesByRole.forEach((role, employeeList) -> {
            System.out.println("Função: " + role);
            employeeList.forEach(System.out::println);
            System.out.println();
        });
    }
}


