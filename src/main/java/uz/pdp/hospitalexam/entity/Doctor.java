package uz.pdp.hospitalexam.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Doctor extends Base {
    @OneToOne
    private User user;
    @ManyToOne
    private Expertise expertise;
    @OneToOne
    private Room room;
}