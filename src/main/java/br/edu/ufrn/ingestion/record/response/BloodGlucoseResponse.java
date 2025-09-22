package br.edu.ufrn.ingestion.record.response;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufrn.ingestion.record.BloodGlucose;

public record BloodGlucoseResponse(
    @JsonProperty("patient_id") int patientId,
    @JsonProperty("registered_at") Instant registeredAt,
    @JsonProperty("blood_glucose") BloodGlucose bloodGlucose
) {}
