package br.edu.ufrn.ingestion.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufrn.ingestion.model.BloodPressureModel;
import br.edu.ufrn.ingestion.model.HeartRateModel;
import br.edu.ufrn.ingestion.model.OxygenSaturationModel;
import br.edu.ufrn.ingestion.record.BloodPressure;
import br.edu.ufrn.ingestion.record.HeartRate;
import br.edu.ufrn.ingestion.record.OxygenSaturation;
import br.edu.ufrn.ingestion.record.request.BloodPressureRequest;
import br.edu.ufrn.ingestion.record.request.HeartRateRequest;
import br.edu.ufrn.ingestion.record.request.OxygenSaturationRequest;
import br.edu.ufrn.ingestion.record.response.BloodPressureResponse;
import br.edu.ufrn.ingestion.record.response.HeartRateResponse;
import br.edu.ufrn.ingestion.record.response.OxygenSaturationResponse;
import br.edu.ufrn.ingestion.repository.BloodPressureRepository;
import br.edu.ufrn.ingestion.repository.HeartRateRepository;
import br.edu.ufrn.ingestion.repository.OxygenSaturationRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IngestionService {

    @Autowired
    private BloodPressureRepository bloodPressureRepository;

    @Autowired
    private HeartRateRepository heartRateRepository;

    @Autowired
    private OxygenSaturationRepository oxygenSaturationRepository;

    public Flux<BloodPressureResponse> retrieveBloodPressure(int patientId, LocalDateTime start, LocalDateTime end) {
        Instant startAsInstant = start.atZone(ZoneOffset.UTC).toInstant();
        Instant endAsInstant = end.atZone(ZoneOffset.UTC).toInstant();
        
        return bloodPressureRepository
            .findByPatientIdAndRegisteredAtBetween(patientId, startAsInstant, endAsInstant)
            .map(
                model -> new BloodPressureResponse(
                    model.getPatientId(),
                    model.getRegisteredAt(),
                    new BloodPressure(
                        model.getSystolicValue(),
                        model.getDiastolicValue()
                    )
                )
            );
    }

    public Mono<BloodPressureResponse> createBloodPressure(BloodPressureRequest request) {
        BloodPressureModel bloodPressureModel = new BloodPressureModel(
            request.patientId(),
            Instant.now(),
            request.bloodPressure().systolicValue(),
            request.bloodPressure().diastolicValue()
        );

        return bloodPressureRepository
            .save(bloodPressureModel)
            .map(
                model -> new BloodPressureResponse(
                    model.getPatientId(),
                    model.getRegisteredAt(),
                    new BloodPressure(
                        model.getSystolicValue(),
                        model.getDiastolicValue()
                    )
                )
            );
    }

    public Flux<HeartRateResponse> retrieveHeartRate(int patientId, LocalDateTime start, LocalDateTime end) {
        Instant startAsInstant = start.atZone(ZoneOffset.UTC).toInstant();
        Instant endAsInstant = end.atZone(ZoneOffset.UTC).toInstant();
        
        return heartRateRepository
            .findByPatientIdAndRegisteredAtBetween(patientId, startAsInstant, endAsInstant)
            .map(
                model -> new HeartRateResponse(
                    model.getPatientId(),
                    model.getRegisteredAt(),
                    new HeartRate(model.getValue())
                )
            );
    }

    public Mono<HeartRateResponse> createHeartRate(HeartRateRequest request) {
        HeartRateModel heartRateModel = new HeartRateModel(
            request.patientId(),
            Instant.now(),
            request.heartRate().value()
        );

        return heartRateRepository
            .save(heartRateModel)
            .map(
                model -> new HeartRateResponse(
                    model.getPatientId(),
                    model.getRegisteredAt(),
                    new HeartRate(model.getValue())
                )
            );
    }

    public Flux<OxygenSaturationResponse> retrieveOxygenSaturation(int patientId, LocalDateTime start, LocalDateTime end) {
        Instant startAsInstant = start.atZone(ZoneOffset.UTC).toInstant();
        Instant endAsInstant = end.atZone(ZoneOffset.UTC).toInstant();
        
        return oxygenSaturationRepository
            .findByPatientIdAndRegisteredAtBetween(patientId, startAsInstant, endAsInstant)
            .map(
                model -> new OxygenSaturationResponse(
                    model.getPatientId(),
                    model.getRegisteredAt(),
                    new OxygenSaturation(model.getValue())
                )
            );
    }

    public Mono<OxygenSaturationResponse> createOxygenSaturation(OxygenSaturationRequest request) {
        OxygenSaturationModel oxygenSaturationModel = new OxygenSaturationModel(
            request.patientId(),
            Instant.now(),
            request.oxygenSaturation().value()
        );

        return oxygenSaturationRepository
            .save(oxygenSaturationModel)
            .map(
                model -> new OxygenSaturationResponse(
                    model.getPatientId(),
                    model.getRegisteredAt(),
                    new OxygenSaturation(model.getValue())
                )
            );
    }

}
