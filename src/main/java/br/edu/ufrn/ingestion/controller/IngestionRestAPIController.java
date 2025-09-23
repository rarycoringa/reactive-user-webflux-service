package br.edu.ufrn.ingestion.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufrn.ingestion.record.request.BloodPressureRequest;
import br.edu.ufrn.ingestion.record.request.HeartRateRequest;
import br.edu.ufrn.ingestion.record.request.OxygenSaturationRequest;
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

    @GetMapping("/pressure")
    public Flux<BloodPressureResponse> retrieveBloodPressure(
        @RequestParam("patient_id") int patientId,
        @RequestParam LocalDateTime start,
        @RequestParam LocalDateTime end
    ) {
        return ingestionService.retrieveBloodPressure(patientId, start, end);
    }

    @PostMapping("/pressure")
    public Mono<BloodPressureResponse> createBloodPressure(
        @RequestBody BloodPressureRequest request
    ) {
        return ingestionService.createBloodPressure(request);
    }

    @GetMapping("/heart")
    public Flux<HeartRateResponse> retrieveHeartRate(
        @RequestParam("patient_id") int patientId,
        @RequestParam LocalDateTime start,
        @RequestParam LocalDateTime end
    ) {
        return ingestionService.retrieveHeartRate(patientId, start, end);
    }

    @PostMapping("/heart")
    public Mono<HeartRateResponse> createHeartRate(
        @RequestBody HeartRateRequest request
    ) {
        return ingestionService.createHeartRate(request);
    }

    @GetMapping("/saturation")
    public Flux<OxygenSaturationResponse> retrieveOxygenSaturation(
        @RequestParam("patient_id") int patientId,
        @RequestParam LocalDateTime start,
        @RequestParam LocalDateTime end
    ) {
        return ingestionService.retrieveOxygenSaturation(patientId, start, end);
    }

    @PostMapping("/saturation")
    public Mono<OxygenSaturationResponse> createOxygenSaturation(
        @RequestBody OxygenSaturationRequest request
    ) {
        return ingestionService.createOxygenSaturation(request);
    }

}
