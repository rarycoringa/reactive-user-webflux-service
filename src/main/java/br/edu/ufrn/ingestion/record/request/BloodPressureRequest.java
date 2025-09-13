package br.edu.ufrn.ingestion.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufrn.ingestion.record.BloodPressure;

public record BloodPressureRequest(
    @JsonProperty("patient_id") int patientId,
    @JsonProperty("blood_pressure") BloodPressure bloodPressure
) {}
