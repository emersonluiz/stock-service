package br.com.controlunion.stock.repository;

import java.util.List;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlunion.stock.model.Company;

@Named
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    List<Company> findByEnable(Boolean enable);
}
