package br.com.controlunion.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.controlunion.stock.model.Alarm;

public interface AlarmRepository extends JpaRepository<Alarm, Integer> {

    @Query("select count(a) from Alarm a where a.readDate = null")
    int countAlarm();
}
