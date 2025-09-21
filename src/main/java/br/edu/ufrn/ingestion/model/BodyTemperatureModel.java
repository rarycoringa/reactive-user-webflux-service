package br.edu.ufrn.ingestion.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("body_temperature")
public class BodyTemperatureModel {
    
    @PrimaryKey
    private MetricPrimaryKey key;

    @Column("value")
    private double value;

    public MetricPrimaryKey getKey() {
        return key;
    }

    public void setKey(MetricPrimaryKey key) {
        this.key = key;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
