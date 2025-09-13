package br.edu.ufrn.ingestion.record;

public record OxygenSaturation(int value) {
    public String unit() {
        return "%";
    }

    @Override
    public String toString() {
        return this.value() + this.unit();
    }
}