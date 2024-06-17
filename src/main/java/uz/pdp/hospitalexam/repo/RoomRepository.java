package uz.pdp.hospitalexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hospitalexam.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}