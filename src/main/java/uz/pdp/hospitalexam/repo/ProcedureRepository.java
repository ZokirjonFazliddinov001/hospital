package uz.pdp.hospitalexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hospitalexam.entity.Procedure;

public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {
}