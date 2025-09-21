package br.edu.ufrn.ingestion.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufrn.ingestion.record.Metadata;
import br.edu.ufrn.ingestion.record.RespirationRate;

public record RespirationRateRequest(
    @JsonProperty("patient_id") int patientId,
    @JsonProperty("respiration_rate") RespirationRate respirationRate
) {}
