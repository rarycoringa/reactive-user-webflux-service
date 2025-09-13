package br.edu.ufrn.ingestion.record;

public record BodyTemperature(double value) {
    public String unit() {
        return "°C";
    }

    @Override
    public String toString() {
        return this.value() + " " + this.unit();
    }
}