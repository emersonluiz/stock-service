package br.com.controlunion.stock.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class StockOutSchedule {

    private static final Logger LOG = LoggerFactory.getLogger(StockOutSchedule.class);

    @Scheduled(fixedRate=5000)
    public void checkProducts() {
        LOG.debug("Task is running!!!");
    }
}
