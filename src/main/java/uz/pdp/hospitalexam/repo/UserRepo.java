package uz.pdp.hospitalexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import uz.pdp.hospitalexam.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}