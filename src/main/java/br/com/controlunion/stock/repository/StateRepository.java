package br.com.controlunion.stock.repository;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlunion.stock.model.State;

@Named
public interface StateRepository extends JpaRepository<State, Integer> {

}
