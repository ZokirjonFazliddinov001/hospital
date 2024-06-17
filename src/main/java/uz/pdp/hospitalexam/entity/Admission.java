package uz.pdp.hospitalexam.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.hospitalexam.entity.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admission")
public class Admission extends Base {
  private LocalDateTime localDateTime;
  @ManyToOne
  private Patient patient;
  @ManyToOne
  private Doctor doctor;
  private String description;
  private Status status;

  @OneToMany
  private List<Procedure> procedures;


  public boolean isTime(LocalDateTime time){
    if(time.isBefore(LocalDateTime.now())){
      return false;
    }
    return true;
  }

}