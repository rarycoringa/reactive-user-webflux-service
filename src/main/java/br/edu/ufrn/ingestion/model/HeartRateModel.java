package br.edu.ufrn.ingestion.model;

import java.time.LocalDateTime;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("heart_rate")
public class HeartRateModel extends BaseMetricModel {

    @Column("value")
    private Integer value;

    public HeartRateModel() {}

    public HeartRateModel(Integer patientId, LocalDateTime timestamp, Integer value) {
        super(patientId, timestamp);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
