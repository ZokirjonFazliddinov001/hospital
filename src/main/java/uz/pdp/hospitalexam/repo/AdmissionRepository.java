package uz.pdp.hospitalexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.hospitalexam.entity.Admission;

import java.util.List;

public interface AdmissionRepository extends JpaRepository<Admission, Integer> {
    @Query(value = """
select * from admission a where patient_id = :id
""", nativeQuery = true)
    List<Admission> findAllByPatientId(Integer id);
}