package com.emlakjet.adapter.consumer;

import com.emlakjet.configuration.KafkaConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class KafkaConsumerListener {

    @KafkaListener(topics = KafkaConfiguration.BENCHMARK_TOPIC)
    public void benchmarkSink(ConsumerRecord<String, Map<String, Object>> payload) {
        log.info(payload.toString());
    }
}
