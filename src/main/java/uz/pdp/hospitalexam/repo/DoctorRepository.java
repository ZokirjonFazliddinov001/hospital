package uz.pdp.hospitalexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hospitalexam.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}