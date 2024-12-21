package com.exampleHospitalManagementSystem.Hospital.service;

import com.exampleHospitalManagementSystem.Hospital.model.Patient;
import com.exampleHospitalManagementSystem.Hospital.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository; // Bin

    public Patient addPatient(Patient patient) {

        return patientRepository.save(patient);
    }
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);

    }
    public Patient updatePatient(Patient updatedPatient, Long id) {
        Patient existingPatient = patientRepository.findById(id).orElse(null);
        if (existingPatient != null) {
            existingPatient.setFirst_name(updatedPatient.getFirst_name());
            existingPatient.setLast_name(updatedPatient.getLast_name());
            existingPatient.setAge(updatedPatient.getAge());
            return patientRepository.save(existingPatient);
        }
        return null;
    }

    public Patient getPatientById(Long id) {

        return patientRepository.findById(id).orElse(null);
    }
    public List<Patient> getAllPatient(){

        return patientRepository.findAll();
    }
}
