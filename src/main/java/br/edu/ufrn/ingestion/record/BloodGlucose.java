package br.edu.ufrn.ingestion.record;

public record BloodGlucose(int value) {
    public String unit() {
        return "mg/dL";
    }

    public String toString() {
        return this.value() + " " + this.unit();
    }
}