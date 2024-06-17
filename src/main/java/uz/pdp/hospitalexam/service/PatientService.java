package uz.pdp.hospitalexam.service;

import uz.pdp.hospitalexam.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> findAll();

    Patient findByPhone(String phone);

    Optional<Patient> findById(int id);
}
