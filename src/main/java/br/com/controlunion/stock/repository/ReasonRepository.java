package br.com.controlunion.stock.repository;

import java.util.List;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlunion.stock.model.Reason;

@Named
public interface ReasonRepository extends JpaRepository<Reason, Integer> {

    List<Reason> findByEnable(Boolean enable);
}
