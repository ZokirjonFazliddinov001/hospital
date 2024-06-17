package uz.pdp.hospitalexam.service;

import uz.pdp.hospitalexam.entity.Admission;

import java.util.List;

public interface AdmissionService {
    void save(Admission admission);

    List<Admission> findAll();

    List<Admission> findByPatientId(Integer id);

    Admission findById(int id);

    void updateAdmission(Admission admission);
}
