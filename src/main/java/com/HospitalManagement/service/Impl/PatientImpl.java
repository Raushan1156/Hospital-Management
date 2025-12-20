package com.HospitalManagement.service.Impl;

import com.HospitalManagement.dto.PatientDto;
import com.HospitalManagement.entity.PatientEntity;
import com.HospitalManagement.repository.PatientRepository;
import com.HospitalManagement.service.Patient;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
//@RequiredArgsConstructor
public class PatientImpl implements Patient {
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    public PatientImpl(PatientRepository patientRepository, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientDto> getAllPatient() {
        List<PatientEntity> patientEntities = patientRepository.findAll();
       return  patientEntities.stream()
                .map(entity -> modelMapper.map(entity, PatientDto.class)).toList();
    }

    @Override
    public PatientDto getPatientById(Long id) {
       PatientEntity patientEntity = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient with id:"+id+"is not available."));
       return modelMapper.map(patientEntity, PatientDto.class);
    }
}
