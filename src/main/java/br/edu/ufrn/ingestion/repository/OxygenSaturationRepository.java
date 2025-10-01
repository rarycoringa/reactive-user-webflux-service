package br.edu.ufrn.ingestion.repository;

import java.time.LocalDateTime;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.ingestion.model.OxygenSaturationModel;
import reactor.core.publisher.Flux;

@Repository
public interface OxygenSaturationRepository extends ReactiveCassandraRepository<OxygenSaturationModel, OxygenSaturationModel> {
    
    Flux<OxygenSaturationModel> findByPatientIdAndTimestampBetween(
        int patientId,
        LocalDateTime start,
        LocalDateTime end
    );

}
