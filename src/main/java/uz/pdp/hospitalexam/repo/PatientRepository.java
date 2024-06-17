package uz.pdp.hospitalexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.hospitalexam.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query(value = """
select p from patient p join public.users u on u.id = p.user_id where u.phone = :phone
""", nativeQuery = true)
    Patient findByPhone(String phone);
}