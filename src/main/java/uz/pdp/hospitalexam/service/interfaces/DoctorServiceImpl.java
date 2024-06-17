package uz.pdp.hospitalexam.service.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.hospitalexam.entity.Doctor;
import uz.pdp.hospitalexam.repo.DoctorRepository;
import uz.pdp.hospitalexam.service.DoctorService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findById(int selectedOption) {
        return doctorRepository.findById(selectedOption);
    }
}
