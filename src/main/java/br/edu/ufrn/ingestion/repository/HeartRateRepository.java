package br.edu.ufrn.ingestion.repository;

import java.time.LocalDateTime;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.ingestion.model.HeartRateModel;
import reactor.core.publisher.Flux;

@Repository
public interface HeartRateRepository extends ReactiveCassandraRepository<HeartRateModel, HeartRateModel> {
    
    Flux<HeartRateModel> findByPatientIdAndTimestampBetween(
        Integer patientId,
        LocalDateTime start,
        LocalDateTime end
    );

}