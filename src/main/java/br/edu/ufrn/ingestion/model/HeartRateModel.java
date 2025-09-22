package br.edu.ufrn.ingestion.model;

import java.time.Instant;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("heart_rate")
public class HeartRateModel extends BaseMetricModel {

    @Column("value")
    private int value;

    public HeartRateModel() {}

    public HeartRateModel(int patientId, Instant registeredAt, int value) {
        super(patientId, registeredAt);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
