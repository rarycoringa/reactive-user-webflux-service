package br.edu.ufrn.ingestion.record.response;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufrn.ingestion.record.BodyTemperature;

public record BodyTemperatureResponse(
    @JsonProperty("patient_id") int patientId,
    @JsonProperty("registered_at") Instant registeredAt,
    @JsonProperty("body_temperature") BodyTemperature bodyTemperature
) {}
