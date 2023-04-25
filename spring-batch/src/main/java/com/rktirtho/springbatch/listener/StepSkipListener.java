package com.rktirtho.springbatch.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rktirtho.springbatch.entity.Customer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.SkipListener;

@Slf4j
public class StepSkipListener implements SkipListener<Customer, Number> {

    @Override
    public void onSkipInRead(Throwable t) {
        log.error("Line read failed {}",t.getMessage());
    }

    @Override
    public void onSkipInWrite(Number item, Throwable t) {
        log.error("Line write failed {} {}",t.getMessage(), item);
    }

    @SneakyThrows
    @Override
    public void onSkipInProcess(Customer item, Throwable t) {
        log.error("Failed to process {}"+ new ObjectMapper().writeValueAsString(item));
    }
}
