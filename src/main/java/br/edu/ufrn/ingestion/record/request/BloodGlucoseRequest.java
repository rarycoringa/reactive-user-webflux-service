package br.edu.ufrn.ingestion.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufrn.ingestion.record.BloodGlucose;

public record BloodGlucoseRequest(
    @JsonProperty("patient_id") int patientId,
    @JsonProperty("blood_glucose") BloodGlucose bloodGlucose
) {}
