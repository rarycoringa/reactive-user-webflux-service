package br.edu.ufrn.ingestion.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufrn.ingestion.record.OxygenSaturation;

public record OxygenSaturationRequest(
    @JsonProperty("patient_id") int patientId,
    @JsonProperty("oxygen_saturation") OxygenSaturation oxygenSaturation
) {}
