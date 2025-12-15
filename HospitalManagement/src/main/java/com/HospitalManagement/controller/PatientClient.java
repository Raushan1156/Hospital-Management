package com.HospitalManagement.controller;

import com.HospitalManagement.dto.PatientDto;
import com.HospitalManagement.service.Impl.PatientImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/patient")
public class PatientClient {

    private final PatientImpl patientImpl;

    @GetMapping(path = "{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id){
        PatientDto patientDto = patientImpl.getPatientById(id);
        return ResponseEntity.ok(patientDto);
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getPatientById(){
        List<PatientDto> patientDto = patientImpl.getAllPatient();
        return ResponseEntity.ok(patientDto);
    }
}
