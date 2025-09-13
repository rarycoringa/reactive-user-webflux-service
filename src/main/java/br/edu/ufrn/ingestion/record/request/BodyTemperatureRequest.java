package br.edu.ufrn.ingestion.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufrn.ingestion.record.BodyTemperature;

public record BodyTemperatureRequest(
    @JsonProperty("patient_id") int patientId,
    @JsonProperty("body_temperature") BodyTemperature bodyTemperature
) {}
