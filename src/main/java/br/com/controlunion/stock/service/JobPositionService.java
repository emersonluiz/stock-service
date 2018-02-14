package br.com.controlunion.stock.service;

import java.util.List;

import br.com.controlunion.stock.model.JobPosition;

public interface JobPositionService {

    List<JobPosition> findAll();
}
