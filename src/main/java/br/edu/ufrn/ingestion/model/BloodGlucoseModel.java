package br.edu.ufrn.ingestion.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("blood_glucose")
public class BloodGlucoseModel {

    @PrimaryKey
    private MetricPrimaryKey key;

    @Column("value")
    private int value;

    public MetricPrimaryKey getKey() {
        return key;
    }

    public void setKey(MetricPrimaryKey key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}
