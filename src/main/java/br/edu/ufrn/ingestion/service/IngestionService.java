package br.edu.ufrn.ingestion.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufrn.ingestion.model.BloodGlucoseModel;
import br.edu.ufrn.ingestion.model.BloodPressureModel;
import br.edu.ufrn.ingestion.model.BodyTemperatureModel;
import br.edu.ufrn.ingestion.model.HeartRateModel;
import br.edu.ufrn.ingestion.model.OxygenSaturationModel;
import br.edu.ufrn.ingestion.model.RespirationRateModel;
import br.edu.ufrn.ingestion.record.BloodGlucose;
import br.edu.ufrn.ingestion.record.BloodPressure;
import br.edu.ufrn.ingestion.record.BodyTemperature;
import br.edu.ufrn.ingestion.record.HeartRate;
import br.edu.ufrn.ingestion.record.OxygenSaturation;
import br.edu.ufrn.ingestion.record.RespirationRate;
import br.edu.ufrn.ingestion.record.request.BloodGlucoseRequest;
import br.edu.ufrn.ingestion.record.request.BloodPressureRequest;
import br.edu.ufrn.ingestion.record.request.BodyTemperatureRequest;
import br.edu.ufrn.ingestion.record.request.HeartRateRequest;
import br.edu.ufrn.ingestion.record.request.OxygenSaturationRequest;
import br.edu.ufrn.ingestion.record.request.RespirationRateRequest;
import br.edu.ufrn.ingestion.record.request.RetrieveRequest;
import br.edu.ufrn.ingestion.record.response.BloodGlucoseResponse;
import br.edu.ufrn.ingestion.record.response.BloodPressureResponse;
import br.edu.ufrn.ingestion.record.response.BodyTemperatureResponse;
import br.edu.ufrn.ingestion.record.response.HeartRateResponse;
import br.edu.ufrn.ingestion.record.response.OxygenSaturationResponse;
import br.edu.ufrn.ingestion.record.response.RespirationRateResponse;
import br.edu.ufrn.ingestion.repository.BloodGlucoseRepository;
import br.edu.ufrn.ingestion.repository.BloodPressureRepository;
import br.edu.ufrn.ingestion.repository.BodyTemperatureRepository;
import br.edu.ufrn.ingestion.repository.HeartRateRepository;
import br.edu.ufrn.ingestion.repository.OxygenSaturationRepository;
import br.edu.ufrn.ingestion.repository.RespirationRateRepository;

@Service
public class IngestionService {
    
    @Autowired
    private BloodGlucoseRepository bloodGlucoseRepository;

    @Autowired
    private BloodPressureRepository bloodPressureRepository;

    @Autowired
    private BodyTemperatureRepository bodyTemperatureRepository;

    @Autowired
    private HeartRateRepository heartRateRepository;

    @Autowired
    private OxygenSaturationRepository oxygenSaturationRepository;

    @Autowired
    private RespirationRateRepository respirationRateRepository;

    public List<BloodGlucoseResponse> retrieveBloodGlucose(RetrieveRequest request) {
        List<BloodGlucoseModel> bloodGlucoseModelList = bloodGlucoseRepository.findByPatientIdAndRegisteredAtBetween(
            request.patientId(), request.start(), request.end()
        );
        
        List<BloodGlucoseResponse> bloodGlucoseList = bloodGlucoseModelList.stream()
            .map(model -> new BloodGlucoseResponse(
                model.getPatientId(),
                model.getRegisteredAt(),
                new BloodGlucose(model.getValue())
            ))
            .collect(Collectors.toList());
        
        return bloodGlucoseList;
    }

    public BloodGlucoseResponse createBloodGlucose(BloodGlucoseRequest request) {
        BloodGlucoseModel bloodGlucoseModel = new BloodGlucoseModel(
            request.patientId(), Instant.now(), request.bloodGlucose().value()
        );

        bloodGlucoseModel = bloodGlucoseRepository.save(bloodGlucoseModel);

        BloodGlucoseResponse bloodGlucoseResponse = new BloodGlucoseResponse(
            bloodGlucoseModel.getPatientId(), bloodGlucoseModel.getRegisteredAt(), request.bloodGlucose()
        );

        return bloodGlucoseResponse;
    }

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

    public List<BodyTemperatureResponse> retrieveBodyTemperature(RetrieveRequest request) {
        List<BodyTemperatureModel> bodyTemperatureModelList = bodyTemperatureRepository.findByPatientIdAndRegisteredAtBetween(
            request.patientId(), request.start(), request.end()
        );
        
        List<BodyTemperatureResponse> bodyTemperatureList = bodyTemperatureModelList.stream()
            .map(model -> new BodyTemperatureResponse(
                model.getPatientId(),
                model.getRegisteredAt(),
                new BodyTemperature(model.getValue())
            ))
            .collect(Collectors.toList());
        
        return bodyTemperatureList;
    }

    public BodyTemperatureResponse createBodyTemperature(BodyTemperatureRequest request) {
        BodyTemperatureModel bodyTemperatureModel = new BodyTemperatureModel(
            request.patientId(), Instant.now(), request.bodyTemperature().value()
        );

        bodyTemperatureModel = bodyTemperatureRepository.save(bodyTemperatureModel);

        BodyTemperatureResponse bodyTemperatureResponse = new BodyTemperatureResponse(
            bodyTemperatureModel.getPatientId(), bodyTemperatureModel.getRegisteredAt(), request.bodyTemperature()
        );

        return bodyTemperatureResponse;
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

    public List<RespirationRateResponse> retrieveRespirationRate(RetrieveRequest request) {
        List<RespirationRateModel> respirationRateModelList = respirationRateRepository.findByPatientIdAndRegisteredAtBetween(
            request.patientId(), request.start(), request.end()
        );
        
        List<RespirationRateResponse> respirationRateList = respirationRateModelList.stream()
            .map(model -> new RespirationRateResponse(
                model.getPatientId(),
                model.getRegisteredAt(),
                new RespirationRate(model.getValue())
            ))
            .collect(Collectors.toList());
        
        return respirationRateList;
    }

    public RespirationRateResponse createRespirationRate(RespirationRateRequest request) {
        RespirationRateModel respirationRateModel = new RespirationRateModel(
            request.patientId(), Instant.now(), request.respirationRate().value()
        );

        respirationRateModel = respirationRateRepository.save(respirationRateModel);

        RespirationRateResponse respirationRateResponse = new RespirationRateResponse(
            respirationRateModel.getPatientId(), respirationRateModel.getRegisteredAt(), request.respirationRate()
        );

        return respirationRateResponse;
    }

}
