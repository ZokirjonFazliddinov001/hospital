package uz.pdp.hospitalexam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "adminstrator")
public class Adminstrator extends Base {
    @OneToOne
    private User user;
}