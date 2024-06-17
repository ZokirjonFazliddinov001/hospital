package uz.pdp.hospitalexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hospitalexam.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}