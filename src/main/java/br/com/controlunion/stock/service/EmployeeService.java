package br.com.controlunion.stock.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.controlunion.stock.model.Employee;

public interface EmployeeService {

    void create(Employee employee);

    Employee findOne(int employeeId);

    void update(int employeeId, Employee employee);

    void delete(int employeeId);

    List<Employee> findByCompanyId(int companyId);

    Page<Employee> findAll(Pageable pageable);

    Employee findByEmployeeDocumentId(int employeeDocumentId);
}
