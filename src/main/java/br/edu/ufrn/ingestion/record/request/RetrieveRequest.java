package br.edu.ufrn.ingestion.record.request;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RetrieveRequest(
    @JsonProperty("patient_id") int patientId,
    @JsonProperty("start") Instant start,
    @JsonProperty("end") Instant end
) {}
