package br.edu.ufrn.ingestion.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.ingestion.model.BodyTemperatureModel;
import br.edu.ufrn.ingestion.model.MetricPrimaryKey;

@Repository
public interface BodyTemperatureRepository extends CassandraRepository<BodyTemperatureModel, MetricPrimaryKey> {
    
    List<BodyTemperatureModel> findByKeyPatientIdAndKeyRegisteredAtBetween(
        int patientId,
        Instant start,
        Instant end
    );

}
