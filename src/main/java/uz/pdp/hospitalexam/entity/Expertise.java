package uz.pdp.hospitalexam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Expertise extends Base {

    private String expertiseName;

}