package com.HospitalManagement.service.Impl;

import com.HospitalManagement.dto.DoctorDto;
import com.HospitalManagement.entity.DoctorEntity;
import com.HospitalManagement.repository.DoctorRepository;
import com.HospitalManagement.service.Doctor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DoctorImpl implements Doctor {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    @Override
    public DoctorDto getDoctorById(Long id) {
       DoctorEntity doctorEntity = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor with id: "+id+" not found."));
       return modelMapper.map(doctorEntity, DoctorDto.class);
    }

    @Override
    public DoctorDto getDoctorByDepartment(String department) {
        return null;
    }

    @Override
    public List<DoctorDto> getAllDoctor() {
       List<DoctorEntity> doctorEntity = doctorRepository.findAll();
        return doctorEntity.stream()
               .map(entity -> modelMapper.map(entity,DoctorDto.class)).toList();
    }
}
