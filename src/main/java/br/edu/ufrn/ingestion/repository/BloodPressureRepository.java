package br.edu.ufrn.ingestion.repository;

import java.time.LocalDateTime;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.ingestion.model.BloodPressureModel;
import reactor.core.publisher.Flux;

@Repository
public interface BloodPressureRepository extends ReactiveCassandraRepository<BloodPressureModel, BloodPressureModel> {
    
    Flux<BloodPressureModel> findByPatientIdAndTimestampBetween(
        int patientId,
        LocalDateTime start,
        LocalDateTime end
    );

}
