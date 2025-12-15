package com.HospitalManagement.service;

import com.HospitalManagement.dto.DoctorDto;

import java.util.List;

public interface Doctor {

    public DoctorDto getDoctorById(Long id);
    public DoctorDto getDoctorByDepartment(String department);
    public List<DoctorDto> getAllDoctor();


}
