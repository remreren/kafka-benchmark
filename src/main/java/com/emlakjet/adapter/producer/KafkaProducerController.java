package com.emlakjet.adapter.producer;

import com.emlakjet.configuration.KafkaConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerController {

    private final KafkaTemplate<String, Object> sampleKafkaSender;

    @GetMapping("/produce")
    public void produce()  {
        Map<String, Object> sample = Map.of(
                "advertId", 1234L,
                "title", "Lorem ipsum",
                "content", "Lorem ipsum dföfdb dfbfmkgbmfg fgkbmfkgbmfgbfg fgbölfgöblfgöblfgölnfgö fşlgöbfdlgbdşferfper",
                "price", BigDecimal.TEN,
                "location", Map.of(
                        "lat", 128.454D,
                        "lng", 234.6453D,
                        "city", Map.of(
                                "cityId", 34L,
                                "name", "İstanbul",
                                "slug", "istanbul"
                        )
                ),
                "features", Map.of(
                        "indoorFeatures", Map.of(
                                "roomCount", "3+1",
                                "bathCount", 2,
                                "floorNumber", 2,
                                "floorCount", 5
                        ),
                        "outdoorFeatures", Map.of(
                                "nearMetro", true,
                                "nearHospital", true,
                                "hasGarden", true,
                                "hasPool", true)));

        sampleKafkaSender.send(KafkaConfiguration.BENCHMARK_TOPIC, sample);
    }
}
