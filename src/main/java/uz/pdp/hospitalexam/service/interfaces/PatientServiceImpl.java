package uz.pdp.hospitalexam.service.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.hospitalexam.entity.Patient;
import uz.pdp.hospitalexam.repo.PatientRepository;
import uz.pdp.hospitalexam.service.PatientService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findByPhone(String phone) {
        return patientRepository.findByPhone(phone);
    }

    @Override
    public Optional<Patient> findById(int id) {
        return patientRepository.findById(id);
    }
}
