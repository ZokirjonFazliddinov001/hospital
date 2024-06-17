package uz.pdp.hospitalexam.service.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.hospitalexam.entity.Admission;
import uz.pdp.hospitalexam.repo.AdmissionRepository;
import uz.pdp.hospitalexam.service.AdmissionService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdmissionServiceImpl implements AdmissionService {

    private final AdmissionRepository admissionRepository;
    @Override
    public void save(Admission admission) {
        admissionRepository.save(admission);
    }

    @Override
    public List<Admission> findAll() {
        return admissionRepository.findAll();
    }

    @Override
    public List<Admission> findByPatientId(Integer id) {
        return admissionRepository.findAllByPatientId(id);
    }

    @Override
    public Admission findById(int id) {
        Optional<Admission> optionalAdmission = admissionRepository.findById(id);
        return optionalAdmission.orElse(null);
    }

    @Override
    public void updateAdmission(Admission admission){
        admissionRepository.save(admission);
    }
}
