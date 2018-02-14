package br.com.controlunion.stock.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlunion.stock.model.Company;
import br.com.controlunion.stock.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyResource {

    @Inject
    CompanyService companyService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Company> findAll() {
        return companyService.findAll();
    }

}
