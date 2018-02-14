package br.com.controlunion.stock.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.controlunion.stock.model.JobPosition;
import br.com.controlunion.stock.repository.JobPositionRepository;

@Named
public class DefaultJobPositionService implements JobPositionService {

    @Inject
    JobPositionRepository jobPositionRepository;

    @Override
    public List<JobPosition> findAll() {
        return jobPositionRepository.findByEnable(true);
    }

}
