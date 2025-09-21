package br.edu.ufrn.ingestion.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufrn.ingestion.record.HeartRate;

public record HeartRateRequest(
    @JsonProperty("patient_id") int patientId,
    @JsonProperty("heart_rate") HeartRate heartRate
) {}
