package uz.pdp.hospitalexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hospitalexam.entity.Adminstrator;

public interface AdminstratorRepository extends JpaRepository<Adminstrator, Integer> {
}