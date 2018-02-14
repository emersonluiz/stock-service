package br.com.controlunion.stock.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.controlunion.stock.model.Size;
import br.com.controlunion.stock.repository.SizeRepository;

@Named
public class DefaultSizeService implements SizeService {

    @Inject
    SizeRepository sizeRepository;

    @Override
    public List<Size> findAll() {
        return sizeRepository.findByEnable(true);
    }

}
