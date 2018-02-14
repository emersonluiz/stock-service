package br.com.controlunion.stock.rest;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.controlunion.stock.model.Employee;
import br.com.controlunion.stock.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {

    @Inject
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<Employee> create(@RequestBody @Valid Employee employee) throws Exception {
        employeeService.create(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();
        return ResponseEntity.created(location).body(employee);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/{employeeId}", method = RequestMethod.GET, produces = { "application/json" })
    public Employee findOne(@PathVariable("employeeId") int employeeId) throws Exception {
        return employeeService.findOne(employeeId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value="/{employeeId}", method = RequestMethod.PUT)
    public void update(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee) throws Exception {
        employeeService.update(employeeId, employee);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value="/{employeeId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("employeeId") int employeeId) throws Exception {
        employeeService.delete(employeeId);
    }

    @RequestMapping(value="/company/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findByCompanyId(@PathVariable("companyId") int companyId) {
        return employeeService.findByCompanyId(companyId);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Page<Employee> findAll(Pageable pageable) {
        return employeeService.findAll(pageable);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/employeeDocument/{employeeDocumentId}", method = RequestMethod.GET, produces = { "application/json" })
    public Employee findByEmployeeDocumentId(@PathVariable("employeeDocumentId") int employeeDocumentId) throws Exception {
        return employeeService.findByEmployeeDocumentId(employeeDocumentId);
    }

}
