package br.com.controlunion.stock.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.controlunion.stock.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByEnableAndCompanyId(Boolean enable, int companyId);

    Page<Employee> findByEnable(Boolean enable, Pageable pageable);

    @Query("SELECT e FROM Employee e JOIN e.documents ed JOIN ed.document d WHERE ed.id NOT IN "
            + "(SELECT d2.id FROM AlarmDocument al JOIN al.document d2) AND ed.expirationDate <= ?1 AND e.enable = true")
    List<Employee> findValidity(Date date);

    @Query("SELECT distinct e FROM Employee e JOIN e.documents ed WHERE ed.id NOT IN "
            + "(SELECT al.id FROM AlarmDocument al) AND e.enable = true")
    List<Employee> findValidity();

    Employee findByDocumentsId(int employeeDocumentId);
}


//AND ed.expirationDate IS NULL AND ed.validity IS NOT NULL