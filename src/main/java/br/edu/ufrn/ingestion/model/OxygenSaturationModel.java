package br.edu.ufrn.ingestion.model;

import java.time.Instant;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("oxygen_saturation")
public class OxygenSaturationModel extends BaseMetricModel {

    @Column("value")
    private int value;

    public OxygenSaturationModel() {}

    public OxygenSaturationModel(int patientId, Instant registeredAt, int value) {
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
