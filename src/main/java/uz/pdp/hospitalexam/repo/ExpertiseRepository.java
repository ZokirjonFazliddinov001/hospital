package uz.pdp.hospitalexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hospitalexam.entity.Expertise;

public interface ExpertiseRepository extends JpaRepository<Expertise, Integer> {
}