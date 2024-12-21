package com.exampleHospitalManagementSystem.Hospital.Controller;

import com.exampleHospitalManagementSystem.Hospital.model.Patient;
import com.exampleHospitalManagementSystem.Hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/patients")
@RequiredArgsConstructor
@RestController

public class PatientController {

    private  final PatientService patientService;
    @PostMapping("/add")
    public Patient addPatient( @RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @DeleteMapping("/delete/{id}")
    public void  deletePatient(@PathVariable Long id) {
        patientService.deletePatient( id);
    }
    @PutMapping("/update/{id}")
    public Patient updatePatient(@RequestBody Patient patient, @PathVariable  Long id){
        return patientService.updatePatient(patient, id);
    }
    @GetMapping("/get/{id}")
    public Patient getPatient( @PathVariable Long id ){
        return patientService.getPatientById(id);
    }

    @GetMapping("/all")
    public List<Patient> getAllPatient( ){
        return patientService.getAllPatient();


    }

}
