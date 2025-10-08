package br.edu.ufrn.ingestion.record;

public record OxygenSaturation(Integer value) {
    public String unit() {
        return "%";
    }

    @Override
    public String toString() {
        return this.value() + this.unit();
    }
}