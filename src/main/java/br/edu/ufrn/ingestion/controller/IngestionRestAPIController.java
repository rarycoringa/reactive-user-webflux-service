package br.edu.ufrn.ingestion.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufrn.ingestion.record.BloodPressure;
import br.edu.ufrn.ingestion.record.HeartRate;
import br.edu.ufrn.ingestion.record.OxygenSaturation;
import br.edu.ufrn.ingestion.record.response.BloodPressureResponse;
import br.edu.ufrn.ingestion.record.response.HeartRateResponse;
import br.edu.ufrn.ingestion.record.response.OxygenSaturationResponse;
import br.edu.ufrn.ingestion.service.IngestionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class IngestionRestAPIController {

    @Autowired
    private IngestionService ingestionService;

    @GetMapping(value = "/{id}/pressure/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<BloodPressureResponse> subscribeBloodPressure(
        @PathVariable("id") int patientId
    ) {
        return ingestionService.subscribeBloodPressure(patientId);
    }

    @GetMapping(value = "/{id}/pressure/past", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<BloodPressureResponse> subscribeBloodPressureBetween(
        @PathVariable("id") int patientId,
        @RequestParam LocalDateTime start,
        @RequestParam LocalDateTime end
    ) {
        return ingestionService.subscribeBloodPressureBetween(patientId, start, end);
    }

    @PostMapping("/{id}/pressure/publish")
    public Mono<BloodPressureResponse> publishBloodPressure(
        @PathVariable("id") int patientId,
        @RequestBody BloodPressure bloodPressure
    ) {
        return ingestionService.publishBloodPressure(patientId, bloodPressure);
    }

    @GetMapping(value = "/{id}/heart/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<HeartRateResponse> subscribeHeartRate(
        @PathVariable("id") int patientId
    ) {
        return ingestionService.subscribeHeartRate(patientId);
    }

    @GetMapping(value = "/{id}/heart/past", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<HeartRateResponse> subscribeHeartRateBetween(
        @PathVariable("id") int patientId,
        @RequestParam LocalDateTime start,
        @RequestParam LocalDateTime end
    ) {
        return ingestionService.subscribeHeartRateBetween(patientId, start, end);
    }

    @PostMapping("/{id}/heart/publish")
    public Mono<HeartRateResponse> publishHeartRate(
        @PathVariable("id") int patientId,
        @RequestBody HeartRate heartRate
    ) {
        return ingestionService.publishHeartRate(patientId, heartRate);
    }

    @GetMapping(value = "/{id}/saturation/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<OxygenSaturationResponse> subscribeOxygenSaturation(
        @PathVariable("id") int patientId
    ) {
        return ingestionService.subscribeOxygenSaturation(patientId);
    }

    @GetMapping(value = "/{id}/saturation/past", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<OxygenSaturationResponse> subscribeOxygenSaturationBetween(
        @PathVariable("id") int patientId,
        @RequestParam LocalDateTime start,
        @RequestParam LocalDateTime end
    ) {
        return ingestionService.subscribeOxygenSaturationBetween(patientId, start, end);
    }

    @PostMapping("/{id}/saturation/publish")
    public Mono<OxygenSaturationResponse> publishOxygenSaturation(
        @PathVariable("id") int patientId,
        @RequestBody OxygenSaturation oxygenSaturation
    ) {
        return ingestionService.publishOxygenSaturation(patientId, oxygenSaturation);
    }

}
