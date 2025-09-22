package br.edu.ufrn.ingestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
import br.edu.ufrn.ingestion.service.IngestionService;

@RestController
public class IngestionRestAPIController {

    @Autowired
    private IngestionService ingestionService;

    @GetMapping("/glucose")
    public ResponseEntity<List<BloodGlucose>> retrieveBloodGlucose(@RequestBody BloodGlucoseRequest request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null);
    }

    @PostMapping("/glucose")
    public ResponseEntity<BloodGlucose> createBloodGlucose(@RequestBody BloodGlucoseRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(request.bloodGlucose());
    }

    @GetMapping("/pressure")
    public ResponseEntity<List<BloodPressure>> retrieveBloodPressure(@RequestBody BloodPressureRequest request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null);
    }

    @PostMapping("/pressure")
    public ResponseEntity<BloodPressure> createBloodPressure(@RequestBody BloodPressureRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(request.bloodPressure());
    }

    @GetMapping("/temperature")
    public ResponseEntity<List<BodyTemperature>> retrieveBodyTemperature(@RequestBody BodyTemperatureRequest request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null);
    }

    @PostMapping("/temperature")
    public ResponseEntity<BodyTemperature> createBodyTemperature(@RequestBody BodyTemperatureRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(request.bodyTemperature());
    }

    @GetMapping("/heart")
    public ResponseEntity<List<HeartRate>> retrieveateHeartRate(@RequestBody HeartRateRequest request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null);
    }

    @PostMapping("/heart")
    public ResponseEntity<HeartRate> createHeartRate(@RequestBody HeartRateRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(request.heartRate());
    }

    @GetMapping("/saturation")
    public ResponseEntity<List<OxygenSaturation>> retrieveOxygenSaturation(@RequestBody OxygenSaturationRequest request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null);
    }

    @PostMapping("/saturation")
    public ResponseEntity<OxygenSaturation> createOxygenSaturation(@RequestBody OxygenSaturationRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(request.oxygenSaturation());
    }

    @GetMapping("/respiration")
    public ResponseEntity<List<RespirationRate>> retrieveRespirationRate(@RequestBody RespirationRateRequest request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null);
    }

    @PostMapping("/respiration")
    public ResponseEntity<RespirationRate> createRespirationRate(@RequestBody RespirationRateRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(request.respirationRate());
    }
}
