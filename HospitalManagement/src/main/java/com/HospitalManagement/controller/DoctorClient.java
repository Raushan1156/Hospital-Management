package com.HospitalManagement.controller;

import com.HospitalManagement.dto.DoctorDto;
import com.HospitalManagement.service.Impl.DoctorImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping(path = "/api/doctor")
public class DoctorClient {

    private final DoctorImpl doctorImpl;
    public DoctorClient(DoctorImpl doctorImpl){
        this.doctorImpl = doctorImpl;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long id){
        DoctorDto doctorDto = doctorImpl.getDoctorById(id);
        return ResponseEntity.ok(doctorDto);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        List<DoctorDto> doctorDto = doctorImpl.getAllDoctor();
        return ResponseEntity.ok(doctorDto);
    }
}
