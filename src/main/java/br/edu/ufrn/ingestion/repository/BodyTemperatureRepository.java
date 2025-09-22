package br.edu.ufrn.ingestion.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.ingestion.model.BodyTemperatureModel;

@Repository
public interface BodyTemperatureRepository extends CassandraRepository<BodyTemperatureModel, BodyTemperatureModel> {
    
    List<BodyTemperatureModel> findByPatientIdAndRegisteredAtBetween(
        int patientId,
        Instant start,
        Instant end
    );

}
