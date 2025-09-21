package br.edu.ufrn.ingestion.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.ingestion.model.BloodPressureModel;
import br.edu.ufrn.ingestion.model.MetricPrimaryKey;

@Repository
public interface BloodPressureRepository extends CassandraRepository<BloodPressureModel, MetricPrimaryKey> {
    
    List<BloodPressureModel> findByKeyPatientIdAndKeyRegisteredAtBetween(
        int patientId,
        Instant start,
        Instant end
    );

}
