package uz.pdp.hospitalexam.service;

import uz.pdp.hospitalexam.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> findAll();

    Optional<Doctor> findById(int selectedOption);
}
