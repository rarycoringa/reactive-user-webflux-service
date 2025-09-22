package br.edu.ufrn.ingestion.record.response;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufrn.ingestion.record.HeartRate;

public record HeartRateResponse(
    @JsonProperty("patient_id") int patientId,
    @JsonProperty("registered_at") Instant registeredAt,
    @JsonProperty("heart_rate") HeartRate heartRate
) {}
