package br.com.controlunion.stock.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.controlunion.stock.model.Company;
import br.com.controlunion.stock.repository.CompanyRepository;

@Named
public class DefaultCompanyService implements CompanyService {

    @Inject
    CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findByEnable(true);
    }

}
