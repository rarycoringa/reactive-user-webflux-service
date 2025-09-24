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
import br.edu.ufrn.ingestion.record.response.BloodPressureResponse;
import br.edu.ufrn.ingestion.record.response.HeartRateResponse;
import br.edu.ufrn.ingestion.record.response.OxygenSaturationResponse;
import br.edu.ufrn.ingestion.repository.BloodPressureRepository;
import br.edu.ufrn.ingestion.repository.HeartRateRepository;
import br.edu.ufrn.ingestion.repository.OxygenSaturationRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class IngestionService {

    private final Sinks.Many<BloodPressureResponse> bloodPressureSinkMany = Sinks
        .many()
        .replay()
        .latest();

    private final Flux<BloodPressureResponse> bloodPressureFlux = bloodPressureSinkMany
        .asFlux();
    
    private final Sinks.Many<HeartRateResponse> heartRateSinkMany = Sinks
        .many()
        .replay()
        .latest();

    private final Flux<HeartRateResponse> heartRateFlux = heartRateSinkMany
        .asFlux();
    
    private final Sinks.Many<OxygenSaturationResponse> oxygenSaturationSinkMany = Sinks
        .many()
        .replay()
        .latest();

    private final Flux<OxygenSaturationResponse> oxygenSaturationFlux = oxygenSaturationSinkMany
        .asFlux();

    @Autowired
    private BloodPressureRepository bloodPressureRepository;

    @Autowired
    private HeartRateRepository heartRateRepository;

    @Autowired
    private OxygenSaturationRepository oxygenSaturationRepository;

    public Flux<BloodPressureResponse> subscribeBloodPressure(int patientId) {
        return bloodPressureFlux
            .filter(response -> response.patientId() == patientId);
    }

    public Flux<BloodPressureResponse> subscribeBloodPressureBetween(
        int patientId,
        LocalDateTime start,
        LocalDateTime end
    ) {
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

    public Mono<BloodPressureResponse> publishBloodPressure(
        int patientId,
        BloodPressure bloodPressure
    ) {
        BloodPressureModel bloodPressureModel = new BloodPressureModel(
            patientId,
            Instant.now(),
            bloodPressure.systolicValue(),
            bloodPressure.diastolicValue()
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
            )
            .doOnNext(bloodPressureSinkMany::tryEmitNext);
    }

    public Flux<HeartRateResponse> subscribeHeartRate(int patientId) {
        return heartRateFlux
            .filter(response -> response.patientId() == patientId);
    }

    public Flux<HeartRateResponse> subscribeHeartRateBetween(
        int patientId,
        LocalDateTime start,
        LocalDateTime end
    ) {
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

    public Mono<HeartRateResponse> publishHeartRate(
        int patientId,
        HeartRate heartRate
    ) {
        HeartRateModel heartRateModel = new HeartRateModel(
            patientId,
            Instant.now(),
            heartRate.value()
        );

        return heartRateRepository
            .save(heartRateModel)
            .map(
                model -> new HeartRateResponse(
                    model.getPatientId(),
                    model.getRegisteredAt(),
                    new HeartRate(model.getValue())
                )
            )
            .doOnNext(heartRateSinkMany::tryEmitNext);
    }

    public Flux<OxygenSaturationResponse> subscribeOxygenSaturation(int patientId) {
        return oxygenSaturationFlux
            .filter(response -> response.patientId() == patientId);
    }

    public Flux<OxygenSaturationResponse> subscribeOxygenSaturationBetween(
        int patientId,
        LocalDateTime start,
        LocalDateTime end
    ) {
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

    public Mono<OxygenSaturationResponse> publishOxygenSaturation(
        int patientId,
        OxygenSaturation oxygenSaturation
    ) {
        OxygenSaturationModel oxygenSaturationModel = new OxygenSaturationModel(
            patientId,
            Instant.now(),
            oxygenSaturation.value()
        );

        return oxygenSaturationRepository
            .save(oxygenSaturationModel)
            .map(
                model -> new OxygenSaturationResponse(
                    model.getPatientId(),
                    model.getRegisteredAt(),
                    new OxygenSaturation(model.getValue())
                )
            )
            .doOnNext(oxygenSaturationSinkMany::tryEmitNext);
    }

}
