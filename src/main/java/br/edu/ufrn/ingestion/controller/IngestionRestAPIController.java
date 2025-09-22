package br.edu.ufrn.ingestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufrn.ingestion.record.BloodGlucose;
import br.edu.ufrn.ingestion.record.BloodPressure;
import br.edu.ufrn.ingestion.record.BodyTemperature;
import br.edu.ufrn.ingestion.record.HeartRate;
import br.edu.ufrn.ingestion.record.OxygenSaturation;
import br.edu.ufrn.ingestion.record.RespirationRate;
import br.edu.ufrn.ingestion.record.request.BloodGlucoseRequest;
import br.edu.ufrn.ingestion.record.request.BloodPressureRequest;
import br.edu.ufrn.ingestion.record.request.BodyTemperatureRequest;
import br.edu.ufrn.ingestion.record.request.HeartRateRequest;
import br.edu.ufrn.ingestion.record.request.OxygenSaturationRequest;
import br.edu.ufrn.ingestion.record.request.RespirationRateRequest;
import br.edu.ufrn.ingestion.record.request.RetrieveRequest;
import br.edu.ufrn.ingestion.record.response.BloodGlucoseResponse;
import br.edu.ufrn.ingestion.record.response.BloodPressureResponse;
import br.edu.ufrn.ingestion.record.response.BodyTemperatureResponse;
import br.edu.ufrn.ingestion.record.response.HeartRateResponse;
import br.edu.ufrn.ingestion.record.response.OxygenSaturationResponse;
import br.edu.ufrn.ingestion.record.response.RespirationRateResponse;
import br.edu.ufrn.ingestion.service.IngestionService;

@RestController
public class IngestionRestAPIController {

    @Autowired
    private IngestionService ingestionService;

    @GetMapping("/glucose")
    public ResponseEntity<List<BloodGlucoseResponse>> retrieveBloodGlucose(RetrieveRequest request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null);
    }

    @PostMapping("/glucose")
    public ResponseEntity<BloodGlucoseResponse> createBloodGlucose(@RequestBody BloodGlucoseRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(null);
    }

    @GetMapping("/pressure")
    public ResponseEntity<List<BloodPressureResponse>> retrieveBloodPressure(RetrieveRequest request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null);
    }

    @PostMapping("/pressure")
    public ResponseEntity<BloodPressureResponse> createBloodPressure(@RequestBody BloodPressureRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(null);
    }

    @GetMapping("/temperature")
    public ResponseEntity<List<BodyTemperatureResponse>> retrieveBodyTemperature(RetrieveRequest request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null);
    }

    @PostMapping("/temperature")
    public ResponseEntity<BodyTemperatureResponse> createBodyTemperature(@RequestBody BodyTemperatureRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(null);
    }

    @GetMapping("/heart")
    public ResponseEntity<List<HeartRateResponse>> retrieveHeartRate(RetrieveRequest request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null);
    }

    @PostMapping("/heart")
    public ResponseEntity<HeartRateResponse> createHeartRate(@RequestBody HeartRateRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(null);
    }

    @GetMapping("/saturation")
    public ResponseEntity<List<OxygenSaturationResponse>> retrieveOxygenSaturation(RetrieveRequest request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null);
    }

    @PostMapping("/saturation")
    public ResponseEntity<OxygenSaturationResponse> createOxygenSaturation(@RequestBody OxygenSaturationRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(null);
    }

    @GetMapping("/respiration")
    public ResponseEntity<List<RespirationRateResponse>> retrieveRespirationRate(RetrieveRequest request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null);
    }

    @PostMapping("/respiration")
    public ResponseEntity<RespirationRateResponse> createRespirationRate(@RequestBody RespirationRateRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(null);
    }
}
