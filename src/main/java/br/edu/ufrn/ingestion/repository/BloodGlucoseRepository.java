package br.edu.ufrn.ingestion.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.ingestion.model.BloodGlucoseModel;

@Repository
public interface BloodGlucoseRepository extends CassandraRepository<BloodGlucoseModel, BloodGlucoseModel> {
    
    List<BloodGlucoseModel> findByPatientIdAndRegisteredAtBetween(
        int patientId,
        Instant start,
        Instant end
    );

}