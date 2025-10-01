package br.edu.ufrn.ingestion.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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

    public Mono<BloodPressureResponse> publishBloodPressure(
        int patientId,
        BloodPressure bloodPressure
    ) {
        LocalDateTime timestamp = LocalDateTime
            .now()
            .truncatedTo(ChronoUnit.SECONDS);

        BloodPressureModel bloodPressureModel = new BloodPressureModel(
            patientId,
            timestamp,
            bloodPressure.systolicValue(),
            bloodPressure.diastolicValue()
        );

        return bloodPressureRepository
            .save(bloodPressureModel)
            .map(
                model -> new BloodPressureResponse(
                    model.getPatientId(),
                    model.getTimestamp(),
                    new BloodPressure(
                        model.getSystolicValue(),
                        model.getDiastolicValue()
                    )
                )
            )
            .doOnNext(bloodPressureSinkMany::tryEmitNext);
    }

    public Flux<BloodPressureResponse> subscribeBloodPressure(int patientId) {
        return bloodPressureFlux
            .filter(response -> response.patientId() == patientId);
    }

    public Flux<BloodPressureResponse> subscribeBloodPressurePast(
        int patientId,
        LocalDateTime start,
        LocalDateTime end
    ) {
        return bloodPressureRepository
            .findByPatientIdAndTimestampBetween(patientId, start, end)
            .map(
                model -> new BloodPressureResponse(
                    model.getPatientId(),
                    model.getTimestamp(),
                    new BloodPressure(
                        model.getSystolicValue(),
                        model.getDiastolicValue()
                    )
                )
            );
    }

    public Mono<HeartRateResponse> publishHeartRate(
        int patientId,
        HeartRate heartRate
    ) {
        LocalDateTime timestamp = LocalDateTime
            .now()
            .truncatedTo(ChronoUnit.SECONDS);

        HeartRateModel heartRateModel = new HeartRateModel(
            patientId,
            timestamp,
            heartRate.value()
        );

        return heartRateRepository
            .save(heartRateModel)
            .map(
                model -> new HeartRateResponse(
                    model.getPatientId(),
                    model.getTimestamp(),
                    new HeartRate(model.getValue())
                )
            )
            .doOnNext(heartRateSinkMany::tryEmitNext);
    }

    public Flux<HeartRateResponse> subscribeHeartRate(int patientId) {
        return heartRateFlux
            .filter(response -> response.patientId() == patientId);
    }

    public Flux<HeartRateResponse> subscribeHeartRatePast(
        int patientId,
        LocalDateTime start,
        LocalDateTime end
    ) { 
        return heartRateRepository
            .findByPatientIdAndTimestampBetween(patientId, start, end)
            .map(
                model -> new HeartRateResponse(
                    model.getPatientId(),
                    model.getTimestamp(),
                    new HeartRate(model.getValue())
                )
            );
    }

    public Mono<OxygenSaturationResponse> publishOxygenSaturation(
        int patientId,
        OxygenSaturation oxygenSaturation
    ) {
        LocalDateTime timestamp = LocalDateTime
            .now()
            .truncatedTo(ChronoUnit.SECONDS);

        OxygenSaturationModel oxygenSaturationModel = new OxygenSaturationModel(
            patientId,
            timestamp,
            oxygenSaturation.value()
        );

        return oxygenSaturationRepository
            .save(oxygenSaturationModel)
            .map(
                model -> new OxygenSaturationResponse(
                    model.getPatientId(),
                    model.getTimestamp(),
                    new OxygenSaturation(model.getValue())
                )
            )
            .doOnNext(oxygenSaturationSinkMany::tryEmitNext);
    }

    public Flux<OxygenSaturationResponse> subscribeOxygenSaturation(int patientId) {
        return oxygenSaturationFlux
            .filter(response -> response.patientId() == patientId);
    }

    public Flux<OxygenSaturationResponse> subscribeOxygenSaturationPast(
        int patientId,
        LocalDateTime start,
        LocalDateTime end
    ) {
        return oxygenSaturationRepository
            .findByPatientIdAndTimestampBetween(patientId, start, end)
            .map(
                model -> new OxygenSaturationResponse(
                    model.getPatientId(),
                    model.getTimestamp(),
                    new OxygenSaturation(model.getValue())
                )
            );
    }

}
