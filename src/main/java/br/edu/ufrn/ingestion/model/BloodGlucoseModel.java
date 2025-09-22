package br.edu.ufrn.ingestion.model;

import java.time.Instant;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("blood_glucose")
public class BloodGlucoseModel extends BaseMetricModel {

    @Column("value")
    private int value;

    public BloodGlucoseModel() {}

    public BloodGlucoseModel(int patientId, Instant registeredAt, int value) {
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
