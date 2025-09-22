package br.edu.ufrn.ingestion.model;

import java.time.Instant;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("body_temperature")
public class BodyTemperatureModel extends BaseMetricModel {

    @Column("value")
    private double value;

    public BodyTemperatureModel() {}

    public BodyTemperatureModel(int patientId, Instant registeredAt, double value) {
        super(patientId, registeredAt);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
