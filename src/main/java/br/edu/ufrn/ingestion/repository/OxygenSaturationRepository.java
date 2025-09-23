package br.edu.ufrn.ingestion.repository;

import java.time.Instant;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.ingestion.model.OxygenSaturationModel;
import reactor.core.publisher.Flux;

@Repository
public interface OxygenSaturationRepository extends ReactiveCassandraRepository<OxygenSaturationModel, OxygenSaturationModel> {
    
    Flux<OxygenSaturationModel> findByPatientIdAndRegisteredAtBetween(
        int patientId,
        Instant start,
        Instant end
    );

}
