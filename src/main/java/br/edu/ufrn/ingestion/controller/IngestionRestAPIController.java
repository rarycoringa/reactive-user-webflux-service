package br.edu.ufrn.ingestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufrn.ingestion.record.request.BloodPressureRequest;
import br.edu.ufrn.ingestion.record.request.HeartRateRequest;
import br.edu.ufrn.ingestion.record.request.OxygenSaturationRequest;
import br.edu.ufrn.ingestion.record.request.RetrieveRequest;
import br.edu.ufrn.ingestion.record.response.BloodPressureResponse;
import br.edu.ufrn.ingestion.record.response.HeartRateResponse;
import br.edu.ufrn.ingestion.record.response.OxygenSaturationResponse;
import br.edu.ufrn.ingestion.service.IngestionService;

@RestController
public class IngestionRestAPIController {

    @Autowired
    private IngestionService ingestionService;

    @GetMapping("/pressure")
    public ResponseEntity<List<BloodPressureResponse>> retrieveBloodPressure(RetrieveRequest request) {

        List<BloodPressureResponse> response = ingestionService.retrieveBloodPressure(request);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @PostMapping("/pressure")
    public ResponseEntity<BloodPressureResponse> createBloodPressure(@RequestBody BloodPressureRequest request) {

        BloodPressureResponse response = ingestionService.createBloodPressure(request);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }

    @GetMapping("/heart")
    public ResponseEntity<List<HeartRateResponse>> retrieveHeartRate(RetrieveRequest request) {

        List<HeartRateResponse> response = ingestionService.retrieveHeartRate(request);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @PostMapping("/heart")
    public ResponseEntity<HeartRateResponse> createHeartRate(@RequestBody HeartRateRequest request) {

        HeartRateResponse response = ingestionService.createHeartRate(request);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }

    @GetMapping("/saturation")
    public ResponseEntity<List<OxygenSaturationResponse>> retrieveOxygenSaturation(RetrieveRequest request) {

        List<OxygenSaturationResponse> response = ingestionService.retrieveOxygenSaturation(request);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @PostMapping("/saturation")
    public ResponseEntity<OxygenSaturationResponse> createOxygenSaturation(@RequestBody OxygenSaturationRequest request) {

        OxygenSaturationResponse response = ingestionService.createOxygenSaturation(request);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }

}
