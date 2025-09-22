package br.edu.ufrn.ingestion.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
public class IngestionRestAPIController {

    @Autowired
    private IngestionService ingestionService;

    @GetMapping("/pressure")
    public ResponseEntity<List<BloodPressureResponse>> retrieveBloodPressure(
        @RequestParam("patient_id") int patientId,
        @RequestParam LocalDateTime start,
        @RequestParam LocalDateTime end
    ) {

        List<BloodPressureResponse> response = ingestionService.retrieveBloodPressure(
            patientId, start, end
        );

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @PostMapping("/pressure")
    public ResponseEntity<BloodPressureResponse> createBloodPressure(
        @RequestBody BloodPressureRequest request
    ) {

        BloodPressureResponse response = ingestionService.createBloodPressure(request);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }

    @GetMapping("/heart")
    public ResponseEntity<List<HeartRateResponse>> retrieveHeartRate(
        @RequestParam("patient_id") int patientId,
        @RequestParam LocalDateTime start,
        @RequestParam LocalDateTime end
    ) {

        List<HeartRateResponse> response = ingestionService.retrieveHeartRate(
            patientId, start, end
        );

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @PostMapping("/heart")
    public ResponseEntity<HeartRateResponse> createHeartRate(
        @RequestBody HeartRateRequest request
    ) {

        HeartRateResponse response = ingestionService.createHeartRate(request);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }

    @GetMapping("/saturation")
    public ResponseEntity<List<OxygenSaturationResponse>> retrieveOxygenSaturation(
        @RequestParam("patient_id") int patientId,
        @RequestParam LocalDateTime start,
        @RequestParam LocalDateTime end
    ) {

        List<OxygenSaturationResponse> response = ingestionService.retrieveOxygenSaturation(
            patientId, start, end
        );

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @PostMapping("/saturation")
    public ResponseEntity<OxygenSaturationResponse> createOxygenSaturation(
        @RequestBody OxygenSaturationRequest request
    ) {

        OxygenSaturationResponse response = ingestionService.createOxygenSaturation(request);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }

}
