package br.com.controlunion.stock.rest;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlunion.stock.dto.AlarmTotalDto;
import br.com.controlunion.stock.model.Alarm;
import br.com.controlunion.stock.service.AlarmService;

@RestController
@RequestMapping("/alarms")
public class AlarmResource {

    @Inject
    AlarmService alarmService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Page<Alarm> findAll(Pageable pageable) {
       return alarmService.findAll(pageable);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value="/{alarmId}", method = RequestMethod.PUT)
    public void update(@PathVariable("alarmId") int id) {
        alarmService.update(id);
    }

    @RequestMapping(value="/total", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public AlarmTotalDto countAlarm() {
       return alarmService.countAlarm();
    }
}
