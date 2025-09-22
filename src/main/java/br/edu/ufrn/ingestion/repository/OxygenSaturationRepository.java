package br.edu.ufrn.ingestion.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.ingestion.model.OxygenSaturationModel;

@Repository
public interface OxygenSaturationRepository extends CassandraRepository<OxygenSaturationModel, OxygenSaturationModel> {
    
    List<OxygenSaturationModel> findByPatientIdAndRegisteredAtBetween(
        int patientId,
        Instant start,
        Instant end
    );

}
