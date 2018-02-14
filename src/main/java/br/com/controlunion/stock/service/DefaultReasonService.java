package br.com.controlunion.stock.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.controlunion.stock.model.Reason;
import br.com.controlunion.stock.repository.ReasonRepository;

@Named
public class DefaultReasonService implements ReasonService {

    @Inject
    ReasonRepository reasonRepository;

    @Override
    public List<Reason> findAll() {
        return reasonRepository.findByEnable(true);
    }

}
