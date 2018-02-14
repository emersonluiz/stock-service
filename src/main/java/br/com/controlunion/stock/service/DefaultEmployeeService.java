package br.com.controlunion.stock.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.controlunion.stock.model.Document;
import br.com.controlunion.stock.model.Employee;
import br.com.controlunion.stock.model.EmployeeDocument;
import br.com.controlunion.stock.repository.DocumentRepository;
import br.com.controlunion.stock.repository.EmployeeRepository;

@Named
public class DefaultEmployeeService implements EmployeeService {

    @Inject
    EmployeeRepository employeeRepository;
    @Inject
    DocumentRepository documentRepository;

    @Override
    public void create(Employee employee) {
        employee.setEnable(true);
        employeeRepository.save(employee);
    }

    @Override
    public Employee findOne(int employeeId) {
        return employeeRepository.findOne(employeeId);
    }

    @Override
    public void update(int employeeId, Employee employee) {
        findOne(employeeId);
        employee.setId(employeeId);
        employee.setEnable(true);

        if(employee.getDocuments() != null) {
            for (EmployeeDocument employeeDocument : employee.getDocuments()) {
                Document document = documentRepository.findOne(employeeDocument.getDocument().getId());
                employeeDocument.setDocument(document);
            }
        }
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int employeeId) {
        Employee employee = findOne(employeeId);
        employee.setEnable(false);
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByCompanyId(int companyId) {
        return employeeRepository.findByEnableAndCompanyId(true, companyId);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findByEnable(true, pageable);
    }

    @Override
    public Employee findByEmployeeDocumentId(int employeeDocumentId) {
        return employeeRepository.findByDocumentsId(employeeDocumentId);
    }

}
