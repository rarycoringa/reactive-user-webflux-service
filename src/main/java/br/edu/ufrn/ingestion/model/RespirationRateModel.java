package br.edu.ufrn.ingestion.model;

import java.time.Instant;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("respiration_rate")
public class RespirationRateModel extends BaseMetricModel {

    @Column("value")
    private int value;

    public RespirationRateModel() {}

    public RespirationRateModel(int patientId, Instant registeredAt, int value) {
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
