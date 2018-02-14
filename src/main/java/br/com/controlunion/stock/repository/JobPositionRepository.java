package br.com.controlunion.stock.repository;

import java.util.List;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlunion.stock.model.JobPosition;

@Named
public interface JobPositionRepository extends JpaRepository<JobPosition, Integer> {

    List<JobPosition> findByEnable(Boolean enable);
}
