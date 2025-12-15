package com.HospitalManagement.service;

import com.HospitalManagement.dto.PatientDto;

import java.util.List;

public interface Patient {
    public List<PatientDto> getAllPatient();
    public PatientDto getPatientById(Long id);
}
