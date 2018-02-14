package br.com.controlunion.stock.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.controlunion.stock.dto.AlarmTotalDto;
import br.com.controlunion.stock.model.Alarm;

public interface AlarmService {

    Page<Alarm> findAll(Pageable pageable);

    void update(int id);

    AlarmTotalDto countAlarm();
}
