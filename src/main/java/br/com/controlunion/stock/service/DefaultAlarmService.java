package br.com.controlunion.stock.service;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.controlunion.stock.dto.AlarmTotalDto;
import br.com.controlunion.stock.model.Alarm;
import br.com.controlunion.stock.repository.AlarmRepository;

@Named
public class DefaultAlarmService implements AlarmService {

    @Inject
    AlarmRepository alarmRepository;

    @Override
    public Page<Alarm> findAll(Pageable pageable) {
        Page<Alarm> list = alarmRepository.findAll(pageable);
        return list;
    }

    @Override
    public void update(int id) {
        Alarm alarm = alarmRepository.findOne(id);
        alarm.setReadDate(new Date());
        alarmRepository.save(alarm);
    }

    @Override
    public AlarmTotalDto countAlarm() {
        AlarmTotalDto alarm = new AlarmTotalDto();
        alarm.setTotal(alarmRepository.countAlarm());
        return alarm;
    }

}
