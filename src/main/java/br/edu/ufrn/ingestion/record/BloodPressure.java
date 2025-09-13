package br.edu.ufrn.ingestion.record;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BloodPressure(
    @JsonProperty("systolic_value") int systolicValue,
    @JsonProperty("diastolic_value") int diastolicValue
) {
    public String unit() {
        return "mmHg";
    }

    @Override
    public String toString() {
        return this.systolicValue() + "/" + this.diastolicValue() + " " + this.unit();
    }
}