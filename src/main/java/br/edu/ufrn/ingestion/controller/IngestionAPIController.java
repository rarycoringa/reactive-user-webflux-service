package br.edu.ufrn.ingestion.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
public class IngestionAPIController {
    @PostMapping("/glucose")
    public ResponseEntity<BloodGlucose> glucose(@RequestBody BloodGlucoseRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(request.bloodGlucose());
    }

    @PostMapping("/pressure")
    public ResponseEntity<BloodPressure> pressure(@RequestBody BloodPressureRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(request.bloodPressure());
    }

    @PostMapping("/temperature")
    public ResponseEntity<BodyTemperature> temperature(@RequestBody BodyTemperatureRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(request.bodyTemperature());
    }

    @PostMapping("/heart")
    public ResponseEntity<HeartRate> heart(@RequestBody HeartRateRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(request.heartRate());
    }

    @PostMapping("/saturation")
    public ResponseEntity<OxygenSaturation> saturation(@RequestBody OxygenSaturationRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(request.oxygenSaturation());
    }

    @PostMapping("/respiration")
    public ResponseEntity<RespirationRate> respiration(@RequestBody RespirationRateRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(request.respirationRate());
    }
}
