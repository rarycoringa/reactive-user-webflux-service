package br.edu.ufrn.ingestion.record.response;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufrn.ingestion.record.BloodPressure;

public record BloodPressureResponse(
    @JsonProperty("patient_id") int patientId,
    @JsonProperty("registered_at") Instant registeredAt,
    @JsonProperty("blood_pressure") BloodPressure bloodPressure
) {}
