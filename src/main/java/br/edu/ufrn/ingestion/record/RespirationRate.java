package br.edu.ufrn.ingestion.record;

public record RespirationRate(int value) { 
    public String unit() {
        return "bpm";
    }

    @Override
    public String toString() {
        return this.value() + " " + this.unit();
    }
}