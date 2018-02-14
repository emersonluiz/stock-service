package br.com.controlunion.stock.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.controlunion.stock.model.State;
import br.com.controlunion.stock.repository.StateRepository;

@Named
public class DefaultStateService implements StateService {

    @Inject
    StateRepository stateRepository;

    @Override
    public List<State> findAll() {
        return stateRepository.findAll();
    }

}
