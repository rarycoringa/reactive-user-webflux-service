package br.edu.ufrn.ingestion.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufrn.ingestion.model.BloodPressureModel;
import br.edu.ufrn.ingestion.model.HeartRateModel;
import br.edu.ufrn.ingestion.model.OxygenSaturationModel;
import br.edu.ufrn.ingestion.record.BloodPressure;
import br.edu.ufrn.ingestion.record.HeartRate;
import br.edu.ufrn.ingestion.record.OxygenSaturation;
import br.edu.ufrn.ingestion.record.request.BloodPressureRequest;
import br.edu.ufrn.ingestion.record.request.HeartRateRequest;
import br.edu.ufrn.ingestion.record.request.OxygenSaturationRequest;
import br.edu.ufrn.ingestion.record.request.RetrieveRequest;
import br.edu.ufrn.ingestion.record.response.BloodPressureResponse;
import br.edu.ufrn.ingestion.record.response.HeartRateResponse;
import br.edu.ufrn.ingestion.record.response.OxygenSaturationResponse;
import br.edu.ufrn.ingestion.repository.BloodPressureRepository;
import br.edu.ufrn.ingestion.repository.HeartRateRepository;
import br.edu.ufrn.ingestion.repository.OxygenSaturationRepository;

@Service
public class IngestionService {

    @Autowired
    private BloodPressureRepository bloodPressureRepository;

    @Autowired
    private HeartRateRepository heartRateRepository;

    @Autowired
    private OxygenSaturationRepository oxygenSaturationRepository;

    public List<BloodPressureResponse> retrieveBloodPressure(RetrieveRequest request) {
        List<BloodPressureModel> bloodPressureModelList = bloodPressureRepository.findByPatientIdAndRegisteredAtBetween(
            request.patientId(), request.start(), request.end()
        );
        
        List<BloodPressureResponse> bloodPressureList = bloodPressureModelList.stream()
            .map(model -> new BloodPressureResponse(
                model.getPatientId(),
                model.getRegisteredAt(),
                new BloodPressure(model.getSystolicValue(), model.getDiastolicValue())
            ))
            .collect(Collectors.toList());
        
        return bloodPressureList;
    }

    public BloodPressureResponse createBloodPressure(BloodPressureRequest request) {
        BloodPressureModel bloodPressureModel = new BloodPressureModel(
            request.patientId(), Instant.now(), request.bloodPressure().systolicValue(), request.bloodPressure().diastolicValue()
        );

        bloodPressureModel = bloodPressureRepository.save(bloodPressureModel);

        BloodPressureResponse bloodPressureResponse = new BloodPressureResponse(
            bloodPressureModel.getPatientId(), bloodPressureModel.getRegisteredAt(), request.bloodPressure()
        );

        return bloodPressureResponse;
    }

    public List<HeartRateResponse> retrieveHeartRate(RetrieveRequest request) {
        List<HeartRateModel> heartRateModelList = heartRateRepository.findByPatientIdAndRegisteredAtBetween(
            request.patientId(), request.start(), request.end()
        );
        
        List<HeartRateResponse> heartRateList = heartRateModelList.stream()
            .map(model -> new HeartRateResponse(
                model.getPatientId(),
                model.getRegisteredAt(),
                new HeartRate(model.getValue())
            ))
            .collect(Collectors.toList());
        
        return heartRateList;
    }

    public HeartRateResponse createHeartRate(HeartRateRequest request) {
        HeartRateModel heartRateModel = new HeartRateModel(
            request.patientId(), Instant.now(), request.heartRate().value()
        );

        heartRateModel = heartRateRepository.save(heartRateModel);

        HeartRateResponse heartRateResponse = new HeartRateResponse(
            heartRateModel.getPatientId(), heartRateModel.getRegisteredAt(), request.heartRate()
        );

        return heartRateResponse;
    }

    public List<OxygenSaturationResponse> retrieveOxygenSaturation(RetrieveRequest request) {
        List<OxygenSaturationModel> oxygenSaturationModelList = oxygenSaturationRepository.findByPatientIdAndRegisteredAtBetween(
            request.patientId(), request.start(), request.end()
        );
        
        List<OxygenSaturationResponse> oxygenSaturationList = oxygenSaturationModelList.stream()
            .map(model -> new OxygenSaturationResponse(
                model.getPatientId(),
                model.getRegisteredAt(),
                new OxygenSaturation(model.getValue())
            ))
            .collect(Collectors.toList());
        
        return oxygenSaturationList;
    }

    public OxygenSaturationResponse createOxygenSaturation(OxygenSaturationRequest request) {
        OxygenSaturationModel oxygenSaturationModel = new OxygenSaturationModel(
            request.patientId(), Instant.now(), request.oxygenSaturation().value()
        );

        oxygenSaturationModel = oxygenSaturationRepository.save(oxygenSaturationModel);

        OxygenSaturationResponse oxygenSaturationResponse = new OxygenSaturationResponse(
            oxygenSaturationModel.getPatientId(), oxygenSaturationModel.getRegisteredAt(), request.oxygenSaturation()
        );

        return oxygenSaturationResponse;
    }

}
