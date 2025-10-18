package br.edu.ufrn.ingestion.model;

import java.time.LocalDateTime;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("blood_pressures")
public class BloodPressureModel extends BaseMetricModel {

    @Column("systolic_value")
    private Integer systolicValue;

    @Column("diastolic_value")
    private Integer diastolicValue;

    public BloodPressureModel() {}

    public BloodPressureModel(Integer patientId, LocalDateTime timestamp, Integer systolicValue, Integer diastolicValue) {
        super(patientId, timestamp);
        this.systolicValue = systolicValue;
        this.diastolicValue = diastolicValue;
    }

    public Integer getSystolicValue() {
        return systolicValue;
    }

    public void setSystolicValue(Integer systolicValue) {
        this.systolicValue = systolicValue;
    }

    public Integer getDiastolicValue() {
        return diastolicValue;
    }

    public void setDiastolicValue(Integer diastolicValue) {
        this.diastolicValue = diastolicValue;
    }

}
