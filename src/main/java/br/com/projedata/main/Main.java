package br.com.projedata.main;

import br.com.projedata.model.Employee;
import br.com.projedata.service.EmployeeService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        List<Employee> employees = employeeService.insertEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }


    }
}
