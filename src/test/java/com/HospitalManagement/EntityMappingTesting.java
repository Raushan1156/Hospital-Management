package com.HospitalManagement;

import com.HospitalManagement.entity.InsuranceEntity;
import com.HospitalManagement.entity.PatientEntity;
import com.HospitalManagement.repository.InsuranceRepository;
import com.HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import java.util.Collections;

@Transactional
//@Rollback(false)
@Commit
@SpringBootTest
public class EntityMappingTesting {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private InsuranceRepository insuranceRepository;
    private InsuranceEntity insuranceEntity;
    @PersistenceContext
    private EntityManager entityManager;


    @Test
    public void oneToOneMapping(){
        Long patientId = 1L;
        PatientEntity patientEntity = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("No patient fount with id:"+patientId));
        System.out.println(patientEntity);

        patientRepository.deleteAllById(Collections.singleton(patientId));
        /* it is running two query which we are expecting with cascadeType
        * Hibernate: delete from insurance where id=?
        * Hibernate: delete from patient where id=?
        */
//        InsuranceEntity insuranceEntity1 = insuranceRepository.findById(2L)
//                .orElseThrow(() -> new RuntimeException("user not found while testing with id: 2"));
//        insuranceEntity1.setPatientEntity(null);
//        insuranceRepository.save(insuranceEntity1);

        PatientEntity patientEntity1 = patientRepository.findById(2L)
                .orElseThrow(() -> new RuntimeException("No patient fount with id:"+patientId));
        patientEntity1.setInsuranceEntity(null);
        patientRepository.save(patientEntity1);
        /* it is running two query which we are expecting with cascadeType (With fetch = Eager)
        Hibernate: select pe1_0.id,pe1_0.birth_date,pe1_0.blood_group,pe1_0.created_date,pe1_0.email,pe1_0.gender,ie1_0.id,ie1_0.created_at,ie1_0.policy_number,ie1_0.provider,ie1_0.valid_until,pe1_0.name from patient pe1_0 left join insurance ie1_0 on pe1_0.id=ie1_0.patient_id where pe1_0.id=?
        Hibernate: select pe1_0.id,pe1_0.birth_date,pe1_0.blood_group,pe1_0.created_date,pe1_0.email,pe1_0.gender,ie1_0.id,ie1_0.created_at,ie1_0.policy_number,ie1_0.provider,ie1_0.valid_until,pe1_0.name from patient pe1_0 left join insurance ie1_0 on pe1_0.id=ie1_0.patient_id where pe1_0.id=?
        Hibernate: delete from insurance where id=?
        Note: Hibernate will always run the select query first before deleting.

        With fetch = lazy: There are extra queries. Check the Medium.com doc...
        Hibernate: select pe1_0.id,pe1_0.birth_date,pe1_0.blood_group,pe1_0.created_date,pe1_0.email,pe1_0.gender,pe1_0.name from patient pe1_0 where pe1_0.id=?
        Hibernate: select ie1_0.id,ie1_0.created_at,pe1_0.id,pe1_0.birth_date,pe1_0.blood_group,pe1_0.created_date,pe1_0.email,pe1_0.gender,pe1_0.name,ie1_0.policy_number,ie1_0.provider,ie1_0.valid_until from insurance ie1_0 left join patient pe1_0 on pe1_0.id=ie1_0.patient_id where ie1_0.patient_id=?
        Hibernate: select pe1_0.id,pe1_0.birth_date,pe1_0.blood_group,pe1_0.created_date,pe1_0.email,pe1_0.gender,ie1_0.id,ie1_0.created_at,ie1_0.policy_number,ie1_0.provider,ie1_0.valid_until,pe1_0.name from patient pe1_0 left join insurance ie1_0 on pe1_0.id=ie1_0.patient_id where pe1_0.id=?
        Hibernate: delete from insurance where id=?
         */

        entityManager.flush();
    }
}
