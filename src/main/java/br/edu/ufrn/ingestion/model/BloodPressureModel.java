package br.edu.ufrn.ingestion.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("blood_pressure")
public class BloodPressureModel {
    
    @PrimaryKey
    private MetricPrimaryKey key;

    @Column("systolic_value")
    private int systolicValue;

    @Column("diastolic_value")
    private int diastolicValue;

    public MetricPrimaryKey getKey() {
        return key;
    }

    public void setKey(MetricPrimaryKey key) {
        this.key = key;
    }

    public int getSystolicValue() {
        return systolicValue;
    }

    public void setSystolicValue(int systolicValue) {
        this.systolicValue = systolicValue;
    }

    public int getDiastolicValue() {
        return diastolicValue;
    }

    public void setDiastolicValue(int diastolicValue) {
        this.diastolicValue = diastolicValue;
    }

}
